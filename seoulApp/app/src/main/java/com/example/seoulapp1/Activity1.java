package com.example.seoulapp1;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;


import java.util.ArrayList;
import java.util.List;

public class Activity1 extends AppCompatActivity {
    //    몰카 검사 신청 버튼
    Button siren;
    //    사용자가 적어둔 이메일 주소를 받아오는 문자열 변수
    //    spinner에서 고른 호선을 받아오는 변수
    ArrayAdapter<CharSequence> line;
    //    line을 토대로 spinner에서 고른 역명을 받아오는 변수
    ArrayAdapter<CharSequence> subway;
    //    사용자가 고른 역명을 받아오는 문자열 변수
    String checksubway;
    int check = 1;
//    private List<String> list;          // 데이터를 넣은 리스트변수
//    private ListView listView;          // 검색을 보여줄 리스트변수
//    private EditText editSearch;        // 검색어를 입력할 Input 창
//    private SearchAdapter adapter;      // 리스트뷰에 연결할 아답터
//    private ArrayList<String> arraylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        try {
            getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            getSupportActionBar().setCustomView(R.layout.activity_action_bar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        final Spinner lineSpinner = (Spinner) findViewById(R.id.lineSpinner);
        final Spinner subwaySpinner = (Spinner) findViewById(R.id.subwaySpinner);

        line = ArrayAdapter.createFromResource(Activity1.this, R.array.line, R.layout.spinner_item);
        line.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        lineSpinner.setAdapter(line);
        lineSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (line.getItem(position).equals("호선 선택")) {
                    check = 2;
                } else if (line.getItem(position).equals("1호선")) {
                    subway = ArrayAdapter.createFromResource(Activity1.this, R.array.line1, R.layout.spinner_item);
                    subway.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
//                    android.R.layout.simple_spinner_dropdown_item
                    subwaySpinner.setAdapter(subway);
                    subwaySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            checksubway = subway.getItem(position).toString();

                            if (checksubway.equals("역 선택")) {
                                check = 0;
                            } else {
                                check = 1;
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            check = 0;
                        }
                    });
                } else if (line.getItem(position).equals("2호선")) {
                    subway = ArrayAdapter.createFromResource(Activity1.this, R.array.line2, R.layout.spinner_item);
                    subway.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    subwaySpinner.setAdapter(subway);
                    subwaySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            checksubway = subway.getItem(position).toString();

                            if (checksubway.equals("역 선택")) {
                                check = 0;
                            } else {
                                check = 1;
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            check = 0;
                        }
                    });
                } else if (line.getItem(position).equals("3호선")) {
                    subway = ArrayAdapter.createFromResource(Activity1.this, R.array.line3, R.layout.spinner_item);
                    subway.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    subwaySpinner.setAdapter(subway);
                    subwaySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            checksubway = subway.getItem(position).toString();

                            if (checksubway.equals("역 선택")) {
                                check = 0;
                            } else {
                                check = 1;
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            check = 0;
                        }
                    });
                } else if (line.getItem(position).equals("4호선")) {
                    subway = ArrayAdapter.createFromResource(Activity1.this, R.array.line4, R.layout.spinner_item);
                    subway.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    subwaySpinner.setAdapter(subway);
                    subwaySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            checksubway = subway.getItem(position).toString();

                            if (checksubway.equals("역 선택")) {
                                check = 0;
                            } else {
                                check = 1;
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            check = 0;
                        }
                    });
                } else if (line.getItem(position).equals("5호선")) {
                    subway = ArrayAdapter.createFromResource(Activity1.this, R.array.line5, R.layout.spinner_item);
                    subway.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    subwaySpinner.setAdapter(subway);
                    subwaySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            checksubway = subway.getItem(position).toString();

                            if (checksubway.equals("역 선택")) {
                                check = 0;
                            } else {
                                check = 1;
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            check = 0;
                        }
                    });
                } else if (line.getItem(position).equals("6호선")) {
                    subway = ArrayAdapter.createFromResource(Activity1.this, R.array.line6, R.layout.spinner_item);
                    subway.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    subwaySpinner.setAdapter(subway);
                    subwaySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            checksubway = subway.getItem(position).toString();

                            if (checksubway.equals("역 선택")) {
                                check = 0;
                            } else {
                                check = 1;
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            check = 0;
                        }
                    });
                } else if (line.getItem(position).equals("7호선")) {
                    subway = ArrayAdapter.createFromResource(Activity1.this, R.array.line7, R.layout.spinner_item);
                    subway.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    subwaySpinner.setAdapter(subway);
                    subwaySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            checksubway = subway.getItem(position).toString();

                            if (checksubway.equals("역 선택")) {
                                check = 0;
                            } else {
                                check = 1;
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            check = 0;
                        }
                    });
                } else if (line.getItem(position).equals("8호선")) {
                    subway = ArrayAdapter.createFromResource(Activity1.this, R.array.line8, R.layout.spinner_item);
                    subway.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    subwaySpinner.setAdapter(subway);
                    subwaySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            checksubway = subway.getItem(position).toString();

                            if (checksubway.equals("역 선택")) {
                                check = 0;
                            } else {
                                check = 1;
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            check = 0;
                        }
                    });
                } else if (line.getItem(position).equals("9호선")) {
                    subway = ArrayAdapter.createFromResource(Activity1.this, R.array.line9, R.layout.spinner_item);
                    subway.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    subwaySpinner.setAdapter(subway);
                    subwaySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            checksubway = subway.getItem(position).toString();

                            if (checksubway.equals("역 선택")) {
                                check = 0;
                            } else {
                                check = 1;
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            check = 0;
                        }
                    });
                } else if (line.getItem(position).equals("경의중앙선")) {
                    subway = ArrayAdapter.createFromResource(Activity1.this, R.array.linecenter, R.layout.spinner_item);
                    subway.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    subwaySpinner.setAdapter(subway);
                    subwaySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            checksubway = subway.getItem(position).toString();

                            if (checksubway.equals("역 선택")) {
                                check = 0;
                            } else {
                                check = 1;
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            check = 0;
                        }
                    });
                } else if (line.getItem(position).equals("분당선")) {
                    subway = ArrayAdapter.createFromResource(Activity1.this, R.array.lineboondang, R.layout.spinner_item);
                    subway.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    subwaySpinner.setAdapter(subway);
                    subwaySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            checksubway = subway.getItem(position).toString();

                            if (checksubway.equals("역 선택")) {
                                check = 0;
                            } else {
                                check = 1;
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            check = 0;
                        }
                    });
                } else if (line.getItem(position).equals("신분당선")) {
                    subway = ArrayAdapter.createFromResource(Activity1.this, R.array.linenewboondang, R.layout.spinner_item);
                    subway.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    subwaySpinner.setAdapter(subway);
                    subwaySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            checksubway = subway.getItem(position).toString();

                            if (checksubway.equals("역 선택")) {
                                check = 0;
                            } else {
                                check = 1;
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            check = 0;
                        }
                    });
                } else if (line.getItem(position).equals("공항철도")) {
                    subway = ArrayAdapter.createFromResource(Activity1.this, R.array.lineairport, R.layout.spinner_item);
                    subway.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    subwaySpinner.setAdapter(subway);
                    subwaySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            checksubway = subway.getItem(position).toString();

                            if (checksubway.equals("역 선택")) {
                                check = 0;
                            } else {
                                check = 1;
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            check = 0;
                        }
                    });
                } else if (line.getItem(position).equals("경춘선")) {
                    subway = ArrayAdapter.createFromResource(Activity1.this, R.array.linegyungchoon, R.layout.spinner_item);
                    subway.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    subwaySpinner.setAdapter(subway);
                    subwaySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            checksubway = subway.getItem(position).toString();

                            if (checksubway.equals("역 선택")) {
                                check = 0;
                            } else {
                                check = 1;
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            check = 0;
                        }
                    });
                } else if (line.getItem(position).equals("우이신설선")) {
                    subway = ArrayAdapter.createFromResource(Activity1.this, R.array.linewooi, R.layout.spinner_item);
                    subway.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    subwaySpinner.setAdapter(subway);
                    subwaySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            checksubway = subway.getItem(position).toString();

                            if (checksubway.equals("역 선택")) {
                                check = 0;
                            } else {
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

        Intent intent = new Intent(this.getIntent());
        final String id = intent.getStringExtra("id");

        siren = (Button) findViewById(R.id.siren);
        siren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check == 1) {
                    Intent email = new Intent(Intent.ACTION_SEND);
                    email.setType("plain/text");
                    String[] address = {"women@seoul.go.kr"};
                    email.putExtra(Intent.EXTRA_EMAIL, address);
                    email.putExtra(Intent.EXTRA_SUBJECT, "★몰래카메라 검사 탐지 장비 신청합니다.");
                    email.putExtra(Intent.EXTRA_TEXT, checksubway + "역 화장실에 몰래카메라가 있는 것 같습니다. \n검사를 요청합니다.\n");
                    startActivity(email);
                } else if (check == 2) {
                    new AlertDialog.Builder(siren.getContext())
                            .setTitle("선택 항목 없음")
                            .setMessage("호선을 선택해주세요.")
                            .setNeutralButton("확인", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dlg, int sumthin) {
                                }
                            })
                            .show();
                } else {
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
//        editSearch = (EditText) findViewById(R.id.editSearch);
//        listView = (ListView) findViewById(R.id.listView);
//
//        // 리스트를 생성한다.
//        list = new ArrayList<String>();
//
//        //intent 다현 추가
//        listView.setAdapter(adapter);
//
//        //페이지 쪽수 설정 !!
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//
//                switch (position) {
//                    case 0:
//                        Intent newActivity1 = new Intent(Activity1.this, ScrollingActivity1.class);
//                        startActivity(newActivity1);
//                        break;
//
//                    case 1:
//                        Intent newActivity4 = new Intent(Activity1.this, ScrollingActivity4.class);
//                        startActivity(newActivity4);
//                        break;
//
//
//                    case 2:
//                        Intent newActivity3 = new Intent(Activity1.this, ScrollingActivity3.class);
//                        startActivity(newActivity3);
//                        break;
//
//                    case 3:
//                        Intent newActivity2 = new Intent(Activity1.this, ScrollingActivity2.class);
//                        startActivity(newActivity2);
//                        break;
//
//                    case 4:
//                        Uri uri = Uri.parse("http://www.victimsinfo.govt.nz/assets/Translations/Korean/MOJ0341.5-sexual-violence-A4-factsheet-KOR.pdf");
//                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                        startActivity(intent);
//                }
//            }
//        });
//
//
//        // 검색에 사용할 데이터을 미리 저장한다.
//        settingList();
//
//        // 리스트의 모든 데이터를 arraylist에 복사한다.// list 복사본을 만든다.
//        arraylist = new ArrayList<String>();
//        arraylist.addAll(list);
//
//        // 리스트에 연동될 아답터를 생성한다.
//        adapter = new SearchAdapter(list, this);
//
//        // 리스트뷰에 아답터를 연결한다.
//        listView.setAdapter(adapter);
//
//        // input창에 검색어를 입력시 "addTextChangedListener" 이벤트 리스너를 정의한다.
//        editSearch.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//                // input창에 문자를 입력할때마다 호출된다.
//                // search 메소드를 호출한다.
//                String text = editSearch.getText().toString();
//                search(text);
//            }
//        });
//
//
    }
