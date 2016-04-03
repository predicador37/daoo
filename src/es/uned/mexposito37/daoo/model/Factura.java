package es.uned.mexposito37.daoo.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Factura {
	
	private String numeroFactura;
	private String cifVendedor;
	private String razonSocialVendedor;
	private Date fechaEmision;
	private BigDecimal importeTotal;
	private Cliente cliente;
	private List<Ticket> tickets;

}
