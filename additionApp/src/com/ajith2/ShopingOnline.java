package com.ajith2;

import java.util.Scanner;

public class ShopingOnline {
	static String item[]=new String[] {"Mouse","Keyboard","Moniter","Iphone","Vivo","Redmi"};
	static int cost[]=new int[10];
	static int a[]=new int[5];
	static int total;
	static Scanner sc=new Scanner(System.in);
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter your name");
		String name=sc.next();
		onlinePurchase(name);
		
		
		
		
		 

	}
	public static void onlinePurchase(String name) {
		System.out.println("Welcome to Online Purchasing");
		System.out.println("choise one \n 1.Computer Accessories \n 2.Mobile \nEnter other number to exit");
		int choise=sc.nextInt();
		
		switch(choise) {
		case 1:{
			System.out.println("1.Mouse - 350, 2.Keyboard - 800, 3.Moniter - 1700 ");
			int accessories=sc.nextInt();
			cost[0]=350;
			cost[1]=800;
			cost[2]=1700;
			switch(accessories) {
			case 1:{
				System.out.println("Confirm to purchase mouse Enter 1 or else enter any number");
				int confirm=sc.nextInt();
				if(confirm==1) {
					a[0]++;
					total+=350;
					
					System.out.println("Your item is Cart");
					break;
				}
				
				
				
			}
			case 2:{
				System.out.println("Confirm to purchase Keyboard Enter 1 or else enter any number");
				int confirm=sc.nextInt();
				if(confirm==1) {
					a[1]++;
					total+=800;
					
					
				}
				System.out.println("Your item is Cart");
				break;
				
			}
			case 3:{
				System.out.println("Confirm to purchase Moniter Enter 1 or else enter any number");
				int confirm=sc.nextInt();
				if(confirm==1) {
					a[2]++;
					total+=1700;
					
					
				}
				System.out.println("Your item is Cart");
				break;
			}
			default:{
				System.out.println("Invalid");
			}
			}
		}
		}
		System.out.println(name+" your Total cost :"+total);
		repeat(name);

		
	}
	public static void repeat(String name) {
		System.out.println("Do you want more Item Enter 1 or else enter any number");
		int more=sc.nextInt();
		
		if(more==1) {
			onlinePurchase(name);
		}
		else {
			System.out.println("Thank you for the Purchasing");
		}
		
	}

}
