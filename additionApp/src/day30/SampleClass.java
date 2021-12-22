package day30;

public class SampleClass {
	int integerValue1;
	int integerValue2;
	int sum=0;
	
	public int addElement() {
		sum=integerValue1+integerValue2;
		return sum;
		
	}
	public SampleClass(int integerValue1,int integerValue2) {
		//ssuper();
		this.integerValue1=integerValue1;
		this.integerValue2=integerValue2;
		
	}

}
