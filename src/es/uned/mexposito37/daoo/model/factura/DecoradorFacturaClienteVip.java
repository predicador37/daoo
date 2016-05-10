package es.uned.mexposito37.daoo.model.factura;

import java.util.Date;

import es.uned.mexposito37.daoo.model.Cliente;

public class DecoradorFacturaClienteVip extends DecoradorFactura {

	public DecoradorFacturaClienteVip() {
		// TODO Auto-generated constructor stub
	}

	public DecoradorFacturaClienteVip(Factura facturaSamsung) {
		factura = facturaSamsung;
	}
	
	private String customization = "\nPor ser cliente especial, disfrute de nuestras mejores ofertas y descuentos de hasta el 20% en nuestros artículos.";
	
	private String addCustomization(String description) {
		return description + customization;
	}
	 
	 @Override
	 public String toString()   {            
	  
		 return addCustomization(factura.toString());	 
	 }       
	
	

}
