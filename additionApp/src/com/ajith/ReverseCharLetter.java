package com.ajith;

public class ReverseCharLetter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name="Madurai";
		char array[]=name.toCharArray();
		System.out.println("Print char");
		for(int i=0;i<array.length;i++) {
			System.out.println(array[i]);
		}
		System.out.println("Reverse char");
		for(int i=array.length-1;i>=0;i--) {
			System.out.println(array[i]);
		}
		StringBuilder sb=new StringBuilder(name);
		System.out.println(sb.reverse());

		

	}

}
