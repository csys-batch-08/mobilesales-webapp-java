package com.ajith;

public class MaximumofFive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=14,b=17,c=21,d=33,e=5;
		if(a>b && a>c && a>d && a>e) {
			System.out.println(a);
		}
		else if(b>c && b>d && b>e) {
			System.out.println(b);
		}
		else if(c>d && c>e) {
			System.out.println(c);
		}
		else if(d>e) {
			System.out.println(d);
		}
		else {
			System.out.println(e);
		}
		

	}

}
