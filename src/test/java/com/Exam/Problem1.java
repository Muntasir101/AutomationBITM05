package com.Exam;
import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        production();
    }
    public static void production(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter First Number: ");
        int number1= sc.nextInt();
        System.out.println("Enter Second Number: ");
        int number2= sc.nextInt();
        System.out.println(number1+ " * "+ number2 + "=" + number1*number2);
    }
}
