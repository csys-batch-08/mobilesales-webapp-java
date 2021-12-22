package com.ajith;

import java.util.Scanner;
public class DummyTwo {
			
			public static int calculateGrade(int[] marks,int num) {
				Scanner sc = new Scanner(System.in);
				int avg=0,result;
				for(int i=0;i<num;i++) {
					marks[i]=sc.nextInt();
					if(marks[i]<0)
						System.out.println("Invalid option");
					else
						avg+=marks[i]/num;
				}
				System.out.println("Your average is : "+avg);
				if(avg>=80 && avg<99)
					result=1;
				else if(avg<80 && avg>60)
					result=2;
				else if(avg<60)
					result=3;
				else
					result=-1;
				return result;
			}

			public static void main(String[] args) {
				// TODO Auto-generated method stub
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter the no of marks");
				int noOfSubjects=sc.nextInt();
				if(noOfSubjects<=0)
					System.out.println("Invalid option");
				else {
				int[] marksArray=new int[noOfSubjects];
				System.out.println("Enter the marks");
				
				int grade=calculateGrade(marksArray, noOfSubjects);
				
				if(grade==1)
					System.out.println("First grade university");
				else if(grade==2)
					System.out.println("Second grade university");
				else if(grade==3 || grade==-1)
					System.out.println("Third grade university");}
			}



	}


