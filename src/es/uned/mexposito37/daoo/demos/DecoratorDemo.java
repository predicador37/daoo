/*
 * Clase demostración del patrón decorator.
 */
package es.uned.mexposito37.daoo.demos;

import java.math.BigDecimal;
import java.util.Date;

import es.uned.mexposito37.daoo.model.Cliente;
import es.uned.mexposito37.daoo.model.LineaTicket;
import es.uned.mexposito37.daoo.model.Ticket;
import es.uned.mexposito37.daoo.model.factura.DecoradorFacturaClienteNoFidelizado;
import es.uned.mexposito37.daoo.model.factura.DecoradorFacturaClienteVip;
import es.uned.mexposito37.daoo.model.factura.Factura;
import es.uned.mexposito37.daoo.model.factura.FacturaGenerica;
import es.uned.mexposito37.daoo.model.producto.MovilLG;
import es.uned.mexposito37.daoo.model.producto.MovilSamsung;
import es.uned.mexposito37.daoo.model.producto.Producto;

/**
 * Clase demostración del patrón decorator.
 */
public class DecoratorDemo {

	/**
	 * Método principal: ejecutar con Eclipse para ver la demostración.
	 * Instancia los clientes, tickets, productos y líneas de tickets necesarios
	 * para generar dos facturas que se decorarán convenientemente. Se muestra
	 * por pantalla el resultado para ambas.
	 *
	 * @param args
	 *            argumentos
	 */
	public static void main(String[] args) {

		Cliente clienteVip = new Cliente("12345", "72056097H", "Miguel Expósito Martín", "c\\ El Campizo 10 2A",
				new Date("02/04/2016"));
		Cliente clienteNoFidelizado = new Cliente("12346", "72090875J", "Pepito Pérez",
				"c\\ Las Acacias 2, esc. izq, 5ºB", new Date("15/04/2016"));
		Ticket primerTicket = new Ticket("00001", clienteVip);
		Ticket segundoTicket = new Ticket("00002", clienteVip);
		Ticket tercerTicket = new Ticket("00003", clienteNoFidelizado);
		Producto primerProducto = new MovilSamsung("1234567891236", "Samsung Galaxy S7", new BigDecimal("517.39"), 21,
				5);
		Producto segundoProducto = new MovilLG("1234567891237", "LG G3", new BigDecimal("222.31"), 21, 10);
		Producto tercerProducto = new MovilLG("1234567891238", "LG G4", new BigDecimal("305.781"), 21, 10);
		LineaTicket primeraLineaTicket = new LineaTicket(2, primerProducto, primerTicket);
		LineaTicket segundaLineaTicket = new LineaTicket(1, segundoProducto, primerTicket);
		LineaTicket terceraLineaTicket = new LineaTicket(1, tercerProducto, segundoTicket);
		LineaTicket cuartaLineaTicket = new LineaTicket(1, tercerProducto, tercerTicket);
		Factura facturaClienteVip = new FacturaGenerica("2016/1", "Q3900764F", "The Phone House",
				new Date("01/05/2016"), clienteVip);
		facturaClienteVip.addToTickets(primerTicket);
		facturaClienteVip.addToTickets(segundoTicket);
		Factura facturaClienteNoFidelizado = new FacturaGenerica("2016/2", "Q3900764F", "The Phone House",
				new Date("03/05/2016"), clienteNoFidelizado);
		facturaClienteNoFidelizado.addToTickets(tercerTicket);
		DecoradorFacturaClienteVip decoradorFacturaClienteVip = new DecoradorFacturaClienteVip(facturaClienteVip);
		DecoradorFacturaClienteNoFidelizado decoradorFacturaClienteNoFidelizado = new DecoradorFacturaClienteNoFidelizado(
				facturaClienteNoFidelizado);
		System.out.println(decoradorFacturaClienteVip.toString());
		System.out.println(decoradorFacturaClienteNoFidelizado.toString());
	}

}
