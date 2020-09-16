package com.example.calculatorapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class History extends AppCompatActivity {
    private Button view,delete,back;
    private EditText id;
    private DatabaseHelper databaseHelper;
    private void setButton(){
        view = findViewById(R.id.viewAllData);
        delete = findViewById(R.id.deleteData);
        id = findViewById(R.id.editTextNumber);
        back = findViewById(R.id.back);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        databaseHelper = new DatabaseHelper(this);
        setButton();
        view.setOnClickListener((view)->{   // view All data in Alert Dialog builder
            Cursor res = databaseHelper.getAllData();
            if (res.getCount() == 0) {
                //show Message
                showMessage("Error","Nothing Found");
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            while(res.moveToNext()){
              stringBuilder.append("ID :").append(res.getString(0)).append("\n");
              stringBuilder.append("Input : ").append(res.getString(1)).append("\n");
              stringBuilder.append("Output : ").append(res.getString(2)).append("\n");
            }
            showMessage("Data",stringBuilder.toString());
        });
        delete.setOnClickListener((view)->{
            String s = id.getText().toString();  /// delete data on the basis of id
            int res = databaseHelper.Delete(s);
            if(res > 0){
                Toast.makeText(getApplicationContext(),"Data Updated",Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getApplicationContext(),"Data not Updated",Toast.LENGTH_LONG).show();
            }
        });
        back.setOnClickListener((view)->{  //switch activity
            Intent intent = new Intent(History.this,scientificCalculator.class);
            startActivity(intent);
        });
    }
    public void showMessage(String title,String message){
        AlertDialog.Builder builder = new AlertDialog.Builder( this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void recyclerView(View view) {
        Intent intent = new Intent(History.this,RecycleView.class);
        startActivity(intent);
    }
}