package com.example.calculatorapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,add,minus,multiply,divide,result,dot,modulus;
    private ImageButton delete,clear;
    private TextView input_show,output_show,input1_show,output1_show;
    private CommonFunction commonFunction;
    private DatabaseHelper databaseHelper;
    private boolean operator = false;
    public void setButton(){
        input1_show = findViewById(R.id.input1_show);
        output1_show = findViewById(R.id.output1_show);
        b1 = findViewById(R.id.one);
        b2 = findViewById(R.id.two);
        b3 = findViewById(R.id.three);
        b4 = findViewById(R.id.four);
        b5 = findViewById(R.id.five);
        b6 = findViewById(R.id.six);
        b7 = findViewById(R.id.seven);
        b8 = findViewById(R.id.eight);
        b9 = findViewById(R.id.nine);
        b0 = findViewById(R.id.zero);
        add = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        multiply = findViewById(R.id.multiply);
        divide = findViewById(R.id.div);
        clear = findViewById(R.id.clear);
        result = findViewById(R.id.equal);
        delete = findViewById(R.id.Backspace);
        input_show = findViewById(R.id.input_show);
        output_show = findViewById(R.id.output_show);
        dot = findViewById(R.id.dot);
        modulus = findViewById(R.id.modulus);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setButton();
        databaseHelper = new DatabaseHelper(this);
        commonFunction = new CommonFunction();
        dot.setOnClickListener(view -> input_show.setText(commonFunction.AddString(input_show.getText().toString(),".")));
        b0.setOnClickListener(view -> input_show.setText(commonFunction.AddString(input_show.getText().toString(),"0")));
        b1.setOnClickListener(view -> input_show.setText(commonFunction.AddString(input_show.getText().toString(),"1")));
        b2.setOnClickListener(view -> input_show.setText(commonFunction.AddString(input_show.getText().toString(),"2")));
        b3.setOnClickListener(view -> input_show.setText(commonFunction.AddString(input_show.getText().toString(),"3")));
        b4.setOnClickListener(view -> input_show.setText(commonFunction.AddString(input_show.getText().toString(),"4")));
        b5.setOnClickListener(view -> input_show.setText(commonFunction.AddString(input_show.getText().toString(),"5")));
        b6.setOnClickListener(view -> input_show.setText(commonFunction.AddString(input_show.getText().toString(),"6")));
        b7.setOnClickListener(view -> input_show.setText(commonFunction.AddString(input_show.getText().toString(),"7")));
        b8.setOnClickListener(view -> input_show.setText(commonFunction.AddString(input_show.getText().toString(),"8")));
        b9.setOnClickListener(view -> input_show.setText(commonFunction.AddString(input_show.getText().toString(),"9")));
        add.setOnClickListener(view -> {
            if(!operator) {
                input_show.setText(commonFunction.AddString(input_show.getText().toString(), "+"));
                operator = true;
            }else{
                input_show.setText(input_show.getText().toString());
            }
        });
        minus.setOnClickListener(view -> {
            if(!operator) {
                input_show.setText(commonFunction.AddString(input_show.getText().toString(),  "-"));
                operator = true;
            }else{
                input_show.setText(input_show.getText().toString());
            }
        });
        multiply.setOnClickListener(view -> {
            if(!operator) {
                input_show.setText(commonFunction.AddString(input_show.getText().toString(), "*"));
                operator = true;
            }else{
                input_show.setText(input_show.getText().toString());
            }
        });
        divide.setOnClickListener(view -> {
            if(!operator) {
                input_show.setText(commonFunction.AddString(input_show.getText().toString(), "/"));
                operator = true;
            }else{
                input_show.setText(input_show.getText().toString());
            }
        });
        modulus.setOnClickListener(view -> {
            if(!operator) {
                input_show.setText(commonFunction.AddString(input_show.getText().toString(), "%"));
                operator = true;
            }else{
                input_show.setText(input_show.getText().toString());
            }
        });
        clear.setOnClickListener(view -> {
            operator = false;
            input1_show.setText(input_show.getText().toString());
            output1_show.setText(output_show.getText().toString());
            input_show.setText("");
            output_show.setText("");
            if(!input1_show.getText().toString().isEmpty()){
                final boolean insert = databaseHelper.insert(input1_show.getText().toString(), output1_show.getText().toString());
            }
        });
        delete.setOnClickListener(view -> {
            String temp = input_show.getText().toString();
            temp = temp.substring(0,temp.length()-1);
            input_show.setText(temp);
        });
        result.setOnClickListener(view -> {
            String str = input_show.getText().toString();
            String answer=" ";
            int n = str.length();
            for(int i = 0 ; i < n; i++) {
                if(str.charAt(i)=='+'){
                    answer = commonFunction.Add(str.substring(0,i),str.substring(i+1,n));
                    break;
                }
                else if(str.charAt(i)=='-'){
                    answer = commonFunction.Minus(str.substring(0,i),str.substring(i+1,n));
                    break;
                }
                else if(str.charAt(i)=='*'){
                    answer = commonFunction.Multiply(str.substring(0,i),str.substring(i+1,n));
                    break;
                }
                else if(str.charAt(i)=='/'){
                    answer = commonFunction.Divide(str.substring(0,i),str.substring(i+1,n));
                    break;
                }
                else if(str.charAt(i)=='%'){
                    answer = commonFunction.Modulus(str.substring(0,i),str.substring(i+1,n));
                    break;
                }
                else if(i == n - 1){
                    answer = "Wrong Input!";
                }
            }
//            if(answer.isEmpty()) {
//                output_show.setText(String.format("= %s", answer));
//            } else {
//                output_show.setText(answer
//              );
//            }
            if(answer.equals("Wrong Input!")){
                output_show.setText(answer);
            }
            else {
                output_show.setText(String.format("= %s", answer));
            }
        });

    }
    public void callSecondActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), scientificCalculator.class);
        startActivity(intent);
    }
}