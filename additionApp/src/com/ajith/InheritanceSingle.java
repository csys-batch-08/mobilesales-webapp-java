package com.ajith;
class dog{
	void method() {
		System.out.println("Walking");
	}
}
class Animal extends dog{
	void sample() {
		System.out.println("All animals here");
		
	}



    
	}


public class InheritanceSingle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   Animal obj=new Animal();
	       obj.method();
	       obj.sample();

	}

}
