package modelo;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConceptoDevengo extends Entidad{
	private int codigo;
	private String nombre;
    private Date fecha = new Date();
    private float valor_devengo;
	private boolean hace_base;
	private double cesantias;
	private double intereses_cesantias;
	private double prima;
	private double vacaciones;
	
	
	public ConceptoDevengo(int codigo, String fecha, float corte_kilos) {
		super(codigo, "QUINCENA CORTE DE CAÑA");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try {
			this.fecha = sdf.parse(fecha);
		}
		catch (Exception e) {
            System.out.println("Error al inicializar la fecha: " + e.getMessage());
		}
		hace_base = true;
		valor_devengo = corte_kilos;
	}
	
	public ConceptoDevengo(int codigo, String nombre, double sumatoria_base) {
		super(codigo, nombre);
		calcularPrestaciones(sumatoria_base);
		hace_base = false;
		//valor_devengo = 0;
		//pago_corte_cana = new TarifaCana();
	}
	
	public void calcularPrestaciones(double sumatoria_base) { //prestaciones sociales
		cesantias = sumatoria_base * 0.0833;
		intereses_cesantias = sumatoria_base * 0.01;
		prima = sumatoria_base * 0.0833; 
		vacaciones = sumatoria_base * 0.0417;
	}
	

	
	public double getCesantias() {
		return cesantias;
	}

	public double getIntereses_cesantias() {
		return intereses_cesantias;
	}

	public double getPrima() {
		return prima;
	}

	public double getVacaciones() {
		return vacaciones;
	}
	
	public Date getFecha() {
		return fecha;
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


