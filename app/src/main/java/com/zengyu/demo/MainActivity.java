package com.zengyu.demo;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.zengyu.demo.button.SelectorButtonActivity;
import com.zengyu.demo.edittext.DebounceEditTextActivity;
import com.zengyu.demo.zlog.ZLogActivity;

/**
 * @author zengyu.zhan
 */
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = findViewById(R.id.list_view);
        fillData();
    }

    private String[] mTitles = {"v1.0.0", "v1.0.1", "v1.0.2"};

    private void fillData() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, mTitles);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                ZLogActivity.actionStart(this);
                break;
            case 1:
                DebounceEditTextActivity.actionStart(this);
                break;
            case 2:
                SelectorButtonActivity.actionStart(this);
                break;
            default:
                break;
        }
    }
}
