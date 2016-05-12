/*
 * Clase abstracta DecoradorFactura de la que heredarán los decoradores concretos.
 */
package es.uned.mexposito37.daoo.model.factura;

import java.util.Date;
import es.uned.mexposito37.daoo.model.Cliente;


/**
 * Class DecoradorFactura.
 */
public abstract class DecoradorFactura extends Factura {

	/**
	 * Constructor vacío por defecto, aunque la clase no será instanciable.
	 */
	public DecoradorFactura() {
		
	}

	/**
	 * Constructor con parámetros a heredar por decoradores concretos.
	 *
	 * @param numeroFactura el numero factura
	 * @param cifVendedor el cif vendedor
	 * @param razonSocialVendedor el razon social vendedor
	 * @param fechaEmision el fecha emision
	 * @param cliente el cliente
	 */
	public DecoradorFactura(String numeroFactura, String cifVendedor, String razonSocialVendedor, Date fechaEmision,
			 Cliente cliente) {
		super(numeroFactura, cifVendedor, razonSocialVendedor, fechaEmision, cliente);
		
	}
	
	Factura factura;
	
	/* (non-Javadoc)
	 * @see es.uned.mexposito37.daoo.model.factura.Factura#toString()
	 */
	public String toString() {
		return "";
	}

}
