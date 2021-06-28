package com.example.finalhw;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class member extends AppCompatActivity {
    Activity context=this;
    Button b1,b2,b3,b4;
    TextView tv4,tv8;
    EditText et1,et2,et3,et4;
    String email;
    public static int ab;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memberr);
        b1=(Button)findViewById(R.id.btn_reok);
        b2=(Button)findViewById(R.id.btn_cl);
        b3=(Button)findViewById(R.id.btn_loginok);
        b4=(Button)findViewById(R.id.btn_change3);


        et1=(EditText)findViewById(R.id.ed_account);
        et2=(EditText)findViewById(R.id.ed_pw);
        et3=(EditText)findViewById(R.id.ed_logaccount);
        et4=(EditText)findViewById(R.id.ed_logpw);

        tv4=(TextView)findViewById(R.id.tv_yn);
        tv8=(TextView)findViewById(R.id.tv_yn2);

        mAuth=FirebaseAuth.getInstance();

//        b1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mAuth.createUserWithEmailAndPassword(et1.getText().toString(), et2.getText().toString()).addOnCompleteListener(context, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if(task.isSuccessful()){
//                            FirebaseUser user=mAuth.getCurrentUser();
//                            tv4.setText("註冊"+user.getEmail()+"成功!");
//                        }else{
//                            tv4.setText("註冊失敗qq"+task.getException());
//                        }
//                    }
//                });
//            }
//        });
//
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et3.setText(null);
                et4.setText(null);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signInWithEmailAndPassword(et3.getText().toString(),et4.getText().toString()).addOnCompleteListener(context, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            FirebaseUser user=mAuth.getCurrentUser();
//                            tv8.setText("登入"+user.getEmail()+"成功");
                            email=user.getEmail();
                            Intent intentmember=new Intent();
                            intentmember.setClass(member.this,content.class);
//                FirebaseUser user=mAuth.getCurrentUser();
//                email=user.getEmail();
                            intentmember.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                            intentmember.putExtra("email",email);
                            startActivity(intentmember);
                        }else{
                            tv8.setText("登入失敗qq");
                        }
                    }
                });
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentmember=new Intent();
                intentmember.setClass(member.this,memberre.class);
//                FirebaseUser user=mAuth.getCurrentUser();
//                email=user.getEmail();
                intentmember.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intentmember.putExtra("email",email);
                startActivity(intentmember);
            }
        });
    }


}