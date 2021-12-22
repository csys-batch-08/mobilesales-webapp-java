package day30;

import java.util.Scanner;

public class FiveSubject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		int e=sc.nextInt();
		int m=sc.nextInt();
		int s=sc.nextInt();
		int ss=sc.nextInt();
		
		Subject obj=new Subject();
		obj.setTamil(t);
		obj.setEnglish(e);
		obj.setMaths(m);
		obj.setScience(s);
		obj.setSocialScience(ss);
		obj.setTotal();
		
		
		System.out.println(obj.getTotal());
		

	}

}
class Subject{
	private int tamil;
	private int english;
	private int maths;
	private int science;
	private int socialScience;
	private int total;
	
	
	
	public int getTamil() {
		return tamil;
	}
	public void setTamil(int tamil) {
		this.tamil = tamil;
	}
	
	public int geEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english=english;
	}
	public int getMaths() {
		return maths;
	}
	public void setMaths(int maths) {
		this.maths=maths;
	}
	public int getScience() {
		return science;
	}
	public void setScience(int science) {
		this.science=science;
	}
	public int getSocialScience() {
		return socialScience;
	}
	public void setSocialScience(int socialScience) {
		this.socialScience=socialScience;
	}
	
	
	 
	
	
	public void setTotal() {
		this.total=tamil+english+maths+science+socialScience;
		
	}
	int getTotal() {
		return this.total;
	}

	
	
	
	
}
