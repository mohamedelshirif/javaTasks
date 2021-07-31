/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 *
 * @author melsh
 */
public class Lab2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String string1 = "This is string1";
	String string2 = "This is string2";
	String betterString;
	
	betterString = betterString(string1, string2, (s1,s2)-> true);
        System.out.println("The better string is: "+ betterString);

	if (isLetter(string1, Character::isLetter)) {
        System.out.println("The string don't have numbers");}
	else {System.out.println("The string has numbers");}
    }	

	public static String betterString(String s1, String s2, BiPredicate<String,String> p) {
            if(p.test(s1, s2))
            {return s1;}	
            else {return s2;}
        }
	
	public static boolean isLetter(String s3, Predicate<Character> p) {
	int l = s3.length();
	for (int i=0; i<l; i++) {
            char c = s3.charAt(i);
            if (p.test(c)){continue;}
            else {return false;}
	}
        return true;
}
}
