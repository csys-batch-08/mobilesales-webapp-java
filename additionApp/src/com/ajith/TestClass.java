package com.ajith;

class ArithmeticOperator{
	
	public int sum(int a,int b) {
		int c=a+b;
		return(c);
		
	}
	public void sum(int a,int b,int c) {
		int d=a+b+c;
		
	}
	
	
}

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArithmeticOperator obj=new ArithmeticOperator();
		
		System.out.println(obj.sum(5, 8));
	   obj.sum(3, 50, 20);


	}

}

