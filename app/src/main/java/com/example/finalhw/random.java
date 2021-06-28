package com.example.finalhw;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Random;

public class random extends AppCompatActivity {
    int a = 0;
    TextView t1;
    ImageView img;
    FirebaseAuth mAuth;
    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);
        t1=(TextView)findViewById(R.id.t1);


    }

    public void b1onclick(View view) {
        Random x= new Random();
        a=x.nextInt(20);
        if(a==1){
            t1.setText(String.valueOf("炒飯"));
        }else if(a==2){
            t1.setText(String.valueOf("炒麵"));
        }else if(a==3){
        t1.setText(String.valueOf("麥當勞"));
        }else if(a==4){
            t1.setText(String.valueOf("八方雲集"));
        }else if(a==5){
            t1.setText(String.valueOf("肯德基"));
        }else if(a==6){
            t1.setText(String.valueOf("乾麵"));
        }else if(a==7){
            t1.setText(String.valueOf("湯麵"));
        }else if(a==8){
            t1.setText(String.valueOf("滷肉飯"));
        }else if(a==9){
            t1.setText(String.valueOf("泡麵..."));
        }else if(a==10){
            t1.setText(String.valueOf("麵線糊"));
        }else if(a==11){
            t1.setText(String.valueOf("魷魚羹"));
        }else if(a==12){
            t1.setText(String.valueOf("永和豆漿"));
        }else if(a==13){
            t1.setText(String.valueOf("滷味"));
        }else if(a==14){
            t1.setText(String.valueOf("雞排"));
        }else if(a==15){
            t1.setText(String.valueOf("省錢不要吃好了"));
        }else if(a==16){
            t1.setText(String.valueOf("豆花"));
        }else if(a==17){
            t1.setText(String.valueOf("烤肉"));
        }else if(a==18){
            t1.setText(String.valueOf("火鍋"));
        }else if(a==19){
            t1.setText(String.valueOf("便當"));
        }else if(a==20){
            t1.setText(String.valueOf("自助餐"));
        }

    }
    public void btn_back_onclick(View view) {
        Intent intent = new Intent();
        intent.setClass(random.this, content.class);
//        FirebaseUser user=mAuth.getCurrentUser();
//        email=user.getEmail();
//        intent.putExtra("email",email);
        startActivity(intent);
    }
}