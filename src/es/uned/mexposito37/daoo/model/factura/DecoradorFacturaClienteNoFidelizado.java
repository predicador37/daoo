package es.uned.mexposito37.daoo.model.factura;

import java.util.Date;

import es.uned.mexposito37.daoo.model.Cliente;

public class DecoradorFacturaClienteNoFidelizado extends DecoradorFactura {

	public DecoradorFacturaClienteNoFidelizado() {
		// TODO Auto-generated constructor stub
	}

	public DecoradorFacturaClienteNoFidelizado(Factura facturaSamsung) {
		factura = facturaSamsung;
	}
	
	private String customization = "\nDisfrute de increíbles descuentos haciéndose cliente VIP en thephonehouse.com o llamando al 1145.";
	
	private String addCustomization(String description) {
		return description + customization ;
	}
	
	 private String content;       
	 
	 @Override
	 public String toString()   {            
	  
		 return addCustomization(factura.toString());	 
	 }       
	
	

}
