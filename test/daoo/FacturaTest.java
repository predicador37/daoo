package daoo;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;

import es.uned.mexposito37.daoo.model.Cliente;
import es.uned.mexposito37.daoo.model.LineaTicket;
import es.uned.mexposito37.daoo.model.Ticket;
import es.uned.mexposito37.daoo.model.factura.Factura;
import es.uned.mexposito37.daoo.model.factura.FacturaGenerica;
import es.uned.mexposito37.daoo.model.producto.MovilLG;
import es.uned.mexposito37.daoo.model.producto.MovilSamsung;
import es.uned.mexposito37.daoo.model.producto.Producto;

public class FacturaTest {

	@Test
	public void toStingTest() {
		
		Cliente cliente = new Cliente("12345", "72056097H", "Miguel Expósito Martín", "c\\ El Campizo 10 2A", new Date("02/04/2016"));
		Ticket primerTicket = new Ticket("00001",  cliente);
		Ticket segundoTicket = new Ticket("00002",  cliente);
		Producto primerProducto = new MovilSamsung("1234567891236", "Samsung Galaxy S7", new BigDecimal("517.39"), 21, 5);
		Producto segundoProducto = new MovilLG("1234567891237", "LG G3", new BigDecimal("222.31"), 21, 10);
		Producto tercerProducto = new MovilLG("1234567891238", "LG G4", new BigDecimal("305.781"), 21, 10);
		LineaTicket primeraLineaTicket = new LineaTicket(2, primerProducto, primerTicket);
		LineaTicket segundaLineaTicket = new LineaTicket(1, segundoProducto, primerTicket);
		LineaTicket terceraLineaTicket = new LineaTicket(1, tercerProducto, segundoTicket);
		Factura factura = new FacturaGenerica("2016/1", "Q3900764F", "The Phone House", new Date("01/05/2016"), cliente);
		factura.addToTickets(primerTicket);
		factura.addToTickets(segundoTicket);
		System.out.println(factura.toString());
	}

}
