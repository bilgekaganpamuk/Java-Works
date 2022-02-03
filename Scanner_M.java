package input;
import java.util.Scanner;
public class Scanner_M {

	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String text, radek, buffer;
		Double db;
		System.out.println("Zadej retezec: ");
		text = input.next();
		System.out.println("Vysledek: "+text);
		buffer = input.next();
		System.out.println("Vysledek buffer: "+buffer);
		input.nextLine();
		//System.out.println("Zadej retezec: "); je zbytecny
		System.out.println("Zadejte radek textu");
		radek = input.nextLine();
		System.out.println("Vysledek: "+radek);
		
		System.out.println("Zadejte double: ");
		// zadava se s desetinnou carkou
		db = input.nextDouble();
		System.out.println("double cislo: "+db);
		System.out.println("Zadejte integer: ");
		int inum = input.nextInt();
		System.out.println("Zadane cislo: "+inum);
	}

}
