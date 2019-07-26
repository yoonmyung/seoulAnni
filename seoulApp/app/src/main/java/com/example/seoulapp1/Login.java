package com.example.seoulapp1;

import android.app.Activity;
import android.content.Intent;

import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.seoulapp1.MainActivity;
import com.example.seoulapp1.NetworkTask;
import com.example.seoulapp1.R;
import com.example.seoulapp1.Signin;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.net.ssl.SSLSessionContext;

public class Login extends AppCompatActivity {

    EditText idInput, passwordInput;
    Button login, signupButton;
    private SharedPreferences appData, auto;
    private CheckBox idcheck, logincheck;
    private String id, pwd;
    private boolean saveLoginData, saveIdData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        try {
            getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            getSupportActionBar().setCustomView(R.layout.activity_action_bar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // 설정값 불러오기
        appData = getSharedPreferences("appData", Activity.MODE_PRIVATE);
        idInput = (EditText) findViewById(R.id.emailInput);
        passwordInput = (EditText) findViewById(R.id.passwordInput);
        login = (Button) findViewById(R.id.loginButton);
        signupButton = (Button) findViewById(R.id.signupButton);
        idcheck = (CheckBox) findViewById(R.id.idBox);
        logincheck = (CheckBox) findViewById(R.id.checkBox);
        final Boolean validation;
        load();
        // load 함수에 이전에 로그인 정보를 저장시킨 기록이 있다면
        if (saveLoginData) {
            Intent intent = new Intent(Login.this, MainActivity.class);
            intent.putExtra("id", id);
            intent.putExtra("password", pwd);
            Toast.makeText(Login.this, "자동로그인 되었습니다.", Toast.LENGTH_SHORT).show();
            startActivity(intent);
            finish();
        }
        if (saveIdData) {
            idInput.setText(id);
            idcheck.setChecked(saveIdData);
        }

        signupButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Signin.class);
                startActivity(intent);
                finish();
            }
        });
        login.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = idInput.getText().toString();
                pwd = passwordInput.getText().toString();
                Boolean validation = loginValidation(id, pwd);
                if (validation) {
                    Toast.makeText(Login.this, "로그인 성공", Toast.LENGTH_LONG).show();
                    // 로그인 성공시 저장 처리, 예제는 무조건 저장
                    loginsave();
                    idsave();
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    intent.putExtra("id", id);
                    intent.putExtra("password", pwd);
                    startActivity(intent);
                    finish();

                } else {
                    Toast.makeText(Login.this, "로그인 실패", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    // 설정값을 저장하는 함수
    private void loginsave() {
        // SharedPreferences 객체만으론 저장 불가능 Editor 사용
        SharedPreferences.Editor editor = appData.edit();
        // 에디터객체.put타입( 저장시킬 이름, 저장시킬 값 )
        // 저장시킬 이름이 이미 존재하면 덮어씌움
        editor.putString("ID", idInput.getText().toString().trim());
        editor.putString("PWD", passwordInput.getText().toString().trim());
        editor.putBoolean("auto", logincheck.isChecked());
        // apply, commit 을 안하면 변경된 내용이 저장되지 않음
        editor.apply();
    }

    private void idsave() {
        SharedPreferences.Editor editor = appData.edit();
        editor.putBoolean("SAVE_ID", idcheck.isChecked());
        editor.putString("ID", idInput.getText().toString().trim());
        editor.apply();
    }

    // 설정값을 불러오는 함수
    private void load() {
        // SharedPreferences 객체.get타입( 저장된 이름, 기본값 )
        // 저장된 이름이 존재하지 않을 시 기본값
        Intent intent = getIntent();
        saveIdData = appData.getBoolean("SAVE_ID", false);
        saveLoginData = appData.getBoolean("auto", false);
        id = appData.getString("ID", "");
        pwd = appData.getString("PWD", "");
        logincheck.setChecked(saveLoginData);


    }

    private boolean loginValidation(String id, String password) {

        boolean validation = false;
        try {
            NetworkTask getlogin = new NetworkTask("api/login", "get", null, null);
            getlogin.execute();
            String s = getlogin.get();
            Log.d("getlogin:", s);
            JSONArray loginList = new JSONArray(s);
            for (int i = 0; i < loginList.length(); i++) {
                JSONObject json = (JSONObject) loginList.get(i);
                Log.d("da", json.getString("identy"));
                if (json.getString("identy").equals(id) && json.getString("password").equals(password)) {
                    validation = true;
                    break;
                }
            }

        } catch (Exception e) {
        }
        return validation;
    }
}
