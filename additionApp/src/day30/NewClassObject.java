package day30;

public class NewClassObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NewClass s4=new NewClass();
		NewClass s1=new NewClass(4);
		int a=4,b=5;
		String n="AjithKumar ";
		s4.run();
		
		NewClass s2=new NewClass(a,b);
		NewClass s3=new NewClass(n,b);
		System.out.println("C value : "+s2.c);
		
		
		
	

	}

}
