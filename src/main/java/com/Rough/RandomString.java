package com.Rough;

import java.util.Random;

public class RandomString {
    public static void main(String[] args) {
       // System.out.println(generate_Random_string());
        String UniqueEmail=generate_Random_string() + "@gmail.com";
        System.out.println(UniqueEmail);
    }

    public static String generate_Random_string(){
        String SALTCHAR="abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGH";
        StringBuilder rstr=new StringBuilder();
        Random rnd=new Random();

        while (rstr.length()<10){
            int index=(int)(rnd.nextFloat()*SALTCHAR.length());
            rstr.append(SALTCHAR.charAt(index));
        }
        String newString=rstr.toString();
        return newString;
    }

}
