package day22;

import java.util.Scanner;

public class FahrenheitToCentigrade {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		float fahrenheit=sc.nextInt();
		if(fahrenheit>0) {
			
		
		float centigrade=(float)((fahrenheit-32)*5/9);
		System.out.println(centigrade);
		}
		else {
			System.out.println("Invalid");
		}

	}

}
