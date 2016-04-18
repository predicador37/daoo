package es.uned.mexposito37.daoo.controller;

import java.util.List;

import es.uned.mexposito37.daoo.model.Producto;

public class ProductoController {
	
	public void ProductoController(){
		
	}

	public void crear(Producto producto) {
		try {
			producto.append();
			System.out.println("nuevo producto appended");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public List<Producto> add(Producto producto, List<Producto> productos){
		for(Producto p : productos){
			if(p.getCodigo() !=null && p.getCodigo().contains(producto.getCodigo())){
				System.out.println("[error] El producto ya existe en la lista.");
				return productos;
			}
			
			}
		productos.add(producto);
		return productos;
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
