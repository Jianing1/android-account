package com.example.myapp2.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapp2.R;
import com.example.myapp2.db.DBUtils;

import java.util.Map;

public class My1Activity extends AppCompatActivity {
    TextView nametx, emailtx, teltx;
    Button myBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my1);
        //初始化数据
        initData();
    }

    //初始化数据
    private void initData() {
        nametx = findViewById(R.id.my1_name);
        emailtx = findViewById(R.id.my1_email);
        teltx = findViewById(R.id.my1_tel);
        //读取个人信息
        Map<String, String> userMap = DBUtils.readInfo();
        nametx.setText(userMap.get("username"));
        emailtx.setText(userMap.get("email"));
        teltx.setText(userMap.get("tel"));
    }

    public void onClick(View view) {
        finish();
    }
}