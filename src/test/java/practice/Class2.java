package practice;

public class Class2 extends Class1{

	public Class2(String hell) {
		super(hell);
		// TODO Auto-generated constructor stub
		
		System.out.println(hell +"from Class 2");
	}
	
	public static void main(String[] args) {
		Class2 cl = new Class2("Hello");
	}

}
