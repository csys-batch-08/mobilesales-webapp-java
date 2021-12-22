package com.ajith;

import java.util.Scanner;
import java.lang.Math;


public class Amstrong2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		int temp=num;
		int count=0,sum=0,i=0;
		
		while(temp>0) {
			temp=temp/10;
			count++;
		}
		System.out.println(count);
		temp=num;
		while(temp>0) {
			i=temp%10;
			sum+=(Math.pow(i, count));
			temp/=10;
		}
		if(num==sum) {
			System.out.println(sum+" is a Amstrong number");
		}
		else {
			System.out.println(sum+" Not a Amstrong number");
		}

	}

}
