package com.kotlin.customview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.kotlin.customview.view.CustomTitleView;

public class MainActivity extends AppCompatActivity {
    private CustomTitleView mCustomTitleView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       //自定义view，通过组合控件的方式实现
        setContentView(R.layout.activity_custom_view_compose_demo);
        mCustomTitleView=findViewById(R.id.customview_title);
        mCustomTitleView.setTitle("This is Title");
        mCustomTitleView.setmLeftOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "click", Toast.LENGTH_SHORT).show();
            }
        });

    }
}