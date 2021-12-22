package com.ajith;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int fact=1;
		int num=sc.nextInt();
		for(int i=1;i<=num;i++) {
			 fact=fact*i;
			
		}
		System.out.println(fact);

	}

}
