package es.uned.mexposito37.daoo.controller;

import java.util.List;

import es.uned.mexposito37.daoo.model.Producto;

public class ProductoController {
	
	public void ProductoController(){
		
	}

	public void crear(Producto producto) {
		
	}
	
	public List<Producto>importar(){
		List<Producto> productos = null;
		try {
			productos=Producto.importar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productos;
	}
}
