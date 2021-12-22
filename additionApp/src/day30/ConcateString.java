package day30;
public class ConcateString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String n1="Ajith ";
		String n2="Karthi ";
		String n3="Mari Selva";
		
		ConcateString2 obj=new ConcateString2();
		
		
		
		System.out.println(obj.concate1(n1,n2,n3));
		
		System.out.println(n1.concat(n2).concat(n3));
		

	}

}

class ConcateString2 {
	
	public String concate1(String n1,String n2,String n3) {
		
		return(n1+n2+n3);
	}

}
