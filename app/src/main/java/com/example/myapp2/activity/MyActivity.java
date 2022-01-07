package com.example.myapp2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapp2.MainActivity;
import com.example.myapp2.R;


public class MyActivity extends AppCompatActivity implements View.OnClickListener {
    Button editBtn, homeBtn;
    ImageView myBtn, sugBtn, skinBtn, aboutBtn, lgtBtn;
    Intent intent;
    TextView nametx, emailtx, teltx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        initView();
    }

    private void initView() {
        editBtn = findViewById(R.id.main_btn_edit);
        homeBtn = findViewById(R.id.btn_home);
        myBtn = findViewById(R.id.img_my1);
        sugBtn = findViewById(R.id.img_suggest);
        skinBtn = findViewById(R.id.img_skin);
        aboutBtn = findViewById(R.id.img_about);
        lgtBtn = findViewById(R.id.img_logout);

        editBtn.setOnClickListener(this);
        homeBtn.setOnClickListener(this);
        myBtn.setOnClickListener(this);
        sugBtn.setOnClickListener(this);
        skinBtn.setOnClickListener(this);
        aboutBtn.setOnClickListener(this);
        lgtBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_btn_edit:
                intent = new Intent(this, RecordActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_home:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.img_about:
                intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                break;
            case R.id.img_suggest:
                intent = new Intent(this, SuggestionActivity.class);
                startActivity(intent);
                break;
            case R.id.img_my1:
                intent = new Intent(this, My1Activity.class);
                startActivity(intent);
                break;
            case R.id.img_logout:
                intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}