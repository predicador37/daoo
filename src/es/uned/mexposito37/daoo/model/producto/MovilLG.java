/*
 * Clase MovilLG: modela un producto de tipo movil y de marca LG.
 */
package es.uned.mexposito37.daoo.model.producto;

import java.math.BigDecimal;

/**
 * Clase MovilLG: modela un producto de tipo movil y de marca LG.
 */
public class MovilLG extends Movil {

	/**
	 * Constructor vacío por defecto.
	 */
	public MovilLG() {

	}

	/**
	 * Constructor con parámetros: instancia un nuevo objeto movil lg.
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
	public MovilLG(String codigo, String descripcion, BigDecimal precio, int iva, int stock) {

		super(codigo, descripcion, precio, iva, stock);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.uned.mexposito37.daoo.model.producto.Producto#toString()
	 */
	@Override
	public String toString() {

		return "Móvil LG " + this.getCodigo() + " - " + this.getDescripcion();
	}

}
