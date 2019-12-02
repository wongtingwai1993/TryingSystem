package com.sgx.regsub.common.validation;

public class TestClass
{
    public static int findLargestGcd(int p, int q){
        if(q == 0){
            return p;
        }
        return findLargestGcd(q, p% q);
    }
    
    public static void main(String args[] ) throws Exception {

        int value1 = 20;
        int value2 = 36;
        int largestGcd = findLargestGcd(value1, value2);
        int totalGcd = largestGcd >= 1? 1: 0;

        for(int x=1; x < largestGcd; x++){
            if( (value1 % x == 0) && (value2 % x == 0)){
                totalGcd++;
            }
        }
        // Write your code here
        System.out.println(totalGcd);

    }
//    public static void main(String args[] ) throws Exception {
//
//        int value1 = 3;
//        int value2 = 17;
//        int divideValue = value1 <  value2? value1: value2;
//        int totalGcd=0;
//
//        for(int x = 1; x <= divideValue ; x++){
//            if(value1 % x == 0 && value2 % x ==0){
//                System.out.println(x);
//                totalGcd++;
//            }
//        }
//        // Write your code here
//        System.out.println(totalGcd);
//
//    }
}
