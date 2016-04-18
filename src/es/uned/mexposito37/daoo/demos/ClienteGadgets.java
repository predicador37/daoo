package es.uned.mexposito37.daoo.demos;

import es.uned.mexposito37.daoo.model.producto.FabricaAbstracta;
import es.uned.mexposito37.daoo.model.producto.Movil;
import es.uned.mexposito37.daoo.model.producto.Tablet;

public class ClienteGadgets {
	
	ClienteGadgets() {
		
	}

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
