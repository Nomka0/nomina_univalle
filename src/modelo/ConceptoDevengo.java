package modelo;

public class ConceptoDevengo extends Entidad{
	int codigo;
	String nombre;
	String fecha;
	int valor_devengo;
	boolean hace_base;
	
	TarifaCana pago_corte_cana;
	
	
	 
	public ConceptoDevengo(int codigo, String nombre, String fecha) {
		super(codigo, nombre);
		this.fecha = fecha;
		hace_base = false;
		valor_devengo = 0;
		pago_corte_cana = new TarifaCana();
	}
	
	public ConceptoDevengo() {
		super();
		valor_devengo = 0;
		pago_corte_cana = new TarifaCana();
	}
	
	public boolean getHaceBase() {
		return hace_base;
	}
	
	public void setHaceBase(boolean hace_base) {
		this.hace_base = hace_base;
	}
	
	//cada dao tendra 2 de estos (ya que son reportes semanales y la liquidación de nomina es quincenal)
	
	public void corteCana(int tipo_cana, char tipo_dia) {
		int pago_semanal = pago_corte_cana.getTarifa(tipo_cana, tipo_dia);
		valor_devengo = pago_semanal; 
		//como no hace base, entonces no se cambia ese valor, que se inicializó en false en el constructor
	}
}


