/*
 * Clase Ticket que modela la entidad del mismo nombre a modo de POJO.
 */

package es.uned.mexposito37.daoo.model;

import java.util.ArrayList;
import java.util.List;

/**
 * La clase Ticket.
 */
public class Ticket {

	private String codigo; // no procede que haya dos ventas simultáneas; por
							// sencillez, se desnormaliza la lista
	// cada registro con el mismo código pertenece al mismo ticket
	// un registro por cada producto vendido
	private List<LineaTicket> lineasTicket;
	private Cliente cliente;

	/**
	 * Constructor vacío para uso de superCSV.
	 */
	public Ticket() {

	}

	/**
	 * Constructor con parámetros: instancia un nuevo ticket.
	 *
	 * @param codigo
	 *            el codigo
	 * @param cliente
	 *            el cliente
	 */

	public Ticket(String codigo, Cliente cliente) {
		super();
		this.codigo = codigo;
		this.cliente = cliente;
		this.lineasTicket = new ArrayList();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public List<LineaTicket> getLineasTicket() {
		return lineasTicket;
	}

	/**
	 * Añade una línea a las líneas del ticket.
	 *
	 * @param lineaTicket
	 *            la linea del ticket
	 */
	public void addToLineasTicket(LineaTicket lineaTicket) {
		this.lineasTicket.add(lineaTicket);
	}

	/**
	 * Elimina una línea de las líneas del ticket.
	 *
	 * @param lineaTicket
	 *            la linea del ticket
	 */
	public void removeFromLineasTicket(LineaTicket lineaTicket) {
		this.lineasTicket.remove(lineaTicket);
	}

}
