package com.example.seoulapp1;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

public class Activity6 extends AppCompatActivity {
    Button memberoutbutton,emailus,aboutus, logout;
    String id,password;
    private final long FINISH_INTERVAL_TIME = 2000;
    private long backPressedTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_6);

        try {
            getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            getSupportActionBar().setCustomView(R.layout.activity_action_bar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        memberoutbutton = (Button)findViewById(R.id.memberoutbutton);
        emailus = (Button)findViewById(R.id.emailus);
//        aboutus = (Button)findViewById(R.id.aboutus);
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        password = intent.getStringExtra("password");

        memberoutbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder signout = new AlertDialog.Builder(Activity6.this);
                signout.setMessage("탈퇴하시겠습니까?");
                signout.setPositiveButton("네",
                        new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface arg0, int arg1){
                                JSONArray jsonarray = new JSONArray();
                                try {
                                    JSONObject jsonObject = new JSONObject();
                                    jsonObject.accumulate("identy", id);
                                    jsonObject.accumulate("password", password);
                                    jsonarray.put(jsonObject);
                                } catch (Exception e) {
                                    Log.d("exception", e.getMessage());
                                }
                                NetworkTask networkTask = new NetworkTask("api/login", "delete", null, jsonarray);
                                networkTask.execute();
                                SharedPreferences appData = getSharedPreferences("appData", Activity.MODE_PRIVATE);
                                SharedPreferences.Editor editor = appData.edit();
                                editor.putBoolean("auto",false);
                                editor.apply();
                                Toast.makeText(Activity6.this,"탈퇴 되었습니다.",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Activity6.this, Login.class);
                                startActivity(intent);
                                finish();

                            }
                        });
                signout.setNegativeButton("아니요",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(Activity6.this,"탈퇴가 취소되었습니다.",Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        });

                AlertDialog alert = signout.create();
                alert.show();
            }
        });

        emailus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.setType("plain/text");
                String[] address = {"seoulunniapp@daum.net"};
                email.putExtra(Intent.EXTRA_EMAIL, address);
                email.putExtra(Intent.EXTRA_SUBJECT, "★서울언니 앱 관련 메일입니다.");
                email.putExtra(Intent.EXTRA_TEXT, "의견 감사합니다! 내용을 입력해 주세요^_^");
                startActivity(email);
            }
        });

        logout = findViewById(R.id.logoutbutton);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity6.this, Login.class);
                SharedPreferences appData = getSharedPreferences("appData", Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor = appData.edit();
                editor.putBoolean("auto",false);
                editor.apply();
                startActivity(intent);
                Toast.makeText(Activity6.this,"로그아웃 되었습니다.",Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
    public void onBackPressed() {
        long tempTime = System.currentTimeMillis();
        long intervalTime = tempTime - backPressedTime;

        if (0 <= intervalTime && FINISH_INTERVAL_TIME >= intervalTime)
        {
            super.onBackPressed();
        }
        else
        {
            backPressedTime = tempTime;
            Intent intent = new Intent(Activity6.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
