package com.ajith2;

import java.util.Scanner;

public class InterChange {
	public static void change(int s[],int num) {
		Scanner sc=new Scanner(System.in);
		
		for(int i=0;i<num;i++) {
			s[i]=sc.nextInt();
			if(s[i]<0) {
				System.out.println("Invalid");
			}
			
			
			
			
		}
		for(int i=num-1;i>=0;i--) {
			System.out.println(s[i]);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		int i=0;
		if(num<0) {
			System.out.println("Invalid");
		}
		else {
			int s[]=new int [num];
			change(s,num);
			
		}

	}

}
