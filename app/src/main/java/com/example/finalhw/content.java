package com.example.finalhw;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Handler;

public class content extends AppCompatActivity {
    //晚餐吃什麼
    int aa = 0;
    TextView t1;
    ImageView img;
    FirebaseAuth mAuth;
    String email;
    //備忘錄
    rooDao rooDao;
    rooDatabase rooDatabase;
    TextView textView;
    Button binsert;
    EditText editTextname,editTextnum;
    LiveData<List<roo>> allwordLive;
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    //點頭貼直接拍照
    private Handler handler;
    private int a=0;
    ImageView imgFavorite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        Toast.makeText(this, "歡迎回來", Toast.LENGTH_LONG).show();

        t1=(TextView)findViewById(R.id.t1);

        if(savedInstanceState!=null){
            String s = savedInstanceState.getString("key");
            t1.setText(s);

        }


        SimpleDateFormat formatter = new SimpleDateFormat("MM月dd日");

        Date curDate = new Date(System.currentTimeMillis()) ; // 獲取當前時間

        String str = formatter.format(curDate);
        TextView textView = findViewById(R.id.tv_time);
        textView.setText("今天ㄉ日期\n"+str);



            Intent intentmember=getIntent();
            String H1=intentmember.getStringExtra("email");
            TextView t1=(TextView) findViewById(R.id.tv_loginnn);

            if(t1.getText() != "尚未登入ㄛ"){
                if(H1 !=null){
                    t1.setText("您已登入"+H1);

                }
            }



        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},1);
        }
        imgFavorite = (ImageView)findViewById(R.id.imageView4);

        recyclerView = findViewById(R.id.recyclerView);
        myAdapter = new MyAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);
        rooDatabase = Room.databaseBuilder(this,rooDatabase.class,"roo_database")
                .allowMainThreadQueries()
                .build();
        rooDao = rooDatabase.getrooDao();
        allwordLive = rooDao.getallwordLive();
        allwordLive.observe(this, new Observer<List<roo>>() {
            @Override
            public void onChanged(List<roo> roos) {
                myAdapter.setAllWords(roos);
                myAdapter.notifyDataSetChanged();

            }
        });
        binsert=findViewById(R.id.binsert2);
        editTextname = (EditText)findViewById(R.id.ed_do);
        editTextnum =(EditText) findViewById(R.id.ed_dead);



        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                //管理滑動情形
                int position = viewHolder.getAdapterPosition();
                myAdapter.removed(position,myAdapter,rooDao);
            }

        }).attachToRecyclerView(recyclerView);
    }


    public void open(){
        a=1;
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 0);


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if(a==1){
        Bitmap bp = (Bitmap) data.getExtras().get("data");
        imgFavorite.setImageBitmap(bp);
    }}

    public void btn_eatonclick(View view) {

        Intent intent = new Intent();
        intent.setClass(content.this,random.class);
        startActivity(intent);
        
    }


    public void btn_imgonclick(View view) {
        Intent intent = new Intent();
        intent.setClass(content.this, img.class);
        startActivity(intent);
    }

    public void btn_beiwangonclick(View view) {
        Intent intent = new Intent();
        intent.setClass(content.this, whatdo.class);
        startActivity(intent);
    }

    public void btn_memberonclick(View view) {
        Intent intent = new Intent();
        intent.setClass(content.this, member.class);
        startActivity(intent);
    }

    public void img_onclick(View view) {
        open();
    }

    public void bionclick(View view) {
            String name = editTextname.getText().toString();
            String num = editTextnum.getText().toString();
            roo word1 = new roo(name,num);

            rooDao.insertword(word1);
            editTextname.setText(null);
            editTextnum.setText(null);
    }
    public void b1onclick(View view) {
        Random x= new Random();
        aa=x.nextInt(20);
        if(aa==1){
            t1.setText(String.valueOf("就決定是炒飯了!!"));
        }else if(aa==2){
            t1.setText(String.valueOf("就決定是炒麵ㄌ!!"));
        }else if(aa==3){
            t1.setText(String.valueOf("就決定是麥噹噹ㄌ!!"));
        }else if(aa==4){
            t1.setText(String.valueOf("就決定是八方雲集ㄌ!!"));
        }else if(aa==5){
            t1.setText(String.valueOf("就決定是肯德基ㄌ!!"));
        }else if(aa==6){
            t1.setText(String.valueOf("就決定是乾麵ㄌ!!"));
        }else if(aa==7){
            t1.setText(String.valueOf("就決定是湯麵ㄌ!!"));
        }else if(aa==8){
            t1.setText(String.valueOf("就決定是滷肉飯ㄌ!!"));
        }else if(aa==9){
            t1.setText(String.valueOf("只能吃泡麵..."));
        }else if(aa==10){
            t1.setText(String.valueOf("就決定是麵線糊ㄌ!!"));
        }else if(aa==11){
            t1.setText(String.valueOf("就決定是魷魚羹ㄌ!!"));
        }else if(aa==12){
            t1.setText(String.valueOf("就決定是永和豆漿ㄌ!!"));
        }else if(aa==13){
            t1.setText(String.valueOf("就決定是滷味ㄌ!!"));
        }else if(aa==14){
            t1.setText(String.valueOf("吃萬惡的雞排><"));
        }else if(aa==15){
            t1.setText(String.valueOf("省錢不要吃好了qq"));
        }else if(aa==16){
            t1.setText(String.valueOf("就決定是豆花ㄌ!!"));
        }else if(aa==17){
            t1.setText(String.valueOf("耶去吃烤肉ㄌ!!"));
        }else if(aa==18){
            t1.setText(String.valueOf("就決定是火鍋ㄌ!!"));
        }else if(aa==19){
            t1.setText(String.valueOf("就決定是便當ㄌ!!"));
        }else if(aa==20){
            t1.setText(String.valueOf("就決定是自助餐ㄌ!!"));
        }


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("key",t1.getText().toString());
    }
}