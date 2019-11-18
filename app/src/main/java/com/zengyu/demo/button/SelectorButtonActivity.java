package com.zengyu.demo.button;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.zengyu.demo.R;
import com.zengyu.wheel.widgets.SelectorButton;

import java.util.List;

import butterknife.BindViews;
import butterknife.ButterKnife;

/**
 * @author zengyu.zhan
 */
public class SelectorButtonActivity extends AppCompatActivity {

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, SelectorButtonActivity.class);
        context.startActivity(intent);
    }

    @BindViews({R.id.press_btn, R.id.corner_btn, R.id.corners_btn, R.id.stroke_btn})
    List<SelectorButton> mBtnList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selector_button);
        ButterKnife.bind(this);

        mBtnList.get(0).setNormalColor("#bac9d8")
                .setPressedColor("#dadee2");

        mBtnList.get(1).setNormalColor("#bac9d8")
                .setPressedColor("#dadee2")
                .setCorner(20);


        float[] corners = {20, 20, 40, 40, 40, 40, 0, 0};
        mBtnList.get(2).setNormalColor(R.color.normal_color)
                .setPressedColor(R.color.press_color)
                .setCorners(corners);

        mBtnList.get(3).setNormalColor("#bac9d8")
                .setPressedColor("#dadee2")
                .setStrokeWidth(20)
                .setStrokeColor("#d42bd3");
    }

}
