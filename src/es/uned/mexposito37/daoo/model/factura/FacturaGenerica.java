package es.uned.mexposito37.daoo.model.factura;

import java.math.BigDecimal;
import java.util.Date;

import es.uned.mexposito37.daoo.model.Cliente;

public class FacturaGenerica extends Factura {

	public FacturaGenerica() {
		// TODO Auto-generated constructor stub
	}

	public FacturaGenerica(String numeroFactura, String cifVendedor, String razonSocialVendedor, Date fechaEmision,
			Cliente cliente) {
		super(numeroFactura, cifVendedor, razonSocialVendedor, fechaEmision, cliente);
		// TODO Auto-generated constructor stub
	}

}
