package modelo;

public class ConceptoDevengo extends Entidad{
	int codigo;
	String nombre;
	String fecha;
	float valor_devengo;
	boolean hace_base;
	char tipo_dia;
	int tipo_cana;
	
	TarifaCana pago_corte_cana;
	
	
	 
	public ConceptoDevengo(int codigo, String fecha, String nombre, float corte_kilos, int tipo_cana,char tipo_dia) {
		super(codigo, nombre);
		this.fecha = fecha;
		this.tipo_dia = tipo_dia;
		this.tipo_cana = tipo_cana;
		hace_base = false;
		pago_corte_cana = new TarifaCana();
		valor_devengo = corteCana()*(corte_kilos/1000);
	}
	
	public ConceptoDevengo() {
		super();
		//valor_devengo = 0;
		//pago_corte_cana = new TarifaCana();
	}
	
	public float getValorDevengo( ) {
		return valor_devengo;
	}
	
	public boolean getHaceBase() {
		return hace_base;
	}
	
	public void setHaceBase(boolean hace_base) {
		this.hace_base = hace_base;
	}
	
	//cada dao tendra 2 de estos (ya que son reportes semanales y la liquidación de nomina es quincenal)
	
	public int corteCana() {
		int pago_semanal = pago_corte_cana.getTarifa(tipo_cana, tipo_dia);
		return pago_semanal; 
		//como no hace base, entonces no se cambia ese valor, que se inicializó en false en el constructor
	}
	
}


