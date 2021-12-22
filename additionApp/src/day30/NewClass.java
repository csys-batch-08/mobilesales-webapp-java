package day30;

public class NewClass {
	 int a,b,c=0;
	 String n;
	 
	
	NewClass(){
		
		System.out.println("default constructor");
		
	}
	NewClass(int a){
		
		this.a=a;
		System.out.println("Single parameter : "+a);
	}
	NewClass(int a,int b){
		this.a=a;
		this.b=b;
		c=a+b;
		//System.out.println("Double Parameter : "+(a+b));
	}
	NewClass(String n,int b){
		this.n=n;
		this.b=b;
		
		System.out.println("String and int Parameter : "+n+b);
		
	}
	void run() {
		System.out.println("Run Method");
	}
	


}
