/*
 * Clase abstracta móvil: modela un producto de tipo móvil sin marca.
 */
package es.uned.mexposito37.daoo.model.producto;

import java.math.BigDecimal;

/**
 * Clase Movil: modela un producto de tipo móvil sin marca.
 */
public abstract class Movil extends Producto {

	/**
	 * Constructor vacío por defecto.
	 */
	public Movil() {

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
	public Movil(String codigo, String descripcion, BigDecimal precio, Integer iva, Integer stock) {
		super(codigo, descripcion, precio, iva, stock);
	}
}
