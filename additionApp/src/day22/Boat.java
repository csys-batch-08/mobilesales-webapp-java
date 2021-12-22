package day22;

import java.util.Scanner;

public class Boat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int boat=sc.nextInt();
		int water=sc.nextInt();
		int distance=sc.nextInt();
		
		int sum=boat+water;
		//System.out.println(sum);
		float hour=(float)distance/sum;
	
		
		System.out.printf("%.2f",hour);
		
		
		
		


	}

}
