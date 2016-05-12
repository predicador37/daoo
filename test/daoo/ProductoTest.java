package daoo;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.After;
import org.junit.Test;

import es.uned.mexposito37.daoo.model.producto.Movil;
import es.uned.mexposito37.daoo.model.producto.MovilSamsung;
import es.uned.mexposito37.daoo.model.producto.Producto;

public class ProductoTest {

	@Test
	public void testProductCSVImport() {
		//fail("Not yet implemented");
		try {
			List<Producto> productos = Movil.importar(MovilSamsung.class);
			System.out.println(productos.get(0).getDescripcion());
			assertTrue("El pvp del primer producto debe ser 200", productos.get(0).getPvp().compareTo(new BigDecimal("200"))==0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testProductCSVExport() {
		List<Producto> productos = null;
		
		try {
			productos = Producto.importar(MovilSamsung.class);
			Producto nuevoProducto = new MovilSamsung("1234567891236", "Vernee Thor", new BigDecimal("85.48"), 21, 5);
			productos.add(nuevoProducto);
			Movil.exportar(productos);
			List<Producto> nuevosProductos = Producto.importar(MovilSamsung.class);
			assertEquals("El número de productos debe ser 3",3,nuevosProductos.size());
			assertTrue("La descripción del último producto es Vernee Thor", nuevosProductos.get(nuevosProductos.size()-1).getDescripcion().equals("Vernee Thor"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			productos.remove(productos.size()-1);
			try {
				Movil.exportar(productos);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void testProductAdd() {
		Producto producto = new MovilSamsung("1234567891236", "Vernee Thor", new BigDecimal("85.48"), 21, 5);
		List<Producto>  productos = null;
		try {
			producto.append();
			productos = Producto.importar(MovilSamsung.class);
			assertEquals("El número de productos debe ser 3",3,productos.size());
			assertTrue("La descripción del último producto es Vernee Thor", productos.get(productos.size()-1).getDescripcion().equals("Vernee Thor"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			productos.remove(productos.size()-1);
			try {
				Movil.exportar(productos);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	

}
