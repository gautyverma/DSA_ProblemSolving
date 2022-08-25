package prac;

public class Ridhi {
	public static void main(String []args){
		System.out.println("Hello World");
		int limit = 25;
		int sum = 60;
		double randomValue = 2.77;

		for (int var = 1; var < limit; var = var + 3) {
     System.out.println("var - "+var);
			System.out.println("randomValue: " + randomValue);
			for (int j = 1; j < limit; j = j + 2) {
			System.out.println("j-"+j);
				sum++;
			}
			System.out.println("Sum = " + sum);
		}
	}
}
