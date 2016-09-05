package finalproject;

public class Char {
	
	// initialize variables
	String name;
	int age;
	
	
	// Constructor class
	public Char (String newName, int newAge) {
		
		// Define variables
		name = newName;
		age = newAge;
		
	}
	
	public void sayHi () {
		System.out.println("Hello, " + name + "!");
	}
	
	public void sayAge () {
		System.out.println("You are " + age + ".");
	}
	
	public void changeName (String someName) {
		name = someName;
	}
	
	public void changeAge (int someAge) {
		age = someAge;
	}
	
	public void grow (int years) {
		age += years;
	}
	
}
