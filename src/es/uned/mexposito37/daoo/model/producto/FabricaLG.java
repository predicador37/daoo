/*
 * Clase FabricaLG: fabrica un mógil de marca LG. Implementa la fábrica abstracta correspondiente.
 */
package es.uned.mexposito37.daoo.model.producto;

/**
 * Clase FabricaLG: fabrica un móvil de marca LG
 */
public class FabricaLG implements FabricaAbstracta {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.uned.mexposito37.daoo.model.producto.FabricaAbstracta#crearMovil()
	 */
	public Movil crearMovil() {
		return new MovilLG();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.uned.mexposito37.daoo.model.producto.FabricaAbstracta#crearTablet()
	 */
	public Tablet crearTablet() {
		return new TabletLG();
	}

}
