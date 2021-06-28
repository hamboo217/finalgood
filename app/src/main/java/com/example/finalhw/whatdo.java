package com.example.finalhw;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class whatdo extends AppCompatActivity {
    rooDao rooDao;
    rooDatabase rooDatabase;
    TextView textView;
    Button binsert;
    EditText editTextname,editTextnum;
    LiveData<List<roo>> allwordLive;
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bei);

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
    public void bionclick(View view) {
        String name = editTextname.getText().toString();
        String num = editTextnum.getText().toString();
        roo word1 = new roo(name,num);

        rooDao.insertword(word1);



    }

    public void bconclick(View view) {
        rooDao.deleteallword();
        roo a =new roo("d","0");
        a.zero();

    }
}