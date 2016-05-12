/*
 * Clase que modela las líneas que aparecen en un ticket a modo de POJO.
 */
package es.uned.mexposito37.daoo.model;

import java.math.BigDecimal;

import es.uned.mexposito37.daoo.model.producto.Producto;

/**
 * Clase LineaTicket.
 */
public class LineaTicket extends AbstractModelObject {

	private Integer unidadesVendidas;
	private BigDecimal importeTotal;
	Producto producto;
	Ticket ticket;

	/**
	 * Constructor vacío para uso de superCSV.
	 */

	public LineaTicket() {

	}

	/**
	 * Constructor con parámetros: instancia una nueva línea de ticket.
	 *
	 * @param unidadesVendidas
	 *            unidades vendidas
	 * @param producto
	 *            producto
	 * @param ticket
	 *            ticket
	 */

	public LineaTicket(Integer unidadesVendidas, Producto producto, Ticket ticket) {
		super();
		this.unidadesVendidas = unidadesVendidas;
		this.importeTotal = producto.getPvp().multiply(new BigDecimal(unidadesVendidas));
		this.producto = producto;
		this.ticket = ticket;
		this.ticket.addToLineasTicket(this);
	}

	/* getters y setters */

	public Integer getUnidadesVendidas() {
		return unidadesVendidas;
	}

	public void setUnidadesVendidas(Integer unidadesVendidas) {
		this.unidadesVendidas = unidadesVendidas;
	}

	public BigDecimal getImporteTotal() {
		return importeTotal;
	}

	public void setImporteTotal(BigDecimal importeTotal) {
		this.importeTotal = importeTotal;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

}
