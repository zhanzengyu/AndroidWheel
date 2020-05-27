package com.zengyu.demo.widget;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.zengyu.demo.R;
import com.zengyu.wheel.widgets.DebounceEditText;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author zengyu.zhan
 */
public class DebounceEditTextActivity extends AppCompatActivity {

    @BindView(R.id.edt_default)
    DebounceEditText mEdtDefault;
    @BindView(R.id.edt_xml)
    DebounceEditText mEdtXml;
    @BindView(R.id.edt_program)
    DebounceEditText mEdtProgram;

    @BindView(R.id.tv_default)
    TextView mTvDefault;
    @BindView(R.id.tv_xml)
    TextView mTvXml;
    @BindView(R.id.tv_program)
    TextView mTvProgram;

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, DebounceEditTextActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debounce_edittext);
        ButterKnife.bind(this);

        mEdtProgram.setDebounceTime(2000);

        mEdtDefault.setOnTextChangedListener(text -> mTvDefault.setText(text));
        mEdtXml.setOnTextChangedListener(text -> mTvXml.setText(text));
        mEdtProgram.setOnTextChangedListener(text -> mTvProgram.setText(text));
    }
}
