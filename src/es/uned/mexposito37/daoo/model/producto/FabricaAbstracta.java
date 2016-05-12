/*
 * Interfaz FabricaAbstracta, que deben implementar las fábricas de los distintos productos.
 */
package es.uned.mexposito37.daoo.model.producto;

/**
 * Interfaz FabricaAbstracta que deben implementar las fábricas de los distintos
 * productos.
 */
public interface FabricaAbstracta {

	/**
	 * Crear movil: crea un producto de tipo teléfono móvil.
	 *
	 * @return movil
	 */
	public Movil crearMovil();

	/**
	 * Crear tablet: crea un producto de tipo tableta.
	 *
	 * @return tablet
	 */
	public Tablet crearTablet();

}
