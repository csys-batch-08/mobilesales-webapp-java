package com.ajith;

import java.util.Scanner;
	

public class CabBooking {
	public static void rateforbike(String bike) {
		int price=10;
		Scanner a=new Scanner(System.in);
		System.out.println("enter kilometer");
		int km=a.nextInt();
		int rate =(price*km);
		
		System.out.println(rate);
	}
	public static void rateforcar(String car) {
		int price=20;
		Scanner a=new Scanner(System.in);
		System.out.println("enter kilometer");
		int km=a.nextInt();
		int rate =(price*km);
		System.out.println(rate);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner a=new Scanner(System.in);
		/*System.out.println("Enter the number");
		System.out.println("1.Micro");
		System.out.println("2.Prime");
		
		int cab=a.nextInt();
		System.out.println("Enter the KM");
		int Km=a.nextInt();
		if(cab==1) {
			int price=10;
			System.out.println("Drop Charge ="+(price*Km));
			
		}
		else if(cab==2){
			int price=20;
			System.out.println("Drop Charge ="+(price*Km));
		}
		else {
			System.out.println("Invalid");
		}*/
	System.out.println("enter your choice");
	System.out.println("bike");
	System.out.println("car");
	String name="bike";
	
	String vehicle=a.next();
	
	if(vehicle.equals(name)) {
		rateforbike(vehicle);
	}
	else if(vehicle.equals("car")) {
		rateforcar(vehicle);
	}
	else {
		System.out.println("Wrong");
	}

}
}
