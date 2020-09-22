package com.example.calculatorapplication;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleView extends AppCompatActivity {
    private RecycleView recycleView;
    //private ArrayList<String> id;
    private ArrayList<String> input,output;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        RecyclerView recyclerView = findViewById(R.id.recycleView);
       // id = new ArrayList<>();
        input = new ArrayList<>();
        output = new ArrayList<>();
        databaseHelper = new DatabaseHelper(this);
        displayData();
        CustomAdapter customAdapter = new CustomAdapter(RecycleView.this, input, output);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(RecycleView.this));
    }
    private void displayData(){
        Cursor res = databaseHelper.getAllData();
        if(res.getCount()==0){
            Toast.makeText(this,"No data",Toast.LENGTH_LONG).show();
        }else{
            while(res.moveToNext()){
                input.add(res.getString(1));
                output.add(res.getString(2));
            }
        }
    }
}