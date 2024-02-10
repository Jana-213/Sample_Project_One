package practice;

public class JavaPractice {

	public static void main(String[] args) {

		String text = "Please use temporary password 'rahulshettyacademy' to Login.";

		String[] split = text.split("'");

		for (String s : split) {
//			if(s.contains("rahul")) {
			
			System.out.println(s);
//			}
		}

	}
}
