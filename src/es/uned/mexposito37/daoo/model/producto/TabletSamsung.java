/*
 * Clase TabletSamsung: modela un producto de tipo tablet y de marca Samsung.
 */
package es.uned.mexposito37.daoo.model.producto;

import java.math.BigDecimal;

/**
 * Clase TabletSamsung: modela un producto de tipo tablet y de marca Samsung.
 */
public class TabletSamsung extends Tablet {

	/**
	 * Constructor vacío por defecto.
	 */
	public TabletSamsung() {

	}

	/**
	 * Constructor con parámetros: instancia un nuevo objeto movil Samsung.
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
	public TabletSamsung(String codigo, String descripcion, BigDecimal precio, int iva, int stock) {

		super(codigo, descripcion, precio, iva, stock);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.uned.mexposito37.daoo.model.producto.Producto#toString()
	 */
	@Override
	public String toString() {

		return "Tablet Samsung " + this.getCodigo() + " - " + this.getDescripcion();
	}

}
