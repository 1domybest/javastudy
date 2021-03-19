package ex14_interface;

public class MainClass {	
		public static void main(String[] args) {
			Zoo z = new Zoo(5);
			
			
			z.addAnimal(new Lion());
			z.addAnimal(new Eagle());
			z.addAnimal(new Shark());
			z.addAnimal(new Lion());
			z.addAnimal(new Shark());
			
			z.info();
		}

}
