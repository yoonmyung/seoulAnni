package com.example.seoulunniapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Activity4 extends AppCompatActivity {
//    지하철 몰카

//    몰카 검사 신청 버튼
    Button siren;
//    사용자가 적어둔 이메일 주소를 받아오는 문자열 변수
    String useremail;
//    spinner에서 고른 호선을 받아오는 변수
    ArrayAdapter<CharSequence> line;
//    line을 토대로 spinner에서 고른 역명을 받아오는 변수
    ArrayAdapter<CharSequence> subway;
//    사용자가 고른 역명을 받아오는 문자열 변수
    String checksubway;
    int check = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity4);

        Intent intent = new Intent(this.getIntent());

        final Spinner lineSpinner = (Spinner)findViewById(R.id.lineSpinner);
        final Spinner subwaySpinner = (Spinner)findViewById(R.id.subwaySpinner);

        line = ArrayAdapter.createFromResource(this, R.array.line, android.R.layout.simple_spinner_dropdown_item);
        line.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lineSpinner.setAdapter(line);
        lineSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(line.getItem(position).equals("호선 선택")) {
                    check = 2;
                }
                else if(line.getItem(position).equals("1호선")) {
                    subway = ArrayAdapter.createFromResource(Activity4.this, R.array.line1,android.R.layout.simple_spinner_dropdown_item);
                    subway.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    subwaySpinner.setAdapter(subway);
                    subwaySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            checksubway = subway.getItem(position).toString();

                            if(checksubway.equals("역 선택")) {
                                check = 0;
                            }
                            else {
                                check = 1;
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            check = 0;
                        }
                    });
                }

                else if(line.getItem(position).equals("2호선")) {
                    subway = ArrayAdapter.createFromResource(Activity4.this, R.array.line2,android.R.layout.simple_spinner_dropdown_item);
                    subway.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    subwaySpinner.setAdapter(subway);
                    subwaySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            checksubway = subway.getItem(position).toString();

                            if(checksubway.equals("역 선택")) {
                                check = 0;
                            }
                            else {
                                check = 1;
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            check = 0;
                        }
                    });
                }

                else if(line.getItem(position).equals("3호선")) {
                    subway = ArrayAdapter.createFromResource(Activity4.this, R.array.line3,android.R.layout.simple_spinner_dropdown_item);
                    subway.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    subwaySpinner.setAdapter(subway);
                    subwaySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            checksubway = subway.getItem(position).toString();

                            if(checksubway.equals("역 선택")) {
                                check = 0;
                            }
                            else {
                                check = 1;
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            check = 0;
                        }
                    });
                }

                else if(line.getItem(position).equals("4호선")) {
                    subway = ArrayAdapter.createFromResource(Activity4.this, R.array.line4,android.R.layout.simple_spinner_dropdown_item);
                    subway.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    subwaySpinner.setAdapter(subway);
                    subwaySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            checksubway = subway.getItem(position).toString();

                            if(checksubway.equals("역 선택")) {
                                check = 0;
                            }
                            else {
                                check = 1;
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            check = 0;
                        }
                    });
                }

                else if(line.getItem(position).equals("5호선")) {
                    subway = ArrayAdapter.createFromResource(Activity4.this, R.array.line5,android.R.layout.simple_spinner_dropdown_item);
                    subway.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    subwaySpinner.setAdapter(subway);
                    subwaySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            checksubway = subway.getItem(position).toString();

                            if(checksubway.equals("역 선택")) {
                                check = 0;
                            }
                            else {
                                check = 1;
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            check = 0;
                        }
                    });
                }

                else if(line.getItem(position).equals("6호선")) {
                    subway = ArrayAdapter.createFromResource(Activity4.this, R.array.line6,android.R.layout.simple_spinner_dropdown_item);
                    subway.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    subwaySpinner.setAdapter(subway);
                    subwaySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            checksubway = subway.getItem(position).toString();

                            if(checksubway.equals("역 선택")) {
                                check = 0;
                            }
                            else {
                                check = 1;
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            check = 0;
                        }
                    });
                }

                else if(line.getItem(position).equals("7호선")) {
                    subway = ArrayAdapter.createFromResource(Activity4.this, R.array.line7,android.R.layout.simple_spinner_dropdown_item);
                    subway.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    subwaySpinner.setAdapter(subway);
                    subwaySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            checksubway = subway.getItem(position).toString();

                            if(checksubway.equals("역 선택")) {
                                check = 0;
                            }
                            else {
                                check = 1;
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            check = 0;
                        }
                    });
                }

                else if(line.getItem(position).equals("8호선")) {
                    subway = ArrayAdapter.createFromResource(Activity4.this, R.array.line8,android.R.layout.simple_spinner_dropdown_item);
                    subway.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    subwaySpinner.setAdapter(subway);
                    subwaySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            checksubway = subway.getItem(position).toString();

                            if(checksubway.equals("역 선택")) {
                                check = 0;
                            }
                            else {
                                check = 1;
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            check = 0;
                        }
                    });
                }

                else if(line.getItem(position).equals("9호선")) {
                    subway = ArrayAdapter.createFromResource(Activity4.this, R.array.line9,android.R.layout.simple_spinner_dropdown_item);
                    subway.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    subwaySpinner.setAdapter(subway);
                    subwaySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            checksubway = subway.getItem(position).toString();

                            if(checksubway.equals("역 선택")) {
                                check = 0;
                            }
                            else {
                                check = 1;
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            check = 0;
                        }
                    });
                }

                else if(line.getItem(position).equals("경의중앙선")) {
                    subway = ArrayAdapter.createFromResource(Activity4.this, R.array.linecenter,android.R.layout.simple_spinner_dropdown_item);
                    subway.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    subwaySpinner.setAdapter(subway);
                    subwaySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            checksubway = subway.getItem(position).toString();

                            if(checksubway.equals("역 선택")) {
                                check = 0;
                            }
                            else {
                                check = 1;
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            check = 0;
                        }
                    });
                }

                else if(line.getItem(position).equals("분당선")) {
                    subway = ArrayAdapter.createFromResource(Activity4.this, R.array.lineboondang,android.R.layout.simple_spinner_dropdown_item);
                    subway.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    subwaySpinner.setAdapter(subway);
                    subwaySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            checksubway = subway.getItem(position).toString();

                            if(checksubway.equals("역 선택")) {
                                check = 0;
                            }
                            else {
                                check = 1;
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            check = 0;
                        }
                    });
                }

                else if(line.getItem(position).equals("신분당선")) {
                    subway = ArrayAdapter.createFromResource(Activity4.this, R.array.linenewboondang,android.R.layout.simple_spinner_dropdown_item);
                    subway.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    subwaySpinner.setAdapter(subway);
                    subwaySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            checksubway = subway.getItem(position).toString();

                            if(checksubway.equals("역 선택")) {
                                check = 0;
                            }
                            else {
                                check = 1;
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            check = 0;
                        }
                    });
                }

                else if(line.getItem(position).equals("공항철도")) {
                    subway = ArrayAdapter.createFromResource(Activity4.this, R.array.lineairport,android.R.layout.simple_spinner_dropdown_item);
                    subway.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    subwaySpinner.setAdapter(subway);
                    subwaySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            checksubway = subway.getItem(position).toString();

                            if(checksubway.equals("역 선택")) {
                                check = 0;
                            }
                            else {
                                check = 1;
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            check = 0;
                        }
                    });
                }

                else if(line.getItem(position).equals("경춘선")) {
                    subway = ArrayAdapter.createFromResource(Activity4.this, R.array.linegyungchoon,android.R.layout.simple_spinner_dropdown_item);
                    subway.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    subwaySpinner.setAdapter(subway);
                    subwaySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            checksubway = subway.getItem(position).toString();

                            if(checksubway.equals("역 선택")) {
                                check = 0;
                            }
                            else {
                                check = 1;
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            check = 0;
                        }
                    });
                }

                else if(line.getItem(position).equals("우이신설선")) {
                    subway = ArrayAdapter.createFromResource(Activity4.this, R.array.linewooi,android.R.layout.simple_spinner_dropdown_item);
                    subway.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    subwaySpinner.setAdapter(subway);
                    subwaySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            checksubway = subway.getItem(position).toString();

                            if(checksubway.equals("역 선택")) {
                                check = 0;
                            }
                            else {
                                check = 1;
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            check = 0;
                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                check = 2;
            }
        });

        siren = (Button) findViewById(R.id.siren);
        siren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check==1) {
                    Intent email = new Intent(Intent.ACTION_SEND);
//                    email.setType(useremail);
//                    앱 구동되는지 보기위해 임시로 주석처리
                    email.setType("plain/text");
                    String[] address = {"women@seoul.go.kr"};
                    email.putExtra(Intent.EXTRA_EMAIL, address);
                    email.putExtra(Intent.EXTRA_SUBJECT, "★몰래카메라 검사 탐지 장비 신청합니다.");
                    email.putExtra(Intent.EXTRA_TEXT, checksubway+"역 화장실에 몰래카메라가 있는 것 같습니다. \n검사를 요청합니다.\n");
                    startActivity(email);
                }

                else if(check==2) {
                    new AlertDialog.Builder(siren.getContext())
                            .setTitle("선택 항목 없음")
                            .setMessage("호선을 선택해주세요.")
                            .setNeutralButton("확인", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dlg, int sumthin) {
                                }
                            })
                            .show();
                }

                else {
                    new AlertDialog.Builder(siren.getContext())
                            .setTitle("선택 항목 없음")
                            .setMessage("역을 선택해주세요.")
                            .setNeutralButton("확인", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dlg, int sumthin) {
                                }
                            })
                            .show();
                }
            }
        });
    }
}
