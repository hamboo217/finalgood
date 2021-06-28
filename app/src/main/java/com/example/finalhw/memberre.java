package com.example.finalhw;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class memberre extends AppCompatActivity {
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
        setContentView(R.layout.activity_memberre);
        b1=(Button)findViewById(R.id.btn_reok);
        b2=(Button)findViewById(R.id.btn_reclean);
        b3=(Button)findViewById(R.id.btn_loginok);
        b4=(Button)findViewById(R.id.btn_cl);


        et1=(EditText)findViewById(R.id.ed_account);
        et2=(EditText)findViewById(R.id.ed_pw);
        et3=(EditText)findViewById(R.id.ed_logaccount);
        et4=(EditText)findViewById(R.id.ed_logpw);

        tv4=(TextView)findViewById(R.id.tv_yn);
        tv8=(TextView)findViewById(R.id.tv_yn2);

        mAuth=FirebaseAuth.getInstance();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.createUserWithEmailAndPassword(et1.getText().toString(), et2.getText().toString()).addOnCompleteListener(context, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            FirebaseUser user=mAuth.getCurrentUser();
                            tv4.setText("註冊"+user.getEmail()+"成功!");
                        }else{
                            tv4.setText("註冊失敗qq"+task.getException());
                        }
                    }
                });
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et1.setText(null);
                et2.setText(null);
            }
        });

    }

    public void btnl_onclick(View view) {
        Intent intent = new Intent();
        intent.setClass(memberre.this, member.class);
        startActivity(intent);
    }
}