package es.uned.mexposito37.daoo.demos;

import es.uned.mexposito37.daoo.model.producto.FabricaAbstracta;
import es.uned.mexposito37.daoo.model.producto.FabricaLG;
import es.uned.mexposito37.daoo.model.producto.FabricaSamsung;

public class AbstractFactoryDemo {
	
	
	

	public static void main(String[] args) {
		
		ClienteGadgets cliente = new ClienteGadgets();
		String marca = "Samsung";
		FabricaAbstracta fabricaProducto = null;
		
		if (marca.equals("Samsung")){
			fabricaProducto = new FabricaSamsung();
		}
		else {
			fabricaProducto = new FabricaLG();
		}
		cliente.fabricarGadget(fabricaProducto);
	}

}
