package es.uned.mexposito37.daoo.model.producto;

import java.math.BigDecimal;

public class MovilSamsung extends Movil {
	
	public MovilSamsung(){
		
	}

	public MovilSamsung(String codigo, String descripcion, BigDecimal precio, int iva, int stock) {
		
		super(codigo, descripcion, precio, iva,  stock);
	}
	
	@Override
	 public String toString() {
	    	
	    	return "Móvil Samsung " + this.getCodigo() + " - " + this.getDescripcion();
	    }

	
}
