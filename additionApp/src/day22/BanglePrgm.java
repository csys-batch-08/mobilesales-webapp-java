package day22;

import java.util.Scanner;

import java.lang.Math;


public class BanglePrgm {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("X1");
		int x1=sc.nextInt();
		System.out.println("Y1");
		int y1=sc.nextInt();
		System.out.println("X2");
		int x2=sc.nextInt();
		System.out.println("Y2");
		int y2=sc.nextInt();
		System.out.println("R1");
		int r1=sc.nextInt();
		System.out.println("R2");
		int r2=sc.nextInt();
		
		int rad=r1+r2;
		
		
		double distance=Math.sqrt(Math.pow((x2-x1),2)+(Math.pow(y1- y2,2)));
		
		System.out.println(distance);
		
		if(distance==rad) {
			System.out.println("Touch");
		}
		else if(distance>rad) {
			System.out.println("Do not Touch");
		}
		else if(distance<rad) {
			System.out.println("Intersect");
		}
		
		
		 
		
		
		
	}

}
