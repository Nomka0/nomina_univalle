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
		
		System.out.println(dao_devengos.obtener(0));
	}
}