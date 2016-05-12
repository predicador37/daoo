/*
 * Clase DecoradorFacturaClienteNoFidelizado: decorador concreto para facturas de clientes no fidelizados.
 */
package es.uned.mexposito37.daoo.model.factura;

/**
 * Clase DecoradorFacturaClienteNoFidelizado: decorador concreto para facturas
 * de clientes no fidelizados.
 */
public class DecoradorFacturaClienteNoFidelizado extends DecoradorFactura {

	/**
	 * Constructor vacío por defecto: instancia un nuevo decorador de facturas
	 * de cliente no fidelizado.
	 */
	public DecoradorFacturaClienteNoFidelizado() {

	}

	/**
	 * Constructor con parámetros: Instancia un nuevo decorador de facturas de
	 * cliente no fidelizado.
	 *
	 * @param facturaCliente
	 *            la factura de cliente.
	 */
	public DecoradorFacturaClienteNoFidelizado(Factura facturaCliente) {
		factura = facturaCliente;
	}

	private String customization = "\nDisfrute de increíbles descuentos haciéndose cliente VIP en thephonehouse.com o llamando al 1145.";

	/**
	 * Añade texto personalizado a la descripción de la factura.
	 *
	 * @param description
	 *            descripción de la factura
	 * @return string
	 */
	private String addCustomization(String description) {
		return description + customization;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.uned.mexposito37.daoo.model.factura.DecoradorFactura#toString()
	 */
	@Override
	public String toString() {

		return addCustomization(factura.toString());
	}

}
