package es.uned.mexposito37.daoo.model.producto;

import java.math.BigDecimal;

public class MovilLG extends Movil {
	
	public MovilLG(){
		
	}

	public MovilLG(String codigo, String descripcion, BigDecimal precio, int iva, int stock) {
		
		super(codigo, descripcion, precio, iva,  stock);
	}
	
	@Override
	 public String toString() {
	    	
	    	return "Móvil LG " + this.getCodigo() + " - " + this.getDescripcion();
	    }

	
}
