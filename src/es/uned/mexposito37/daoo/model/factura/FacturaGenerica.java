/*
 * Clase factura genérica: modela una factura sin decorar
 */
package es.uned.mexposito37.daoo.model.factura;

import java.util.Date;

import es.uned.mexposito37.daoo.model.Cliente;

/**
 * Clase FacturaGenerica: modela una factura sin decorar.
 */
public class FacturaGenerica extends Factura {

	/**
	 * Constructor vacío por defecto.
	 */
	public FacturaGenerica() {
		
	}

	/**
	 * Constructor con parámetros: instancia una nueva factura.
	 *
	 * @param numeroFactura numero factura
	 * @param cifVendedor cif vendedor
	 * @param razonSocialVendedor razon social vendedor
	 * @param fechaEmision fecha emision
	 * @param cliente cliente
	 */
	public FacturaGenerica(String numeroFactura, String cifVendedor, String razonSocialVendedor, Date fechaEmision,
			Cliente cliente) {
		super(numeroFactura, cifVendedor, razonSocialVendedor, fechaEmision, cliente);
		
	}

}
