package com.zengyu.wheel.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;

import com.zengyu.wheel.R;

import androidx.appcompat.widget.AppCompatEditText;
/**
 * Created on 2019-11-01
 *
 * @author Zengyu.Zhan
 */
public class DebounceEditText extends AppCompatEditText {
    public DebounceEditText(Context context) {
        this(context, null);
    }

    public DebounceEditText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DebounceEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(attrs);
    }

    private void initAttrs(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.DebounceEditText);
            mDebounceTime = typedArray.getInt(R.styleable.DebounceEditText_debounce_time, (int) mDebounceTime);
            if (mDebounceTime < 0) {
                mDebounceTime = 0;
            }
            typedArray.recycle();
        }
    }

    private long mDebounceTime = 300;
    public void setDebounceTime(long debounceTime) {
        this.mDebounceTime = debounceTime;
    }

    private OnTextChangedListener mListener;
    public void setOnTextChangedListener(OnTextChangedListener listener) {
        this.mListener = listener;
    }

    private String mCurrentText = "";
    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            if (mListener != null && !TextUtils.equals(mCurrentText, getText().toString())) {
                mCurrentText = getText().toString();
                mListener.onTextChanged(mCurrentText);
            }
        }
    };

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        removeCallbacks(mRunnable);
        postDelayed(mRunnable, mDebounceTime);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(mRunnable);
    }

    public interface OnTextChangedListener {
        /**
         * Callback when the text changes
         * @param text
         */
        void onTextChanged(String text);
    }
}
