package day22;

import java.util.Scanner;

public class PrimeIndexSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n];
		int sum=0;
		int prime=2,n2=n-1;
		for(int i=0;i<n;i++) {
			 arr[i]=sc.nextInt();
		}
		
		
		while(n2>=0) {
			int count=0;
		for(int i=1;i<=prime;i++) {
			if(prime%i==0) {
				count++;
			}
			
			
		}
		//System.out.println("count :"+count);
		if(count<3) {
			System.out.println(prime);
			sum+=arr[prime-1];
		}
		prime++;
		n2--;
		}
	
		System.out.println(sum);
		
	
	}

}
