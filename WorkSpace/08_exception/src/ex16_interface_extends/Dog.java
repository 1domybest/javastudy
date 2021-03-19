package ex16_interface_extends;

public class Dog extends Pet implements Walkable {

	public Dog(String name) {
		super(name);
		System.out.println("Who let the dogs out who! who! who!");
	}
	
}
