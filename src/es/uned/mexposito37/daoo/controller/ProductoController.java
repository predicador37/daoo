/*
 * Clase ProductoController: controlador con acciones a ejecutar sobre productos. 
 */
package es.uned.mexposito37.daoo.controller;

import java.util.List;

import es.uned.mexposito37.daoo.model.producto.Producto;

/**
 * Clase ProductoController: controlador con acciones a ejecutar sobre
 * productos.
 */
public class ProductoController {

	/**
	 * Constgructor vacío por defecto.
	 */
	public ProductoController() {

	}

	/**
	 * Crear: crea un producto.
	 *
	 * @param producto
	 *            el producto a crear.
	 */
	public void crear(Producto producto) {
		try {
			producto.append();
			System.out.println("nuevo producto añadido");
		} catch (Exception e1) {

			e1.printStackTrace();
		}
	}

	/**
	 * Añade: añade un producto a la lista.
	 *
	 * @param producto
	 *            el producto a añadir
	 * @param productos
	 *            la lista de productos a la que añadir el producto
	 * @return the list
	 */
	public List<Producto> add(Producto producto, List<Producto> productos) {
		for (Producto p : productos) {
			if (p.getCodigo() != null && p.getCodigo().contains(producto.getCodigo())) {
				System.out.println("[error] El producto ya existe en la lista.");
				return productos;
			}

		}
		productos.add(producto);
		return productos;
	}

	/**
	 * Importar: importa un producto desde fichero.
	 *
	 * @param clase
	 *            la clase del producto a importar.
	 * @return lista de productos importados.
	 */
	public List<Producto> importar(Class clase) {
		List<Producto> productos = null;
		try {
			productos = Producto.importar(clase);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return productos;
	}
}