//
//    // 검색을 수행하는 메소드
//    public void search(String charText) {
//
//        // 문자 입력시마다 리스트를 지우고 새로 뿌려준다.
//        list.clear();
//
//        // 문자 입력이 없을때는 모든 데이터를 보여준다.
//        if (charText.length() == 0) {
//            list.addAll(arraylist);
//        }
//        // 문자 입력을 할때..
//        else
//        {
//            // 리스트의 모든 데이터를 검색한다.
//            for(int i = 0;i < arraylist.size(); i++)
//            {
//                // arraylist의 모든 데이터에 입력받은 단어(charText)가 포함되어 있으면 true를 반환한다.
//                if (arraylist.get(i).toLowerCase().contains(charText))
//                {
//                    // 검색된 데이터를 리스트에 추가한다.
//                    list.add(arraylist.get(i));
//                }
//            }
//        }
//        // 리스트 데이터가 변경되었으므로 아답터를 갱신하여 검색된 데이터를 화면에 보여준다.
//        adapter.notifyDataSetChanged();
//    }
//
//    // 검색에 사용될 데이터를 리스트에 추가한다. !!
//    private void settingList(){
//        list.add("도움을 받을 수 있는 전문기관 / 센터 등의 정보");
//        list.add("피해자 본인의 대처 방법");
//        list.add("주변인, 타인의 대처 방법");
//        list.add("피해자 본인의 대처 방법 + 부가 설명");
//        list.add("성폭력 피해자를 위한 안내서 (다운)");
//    }
}
