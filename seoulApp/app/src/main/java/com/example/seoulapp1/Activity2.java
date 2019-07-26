package com.example.seoulapp1;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;
import java.util.List;

public class Activity2 extends AppCompatActivity {
    private Context mContext;
    private FirebaseStorage storage;
    private FirebaseDatabase database;
    private List<ImageDTO> imageDTOS = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        mContext = getApplicationContext();
        storage= FirebaseStorage.getInstance();
        database=FirebaseDatabase.getInstance();



        try {
            getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            getSupportActionBar().setCustomView(R.layout.activity_action_bar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        GridView gv = (GridView)findViewById(R.id.gridView1);

        final MyAdapter adapter = new MyAdapter(
                getApplicationContext(), R.layout.row, imageDTOS
        );
        gv.setAdapter(adapter);

        database.getReference().child("images").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                imageDTOS.clear();
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    ImageDTO imageDTO = snapshot.getValue(ImageDTO.class);
                    imageDTOS.add(imageDTO);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        //for develope
//        final Button button = findViewById(R.id.upload);
//        button.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v){
//                Intent intent = new Intent(mContext,upload_view.class);
//                System.out.println("?????????????here");
//                startActivity(intent);
//            }
//        });

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                try {
                    getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setCustomView(R.layout.activity_action_bar);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                //Toast.makeText(MainActivity.this , " " + i + " "+l,Toast.LENGTH_SHORT ).show();
                ImageDTO imageDTO3 = new ImageDTO();
                imageDTO3.title = imageDTOS.get(i).title;
                imageDTO3.description = imageDTOS.get(i).description;
                imageDTO3.imageUrl = imageDTOS.get(i).imageUrl;
                Intent intent2 = new Intent(mContext , Board.class);
                System.out.println(imageDTO3.imageUrl);
                System.out.println("nani doGGO GA2222???????????????");
                System.out.println("nanininini???????????????? "+i);
                Bundle bundle = new Bundle();
                bundle.putSerializable("mydata",imageDTO3);
                intent2.putExtras(bundle);
                startActivity(intent2);

            }
        });

    }// end of onCreate
}// end of class

class MyAdapter extends BaseAdapter{
    Context context;
    int layout;
    //int img[];
    private List<ImageDTO> sendimageDTOS = new ArrayList<>();
    String sendtitle;
    String senddescription;
    LayoutInflater inf;

    public MyAdapter (Context context , int layout , List<ImageDTO> sended){

        this.context = context;
        this.layout = layout;
        this.sendimageDTOS = sended;
        inf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return sendimageDTOS.size();
    }

    @Override
    public Object getItem(int position) {
        return sendimageDTOS.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if(view == null)
            view = inf.inflate(layout,null);

        ImageView iv = (ImageView)view.findViewById(R.id.imageView1);
        TextView tv = (TextView)view.findViewById(R.id.textView2);
        //iv.setImageResource(sendimageDTOS.get(position).imageUrl);
        tv.setText(sendimageDTOS.get(position).title);
        Glide.with(view.getContext())
                .load(sendimageDTOS.get(position).imageUrl)
                .thumbnail(0.01f)
                .placeholder(R.mipmap.ic_launcher)
                .override(500,400)
                .centerCrop()
                .into(iv);

        return view;
    }
}


