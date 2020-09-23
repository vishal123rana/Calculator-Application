package com.example.calculatorapplication;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class scientificCalculator extends AppCompatActivity {
    private CommonFunction commonFunction;
    private Button zero,one,two,three,four,five,six,seven,eight,nine,factorial,power,exponent,left,right,dot,nlog,log,cos,sin,root,equal,normal;
    private Button plus,minus,modulus,multiply,divide;
    private TextView input_show1,input_show2,output_show1,output_show2;
    private DatabaseHelper databaseHelper;
    private static boolean higherOperator = false;
 //   private static boolean operator = false;
    private static boolean afterEqual = false;
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
        zero.setOnClickListener(view ->{
            if(afterEqual) {
                input_show2.setText(input_show1.getText().toString());
                output_show2.setText(output_show1.getText().toString());
                if(!input_show2.getText().toString().isEmpty()){ // check upcoming record is null or not if it is not null then store data in database
                    final boolean insert = databaseHelper.insert(input_show2.getText().toString(), output_show2.getText().toString());//  insert data in database  // using helper method
                    if(insert){
                        Toast.makeText(getApplicationContext(),"Data save!",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(),"Data not save!",Toast.LENGTH_SHORT).show();
                    }
                }
                input_show1.setText("");
                output_show1.setText("");
                afterEqual = false;
            }
            input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"0"));
        });  // add 0 end of string
        one.setOnClickListener(view -> {
            if(afterEqual) {
                input_show2.setText(input_show1.getText().toString());
                output_show2.setText(output_show1.getText().toString());
                if(!input_show2.getText().toString().isEmpty()){ // check upcoming record is null or not if it is not null then store data in database
                    final boolean insert = databaseHelper.insert(input_show2.getText().toString(), output_show2.getText().toString());//  insert data in database  // using helper method
                    if(insert){
                        Toast.makeText(getApplicationContext(),"Data save!",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(),"Data not save!",Toast.LENGTH_SHORT).show();
                    }
                }
                input_show1.setText("");
                output_show1.setText("");
                afterEqual = false;
            }
            input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"1"));
        });  // add 1 end of string
        two.setOnClickListener(view -> {
            if(afterEqual) {
                input_show2.setText(input_show1.getText().toString());
                output_show2.setText(output_show1.getText().toString());
                if(!input_show2.getText().toString().isEmpty()){ // check upcoming record is null or not if it is not null then store data in database
                    final boolean insert = databaseHelper.insert(input_show2.getText().toString(), output_show2.getText().toString());//  insert data in database  // using helper method
                    if(insert){
                        Toast.makeText(getApplicationContext(),"Data save!",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(),"Data not save!",Toast.LENGTH_SHORT).show();
                    }
                }
                input_show1.setText("");
                output_show1.setText("");
                afterEqual = false;
            }
            input_show1.setText(commonFunction.AddString(input_show1.getText().toString(), "2"));
        }); // add 2 end of string
        three.setOnClickListener(view -> {
            if(afterEqual) {
                input_show2.setText(input_show1.getText().toString());
                output_show2.setText(output_show1.getText().toString());
                if(!input_show2.getText().toString().isEmpty()){ // check upcoming record is null or not if it is not null then store data in database
                    final boolean insert = databaseHelper.insert(input_show2.getText().toString(), output_show2.getText().toString());//  insert data in database  // using helper method
                    if(insert){
                        Toast.makeText(getApplicationContext(),"Data save!",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(),"Data not save!",Toast.LENGTH_SHORT).show();
                    }
                }
                input_show1.setText("");
                output_show1.setText("");
                afterEqual = false;
            }
            input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"3"));
        }); // add 3 end of string
        four.setOnClickListener(view -> {
            if(afterEqual) {
                input_show2.setText(input_show1.getText().toString());
                output_show2.setText(output_show1.getText().toString());
                if(!input_show2.getText().toString().isEmpty()){ // check upcoming record is null or not if it is not null then store data in database
                    final boolean insert = databaseHelper.insert(input_show2.getText().toString(), output_show2.getText().toString());//  insert data in database  // using helper method
                    if(insert){
                        Toast.makeText(getApplicationContext(),"Data save!",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(),"Data not save!",Toast.LENGTH_SHORT).show();
                    }
                }
                input_show1.setText("");
                output_show1.setText("");
                afterEqual = false;
            }
            input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"4"));

        }); // add 4 end of string
        five.setOnClickListener(view -> {
            if(afterEqual) {
                input_show2.setText(input_show1.getText().toString());
                output_show2.setText(output_show1.getText().toString());
                if(!input_show2.getText().toString().isEmpty()){ // check upcoming record is null or not if it is not null then store data in database
                    final boolean insert = databaseHelper.insert(input_show2.getText().toString(), output_show2.getText().toString());//  insert data in database  // using helper method
                    if(insert){
                        Toast.makeText(getApplicationContext(),"Data save!",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(),"Data not save!",Toast.LENGTH_SHORT).show();
                    }
                }
                input_show1.setText("");
                output_show1.setText("");
                afterEqual = false;
            }
            input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"5"));

        }); // add 5 end of string
        six.setOnClickListener(view -> {
            if(afterEqual) {
                input_show2.setText(input_show1.getText().toString());
                output_show2.setText(output_show1.getText().toString());
                if(!input_show2.getText().toString().isEmpty()){ // check upcoming record is null or not if it is not null then store data in database
                    final boolean insert = databaseHelper.insert(input_show2.getText().toString(), output_show2.getText().toString());//  insert data in database  // using helper method
                    if(insert){
                        Toast.makeText(getApplicationContext(),"Data save!",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(),"Data not save!",Toast.LENGTH_SHORT).show();
                    }
                }
                input_show1.setText("");
                output_show1.setText("");
                afterEqual = false;
            }
            input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"6"));
        });  // add 6 end of string
        seven.setOnClickListener(view -> {
            if(afterEqual) {
                input_show2.setText(input_show1.getText().toString());
                output_show2.setText(output_show1.getText().toString());
                if(!input_show2.getText().toString().isEmpty()){ // check upcoming record is null or not if it is not null then store data in database
                    final boolean insert = databaseHelper.insert(input_show2.getText().toString(), output_show2.getText().toString());//  insert data in database  // using helper method
                    if(insert){
                        Toast.makeText(getApplicationContext(),"Data save!",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(),"Data not save!",Toast.LENGTH_SHORT).show();
                    }
                }
                input_show1.setText("");
                output_show1.setText("");
                afterEqual = false;
            }
            input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"7"));
        }); // add 7 end of string
        eight.setOnClickListener(view ->{
            if(afterEqual) {
                input_show2.setText(input_show1.getText().toString());
                output_show2.setText(output_show1.getText().toString());
                if(!input_show2.getText().toString().isEmpty()){ // check upcoming record is null or not if it is not null then store data in database
                    final boolean insert = databaseHelper.insert(input_show2.getText().toString(), output_show2.getText().toString());//  insert data in database  // using helper method
                    if(insert){
                        Toast.makeText(getApplicationContext(),"Data save!",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(),"Data not save!",Toast.LENGTH_SHORT).show();
                    }
                }
                input_show1.setText("");
                output_show1.setText("");
                afterEqual = false;
            }
            input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"8"));

        });  // add 8 end of string
        nine.setOnClickListener(view -> {
            if(afterEqual) {
                input_show2.setText(input_show1.getText().toString());
                output_show2.setText(output_show1.getText().toString());
                if(!input_show2.getText().toString().isEmpty()){ // check upcoming record is null or not if it is not null then store data in database
                    final boolean insert = databaseHelper.insert(input_show2.getText().toString(), output_show2.getText().toString());//  insert data in database  // using helper method
                    if(insert){
                        Toast.makeText(getApplicationContext(),"Data save!",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(),"Data not save!",Toast.LENGTH_SHORT).show();
                    }
                }
                input_show1.setText("");
                output_show1.setText("");
                afterEqual = false;
            }
            input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"9"));
        });  // add 9 end of string
        dot.setOnClickListener(view -> {   //  add dot end of string
            if (input_show1.getText().toString().isEmpty()) {
                input_show1.setText(commonFunction.AddString(input_show1.getText().toString(), "0."));
            } else {
                input_show1.setText(commonFunction.AddString(input_show1.getText().toString(), "."));
            }

        });
        plus.setOnClickListener(view ->{ // add + end of string
//            if(!operator) {
//                input_show1.setText(commonFunction.AddString(input_show1.getText().toString(), "+"));
//                operator = true;  // disable operator
//            }else{
//                input_show1.setText(input_show1.getText().toString());
//            }
            input_show1.setText(commonFunction.AddString(input_show1.getText().toString()," + "));
        });
        minus.setOnClickListener(view -> { // add - end of string
//            if(!operator){
//                input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"-"));
//                operator = true; // disable operator
//            }else{
//                input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"-"));
//            }
            input_show1.setText(commonFunction.AddString(input_show1.getText().toString()," - "));
        });
        multiply.setOnClickListener(view ->{  // add * end of string
//            if(!operator) {
//                input_show1.setText(commonFunction.AddString(input_show1.getText().toString(), "*"));
//                operator = true;   // disable operator
//            }
//            else{
//                input_show1.setText(input_show1.getText().toString());
//            }
            input_show1.setText(commonFunction.AddString(input_show1.getText().toString()," * "));
        });
        divide.setOnClickListener(view -> {  // add / end of string
//            if(!operator) {
//                input_show1.setText(input_show1.getText().toString());
//                operator = true;// Disable operator
//            }else{
//                input_show1.setText(input_show1.getText().toString());
//            }
            input_show1.setText(commonFunction.AddString(input_show1.getText().toString()," / "));
        });
        modulus.setOnClickListener(view -> {   // add % end of string
//            if(!operator) {
//                input_show1.setText(commonFunction.AddString(input_show1.getText().toString(), "%"));
//                operator = true;  // Disable operator
//            }else{
//                input_show1.setText(input_show1.getText().toString());
//            }
            input_show1.setText(commonFunction.AddString(input_show1.getText().toString()," % "));
        });
        left.setOnClickListener(view -> input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"(")));  // add ( end of string
        right.setOnClickListener(view -> input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),")"))); // add ) end of string
        power.setOnClickListener(view -> input_show1.setText(commonFunction.AddString(input_show1.getText().toString()," ^ ")));  // add power operator
        log.setOnClickListener(view -> {
            if(afterEqual) {
                input_show2.setText(input_show1.getText().toString());
                output_show2.setText(output_show1.getText().toString());
                if(!input_show2.getText().toString().isEmpty()){ // check upcoming record is null or not if it is not null then store data in database
                    final boolean insert = databaseHelper.insert(input_show2.getText().toString(), output_show2.getText().toString());//  insert data in database  // using helper method
                    if(insert){
                        Toast.makeText(getApplicationContext(),"Data save!",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(),"Data not save!",Toast.LENGTH_SHORT).show();
                    }
                }
                input_show1.setText("");
                output_show1.setText("");
                afterEqual = false;
            }
            input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"log("));   // add log end of string
            higherOperator = true;
        });
        nlog.setOnClickListener(view -> {
            if(afterEqual) {
                input_show2.setText(input_show1.getText().toString());
                output_show2.setText(output_show1.getText().toString());
                if(!input_show2.getText().toString().isEmpty()){ // check upcoming record is null or not if it is not null then store data in database
                    final boolean insert = databaseHelper.insert(input_show2.getText().toString(), output_show2.getText().toString());//  insert data in database  // using helper method
                    if(insert){
                        Toast.makeText(getApplicationContext(),"Data save!",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(),"Data not save!",Toast.LENGTH_SHORT).show();
                    }
                }
                input_show1.setText("");
                output_show1.setText("");
                afterEqual = false;
            }
            input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"ln("));  // add natural log end of string
            higherOperator = true;
        });
        root.setOnClickListener(view -> {
            if(afterEqual) {
                input_show2.setText(input_show1.getText().toString());
                output_show2.setText(output_show1.getText().toString());
                if(!input_show2.getText().toString().isEmpty()){ // check upcoming record is null or not if it is not null then store data in database
                    final boolean insert = databaseHelper.insert(input_show2.getText().toString(), output_show2.getText().toString());//  insert data in database  // using helper method
                    if(insert){
                        Toast.makeText(getApplicationContext(),"Data save!",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(),"Data not save!",Toast.LENGTH_SHORT).show();
                    }
                }
                input_show1.setText("");
                output_show1.setText("");
                afterEqual = false;
            }
            input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"sqrt("));  // add sqrt
            higherOperator = true;
        });
        cos.setOnClickListener(view -> {
//            if(afterEqual) {
//                input_show2.setText(input_show1.getText().toString());
//                output_show2.setText(output_show1.getText().toString());
//                if(!input_show2.getText().toString().isEmpty()){ // check upcoming record is null or not if it is not null then store data in database
//                    final boolean insert = databaseHelper.insert(input_show2.getText().toString(), output_show2.getText().toString());//  insert data in database  // using helper method
//                    if(insert){
//                        Toast.makeText(getApplicationContext(),"Data save!",Toast.LENGTH_SHORT).show();
//                    }else{
//                        Toast.makeText(getApplicationContext(),"Data not save!",Toast.LENGTH_SHORT).show();
//                    }
//                }
//                input_show1.setText("");
//                output_show1.setText("");
//                afterEqual = false;
//            }
//            input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"cos("));  // add cos
//            higherOperator = true;

//            Cursor res = databaseHelper.getAllData();
//            if (res.getCount() == 0) {
//                showMessage("Error","Nothing Found");
//                return;
//            }
//            StringBuilder buffer = new StringBuilder();
//            while(res.moveToNext()){
//                buffer.append("ID :").append(res.getString(0)).append("\n");
//                buffer.append("Input :").append(res.getString(1)).append("\n");
//                buffer.append("Output :").append(res.getString(2)).append("\n");
//
//            }
  //          showMessage("Data",buffer.toString());
//            Intent intent = new Intent(scientificCalculator.this,RecycleView.class);  // switch to third Activity
//            startActivity(intent);
//
//            @SuppressLint({"InflateParams", "ResourceType"})
//            View v = LayoutInflater.from(this).inflate(R.layout.activity_recycle_view,null);
//            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
//            bottomSheetDialog.setContentView(v);
//            bottomSheetDialog.show();
          BottomSheetDialogFragment bottomSheetDialogFragment = new BottomSheetDialog2();
          bottomSheetDialogFragment.show(((FragmentActivity)this).getSupportFragmentManager(), bottomSheetDialogFragment.getTag());
        });
        sin.setOnClickListener(view -> {
            if(afterEqual) {
                input_show2.setText(input_show1.getText().toString());
                output_show2.setText(output_show1.getText().toString());
                if(!input_show2.getText().toString().isEmpty()){ // check upcoming record is null or not if it is not null then store data in database
                    final boolean insert = databaseHelper.insert(input_show2.getText().toString(), output_show2.getText().toString());//  insert data in database  // using helper method
                    if(insert){
                        Toast.makeText(getApplicationContext(),"Data save!",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(),"Data not save!",Toast.LENGTH_SHORT).show();
                    }
                }
                input_show1.setText("");
                output_show1.setText("");
                afterEqual = false;
            }
            input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"sin("));  // add sin
            higherOperator = true;
        });
        factorial.setOnClickListener(view -> {
            if(afterEqual){
                input_show2.setText(input_show1.getText().toString());
                output_show2.setText(output_show1.getText().toString());
                if(!input_show2.getText().toString().isEmpty()){ // check upcoming record is null or not if it is not null then store data in database
                    final boolean insert = databaseHelper.insert(input_show2.getText().toString(), output_show2.getText().toString());//  insert data in database  // using helper method
                    if(insert){
                        Toast.makeText(getApplicationContext(),"Data save!",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(),"Data not save!",Toast.LENGTH_SHORT).show();
                    }
                }
                input_show1.setText("");
                output_show1.setText("");
                afterEqual = false;
            }
            higherOperator = true;
            input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"!"));  // add factorial
        });
        exponent.setOnClickListener(view -> {
            if(afterEqual){
                input_show2.setText(input_show1.getText().toString());
                output_show2.setText(output_show1.getText().toString());
                if(!input_show2.getText().toString().isEmpty()){ // check upcoming record is null or not if it is not null then store data in database
                    final boolean insert = databaseHelper.insert(input_show2.getText().toString(), output_show2.getText().toString());//  insert data in database  // using helper method
                    if(insert){
                        Toast.makeText(getApplicationContext(),"Data save!",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(),"Data not save!",Toast.LENGTH_SHORT).show();
                    }
                }
                input_show1.setText("");
                output_show1.setText("");
                afterEqual = false;
            }
            higherOperator = true;
            input_show1.setText(commonFunction.AddString(input_show1.getText().toString(),"exp("));  // add exponent
        });
        clear.setOnClickListener(view -> {
            /// whenever we click listener that record save on above textView
        //    operator = false;
            input_show2.setText(input_show1.getText().toString());
            output_show2.setText(output_show1.getText().toString());
            input_show1.setText("");
            output_show1.setText("");
            if(!input_show2.getText().toString().isEmpty()){ // check upcoming record is null or not if it is not null then store data in database
                final boolean insert = databaseHelper.insert(input_show2.getText().toString(), output_show2.getText().toString());//  insert data in database  // using helper method
                if(insert){
                    Toast.makeText(getApplicationContext(),"Data save!",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Data not save!",Toast.LENGTH_SHORT).show();
                }
            }
        });
        backspace.setOnClickListener(view -> {
            /// delete every last character from TextView
            String temp = input_show1.getText().toString();   // fetch data from textView
            int n = temp.length();
            if(temp.charAt(n-1)==' '){
                temp = temp.substring(0,n-2);
            }
            else {
                temp = temp.substring(0, temp.length() - 1);    // remove last character from end
            }
            input_show1.setText(temp);    // and then show  on textView
        });
        equal.setOnClickListener(view -> {
            // actual computation
            String expression = input_show1.getText().toString();   // fetch string from textView
            int length = expression.length();
            String answer = null;  // output string where we store result

//            for(int i = 0 ; i < length; i++){
//                if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == '/' || str.charAt(i) == '^' || str.charAt(i) == '%') {
//                    checkOperator = true;
//                    break;
//                }
//            }
//            for(int i = 1 ; i < length ; i++){
//                if (expression.charAt(i-1) == '+' && expression.charAt(i)=='+'){
//                    checkOperator = false;
//                    break;
//                }
//                else if(expression.charAt(i-1)=='-' && expression.charAt(i)=='-'){
//                    checkOperator = false;
//                    break;
//                }else if(expression.charAt(i-1)=='*' && expression.charAt(i)=='*'){
//                    checkOperator = false;
//                    break;
//                }else if(expression.charAt(i-1)=='%' && expression.charAt(i)=='%'){
//                    checkOperator = false;
//                    break;
//                }else if(expression.charAt(i-1)=='/' && expression.charAt(i)=='/'){
//                    checkOperator = false;
//                    break;
//                }else if(expression.charAt(i-1)=='^' && expression.charAt(i) == '^'){
//                    checkOperator = false;
//                    break;
//                }
//            }
            boolean checkOperator = commonFunction.checkDoubleOperator(expression);
            if(!higherOperator && checkOperator) {
                double ans = commonFunction.evaluate(expression);
                answer = String.valueOf(ans);
//                for (int i = 0; i < length; i++) { // loop for every character
//                   if(str.charAt(i)=='+'){   // if given character is + then parse input string
//                       answer = commonFunction.Add(str.substring(0,i),str.substring(i+1,length)); // and perform Addition operation which implement in commonFunction class
//                       break;
//                   }else if(str.charAt(i)=='-'){ // if given character is - then parse input string
//                       answer = commonFunction.Minus(str.substring(0,i),str.substring(i+1,length)); //perform Minus operation
//                       break;
//                   }else if(str.charAt(i)=='*'){ // if given character is * then parse input string
//                       answer = commonFunction.Multiply(str.substring(0,i),str.substring(i+1,length)); // perform Multiply operation
//                       break;
//                   }else if(str.charAt(i)=='%'){
//                       answer = commonFunction.Modulus(str.substring(0,i),str.substring(i+1,length));
//                       break;
//                   }else if(str.charAt(i)=='/'){
//                       answer = commonFunction.Divide(str.substring(0,i),str.substring(i+1,length));
//                       break;
//                   }
//                   else if(str.charAt(i)=='^'){
//                       answer = commonFunction.power(str.substring(0,i),str.substring(i+1,length));
//                       break;
//                   }
//                }
            }
            else if(higherOperator){
                if(expression.charAt(length-1)=='!'){
                    answer = commonFunction.factorial(expression.substring(0,length-1));
                }
                else if(expression.substring(0,3).equals("log")){
                    boolean flag = commonFunction.checkOperator(expression.substring(4,length-1));
                    if(flag) {
                        answer = commonFunction.log(String.valueOf(commonFunction.evaluate(expression.substring(4,length-1))));
                    }else{
                        answer = commonFunction.log(expression.substring(4,length-1));
                    }
                }
                else if(expression.substring(0,2).equals("ln")){
                    boolean flag = commonFunction.checkOperator(expression.substring(3,length-1));
                    if(flag){
                        answer = commonFunction.nlog(String.valueOf(commonFunction.evaluate(expression.substring(3,length-1))));
                    }
                    else {
                        answer = commonFunction.nlog(expression.substring(3, length - 1));
                    }
                }
                else if(expression.substring(0,3).equals("sin")){
                    boolean flag = commonFunction.checkOperator(expression.substring(4,length-1));
                    if(flag) {
                        answer = commonFunction.sin(String.valueOf(commonFunction.evaluate(expression.substring(4,length-1))));
                    }else{
                        answer = commonFunction.sin(expression.substring(4,length-1));
                    }
                }
                else if(expression.substring(0,3).equals("cos"))
                {
                    boolean flag = commonFunction.checkOperator(expression.substring(4,length-1));
                    if(flag){
                        answer = commonFunction.cos(String.valueOf(commonFunction.evaluate(expression.substring(4,length-1))));
                    }else {
                        answer = commonFunction.cos(expression.substring(4, length - 1));
                    }
                }else if(expression.substring(0,4).equals("sqrt")){
                    boolean flag = commonFunction.checkOperator(expression.substring(5,length-1));
                    if(flag){
                        answer = commonFunction.sqrt(String.valueOf(commonFunction.evaluate(expression.substring(5,length-1))));
                    }else {
                        answer = commonFunction.sqrt(expression.substring(5, length - 1));
                    }
                }
                else if(expression.substring(0,3).equals("exp")){
                    boolean flag = commonFunction.checkOperator(expression.substring(4,length-1));
                    if(flag){
                        answer = commonFunction.exponent(String.valueOf(commonFunction.evaluate(expression.substring(4,length-1))));
                    }
                    else {
                        answer = commonFunction.exponent(expression.substring(4, length - 1));
                    }
                }
                higherOperator = false;
            }
            else{
                answer = "Wrong Input!";
            }
            assert answer != null;
            if(answer.equals("Wrong Input!")){
                output_show1.setText(answer);
            }else {
                output_show1.setText(String.format("= %s", answer));
            }
            afterEqual = true;
          //  operator = false;  // Enable operator
        });
        normal.setOnClickListener(view ->{
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        });

    }

    public void viewHistory(View view) {
        Intent intent = new Intent(getApplicationContext(),RecycleView.class);
        startActivity(intent);
    }

    public void Exit(View view) {
       finish();
    }
//    public void showMessage(String title,String Message){
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setCancelable(true);
//        builder.setMessage(Message);
//        builder.show();
//    }

}