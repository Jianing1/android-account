package com.example.myapp2.activity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapp2.MainActivity;
import com.example.myapp2.R;
import com.example.myapp2.db.DBUtils;
import com.example.myapp2.db.ItFxqConstants;

public class LoginActivity extends AppCompatActivity {
    //注册组件
    private TextView regTv;
    //登录组件
    private Button loginBtn;
    //用户名称
    private EditText loginNameEt;
    //密码
    private EditText loginPwdEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置布局文件
        setContentView(R.layout.activity_login);
        //创建数据库 /data/data/cn.itfxq.wordsapp/database/xxx.db
        DBUtils dbUtils = new DBUtils(this, ItFxqConstants.DBNAME, 1);
        SQLiteDatabase dataBase = dbUtils.getReadableDatabase();

        //注册
        regTv = findViewById(R.id.regTv);
        loginBtn = findViewById(R.id.loginBtn);
        loginNameEt = findViewById(R.id.log_name);
        loginPwdEt = findViewById(R.id.log_pwd);
        //登录监听事件
        regTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this, RegistActivity.class);
                //启动
                startActivity(intent);
            }
        });

    }

    //登录系统
    public void loginSys(View view) {
        SQLiteDatabase db = DBUtils.getDbHelper(LoginActivity.this);
        String username = loginNameEt.getText().toString().trim();
        String pwd = loginPwdEt.getText().toString().trim();
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("password", pwd);

        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(pwd)) {
            Toast.makeText(this, "用户名和密码不能为空", Toast.LENGTH_SHORT).show();
        } else {
            if (DBUtils.checkUserIsExits(LoginActivity.this, username)) {
                //如果存在 就登录
                if (DBUtils.userLogin(LoginActivity.this, username, pwd)) {
                    Intent intent = new Intent();
                    intent.setClass(LoginActivity.this, MainActivity.class);
                    //启动
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "密码错误!", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "用户名不存在,请注册!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}