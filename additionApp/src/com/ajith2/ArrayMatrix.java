package com.ajith2;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int val[][]=new int[3][3];
		int val2[][]=new int[3][3];
		int val3[][]=new int[3][3];
		System.out.println("Enter 1st Matrix");
		for(int i=0;i<val.length;i++) {
			for(int j=0;j<val.length;j++){
				val[i][j]=sc.nextInt();
				
			}
		}
		System.out.println("Enter 2st Matrix");
		for(int i=0;i<val.length;i++) {
			for(int j=0;j<val.length;j++){
				val2[i][j]=sc.nextInt();
				
			}
		}
		for(int i=0;i<val3.length;i++) {
			for(int j=0;j<val.length;j++){
				val3[i][j]=val[i][j]-val2[i][j];
				
			}
		}
		System.out.println("\n--------1st Matrix--------");
		System.out.println(Arrays.deepToString(val));
		System.out.println("\n--------2nd Matrix--------");
		System.out.println(Arrays.deepToString(val2));
		System.out.println("\n--------Result matrix--------");
		System.out.println(Arrays.deepToString(val3));
		
		
		

	}

}
