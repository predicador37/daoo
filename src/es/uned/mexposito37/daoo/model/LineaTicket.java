package es.uned.mexposito37.daoo.model;

import java.math.BigDecimal;

import es.uned.mexposito37.daoo.model.producto.Producto;

public class LineaTicket {
	
	private Integer unidadesVendidas;
	private BigDecimal importeTotal;
	Producto producto;
	Ticket ticket;
	
	public LineaTicket() {
		
	}
	public LineaTicket(Integer unidadesVendidas, Producto producto, Ticket ticket) {
		super();
		this.unidadesVendidas = unidadesVendidas;
		this.importeTotal =  producto.getPvp().multiply(new BigDecimal(unidadesVendidas));
		this.producto = producto;
		this.ticket = ticket;
		this.ticket.addToLineasTicket(this);
	}
	
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
