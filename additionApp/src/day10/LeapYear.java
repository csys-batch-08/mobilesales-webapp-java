package day10;

import java.util.Scanner;

public class LeapYear {
	
	public static int leapYear(int num) {
		int count=0;
		if(num%400==0) {
			count++;
			return count;
		}
		else if(num%100==0) {
			return count;
		}
		else if(num%4==0){
			count++;
			return count;
		}
		else {
			return count;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count=0;
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
         count=leapYear(num);
       
		if(count==1) {
			System.out.println(num+" is LeapYear");
		}
		else {
			System.out.println(num+" is Not a Leapyear");
		}

	}

}
