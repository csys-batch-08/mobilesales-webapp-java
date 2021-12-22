package com.ajith;

import java.util.Scanner;


public class ArrayConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Aray concept
		Scanner sc=new Scanner(System.in);
		
				int c[]=new int[5];
				for(int j=0;j<c.length;j++) {
					c[j]=sc.nextInt();
					
				}
				for(int j=0;j<c.length;j++) {
					System.out.println(c[j]);
				}
	}

}
