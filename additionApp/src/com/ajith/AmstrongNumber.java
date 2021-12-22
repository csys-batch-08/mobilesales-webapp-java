package com.ajith;

import java.util.Scanner;


public class AmstrongNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		int sum=0;
		int temp=num;
		while(num>0) {
			int i=num%10;
			sum+=i*i*i;
			num/=10;
			
		}
		if(temp==sum) {
			System.out.println(temp+" is a Amstrong number");
		}
		else {
			System.out.println(temp+" Not a Amstrong number");
	}
		

		
		
	}

}
