package com.Exam;

public class Problem4 {
    public static void main(String[] args) {
        divisibleBy3();
        divisibleBy5();
        divisibleBy3and5();
    }
    public static void divisibleBy3(){
        System.out.println("\nDivisible by 3:");
        for(int i=1;i<=100;i++){
            if(i%3==0){
                System.out.println(i +",");
            }
        }
    }
    public static void divisibleBy5(){
        System.out.println("\n\nDivisible by 5:");
        for(int i=1;i<=100;i++){
            if(i%5==0){
                System.out.println(i +",");
            }
        }
    }
    public static void divisibleBy3and5(){
        System.out.println("\nDivisible by 3 and 5:");
        for(int i=1;i<=100;i++){
            if(i%3==0 && i%5==0){
                System.out.println(i +",");
            }
        }
        System.out.println("\n");
    }
}
