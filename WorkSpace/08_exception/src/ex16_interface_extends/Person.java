package ex16_interface_extends;

public class Person {
	
	//1.Pet 에게 food 주기
	
	public void feed(Pet pet , String food) {
		pet.feed(food);
	}
	//pet과 산책하기
	public void walking(Walkable pet) {
		System.out.println("Walking with"+((Pet) pet).getName());
	}
	
	
}
