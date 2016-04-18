package es.uned.mexposito37.daoo.model.producto;

public class FabricaLG implements FabricaAbstracta {
	
	public Movil crearMovil() {
		return new MovilLG();
	}
	public Tablet crearTablet() {
		return new TabletLG();
	}

}
