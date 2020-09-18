package com.example.calculatorapplication;

import java.util.Stack;

public final class CommonFunction {
    public String Add(String s1, String s2){
        return String.valueOf(Double.sum(Double.parseDouble(s1),Double.parseDouble(s2)));
    }
//    public String Multiply(String s1,String s2){
//        return String.valueOf(Double.parseDouble(s1) * Double.parseDouble(s2));
//    }
    public String AddString(String left,String right){
        return left.concat(right);
    }
//    public String Minus(String s1,String s2){
//        double value1 = Double.parseDouble(s1);
//        double value2 = Double.parseDouble(s2);
//        if(value1 > value2)
//            value1 = value1 - value2;
//        else
//            value1 = value2 - value1;
//        return String.valueOf(value1);
//    }
//    public String Divide(String s1,String s2){
//        if(Double.parseDouble(s2)==0)
//            return "Wrong input";
//        return String.valueOf(Double.parseDouble(s1)/Double.parseDouble(s2));
//    }
//    public String Modulus(String s1,String s2){
//
//        return String.valueOf(Double.parseDouble(s1)%Double.parseDouble(s2));
//    }
    public String power(String s1,String s2){
        return String.valueOf(Math.pow(Double.parseDouble(s1),Double.parseDouble(s2)));
    }

    public String exponent(String s){
        return String.valueOf(Math.exp(Double.parseDouble(s)));
    }
    public String log(String s){
        return String.valueOf(Math.log10(Double.parseDouble(s)));
    }
    public String nlog(String s){
        return String.valueOf(Math.log(Double.parseDouble(s)));
    }
    public String sqrt(String s){
        return String.valueOf(Math.sqrt(Double.parseDouble(s)));
    }
    public String sin(String s){
        return String.valueOf(Math.sin(Double.parseDouble(s)));
    }
    public String cos(String s){
        return String.valueOf(Math.cos(Double.parseDouble(s)));
    }
    public String factorial(String s){
        double d = Double.parseDouble(s);
        double ans = 1,i = 1;
        while(i <= d){
            ans = ans*i;
            i++;
        }
        return String.valueOf(ans);
    }
    public boolean checkDoubleOperator(String expression){
        int n = expression.length();
        boolean check = true;
        for(int i = 1 ; i < n; i++){
            if(expression.charAt(i-1)=='+' && expression.charAt(i)=='+'){
                check = false;
                break;
            }
            else if(expression.charAt(i-1)=='-' && expression.charAt(i)=='-'){
                check = false;
                break;
            }
            else if(expression.charAt(i-1)=='*' && expression.charAt(i)=='*'){
                check = false;
                break;
            }
            else if(expression.charAt(i-1)=='/' && expression.charAt(i)=='/'){
                check = false;
                break;
            }else if(expression.charAt(i-1)=='%' && expression.charAt(i)=='%'){
                check = false;
                break;
            }
        }
        return check;
    }
    public boolean checkOperator(String s){
        int n = s.length();
        for(int i = 0 ; i < n; i++)
            if(s.charAt(i)=='+'||s.charAt(i)=='-'||s.charAt(i)=='*'||s.charAt(i)=='^'||s.charAt(i)=='%'||s.charAt(i)=='/')
                return true;
        return false;
    }
    private static double applyOp(char op,double b,double a){
        switch (op){
            case '+':
                return a+b;
            case '-':
                return a - b;
            case '*':
                return a*b;
            case '%':
                return  a%b;
            case '/':
                if (b == 0) {
                    throw new UnsupportedOperationException("Cannot divide by zero");
                }
                return a/b;
        }
        return 0;
    }
    public static boolean hasPrecedence(char op1,char op2){
        if(op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/' || op1 == '%') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }
    public double evaluate(String s){
        char[] tokens = s.toCharArray();
        Stack<Double> values = new Stack<>();
        Stack<Character> ops = new Stack<>();
        int i = 0;
        while (i < tokens.length)
        {
            if (tokens[i] == ' ')
                continue;
            if (tokens[i] >= '0' && tokens[i] <= '9')
            {
                StringBuilder sbuf = new StringBuilder();
                // There may be more than one digits in number
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
                    sbuf.append(tokens[i++]);
                values.push(Double.parseDouble(sbuf.toString()));
                continue;
            }
            else if (tokens[i] == '(')
                ops.push(tokens[i]);
            else if (tokens[i] == ')')
            {
                while (ops.peek() != '(')
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.pop();
            }
            else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '%' ||
                    tokens[i] == '*' || tokens[i] == '/') {
                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.push(tokens[i]);
            }
            i++;
        }
        while (!ops.empty())
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));
        return values.pop();
    }
}
