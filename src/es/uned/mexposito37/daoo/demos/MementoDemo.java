/*
 * Clase demostración para el patrón memento.
 */
package es.uned.mexposito37.daoo.demos;

import java.math.BigDecimal;
import java.util.Date;

import es.uned.mexposito37.daoo.model.Cliente;
import es.uned.mexposito37.daoo.model.LineaTicket;
import es.uned.mexposito37.daoo.model.Ticket;
import es.uned.mexposito37.daoo.model.factura.Factura;
import es.uned.mexposito37.daoo.model.factura.FacturaGenerica;
import es.uned.mexposito37.daoo.model.producto.MovilLG;
import es.uned.mexposito37.daoo.model.producto.MovilSamsung;
import es.uned.mexposito37.daoo.model.producto.Producto;

/**
 * Clase demostración para el patrón memento.
 */
public class MementoDemo {

	/**
	 * Método principal: ejecutar con eclipse para ver la demostración. Genera
	 * las instancias de clientes, tickets, líneas de tickets y facturas
	 * necesarias para guardar un estado del listado de facturas de un cliente y
	 * restaurarlo posteriormente con memento.
	 *
	 * @param args
	 *            argumentos
	 */
	public static void main(String[] args) {
		Cliente cliente = new Cliente("12345", "72056097H", "Miguel Expósito Martín", "c\\ El Campizo 10 2A",
				new Date("02/04/2016"));
		Ticket primerTicket = new Ticket("00001", cliente);
		Ticket segundoTicket = new Ticket("00002", cliente);
		Ticket tercerTicket = new Ticket("00003", cliente);
		Producto primerProducto = new MovilSamsung("1234567891236", "Samsung Galaxy S7", new BigDecimal("517.39"), 21,
				5);
		Producto segundoProducto = new MovilLG("1234567891237", "LG G3", new BigDecimal("222.31"), 21, 10);
		Producto tercerProducto = new MovilLG("1234567891238", "LG G4", new BigDecimal("305.781"), 21, 10);
		LineaTicket primeraLineaTicket = new LineaTicket(2, primerProducto, primerTicket);
		LineaTicket segundaLineaTicket = new LineaTicket(1, segundoProducto, segundoTicket);
		LineaTicket terceraLineaTicket = new LineaTicket(1, tercerProducto, tercerTicket);
		Factura primeraFactura = new FacturaGenerica("2016/1", "Q3900764F", "The Phone House", new Date("01/05/2016"),
				cliente);
		// Se guarda el estado en un memento
		System.out.println("\n--------------------------------------------\n");
		System.out.println("Facturas para el cliente antes de guardar estado: \n");
		for (Factura f : cliente.getFacturas()) {
			System.out.println(f.toString());
		}
		Object memento = cliente.getMemento();
		// Se añaden más facturas a la lista, cambiando por tanto el estado del
		// cliente
		Factura segundaFactura = new FacturaGenerica("2016/2", "Q3900764F", "The Phone House", new Date("03/05/2016"),
				cliente);
		Factura terceraFactura = new FacturaGenerica("2016/3", "Q3900764F", "The Phone House", new Date("06/05/2016"),
				cliente);
		primeraFactura.addToTickets(primerTicket);
		segundaFactura.addToTickets(segundoTicket);
		terceraFactura.addToTickets(tercerTicket);
		System.out.println("\n--------------------------------------------\n");
		System.out.println("Facturas para el cliente antes de deshacer: \n");
		for (Factura f : cliente.getFacturas()) {
			System.out.println(f.toString());
		}
		// Se deshacen los cambios (se vuelve al memento)
		cliente.setMemento(memento);
		System.out.println("\n--------------------------------------------\n");
		System.out.println("Facturas para el cliente después de deshacer: \n");
		for (Factura f : cliente.getFacturas()) {
			System.out.println(f.toString());
		}

	}

}
