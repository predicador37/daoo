/*
 * Clase FabricaLG: fabrica un mógil de marca LG. Implementa la fábrica abstracta correspondiente.
 */
package es.uned.mexposito37.daoo.model.producto;

/**
 * Clase FabricaSamsung: fabrica un móvil de marca Samsung.
 */
public class FabricaSamsung implements FabricaAbstracta {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.uned.mexposito37.daoo.model.producto.FabricaAbstracta#crearMovil()
	 */
	public Movil crearMovil() {
		return new MovilSamsung();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.uned.mexposito37.daoo.model.producto.FabricaAbstracta#crearTablet()
	 */
	public Tablet crearTablet() {
		return new TabletSamsung();
	}

}
