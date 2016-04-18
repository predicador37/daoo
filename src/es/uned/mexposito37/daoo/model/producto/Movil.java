package es.uned.mexposito37.daoo.model.producto;

import java.math.BigDecimal;

public abstract class Movil extends Producto {

	public Movil() {
		
	}
	
	public Movil(String codigo, String descripcion, BigDecimal precio, Integer iva,  Integer stock) {
		super(codigo, descripcion, precio, iva,  stock);
	}
}
