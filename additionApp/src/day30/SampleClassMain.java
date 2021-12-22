package day30;

import java.util.Scanner;

public class SampleClassMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int integerValue1=sc.nextInt();
		int integerValue2=sc.nextInt();
		SampleClass n1=new SampleClass(integerValue1, integerValue2);
		
		System.out.println(n1.addElement());
		

	}

}
