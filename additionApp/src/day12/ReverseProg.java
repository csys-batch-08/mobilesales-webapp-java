package day12;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseProg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		int num2=String.valueOf(num).length();
		System.out.println(num2);
		int a[]=new int[num2];
		int i=0;
		while(num>0) {
			
			a[i]=num%10;
			num/=10;
			i++;
			
		}
		System.out.println(Arrays.toString(a));
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		int sum=0;
		
		for(int j=a.length-1;j>=0;j--) {
	    	 sum=sum*10+a[j];
			//System.out.print(a[j]);
		}
		System.out.println(sum);

	}

}
