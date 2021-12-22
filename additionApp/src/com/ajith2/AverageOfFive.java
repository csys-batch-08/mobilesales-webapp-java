package com.ajith2;

import java.util.Scanner;


public class AverageOfFive {
	
	public static int average(int num,int mark[]){
		int grade=0,total=0,avg=0;
	//	int mark[]=new int[num];
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<num;i++) {
			mark[i]=sc.nextInt();
			if(mark[i]<0) {
				System.out.println("Invalid value");
			}
			else if(mark[i]>99) {
				System.out.println("Invalid ");
			}
			else {
				total=total+mark[i];
				avg=total/num;
				
				
			}
			
			
		}
		System.out.println("Average :"+avg);
		
		if(avg>=80 && avg<99) {
			grade=1;
		}
		else if(avg>=60 && avg<80){
			grade=2;
			
		}
		else if(avg<60) {
			grade=3;
		}
		else {
			grade=-1;
		}
		return grade;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the no of Subject");
		int num=sc.nextInt();
		int avg=0,total=0,grade=0;
		if(num<=0) {
			System.out.println("invalid option");
		}
		else {
			int [] mark=new int[num];
			System.out.println("Enter the marks");
			
			grade=average(num,mark);
			
			
		}
		if(grade==1) {
			System.out.println("First grade University");
		}
		else if(grade==2) {
			System.out.println("Second grade University");
		}
		else if(grade==3 || grade==-1) {
			System.out.println("Third grade University");
		}
		
		

		

	}

}
