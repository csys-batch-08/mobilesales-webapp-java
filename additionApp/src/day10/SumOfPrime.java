package day10;

import java.util.Scanner;

public class SumOfPrime {
	static int sum=0;
    static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Enter array size");
	    int size=sc.nextInt();
		int num[]=new int[size];
		//int sum=0;
		
		

		sumPrime(size,num);
		System.out.println(sum);
			

	}
	public static void sumPrime(int size,int[] num) {
		for(int i=0;i<num.length;i++) {
			num[i]=sc.nextInt();
			if(num[i]<=0) {
				System.out.println("Invalid");
				System.exit(0);
			}
			
		}
		for(int i=0;i<=num.length;i++) {
			
			
			int flag=0;
			for(int j=2;j<=num[i]/2;j++) {
				if(num[i]%j==0) {
					flag++;
	
				}
			}
			if(flag==2) {
				
				sum+=num[i];
				System.out.println(num[i]);
			}
			flag=0;
			
		}
		
	}

}
