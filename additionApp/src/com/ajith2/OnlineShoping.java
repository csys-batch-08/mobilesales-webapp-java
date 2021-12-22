package com.ajith2;

import java.util.Scanner;

public class OnlineShoping {
	static int price=0;
	static int total=0;
	
	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		purchase();
	}
		// TODO Auto-generated method stub
		public static void purchase() {
		System.out.println("Choose the Product type \n 1.Laptop \n 2.Moblie \n 3.Shoes");
		//Scanner sc=new Scanner(System.in);
		int Product=sc.nextInt();
		
		switch(Product){
		case 1:{
			System.out.println("Laptop Accesories list \n 1.Mouse \n 2.Keyboard \n 3.Moniter");
			int laptopAcc=sc.nextInt();
			
			total+=laptop(laptopAcc);
			
			
			break;
		}
		case 2:{
			System.out.println("Mobile Accesories list \n 1.Redmi Note 10 \n 2.Vivo v12 \n 3.iphone 12pro");
			int mobileAcc=sc.nextInt();
			total=mobile(mobileAcc);
			break;
			
		}
		default:{
			System.out.println("Invalid Choise");
		}
		}
		System.out.println("total :"+ total);
		

	}
	public static int laptop(int laptopAcc) {
		switch(laptopAcc){
		case 1:{
			int mouse=540;
			price=price+mouse;
			System.out.println("Product         Price");
			System.out.println("Mouse price  :   "+mouse);
			break;
		}
		case 2:{
			int keyboard=750;
			price=price+keyboard;
			System.out.println("Product         Price");
			System.out.println("Keyboard price  :   "+keyboard);
			break;
		}
		case 3:{
			int moniter=2000;
			price=price+moniter;
			System.out.println("Product         Price");
			System.out.println("Moniter price  :   "+moniter);
			break;
		}
		default:{
			System.out.println("Invalid choise");
		}
			
		}
		System.out.println("Do you want more purchase \n yes \n no");
		String more=sc.next();
		if(more.equals("yes")) {
			purchase();
		}
		else {
			System.exit(0);
		}
		return price;
		
	}
	public static int mobile(int mobileAcc) {
		// TODO Auto-generated method stub
		
		switch(mobileAcc) {
		case 1:{
			int redmi=14000;
			price+=redmi;
			System.out.println("Product         Price");
			System.out.println("redmi price 10  :  "+redmi);
			
			
			break;
			
			
		}
		case 2:{
			int vivo=21000;
			price+=vivo;
			System.out.println("Product         Price");
			System.out.println("vivo v12  :  "+vivo);
			break;
			
		}
		case 3:{
			int iphone=98000;
			price+=iphone;
			System.out.println("Product         Price");
			System.out.println("iphone 12      :  "+iphone);
			break;
		}
		default:{
			System.out.println("Invalid choise");
		}
		
		}
		System.out.println("Do you want more purchase \n yes \n no");
		String more=sc.next();
		if(more.equals("yes")) {
			purchase();
		}
		else {
			System.exit(0);
		}
		
		return price;
	}

}
