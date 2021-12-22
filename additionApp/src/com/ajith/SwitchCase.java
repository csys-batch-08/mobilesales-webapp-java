package com.ajith;

import java.util.Scanner;

public class SwitchCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner obj=new Scanner(System.in);
		System.out.println("Please select the cab \n 1.Micro \n 2.Mini \n 3.Prime");
		String num=obj.nextLine();
		//obj.nextLine();
		System.out.println("enter dummy");
		//String dum=obj.nextLine();
		//System.out.println(dum);
		
		switch (num) {
		
		case "1":{
			System.out.println("Enter name");
			String name=obj.nextLine();
			System.out.println("enter Kilometer");
			long c=obj.nextLong();
			System.out.println(name+" \nPrice:"+(c*10));
			break;
		}
		case "2":{
			System.out.println("Enter name");
			String name=obj.next();
			System.out.println("enter Kilometer");
			long c=obj.nextLong();
			obj.nextLine();
			System.out.println("Enter village");
			String vil=obj.nextLine();
			System.out.println(name+" \nPrice:"+(c*20));
			break;
		}
		case "3":{
			System.out.println("Enter name");
			String name=obj.next();
			System.out.println("enter Kilometer");
			long c=obj.nextLong();
			System.out.println(name+" \nPrice:"+(c*30));
			break;
		}
		default:{
			System.out.println("Invalid choise");
		}
		obj.close();
		
			
		}
			
		

	}

}
