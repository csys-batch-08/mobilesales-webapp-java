package day3_12_21;

public class Susiki extends Car {
	public Susiki(int n1) {
		super(n1);
		System.out.println("Susiki Constructor");
	}
 

	@Override
	public void run() {
		int i1 = super.speed;
		// TODO Auto-generated method stub
		System.out.println("Running"+i1);
		
	}


	@Override
	public  void break1() {
		// TODO Auto-generated method stub
		
	}
	


	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}
	
	

}
