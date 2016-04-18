package es.uned.mexposito37.daoo.model.producto;

import java.math.BigDecimal;

public class TabletSamsung extends Tablet {
	
	public TabletSamsung(){
		
	}

	public TabletSamsung(String codigo, String descripcion, BigDecimal precio, int iva, int stock) {
		
		super(codigo, descripcion, precio, iva,  stock);
	}
	

	@Override
	 public String toString() {
	    	
	    	return "Tablet Samsung " + this.getCodigo() + " - " + this.getDescripcion();
	    }

	
}
