package com.ajith;

import java.util.Scanner;

public class SumtheNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		int sum=0;
		while(num>0) {
			int i=num%10;
			sum+=i;
			num/=10;
			
			
		}
		System.out.println(sum);

	}

}
