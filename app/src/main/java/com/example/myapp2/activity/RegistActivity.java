package com.example.myapp2.activity;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapp2.R;
import com.example.myapp2.db.DBUtils;
import com.example.myapp2.db.ItFxqConstants;

public class RegistActivity extends AppCompatActivity {
    //点击去登录组件
    private TextView goLoginTv;
    //用户名编辑框
    private EditText usernameEt;
    //密码编辑框
    private EditText pwdEt;
    //邮件编辑框
    private EditText emailEt;
    //电话号码编辑框
    private EditText telEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置注册布局
        setContentView(R.layout.activity_regist);
        //获取组件
        usernameEt = findViewById(R.id.username);
        pwdEt = findViewById(R.id.pwd);
        emailEt = findViewById(R.id.email);
        telEt = findViewById(R.id.tel);
        //绑定事件
        goLoginTv = findViewById(R.id.goLoginTv);
        goLoginTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    //注册保存用户信息
    public void saveUser(View view) {
        DBUtils dbUtils = new DBUtils(this, ItFxqConstants.DBNAME, 1);
        SQLiteDatabase db = dbUtils.getReadableDatabase();
        ContentValues values = new ContentValues();
        //获取存入的内容-用户名
        String username = usernameEt.getText().toString().trim();
        //获取存入的内容-密码
        String pwd = pwdEt.getText().toString().trim();
        //获取存入的内容-电话
        String tel = telEt.getText().toString().trim();
        //获取存入的内容-邮件
        String email = emailEt.getText().toString().trim();

        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(pwd)) {
            Toast.makeText(this, "用户名和密码不能为空", Toast.LENGTH_SHORT).show();
        } else {
            //如果已经存在 就提示
            if (DBUtils.checkUserIsExits(this, username)) {
                Toast.makeText(this, "用户名已被注册", Toast.LENGTH_SHORT).show();
            } else {
                values.put("username", username);
                values.put("password", pwdEt.getText().toString());
                values.put("tel", telEt.getText().toString());
                values.put("email", emailEt.getText().toString());
                long result = db.insert(ItFxqConstants.USER_TABLE, null, values);
                db.close();
                if (result != -1) {
                    AlertDialog.Builder dlog = new AlertDialog.Builder(this);
                    dlog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dlg, int arg1) {
                            Intent intent = new Intent(RegistActivity.this, LoginActivity.class);
                            startActivity(intent);
                        }
                    });
                    dlog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dlg, int arg1) {
                            dlg.dismiss();
                            ;
                        }
                    });
                    dlog.setMessage("保存成功,返回登录。");
                    dlog.setTitle("温馨提示");
                    dlog.show();

                }
            }
        }
    }

}