package es.uned.mexposito37.daoo.model.producto;

public class FabricaSamsung implements FabricaAbstracta {
	
	public Movil crearMovil() {
		return new MovilSamsung();
	}
	public Tablet crearTablet() {
		return new TabletSamsung();
	}

}
