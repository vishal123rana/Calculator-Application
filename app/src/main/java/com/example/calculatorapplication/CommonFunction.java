package com.example.calculatorapplication;
public final class CommonFunction {
    public String Add(String s1, String s2){
        return String.valueOf(Double.sum(Double.parseDouble(s1),Double.parseDouble(s2)));
    }
    public String Multiply(String s1,String s2){
        return String.valueOf(Double.parseDouble(s1) * Double.parseDouble(s2));
    }
    public String AddString(String left,String right){
        return left.concat(right);
    }
    public String Minus(String s1,String s2){
        double value1 = Double.parseDouble(s1);
        double value2 = Double.parseDouble(s2);
        if(value1 > value2)
            value1 = value1 - value2;
        else
            value1 = value2 - value1;
        return String.valueOf(value1);
    }
    public String Divide(String s1,String s2){
        if(Double.parseDouble(s2)==0)
            return "Wrong input";
        return String.valueOf(Double.parseDouble(s1)/Double.parseDouble(s2));
    }
    public String Modulus(String s1,String s2){

        return String.valueOf(Double.parseDouble(s1)%Double.parseDouble(s2));
    }
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
}
