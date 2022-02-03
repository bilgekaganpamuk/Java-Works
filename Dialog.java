package input;
import javax.swing.JOptionPane;
public class Dialog {
	
	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "Vitejte \nv \nJave");
		String name = JOptionPane.showInputDialog("Jak se jmenujete?");
		// nacte cely radek
		String zprava = String.format("Jmenuji se %s a jsem\nzde rad",name); 
		JOptionPane.showMessageDialog(null, zprava);
		//cele cislo
		name = JOptionPane.showInputDialog("Zadejte cele cislo:");
		int k = Integer.parseInt(name);
		System.out.println("Cele cislo: "+k);
		String vysledek = Integer.toString(k);
		zprava = String.format("Nactene cele cislo: %d je zde",k);
		JOptionPane.showMessageDialog(null, zprava);
		//double cislo
		name = JOptionPane.showInputDialog("Zadejte double cislo:");
		Double db =Double.parseDouble(name);
		zprava = String.format("Double cislo: %7.2f je zde", db);
		JOptionPane.showMessageDialog(null, zprava);
		vysledek = Double.toString(db);
        //Boolean, Character, Long, Float, Double
	}

}
