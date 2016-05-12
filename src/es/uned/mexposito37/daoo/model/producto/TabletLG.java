/*
 * Clase TabletLG: modela un producto de tipotableta y de marca LG.
 */
package es.uned.mexposito37.daoo.model.producto;

import java.math.BigDecimal;

/**
 * Clase MovilLG: modela un producto de tipo tableta y de marca LG.
 */
public class TabletLG extends Tablet {
	
	/**
	 *  Constructor vacío por defecto.
	 */
	public TabletLG(){
		
	}

	/**
	 * Constructor con parámetros: instancia un nuevo objeto tablet lg.
	 *
	 * @param codigo codigo
	 * @param descripcion descripcion
	 * @param precio precio
	 * @param iva iva
	 * @param stock stock
	 */
	public TabletLG(String codigo, String descripcion, BigDecimal precio, int iva, int stock) {
		
		super(codigo, descripcion, precio, iva,  stock);
	}
	

	/* (non-Javadoc)
	 * @see es.uned.mexposito37.daoo.model.producto.Producto#toString()
	 */
	@Override
	 public String toString() {
	    	
	    	return "Tablet LG " + this.getCodigo() + " - " + this.getDescripcion();
	    }

	
}
