package day30;

import java.util.Scanner;

public class Polymorphism {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=sc.nextInt();
		int d=sc.nextInt();
		PolyClass obj=new PolyClass();
		obj.run(a, b);
		obj.run(a, b, c);
		obj.run(a, b, c, d);
		
		

	}

}
class PolyClass {

	void run(int a,int b) {
		if(a>b) {
			System.out.println("a is greater :"+a);
		}
		else {
			System.out.println("b is greater :"+b);
		}
		
	}
	void run(int a,int b,int c) {
		if(a>b && a>c) {
			System.out.println("a is greater :"+a);
		}
		else if(b>c) {
			System.out.println("b is greater ");
		}
		else {
			System.out.println("c is greater");
		}
			
	}
	void run(int a,int b,int c,int d) {
		if(a>b && a>c && a>d) {
			System.out.println("a is greater");
		}
		else if(b>c && b>d) {
			System.out.println("b is greater");
		}
		else if(c>d){
			System.out.println("c is greater");
		}
		else {
			System.out.println("d is greater");
		}
			
	}
	
}