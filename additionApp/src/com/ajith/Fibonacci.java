package com.ajith;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int input=sc.nextInt();
		int n1=0,n2=1;
		System.out.println(n1 +"\n"+n2);
		for(int i=2;i<input;i++) {
			int n3=n1+n2;
			System.out.println(n3);
			n1=n2;
			n2=n3;
			
		}

	}

}
