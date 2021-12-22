package com.ajith;

import java.util.Scanner;

public class StringProgram {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int num2=sc.nextInt();
		// TODO Auto-generated method stub
		String first ="Ajith";
		String last ="Kumar";
		
		String fullname=(first+last);
		
		System.out.println(fullname);
		addtwonum(num2);
		
		//String buffer ,string bilder
		StringBuffer content=new StringBuffer();
		content.append("Chennai").append(",").append("Madurai");
		System.out.println(content);
		StringBuilder content2=new StringBuilder();
		content2.append("Madurai").append(",").append("Chennai");
		System.out.println(content2);
	}
	

		//
		public static void addtwonum(int num2) {
			
	    if(num2%2==0){
			System.out.println("Even");
		}
		else {
			System.out.println("Odd");
		}
	    }
		
		
		//nested if
		
			
	
		
	}


