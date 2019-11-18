package com.zengyu.wheel.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;

import com.zengyu.wheel.R;

/**
 * Created on 2019-11-15
 *
 * @author Zengyu.Zhan
 */
public class SelectorButton extends AppCompatButton {
    public SelectorButton(Context context) {
        this(context, null);
    }

    public SelectorButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SelectorButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(attrs);
        init();
    }

    /**
     * Initial color value
     */
    private int mNormalColor;
    /**
     * Press color value
     */
    private int mPressedColor;

    private int mStrokeColor;
    private float mStrokeWidth;

    /**
     * Fillet radius
     */
    private float mCorner;
    private void initAttrs(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.SelectorButton);
            mNormalColor = typedArray.getColor(R.styleable.SelectorButton_normal_color, Color.GRAY);
            mPressedColor = typedArray.getColor(R.styleable.SelectorButton_press_color, Color.WHITE);
            mStrokeColor = typedArray.getColor(R.styleable.SelectorButton_stroke_color, Color.TRANSPARENT);
            mStrokeWidth = typedArray.getDimension(R.styleable.SelectorButton_stroke_width, 0.0f);
            mCorner = typedArray.getDimension(R.styleable.SelectorButton_corner, 0.0f);
            typedArray.recycle();
        }
    }

    private GradientDrawable mGradientDrawable;
    private void init() {
        setGravity(Gravity.CENTER);

        mGradientDrawable = new GradientDrawable();
        mGradientDrawable.setColor(mNormalColor);
        mGradientDrawable.setStroke((int) mStrokeWidth, mStrokeColor);
        mGradientDrawable.setCornerRadius(mCorner);

        setBackgroundDrawable(mGradientDrawable);

        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                setBackgroundDrawable(mGradientDrawable);
                return setColor(event.getAction());
            }
        });
    }

    private boolean mIsTouchDeliver = true;
    private boolean setColor(int action) {
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                mGradientDrawable.setColor(mPressedColor);
                break;
            case MotionEvent.ACTION_UP:
                mGradientDrawable.setColor(mNormalColor);
                break;
            case MotionEvent.ACTION_CANCEL:
                mGradientDrawable.setColor(mNormalColor);
                break;
            default:
                break;
        }
        return mIsTouchDeliver;
    }

    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        super.setOnClickListener(l);
        mIsTouchDeliver = false;
    }

    /**
     * @param colorId e.g.:R.color.xxx
     */
    public SelectorButton setPressedColor(int colorId) {
        updatePressedColor(ContextCompat.getColor(getContext(), colorId));
        return this;
    }

    /**
     * @param pressedColor ex：#ffffff
     */
    public SelectorButton setPressedColor(String pressedColor) {
        updatePressedColor(Color.parseColor(pressedColor));
        return this;
    }



    /**
     * @param colorId e.g.:R.color.xxx
     */
    public SelectorButton setNormalColor(int colorId) {
        updateNormalColor(ContextCompat.getColor(getContext(), colorId));
        return this;
    }

    /**
     * @param normalColor ex：#ffffff
     */
    public SelectorButton setNormalColor(String normalColor) {
        updateNormalColor(Color.parseColor(normalColor));
        return this;
    }

    /**
     * @param corner 设置四边的圆角半径
     */
    public SelectorButton setCorner(float corner) {
        if (mGradientDrawable != null) {
            mGradientDrawable.setCornerRadius(corner);
        }
        return this;
    }

    /**
     * 设置每个角的圆角半径，顺时针，4 个角的 xy 组成 8 个数字
     * @param corners
     */
    public SelectorButton setCorners(float[] corners) {
        if (corners == null || corners.length != 8) {
            throw new IllegalArgumentException("corners needs 8 values");
        }

        if (mGradientDrawable != null) {
            mGradientDrawable.setCornerRadii(corners);
        }
        return this;
    }

    /**
     * @param strokeWidth 设置边框宽度
     */
    public SelectorButton setStrokeWidth(float strokeWidth) {
        mStrokeWidth = strokeWidth;
        if (mGradientDrawable != null) {
            mGradientDrawable.setStroke((int) strokeWidth, mStrokeColor);
        }
        return this;
    }

    /**
     * @param colorId e.g.: R.color.xxx
     */
    public SelectorButton setStrokeColor(int colorId) {
        updateStrokeColor(ContextCompat.getColor(getContext(), colorId));
        return this;
    }

    /**
     * @param strokeColor e.g.:#ffffff
     */
    public SelectorButton setStrokeColor(String strokeColor) {
        updateStrokeColor(Color.parseColor(strokeColor));
        return this;
    }



    /**
     * 设置按下去后的颜色值
     * @param pressedColor
     */
    private void updatePressedColor(int pressedColor) {
        mPressedColor = pressedColor;
    }

    /**
     * 设置初始颜色值
     * @param normalColor
     */
    private void updateNormalColor(int normalColor) {
        mNormalColor = normalColor;
        if (mGradientDrawable != null) {
            mGradientDrawable.setColor(mNormalColor);
        }
    }

    /**
     * 设置边框颜色值
     * @param color
     */
    private void updateStrokeColor(int color) {
        mStrokeColor = color;
        if (mGradientDrawable != null) {
            mGradientDrawable.setStroke((int) mStrokeWidth, mStrokeColor);
        }
    }
}
