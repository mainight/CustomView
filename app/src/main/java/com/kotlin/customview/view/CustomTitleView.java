package com.kotlin.customview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.kotlin.customview.R;

/**
 * 组合控件 ：将系统原有的控件进行组合，构成一个新的控件
 */
public class CustomTitleView extends FrameLayout implements View.OnClickListener {
    private View.OnClickListener mLeftOnClickListener;
    private Button mBackBtn;
    private TextView mTitleView;
    public CustomTitleView(Context context,AttributeSet attrs){
        super(context,attrs);
        LayoutInflater.from(context).inflate(R.layout.custom_title_view,this);
        mBackBtn=findViewById(R.id.btn_left);
        mBackBtn.setOnClickListener(this);
        mTitleView=findViewById(R.id.title_tv);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_left:
                if (mLeftOnClickListener!=null){
                    mLeftOnClickListener.onClick(v);
                }
                break;
        }
    }

    public void setmLeftOnClickListener(OnClickListener mLeftOnClickListener) {
        this.mLeftOnClickListener = mLeftOnClickListener;
    }

    public void setTitle(String title){
        mTitleView.setText(title);
    }
}
