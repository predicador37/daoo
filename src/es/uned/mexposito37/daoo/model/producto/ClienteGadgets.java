/*
 * Clase ClienteGadgets: fabrica productos en función de la fábrica que reciba como parámetro.
 */
package es.uned.mexposito37.daoo.model.producto;

/**
 * Clase ClienteGadgets: fabrica productos en función de la fábrica que reciba
 * como parámetro.
 */
public class ClienteGadgets {

	/**
	 * Constructor vacío por defecto para instanciar un cliente.
	 */
	public ClienteGadgets() {

	}

	/**
	 * Fabricar gadget: fabrica un gadget según la fábrica recibida como
	 * parámetro.
	 *
	 * @param fabrica
	 *            the fabrica
	 */
	public void fabricarGadget(FabricaAbstracta fabrica) {
		Movil movil = fabrica.crearMovil();
		movil.setCodigo("9876543219876");
		movil.setDescripcion("Smartphone de 5'");
		Tablet tablet = fabrica.crearTablet();
		tablet.setCodigo("9876543219878");
		tablet.setDescripcion("Tableta de 7'");

		System.out.println(movil.toString());
		System.out.println(tablet.toString());

	}
}
