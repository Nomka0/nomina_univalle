package modelo;
import java.util.HashMap;
import java.util.Objects;

//clase para las tipos de las cañas, esta info le conscierne a ConceptoDevengo, para calcular los devengos
public class TarifaCana {
	 private HashMap<Pair, Integer> tipos = new HashMap<>(); //tipos de tipo caña, el pair es para
	//señalar si el día es festivo u ordinario y también el tipo decaña, y el integer señala el tipo de tipo
	private HashMap<Integer,Integer> tarifas = new HashMap<>();
	private int cana_tipo;
	private char dia_tipo;

	
	public TarifaCana(int cana_tipo, char dia_tipo) {
		//inicialización tipos
		tipos.put(new Pair(1, 'O'), 1); //quemada ordinaria
		tipos.put(new Pair(1, 'F'), 2); //quemada festiva
		tipos.put(new Pair(2, 'O'), 3);//cruda ordinaria 
		tipos.put(new Pair(2, 'F'), 4);//cruda festiva

		//inicialización tarifas
		tarifas.put(1, 80000);//el dato de clave es el tipo de tarifa, el dato a acceder es el valor en pesos
		tarifas.put(2, 100000);
		tarifas.put(3, 150000);
		tarifas.put(4, 200000);
		
		this.cana_tipo = cana_tipo;
		this.dia_tipo = dia_tipo;
	}
	
	public int getTipo() {
		int tipo = tipos.get(new Pair(cana_tipo, dia_tipo));
		//getTipoString(tipo); //esto es para debugear
		return tipo;
	}


	public void getTipoString(int tipo) {
		switch(tipo) {
		case 1:
			System.out.println("el tipo de tarifa es: quemada ordinaria");
			break;
		case 2:
			System.out.println("el tipo de tarifa es: quemada festiva");
			break;
		case 3:
			System.out.println("el tipo de tarifa es: cruda ordinaria");
			break;
		case 4:
			System.out.println("el tipo de tarifa es: cruda festiva");
			break;
		default:
			// Código para otros casos
			System.out.println("invalido");
			break;
		}
		
	}
	
	public int getTarifa() {
		int tipo = getTipo();
		int tarifa = tarifas.get(tipo);
		
		//getTipoString(tipo);
		//System.out.println("el valor de la tarifa es " + tarifa); //esto es para debug
		return tarifa;
	}

}

//para almacenar el primer dato de la clave del hashmap, el cual se conforma de una pareja de int y char
	class Pair {
		private int key1;
		private char key2;

		public Pair(int key1, char key2) {
			this.key1 = key1;
			this.key2 = key2;
		}
		// Sobrescribir los métodos equals() y hashCode() para la correcta comparación de claves

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Pair pair = (Pair) o;
			return key1 == pair.key1 && key2 == pair.key2;
		}

		@Override
		public int hashCode() {
			return Objects.hash(key1, key2);
		}
	}