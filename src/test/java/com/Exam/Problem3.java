package com.Exam;

public class Problem3 {
    public static void main(String[] args) {
        oddNumber(1,100);
    }
    public static void oddNumber(int min, int max){
        for (int i =min; i<max; i++){
            if(i % 2!=0){
                System.out.println(i);
            }
        }
    }
}
