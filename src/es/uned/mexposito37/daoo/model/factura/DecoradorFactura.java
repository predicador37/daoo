package es.uned.mexposito37.daoo.model.factura;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import es.uned.mexposito37.daoo.model.Cliente;
import es.uned.mexposito37.daoo.model.Ticket;

public abstract class DecoradorFactura extends Factura {

	public DecoradorFactura() {
		// TODO Auto-generated constructor stub
	}

	public DecoradorFactura(String numeroFactura, String cifVendedor, String razonSocialVendedor, Date fechaEmision,
			 Cliente cliente) {
		super(numeroFactura, cifVendedor, razonSocialVendedor, fechaEmision, cliente);
		// TODO Auto-generated constructor stub
	}
	
	Factura factura;
	
	public String toString() {
		return "";
	}

}
