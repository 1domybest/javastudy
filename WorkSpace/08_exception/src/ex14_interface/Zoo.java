package ex14_interface;

public class Zoo {
	
	private Animal[] animals;
	private int idx;
	
	
	public Zoo(int animalCount) {
	animals = new Animal[animalCount];
	}
	
	public void addAnimal(Animal animal) {
		if(idx < animals.length) {
		animals[idx++]= animal;
		
		}
	}
	public void info() {
		for (Animal animal : animals) {
			if(animal != null) {
				
				animal.move();
			}
		}
		
	}
	
	
}
