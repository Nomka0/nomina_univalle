package modelo;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConceptoDevengo extends Entidad{
	private int codigo;
	private String nombre;
    private Date fecha = new Date();
    private float valor_devengo;
	private boolean hace_base;
	
	 
	public ConceptoDevengo(int codigo, String nombre, String fecha, float corte_kilos) {
		super(codigo, nombre);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try {
			this.fecha = sdf.parse(fecha);
		}
		catch (Exception e) {
            System.out.println("Error al inicializar la fecha: " + e.getMessage());
		}
		hace_base = false;
		valor_devengo = corte_kilos;
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
	
	/*
	public int corteCana() {
		int pago_semanal = pago_corte_cana.getTarifa(tipo_cana, tipo_dia);
		return pago_semanal; 
		//como no hace base, entonces no se cambia ese valor, que se inicializó en false en el constructor
	}*/
	
}


