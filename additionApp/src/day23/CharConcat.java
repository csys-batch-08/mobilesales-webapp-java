package day23;

import java.util.Scanner;

public class CharConcat {
	public String concat(char n,char m) {
		
		String name=Character.toString(n)+Character.toString(m);
		
		return name;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	    char n='A';
	    char m='K';
	    
	    CharConcat obj=new CharConcat();
	    System.out.println(obj.concat(n, m));
	    
	    
	   // concat(n,m);
	    

	}

}
