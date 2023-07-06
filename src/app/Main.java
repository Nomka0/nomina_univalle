package app;
import modelo.TarifaCana;
import modelo.ConceptoDevengo;
import dao.ConceptoDevengoDAO;

public class Main {
	public static void main(String[] args) {
		//TarifaCana tarifa = new TarifaCana(); 
		//tarifa.getTarifa(1, 'F');
		
		//testeando...
		ConceptoDevengoDAO dao_devengos = new ConceptoDevengoDAO();
		ConceptoDevengo corte_cana = new ConceptoDevengo(1234,"PRIMER PAGO SEMANAL","20230629");
		corte_cana.corteCana(1, 'F');
		
		dao_devengos.crear(corte_cana);
		
		ConceptoDevengo uno_mas = dao_devengos.obtener(0);
		
		String nombre_del_devengo = uno_mas.getNombre();
		
		System.out.println("Este es el valor (pesos) del devengo creado: " + uno_mas.getValorDevengo());
		
		System.out.println("Este es el devengo creado: " + nombre_del_devengo);

	}
}