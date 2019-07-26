package com.example.seoulapp1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.seoulapp1.NetworkTask;

import org.json.JSONArray;
import org.json.JSONObject;

public class Signin extends AppCompatActivity {

    EditText emailInput,passwordInput,passwordtwiceInput;
    Button signinButton,exitButton,emailButton;
    String password;
    String passwordtwice;
    String email;
    Boolean vali;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);

        try {
            getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            getSupportActionBar().setCustomView(R.layout.activity_action_bar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        emailInput = (EditText) findViewById(R.id.emailInput);
        passwordInput = (EditText) findViewById(R.id.passwordInput);
        passwordtwiceInput = (EditText) findViewById(R.id.passwordtwiceInput);
        signinButton = (Button) findViewById(R.id.signinButton);
        exitButton = (Button) findViewById(R.id.exitButton);
        emailButton = (Button) findViewById(R.id.emailButton);

        emailButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = emailInput.getText().toString();
                vali = emailValidation(email);
                if (vali == true && email != null)
                    Toast.makeText(Signin.this, "유효한 이메일입니다.", Toast.LENGTH_SHORT).show();
                else {
                    Toast.makeText(Signin.this, "유효하지 않는 이메일입니다. 다시 입력해주세요.", Toast.LENGTH_LONG).show();
                    emailInput.setText(null);
                    emailInput.setHint("이메일 입력");
                }
            }
        });

        signinButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                password=passwordInput.getText().toString();
                passwordtwice=passwordtwiceInput.getText().toString();
                if (password.equals(passwordtwice)) {
                    JSONArray jsonarray = new JSONArray();
                    try {
                        JSONObject jsonObject = new JSONObject();
                        password = passwordInput.getText().toString();
                        email = emailInput.getText().toString();
                        jsonObject.accumulate("identy", email);
                        jsonObject.accumulate("password", password);
                        jsonarray.put(jsonObject);
                        NetworkTask networkTask = new NetworkTask("api/login", "post", null, jsonarray);
                        networkTask.execute();
                    } catch (Exception e) {
                        Log.d("exception", e.getMessage());
                    }
                    Intent intent = new Intent(Signin.this, Login.class);
                    startActivity(intent);
                    finish();

                }
                else{
                    Toast.makeText(Signin.this,"비밀번호를 틀리게 입력했습니다. 다시 입력해주세요.",Toast.LENGTH_SHORT).show();
                }
            }
        });

        exitButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Signin.this, Login.class);
                startActivity(intent);
                finish();
            }
        });


    }
    private boolean emailValidation(String id) {

        boolean validation = true;
        try {
            NetworkTask getemail = new NetworkTask("api/login", "get", null, null);
            getemail.execute();
            String s = getemail.get();
            if(s != null) {
                Log.d("getemail:", s);
                JSONArray emailList = new JSONArray(s);
                for (int i = 0; i < emailList.length(); i++) {
                    JSONObject json = (JSONObject) emailList.get(i);
                    if (!json.getString("identy").equals(id)) {
                        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(id).matches())
                            validation = false;
                        else
                            validation = true;
                    }
                    else
                        validation = false;
                }
            }

        }
        catch (Exception e) {
        }
        return validation;
    }
}