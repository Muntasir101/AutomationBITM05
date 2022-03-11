package com.Exam;

import java.util.Scanner;

public class Problem5 {
    public static void main(String[] args) {

        gradeCalculation();
    }
    public static void gradeCalculation(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your Marks: ");
        int marks= sc.nextInt();

        if(marks >= 80 && marks  <=100 ){
            System.out.println("Grade A+");
        }
       else if(marks >= 70 && marks  <=79 ){
            System.out.println("Grade A");
        }
        else if(marks >= 60 && marks  <=69 ){
            System.out.println("Grade A-");
        }
        else if(marks >= 50 && marks  <=59 ){
            System.out.println("Grade B");
        }
        else if(marks >= 40 && marks  <=49 ){
            System.out.println("Grade C");
        }
        else if(marks >= 33 && marks  <=39 ){
            System.out.println("Grade D");
        }
        else if(marks <33 ){
            System.out.println("Grade F");
        }
        else {
            System.out.println("Invalid Marks");
        }
    }
}
