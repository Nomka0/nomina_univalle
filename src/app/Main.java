package app;
import modelo.TarifaCana;


public class Main {
	public static void main(String[] args) {
		TarifaCana tarifa = new TarifaCana(); 
		tarifa.getTarifa(1, 'F');
	}
}