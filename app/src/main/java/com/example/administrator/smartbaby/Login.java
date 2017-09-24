package com.example.administrator.smartbaby;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.administrator.smartbaby.util.DialogUtil;
import com.example.administrator.smartbaby.util.HttpUtil;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/24.
 */

public class Login extends Activity {
    EditText etName, etPass;
    Button bnLogin, bnCancel;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        // 获取界面中两个编辑框按钮
        etName = (EditText) findViewById(R.id.userEditText);
        etPass = (EditText) findViewById(R.id.pwdEditText);
        bnLogin = (Button) findViewById(R.id.bnLogin);
        bnCancel = (Button) findViewById(R.id.bnCancel);
        // 为按钮的单击事件绑定事件监听器
        bnCancel.setOnClickListener(new HomeListener(this));
        bnLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // 执行输入校验
                if (validate()) {
                    if (loginPro()) {
                        Intent intent = new Intent(Login.this
                                , MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    else {
                        DialogUtil.showDialog(Login.this
                                , "用户名称或者密码错误，请重新输入！", false);
                    }
                }
            }
        });
    }

    private boolean loginPro()
    {
        // 获取用户输入的用户名、密码
        String username = etName.getText().toString();
        String pwd = etPass.getText().toString();
        JSONObject jsonObj;
        try
        {
            jsonObj = query(username, pwd);
            // 如果userId 大于0
            if (jsonObj.getInt("userId") > 0)
            {
                return true;
            }
        }
        catch (Exception e)
        {
            DialogUtil.showDialog(this
                    , "服务器响应异常，请稍后再试！", false);
            e.printStackTrace();
        }

        return false;
    }

    // 对用户输入的用户名、密码进行校验
    private boolean validate()
    {
        String username = etName.getText().toString().trim();
        if (username.equals(""))
        {
            DialogUtil.showDialog(this, "用户账号是必填项！", false);
            return false;
        }
        String pwd = etPass.getText().toString().trim();
        if (pwd.equals(""))
        {
            DialogUtil.showDialog(this, "用户密码是必填项！", false);
            return false;
        }
        return true;
    }

    // 定义发送请求的方法
    private JSONObject query(String username, String password)
            throws Exception
    {
        // 使用Map封装请求参数
        Map<String, String> map = new HashMap<>();
        map.put("user", username);
        map.put("pass", password);
        String url = HttpUtil.BASE_URL + "login.jsp";
        // 发送请求
       // return new JSONObject(HttpUtil.postRequest(url, map));
        return null;
    }
}
