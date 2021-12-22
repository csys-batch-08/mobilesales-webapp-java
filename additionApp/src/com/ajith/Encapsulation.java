package com.ajith;

import java.util.Scanner;

public class Encapsulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SampleMethod obj=new SampleMethod();
		obj.setCusId(6);
		System.out.println(obj.getCusId());
		obj.setName("Ajith");
		System.out.println(obj.getName());
		
		//chage value
		Scanner sc=new Scanner(System.in);
		int Id=sc.nextInt();
		String name1=sc.next();
		obj.setCusId(Id);
		System.out.println(obj.getCusId());
		obj.setName(name1);
		System.out.println(obj.getName());
		
		
		

	}

}
