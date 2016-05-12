/*
 * Clase DecoradorFacturaClienteNoFidelizado: decorador concreto para facturas de clientes vip.
 */
package es.uned.mexposito37.daoo.model.factura;

/**
 * Clase DecoradorFacturaClienteNoFidelizado: decorador concreto para facturas
 * de clientes vip.
 */
public class DecoradorFacturaClienteVip extends DecoradorFactura {

	/**
	 * Constructor vacío por defecto: instancia un nuevo decorador de facturas
	 * de cliente vip.
	 */
	public DecoradorFacturaClienteVip() {

	}

	/**
	 * Constructor con parámetros: Instancia un nuevo decorador de facturas de
	 * cliente vip.
	 *
	 * @param facturaCliente
	 *            la factura de cliente.
	 */
	public DecoradorFacturaClienteVip(Factura facturaCliente) {
		factura = facturaCliente;
	}

	private String customization = "\nPor ser cliente especial, disfrute de nuestras mejores ofertas y descuentos de hasta el 20% en nuestros artículos.";

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
