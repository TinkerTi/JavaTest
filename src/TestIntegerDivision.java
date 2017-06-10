
public class TestIntegerDivision {
	public static void main(String[] args){
		TestIntegerDivision test=new TestIntegerDivision();
//		test.testIntegerDivision();
//		test.testShorCircuit();
//		test.testHex();
		test.testBitOperator();
		
	}
	
	public void testBitOperator(){
		int x=1;
		int y=0;
		int z=x^y;
		System.out.println(z);
	}
	public void testHex(){
//		int x=0xf;
//		int y=017;
		double z =1e+2;
//		System.out.println(x);
//		System.out.println(y);
		System.out.println(z);
		
	}
	public void testIntegerDivision(){
		int result=1/2;
		int result1=3/2;
		System.out.println(result);
		System.out.println(result1);
	}
	
	public boolean test1(int x){
		System.out.println(x+":");
		return x<1;
	}
	public boolean test2(int y){
		System.out.println(y+":");
		return y<2;
	}
	public void testShorCircuit(){
		boolean truth=test1(2)&&test2(1);
		System.out.println(truth);
	}
}
