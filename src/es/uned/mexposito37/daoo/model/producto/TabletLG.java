package es.uned.mexposito37.daoo.model.producto;

import java.math.BigDecimal;

public class TabletLG extends Tablet {
	
	public TabletLG(){
		
	}

	public TabletLG(String codigo, String descripcion, BigDecimal precio, int iva, int stock) {
		
		super(codigo, descripcion, precio, iva,  stock);
	}
	

	@Override
	 public String toString() {
	    	
	    	return "Tablet LG " + this.getCodigo() + " - " + this.getDescripcion();
	    }

	
}
