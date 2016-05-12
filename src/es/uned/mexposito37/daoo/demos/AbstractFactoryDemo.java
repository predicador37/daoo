/*
 * Clase demostración del patrón abstract factory.
 */
package es.uned.mexposito37.daoo.demos;

import es.uned.mexposito37.daoo.model.producto.ClienteGadgets;
import es.uned.mexposito37.daoo.model.producto.FabricaAbstracta;
import es.uned.mexposito37.daoo.model.producto.FabricaLG;
import es.uned.mexposito37.daoo.model.producto.FabricaSamsung;

/**
 * Clase demostración del patrón abstract factory.
 */
public class AbstractFactoryDemo {

	/**
	 * Método main: ejecutar con Eclipse para ver la demostración. En base a la
	 * marca Samsung invoca a un cliente pasándole la fábrica correspondiente
	 * como argumento. El cliente genera dos productos distintos de esta marca.
	 *
	 * @param args
	 *            argumentos
	 */
	public static void main(String[] args) {

		ClienteGadgets cliente = new ClienteGadgets();
		String marca = "Samsung"; // o LG
		FabricaAbstracta fabricaProducto = null;

		if (marca.equals("Samsung")) {
			fabricaProducto = new FabricaSamsung();
		} else {
			fabricaProducto = new FabricaLG();
		}
		cliente.fabricarGadget(fabricaProducto);
	}

}
