/*
 * Clase MovilSamsung: modela un producto de tipo movil y de marca Samsung.
 */
package es.uned.mexposito37.daoo.model.producto;

import java.math.BigDecimal;

/**
 * Clase MovilSamsung: modela un producto de tipo movil y de marca Samsung.
 */
public class MovilSamsung extends Movil {

	/**
	 * Constructor vacío por defecto.
	 */
	public MovilSamsung() {

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
	public MovilSamsung(String codigo, String descripcion, BigDecimal precio, int iva, int stock) {

		super(codigo, descripcion, precio, iva, stock);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.uned.mexposito37.daoo.model.producto.Producto#toString()
	 */
	@Override
	public String toString() {

		return "Móvil Samsung " + this.getCodigo() + " - " + this.getDescripcion();
	}

}
