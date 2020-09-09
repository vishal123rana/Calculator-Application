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
    private boolean higherOperator = false;
    private ImageButton clear,backspace;
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
        commonFunction = new CommonFunction();
        setButton();
        zero.setOnClickListener(view -> input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"0")));
        one.setOnClickListener(view -> input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"1")));
        two.setOnClickListener(view -> input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"2")));
        three.setOnClickListener(view -> input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"3")));
        four.setOnClickListener(view -> input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"4")));
        five.setOnClickListener(view -> input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"5")));
        six.setOnClickListener(view -> input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"6")));
        seven.setOnClickListener(view -> input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"7")));
        eight.setOnClickListener(view -> input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"8")));
        nine.setOnClickListener(view -> input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"9")));
        dot.setOnClickListener(view -> {
            if (input_show1.getText().toString().isEmpty()) {
                input_show1.setText(commonFunction.AddString(input_show1.getText().toString(), "0."));
            } else {
                input_show1.setText(commonFunction.AddString(input_show1.getText().toString(), "."));
            }

        });
        plus.setOnClickListener(view -> input_show1.setText(commonFunction.AddString(input_show1.getText().toString()," + ")));
        minus.setOnClickListener(view -> input_show1.setText(commonFunction.AddString(input_show1.getText().toString()," - ")));
        multiply.setOnClickListener(view -> input_show1.setText(commonFunction.AddString(input_show1.getText().toString()," * ")));
        divide.setOnClickListener(view -> input_show1.setText(commonFunction.AddString(input_show1.getText().toString()," / ")));
        modulus.setOnClickListener(view -> input_show1.setText(commonFunction.AddString(input_show1.getText().toString()," % ")));
        left.setOnClickListener(view -> input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"(")));
        right.setOnClickListener(view -> input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),")")));
        power.setOnClickListener(view -> input_show1.setText(commonFunction.AddString(input_show1.getText().toString()," ^ ")));
        log.setOnClickListener(view -> {
            this.higherOperator = true;
            input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"log("));
        });
        nlog.setOnClickListener(view -> {
            this.higherOperator = true;
            input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"ln("));
        });
        root.setOnClickListener(view -> {
            this.higherOperator = true;
            input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"sqrt("));
        });
        cos.setOnClickListener(view -> {
            this.higherOperator = true;
            input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"cos("));
        });
        sin.setOnClickListener(view -> {
            this.higherOperator = true;
            input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"sin("));
        });
        factorial.setOnClickListener(view -> {
            this.higherOperator = true;
            input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"!"));
        });
        exponent.setOnClickListener(view -> {
            this.higherOperator = true;
            input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"exp("));
        });
        clear.setOnClickListener(view -> {
            /// whenever we click listener that record save on above textView
            input_show2.setText(input_show1.getText().toString());
            output_show2.setText(output_show1.getText().toString());
            input_show1.setText("");
            output_show1.setText("");
        });
        backspace.setOnClickListener(view -> {
            /// delete every last character from TextView
            String temp = input_show1.getText().toString();
            temp = temp.substring(0,temp.length()-1);
            input_show1.setText(temp);
        });
        equal.setOnClickListener(view -> {
            // actual computation
            String str = input_show1.getText().toString();
            String[] token;
            String answer="";
            if(!higherOperator) {
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == '+') {
                        token = str.split(" ");
                        //       answer = Double.toString(Double.parseDouble(token[0]) + Double.parseDouble(token[2]));
                        answer = commonFunction.Add(token[0], token[2]);
                        break;
                    } else if (str.charAt(i) == '-') {
                        token = str.split(" ");
                        answer = commonFunction.Minus(token[0], token[2]);
                        break;
                    } else if (str.charAt(i) == '*') {
                        token = str.split(" ");
                        //answer = Double.toString(Double.parseDouble(token[0])*Double.parseDouble(token[2]));
                        answer = commonFunction.Multiply(token[0], token[2]);
                        break;
                    } else if (str.charAt(i) == '%') {
                        token = str.split(" ");
                        //answer = Double.toString(Integer.parseInt(token[0])%Integer.parseInt(token[2]));
                        answer = commonFunction.Modulus(token[0], token[2]);
                        //  System.out.println(answer);
                        break;
                    } else if (str.charAt(i) == '/') {
                        token = str.split(" ");
                        answer = commonFunction.Divide(token[0], token[2]);
                    } else if (str.charAt(i) == '^') {
                        token = str.split(" ");
                        answer = commonFunction.power(token[0], token[2]);
                    }
                }
            }
            else{
                int n = str.length();
                if(str.charAt(n-1)=='!'){
                    answer = commonFunction.factorial(str.substring(0,n-1));
                }
                else if(str.substring(0,3).equals("log")){
                    answer = commonFunction.log(str.substring(4,n-1));
                }
                else if(str.substring(0,2).equals("ln")){
                    answer = commonFunction.nlog(str.substring(3,n-1));
                }
                else if(str.substring(0,3).equals("sin")){
                    answer = commonFunction.sin(str.substring(4,n-1));
                }
                else if(str.substring(0,3).equals("cos")){
                    answer = commonFunction.cos(str.substring(4,n-1));
                }
                else if(str.substring(0,4).equals("sqrt")){
                    answer = commonFunction.sqrt(str.substring(5,n-1));
                }
                else if(str.substring(0,3).equals("exp")){
                    answer = commonFunction.exponent(str.substring(4,n-1));
                }
            }
//            if(answer.equals("")) {
//                output_show1.setText(String.format("= %s", answer));
//            }
//            else {
//                output_show1.setText(answer);
//            }
            output_show1.setText(String.format("= %s",answer));
        });
        normal.setOnClickListener(view ->{
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        });

    }

}