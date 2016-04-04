package daoo;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import es.uned.mexposito37.daoo.model.Producto;

public class ProductoTest {

	@Test
	public void testProductCSVImport() {
		//fail("Not yet implemented");
		try {
			List<Producto> productos = Producto.importar();
			assertTrue("El pvp del primer producto debe ser 200", productos.get(0).getPvp().compareTo(new BigDecimal("200"))==0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
