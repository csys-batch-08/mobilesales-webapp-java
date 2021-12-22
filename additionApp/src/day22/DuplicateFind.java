package day22;

import java.util.Scanner;

public class DuplicateFind {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n+1];
		
		for(int i=0;i<=n;i++) {
			arr[i]=sc.nextInt();
		}
		int count=0;
		for(int i=0;i<=n;i++) {
			for(int j=i+1;j<=n;j++) {
				if(arr[i]==arr[j]) {
					count++;
					System.out.println("Count");
					System.out.println(arr[i]);
				}
			}
		}
		System.out.println(count);

	}

}
//2
//1
//3
//8
//6
//8
//10
//8
//8
