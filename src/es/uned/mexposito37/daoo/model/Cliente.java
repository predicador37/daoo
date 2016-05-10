package es.uned.mexposito37.daoo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.uned.mexposito37.daoo.model.factura.Factura;

public class Cliente {

	private String codigo;
	private String nif;
	private String razonSocial;
	private String domicilio;
	private Date fechaAlta;
	private List<Factura> facturas;
	
	
	public Cliente() {
		
	}
	
	public Cliente(String codigo, String nif, String razonSocial, String domicilio, Date fechaAlta) {
		super();
		this.codigo = codigo;
		this.nif = nif;
		this.razonSocial = razonSocial;
		this.domicilio = domicilio;
		this.fechaAlta = fechaAlta;
		this.facturas = new ArrayList();
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	
	public void addToFacturas(Factura factura){
		this.facturas.add(factura);
	}
	
	public List<Factura> getFacturas() {
		return this.facturas;
	}
	
	public void setFacturas(ArrayList<Factura> facturas)
	{
	    this.facturas = facturas;
	}
	
	private class ClienteMemento {
		private List estado;

		private ClienteMemento(List<Factura> facturas) {
			this.estado = new ArrayList(facturas);
		}
		public List getEstado() {
			return this.estado;
		}
	}

	public Object getMemento() {
		return new ClienteMemento(this.getFacturas());
	}

	public void setMemento(Object objeto) {
		if (objeto instanceof ClienteMemento) {
			ClienteMemento memento = (ClienteMemento) objeto;
			this.setFacturas(new ArrayList<Factura>(memento.getEstado()));
		}
	}
	
}
