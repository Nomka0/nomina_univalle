package modelo;
import java.util.HashMap;
import java.util.Objects;

//clase para las tarifas de las cañas, esta info le conscierne a ConceptoDevengo, para calcular los devengos
public class TarifaCana {
	HashMap<Pair, Integer> tarifas = new HashMap<>(); //tarifas de caña, el pair es para
	//señalar si el día es festivo u ordinario y también el tipo decaña, y el integer señala el tipo de tarifa

	public TarifaCana() {
		tarifas.put(new Pair(1, 'O'), 1); //quemada ordinaria
		tarifas.put(new Pair(2, 'F'), 2); //quemada festiva
		tarifas.put(new Pair(3, 'O'), 3);//cruda ordinaria 
		tarifas.put(new Pair(4, 'F'), 4);//cruda festiva
	}

	public int getTarifa(int cana_tipo, char dia_tipo) {
		int tarifa = tarifas.get(new Pair(cana_tipo, dia_tipo));
		getTarifaString(tarifa);
		return tarifa;
	}


	public void getTarifaString(int tarifa) {
		switch(tarifa) {
		case 1:
			System.out.println("quemada ordinaria");
			break;
		case 2:
			System.out.println("quemada festiva");
			break;
		case 3:
			System.out.println("cruda ordinaria");
			break;
		case 4:
			System.out.println("cruda festiva");
			break;
		default:
			// Código para otros casos
			System.out.println("invalido");
			break;
		}
	}

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
}