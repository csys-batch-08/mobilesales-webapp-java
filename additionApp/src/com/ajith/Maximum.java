package com.ajith;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Maximum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=5;
		int b=3;
		if(a>b) {
			System.out.println(a);
		}
		else {
			System.out.println(b);
		}
		int num1=7,num2=7;
		System.out.println((num1==num2)?"equal":"not Equal");
	   int n[]= {2,1,7,8,5};
	   Arrays.sort(n);
	   for(int i=0;i<n.length;i++) {
		   System.out.println(n[i]);
	   }
	   
	}

}
