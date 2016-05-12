/*
 * Clase Cliente que modela la entidad del mismo nombre a modo de POJO.
 */
package es.uned.mexposito37.daoo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.uned.mexposito37.daoo.model.factura.Factura;

/**
 * Clase Cliente.
 */
public class Cliente {

	private String codigo;
	private String nif;
	private String razonSocial;
	private String domicilio;
	private Date fechaAlta;
	private List<Factura> facturas;

	/**
	 * Constructor vacío para uso de superCSV.
	 */

	public Cliente() {

	}

	/**
	 * Constructor con parámetros: instancia un nuevo cliente.
	 *
	 * @param codigo
	 *            código de cliente
	 * @param nif
	 *            nif del cliente
	 * @param razonSocial
	 *            razón social o nombre y apellidos del cliente
	 * @param domicilio
	 *            domicilio del cliente
	 * @param fechaAlta
	 *            fecha de alta del cliente
	 */

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

	/**
	 * Fija el codigo.
	 *
	 * @param codigo
	 *            el nuevo codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Recupera el nif.
	 *
	 * @return el nif
	 */
	public String getNif() {
		return nif;
	}

	/**
	 * Fija el nif.
	 *
	 * @param nif
	 *            el nuevo nif
	 */
	public void setNif(String nif) {
		this.nif = nif;
	}

	/**
	 * Recupera el domicilio.
	 *
	 * @return el domicilio
	 */
	public String getDomicilio() {
		return domicilio;
	}

	/**
	 * Fija el domicilio.
	 *
	 * @param domicilio
	 *            el nuevo domicilio
	 */
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	/**
	 * Recupera la fecha de alta.
	 *
	 * @return la fecha de alta
	 */
	public Date getFechaAlta() {
		return fechaAlta;
	}

	/**
	 * Fija la fecha de alta.
	 *
	 * @param fechaAlta
	 *            la nuevo fecha alta
	 */
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	/**
	 * Recupera la razon social.
	 *
	 * @return la razon social
	 */
	public String getRazonSocial() {
		return razonSocial;
	}

	/**
	 * Fija el razon social.
	 *
	 * @param razonSocial
	 *            la nueva razon social
	 */
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	/**
	 * Añade una factura.
	 *
	 * @param factura
	 *            la factura
	 */
	public void addToFacturas(Factura factura) {
		this.facturas.add(factura);
	}

	/**
	 * Recupera la lista de facturas.
	 *
	 * @return lista de facturas
	 */
	public List<Factura> getFacturas() {
		return this.facturas;
	}

	/**
	 * Fija la lista de facturas.
	 *
	 * @param facturas
	 *            la nueva lista de facturas
	 */
	public void setFacturas(ArrayList<Factura> facturas) {
		this.facturas = facturas;
	}

	/**
	 * Clase ClienteMemento: clase interna que modela el memento para las
	 * facturas del cliente.
	 */
	private class ClienteMemento {

		/** estado. */
		private List estado;

		/**
		 * Instancia un nuevo cliente memento.
		 *
		 * @param facturas
		 *            lista de facturas
		 */
		private ClienteMemento(List<Factura> facturas) {
			this.estado = new ArrayList(facturas);
		}

		/**
		 * Recupera el estado.
		 *
		 * @return estado
		 */
		public List getEstado() {
			return this.estado;
		}
	}

	/**
	 * Recupera el memento.
	 *
	 * @return memento
	 */
	public Object getMemento() {
		return new ClienteMemento(this.getFacturas());
	}

	/**
	 * Fija el memento.
	 *
	 * @param objeto
	 *            el nuevo memento
	 */
	public void setMemento(Object objeto) {
		if (objeto instanceof ClienteMemento) {
			ClienteMemento memento = (ClienteMemento) objeto;
			this.setFacturas(new ArrayList<Factura>(memento.getEstado()));
		}
	}

}
