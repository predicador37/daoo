/*
 * Clase abstracta tablet: modela un producto de tipo tableta sin marca.
 */
package es.uned.mexposito37.daoo.model.producto;

import java.math.BigDecimal;

/**
 * Clase abstracta tablet: modela un producto de tipo tableta sin marca.
 */
public abstract class Tablet extends Producto {

	/**
	 * Constructor vacío por defecto.
	 */
	public Tablet() {

	}

	/**
	 * Constructor con parámetros: instancia un nuevo móvil.
	 *
	 * @param codigo
	 *            codigo
	 * @param descripcion
	 *            descripcion
	 * @param precio
	 *            precio
	 * @param iva
	 *            iva
	 * @param stock
	 *            stock
	 */
	public Tablet(String codigo, String descripcion, BigDecimal precio, Integer iva, Integer stock) {
		super(codigo, descripcion, precio, iva, stock);
	}

}
