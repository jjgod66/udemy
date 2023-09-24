package testtest.com.ksj;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		B b = new B(3);
		System.out.println(b.a);
	}

}
class A {
	public A (int b) {
		this.b = b;
	}
	int a = 1;
	int b = 0;
}

class B extends A{

	
	public B(int b) {
		super(2);
		this.b = b;
	}
	
	int b = 3;
}
