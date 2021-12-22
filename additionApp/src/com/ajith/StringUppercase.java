package com.ajith;

import java.util.Scanner;

public class StringUppercase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
//		String s1=sc.next();
//		String s2=sc.next();
    	String s3="java";
		String s4="program";
		
		String s5="javaprogram";
		
		
	int n1=sc.nextInt();
//		int n2=sc.nextInt();
//		
//		System.out.println(s1.toUpperCase());
//		System.out.println(s2.toUpperCase());
//		
//		if(s1.equals(s2)) {
//			System.out.println("Two strings are equal");
//		}
//		else {
//			System.out.println("Two strings are not equal");
//		}
		if(s3==s4) {
			System.out.println("equal");
		}
		else {
			System.out.println("not equal");
		}
		
		//substring
		
//		System.out.println(s1.substring(4));
//		
//		
//		System.out.println(s2.substring(n1, n2));
		
		s3=s3.concat(s4);
		System.out.println(s3);
		System.out.println(s3.equals(s5));
		System.out.println(s3.toUpperCase());

	}

}
