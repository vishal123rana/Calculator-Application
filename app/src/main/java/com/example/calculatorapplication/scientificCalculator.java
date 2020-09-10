package com.example.calculatorapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
public class scientificCalculator extends AppCompatActivity {
    private CommonFunction commonFunction;
    private Button zero,one,two,three,four,five,six,seven,eight,nine,factorial,power,exponent,left,right,dot,nlog,log,cos,sin,root,equal,normal;
    private Button plus,minus,modulus,multiply,divide;
    private TextView input_show1,input_show2,output_show1,output_show2;
    private DatabaseHelper databaseHelper;
    private boolean higherOperator = false;
    private boolean operator = false;
    private ImageButton clear,backspace;
   // set All Button
    private void setButton(){
        this.normal = findViewById(R.id.normal);
        this.zero = findViewById(R.id.zero1);
        this.one = findViewById(R.id.one1);
        this.two = findViewById(R.id.two1);
        this.three = findViewById(R.id.three1);
        this.four = findViewById(R.id.four1);
        this.five = findViewById(R.id.five1);
        this.six = findViewById(R.id.six1);
        this.seven = findViewById(R.id.seven1);
        this.eight = findViewById(R.id.eight1);
        this.nine = findViewById(R.id.nine1);
        this.factorial = findViewById(R.id.factorial);
        this.power = findViewById(R.id.power);
        this.exponent = findViewById(R.id.exponent);
        this.left = findViewById(R.id.left_parenthesis);
        this.right = findViewById(R.id.right_parenthesis);
        this.input_show1 = findViewById(R.id.input_show1);
        this.input_show2 = findViewById(R.id.input1_show2);
        this.output_show1 = findViewById(R.id.output_show1);
        this.output_show2 = findViewById(R.id.output_show2);
        this.clear = findViewById(R.id.clear1);
        this.backspace = findViewById(R.id.Backspace1);
        this.dot = findViewById(R.id.dot1);
        this.sin = findViewById(R.id.sin);
        this.cos = findViewById(R.id.cos);
        this.root = findViewById(R.id.square_root);
        this.nlog = findViewById(R.id.nlog);
        this.log = findViewById(R.id.log);
        this.equal = findViewById(R.id.equal1);
        this.plus = findViewById(R.id.plus1);
        this.minus = findViewById(R.id.minus1);
        this.multiply = findViewById(R.id.multiply1);
        this.divide = findViewById(R.id.divide1);
        this.modulus = findViewById(R.id.Modulus1);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scientific_calculator);
        commonFunction = new CommonFunction();  // it uses commonFunction class for perform some operation such as Add Minus subtract power modulus
        setButton();  // call set Button function
        databaseHelper = new DatabaseHelper(this);  // create DatabaseHelper instance for storing data in database (sqlite)
        zero.setOnClickListener(view -> input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"0")));  // add 0 end of string
        one.setOnClickListener(view -> input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"1")));  // add 1 end of string
        two.setOnClickListener(view -> input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"2"))); // add 2 end of string
        three.setOnClickListener(view -> input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"3"))); // add 3 end of string
        four.setOnClickListener(view -> input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"4"))); // add 4 end of string
        five.setOnClickListener(view -> input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"5"))); // add 5 end of string
        six.setOnClickListener(view -> input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"6")));  // add 6 end of string
        seven.setOnClickListener(view -> input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"7"))); // add 7 end of string
        eight.setOnClickListener(view -> input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"8")));  // add 8 end of string
        nine.setOnClickListener(view -> input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"9")));  // add 9 end of string
        dot.setOnClickListener(view -> {   //  add dot end of string
            if (input_show1.getText().toString().isEmpty()) {
                input_show1.setText(commonFunction.AddString(input_show1.getText().toString(), "0."));
            } else {
                input_show1.setText(commonFunction.AddString(input_show1.getText().toString(), "."));
            }

        });
        plus.setOnClickListener(view ->{ // add + end of string
            if(!operator) {
                input_show1.setText(commonFunction.AddString(input_show1.getText().toString(), "+"));
                operator = true;
            }else{
                input_show1.setText(input_show1.getText().toString());
            }
        });
        minus.setOnClickListener(view -> { // add - end of string
            if(!operator){
                input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"-"));
                operator = true;
            }else{
                input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),""));
            }
        });
        multiply.setOnClickListener(view ->{  // add * end of string
            if(!operator) {
                input_show1.setText(commonFunction.AddString(input_show1.getText().toString(), "*"));
                operator = true;
            }
            else{
                input_show1.setText(input_show1.getText().toString());
            }
        });
        divide.setOnClickListener(view -> {  // add / end of string
            if(!operator) {
                input_show1.setText(input_show1.getText().toString());
                operator = true;
            }else{
                input_show1.setText(input_show1.getText().toString());
            }
        });
        modulus.setOnClickListener(view -> {   // add % end of string
            if(!operator) {
                input_show1.setText(commonFunction.AddString(input_show1.getText().toString(), "%"));
                operator = true;
            }else{
                input_show1.setText(input_show1.getText().toString());
            }
        });
        left.setOnClickListener(view -> input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"(")));  // add ( end of string
        right.setOnClickListener(view -> input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),")"))); // add ) end of string
        power.setOnClickListener(view -> input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"^")));  // add power operator
        log.setOnClickListener(view -> {
            this.higherOperator = true;
            input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"log("));   // add log end of string
        });
        nlog.setOnClickListener(view -> {
            this.higherOperator = true;
            input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"ln("));  // add natural log end of string
        });
        root.setOnClickListener(view -> {
            this.higherOperator = true;
            input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"sqrt("));  // add sqrt
        });
        cos.setOnClickListener(view -> {
            this.higherOperator = true;
            input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"cos("));  // add cos
        });
        sin.setOnClickListener(view -> {
            this.higherOperator = true;
            input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"sin("));  // add sin
        });
        factorial.setOnClickListener(view -> {
            this.higherOperator = true;
            input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"!"));  // add factorial
        });
        exponent.setOnClickListener(view -> {
            this.higherOperator = true;
            input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"exp("));  // add exponent
        });
        clear.setOnClickListener(view -> {
            /// whenever we click listener that record save on above textView
            operator = false;
            input_show2.setText(input_show1.getText().toString());
            output_show2.setText(output_show1.getText().toString());
            input_show1.setText("");
            output_show1.setText("");
            if(!input_show2.getText().toString().isEmpty()){ // check upcoming record is null or not if it is not null then store data in database
                final boolean insert = databaseHelper.insert(input_show2.getText().toString(), output_show2.getText().toString());  //  insert data in database
            }                                                                                                                       // using helper method
        });
        backspace.setOnClickListener(view -> {
            /// delete every last character from TextView
            String temp = input_show1.getText().toString();   // fetch data from textView
            temp = temp.substring(0,temp.length()-1);    // remove last character from end
            input_show1.setText(temp);    // and then show  on textView
        });
        equal.setOnClickListener(view -> {
            // actual computation
            String str = input_show1.getText().toString();   // fetch string from textView
            int length = str.length();
            String answer="";  // output string where we store result
            if(!higherOperator) {
                for (int i = 0; i < length; i++) { // loop for every character
                   if(str.charAt(i)=='+'){   // if given character is + then parse input string
                       answer = commonFunction.Add(str.substring(0,i),str.substring(i+1,length)); // and perform Addition operation which implement in commonFunction class
                       break;
                   }else if(str.charAt(i)=='-'){ // if given character is - then parse input string
                       answer = commonFunction.Minus(str.substring(0,i),str.substring(i+1,length)); //perform Minus operation
                       break;
                   }else if(str.charAt(i)=='*'){ // if given character is * then parse input string
                       answer = commonFunction.Multiply(str.substring(0,i),str.substring(i+1,length)); // perform Multiply operation
                       break;
                   }else if(str.charAt(i)=='%'){
                       answer = commonFunction.Modulus(str.substring(0,i),str.substring(i+1,length));
                       break;
                   }else if(str.charAt(i)=='/'){
                       answer = commonFunction.Divide(str.substring(0,i),str.substring(i+1,length));
                       break;
                   }
                   else if(str.charAt(i)=='^'){
                       answer = commonFunction.power(str.substring(0,i),str.substring(i+1,length));
                       break;
                   }
                   else if(i==length-1){
                       answer = "Wrong Input!";
                   }
                }
            }
            else{
                if(str.charAt(length-1)=='!'){
                    answer = commonFunction.factorial(str.substring(0,length-1));
                }
                else if(str.substring(0,3).equals("log")){
                    answer = commonFunction.log(str.substring(4,length-1));
                }
                else if(str.substring(0,2).equals("ln")){
                    answer = commonFunction.nlog(str.substring(3,length-1));
                }
                else if(str.substring(0,3).equals("sin")){
                    answer = commonFunction.sin(str.substring(4,length-1));
                }
                else if(str.substring(0,3).equals("cos")){
                    answer = commonFunction.cos(str.substring(4,length-1));
                }
                else if(str.substring(0,4).equals("sqrt")){
                    answer = commonFunction.sqrt(str.substring(5,length-1));
                }
                else if(str.substring(0,3).equals("exp")){
                    answer = commonFunction.exponent(str.substring(4,length-1));
                }
                else {
                    answer = "Wrong Input!";
                }
            }
            if(answer.equals("Wrong Input!")){
                output_show1.setText(answer);
            }else {
                output_show1.setText(String.format("= %s", answer));
            }
        });
        normal.setOnClickListener(view ->{
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        });

    }

}