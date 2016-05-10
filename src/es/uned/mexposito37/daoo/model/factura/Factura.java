package es.uned.mexposito37.daoo.model.factura;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.uned.mexposito37.daoo.model.Cliente;
import es.uned.mexposito37.daoo.model.LineaTicket;
import es.uned.mexposito37.daoo.model.Ticket;
import es.uned.mexposito37.daoo.model.producto.Producto;

public abstract class Factura {

	private String numeroFactura;
	private String cifVendedor;
	private String razonSocialVendedor;
	private Date fechaEmision;
	private BigDecimal importeTotal;
	private Cliente cliente;
	private List<Ticket> tickets;

	public Factura() {

	}

	public Factura(String numeroFactura, String cifVendedor, String razonSocialVendedor, Date fechaEmision,
			Cliente cliente) {
		super();
		this.numeroFactura = numeroFactura;
		this.cifVendedor = cifVendedor;
		this.razonSocialVendedor = razonSocialVendedor;
		this.fechaEmision = fechaEmision;
		this.cliente = cliente;
		this.tickets = new ArrayList();
		this.importeTotal=new BigDecimal(0);
		this.cliente.addToFacturas(this);
	}

	public String getNumeroFactura() {
		return numeroFactura;
	}

	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public String getCifVendedor() {
		return cifVendedor;
	}

	public void setCifVendedor(String cifVendedor) {
		this.cifVendedor = cifVendedor;
	}

	public String getRazonSocialVendedor() {
		return razonSocialVendedor;
	}

	public void setRazonSocialVendedor(String razonSocialVendedor) {
		this.razonSocialVendedor = razonSocialVendedor;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public BigDecimal getImporteTotal() {
		return importeTotal;
	}

	public void setImporteTotal(BigDecimal importeTotal) {
		this.importeTotal = importeTotal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void addToTickets(Ticket ticket) {
		this.tickets.add(ticket);
		for (LineaTicket lt : ticket.getLineasTicket()) {
			this.setImporteTotal(this.importeTotal.add(lt.getImporteTotal()));
		}
		
	}

	@Override
	public String toString() {

		String productos = "";

		for (Ticket t : this.getTickets()) {
			for (LineaTicket lt : t.getLineasTicket()) {
				productos += "Producto: " + lt.getProducto().getDescripcion() + ", Ticket: " + t.getCodigo()
						+ ", Cantidad: " + lt.getUnidadesVendidas() + ", Subtotal: " + lt.getImporteTotal().setScale(2, RoundingMode.CEILING) + "\n";
			}
		}

		return  "\n----------------------------------\n" +
				"Datos de la Factura: \n" 
		        + "Factura no.: " + this.getNumeroFactura() + "\n" + "CIF del vendedor: " + this.getCifVendedor() + "\n"
				+ "Razón social del vendedor: " + this.getRazonSocialVendedor() + "\n" + "Fecha de emisión :"
				+ this.getFechaEmision() + "\n" + "Código de cliente :" + this.cliente.getCodigo() + "\n"
				+ "NIF del cliente :" + this.cliente.getNif() + "\n" + "Razón social del cliente: "
				+ this.cliente.getRazonSocial() + "\n" + "Domicilio del cliente: " + this.cliente.getDomicilio() + "\n"
				+ productos + 
				"Importe total: " + this.getImporteTotal().setScale(2, RoundingMode.CEILING);

	}

}
