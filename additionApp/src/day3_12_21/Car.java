package day3_12_21;

public abstract class Car implements NewOnew{
	 int speed=120;
	
	public Car(int n1) {
		System.out.println("Constructor"+n1);
	}
	public Car(int a,int b) {
		System.out.println(a+b);
	}
	public abstract void run();
	
	public void show() {
		System.out.println("This is Parant class");
	}
	
}
