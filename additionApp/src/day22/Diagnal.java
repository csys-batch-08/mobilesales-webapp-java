
package day22;

import java.util.Scanner;
import java.lang.Math;


public class Diagnal {
	
//	Sample Input 1:
//		3
//		11 2 4
//		4 5 6
//		10 8 -12
//		Sample Output 1:
//		15

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[][]=new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		int sum1=0,sum2=0;
		int n2=n-1;
		int n3=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i==j) {
					sum1+=arr[i][j];
				}
				if(i+j==n-1){
					
						sum2+=arr[i][j];
						
				}
				
			//My own logic code	
//				if(  i==n3 && j==n2  )
//				{
//					sum2+=arr[i][j];
//					n3+=1;
//					n2-=1;
//					System.out.println(n3 +" "+n2);
//				}
		
				
			}
		}

		System.out.println(sum1);
		System.out.println(sum2);
		int res=Math.abs(sum1-sum2);
		System.out.println(res);

	}

}
