/*
 * Clase abstracta producto: modela un producto genérico y sus operaciones comunes.
 */
package es.uned.mexposito37.daoo.model.producto;

import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.supercsv.cellprocessor.ParseBigDecimal;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.constraint.UniqueHashCode;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import es.uned.mexposito37.daoo.model.AbstractModelObject;

/**
 * Clase abstracta producto: modela un producto genérico y sus operaciones
 * comunes.
 */
public abstract class Producto extends AbstractModelObject {

	final static String CSV_FILENAME = "./data/productos.csv";

	private String codigo;
	private String descripcion;
	private BigDecimal precio;
	private Integer iva;
	private BigDecimal pvp;
	private Integer stock;

	/**
	 * Constructor vacío por defecto.
	 */
	public Producto() {

	}

	/**
	 * Constructor con parámetros: instancia un nuevo producto.
	 *
	 * @param codigo
	 *            codigo
	 * @param descripcion
	 *            descripcion
	 * @param precio
	 *            precio
	 * @param iva
	 *            iva
	 * @param stock
	 *            stock
	 */
	public Producto(String codigo, String descripcion, BigDecimal precio, Integer iva, Integer stock) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precio = precio;
		this.iva = iva;
		this.pvp = precio.multiply(new BigDecimal((1 + (double) iva / (double) 100)));
		this.stock = stock;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Integer getIva() {
		return iva;
	}

	public void setIva(Integer iva) {
		this.iva = iva;
	}

	public BigDecimal getPvp() {
		return pvp;
	}

	public void setPvp() {
		this.pvp = this.precio.multiply(new BigDecimal((1 + (double) this.iva / (double) 100)));
	}
	
	public void setPvp(BigDecimal pvp) {
		this.pvp = pvp;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {

		return this.getCodigo() + " - " + this.getDescripcion();
	}

	/**
	 * Inicializa el procesador de lectura de campos, uno por cada columna. Las
	 * columnas vacías se leen como null.
	 * 
	 * 
	 * @return procesador de celdas
	 */
	public static CellProcessor[] getReadProcessors() {

		final CellProcessor[] processors = new CellProcessor[] { new UniqueHashCode(), // código
																						// de
																						// producto
				new NotNull(), // descripción
				new ParseBigDecimal(), // precio sin iva
				new ParseInt(), // iva
				new ParseBigDecimal(), // pvp
				new ParseInt() // stock
		};

		return processors;
	}

	/**
	 * Inicializa el procesador de escritura de campos, uno por cada columna.
	 * 
	 * 
	 * @return procesador de celdas
	 */
	public static CellProcessor[] getWriteProcessors() {

		final CellProcessor[] processors = new CellProcessor[] { new UniqueHashCode(), // código
																						// de
																						// producto
				new NotNull(), // descripción
				new NotNull(), // precio sin iva
				new NotNull(), // iva
				new NotNull(), // pvp
				new NotNull() // stock

		};

		return processors;
	}

	/**
	 * Importar: importa productos desde archivo.
	 *
	 * @param clase
	 *            clase
	 * @return lista de productos
	 * @throws Exception
	 *             exception genérica
	 */
	public static List<Producto> importar(Class clase) throws Exception {

		ICsvBeanReader beanReader = null;
		List<Producto> productos = new ArrayList<Producto>();
		try {
			beanReader = new CsvBeanReader(new FileReader(CSV_FILENAME), CsvPreference.STANDARD_PREFERENCE);
			final String[] header = beanReader.getHeader(true);
			final CellProcessor[] processors = getReadProcessors();
			Producto producto;
			while ((producto = beanReader.read(clase, header, processors)) != null) {
				productos.add(producto);

			}

		} finally {
			if (beanReader != null) {
				beanReader.close();

			}

		}
		return productos;
	}

	/**
	 * Exportar: exporta productos a archivo.
	 *
	 * @param productos
	 *            los productos
	 * @throws Exception
	 *             exception genérica
	 */
	public static void exportar(List<Producto> productos) throws Exception {

		ICsvBeanWriter beanWriter = null;
		try {
			beanWriter = new CsvBeanWriter(new FileWriter(CSV_FILENAME), CsvPreference.STANDARD_PREFERENCE);

			// the header elements are used to map the bean values to each
			// column (names must match)
			final String[] header = new String[] { "codigo", "descripcion", "precio", "iva", "pvp", "stock" };
			final CellProcessor[] processors = getWriteProcessors();

			// write the header
			beanWriter.writeHeader(header);

			// write the beans
			for (final Producto producto : productos) {

				beanWriter.write(producto, header, processors);
			}

		} finally {
			if (beanWriter != null) {
				beanWriter.close();
			}
		}
	}

	/**
	 * Append: añade un producto a un fichero con productos ya existente.
	 *
	 * @throws Exception
	 *             exception genérica
	 */
	public void append() throws Exception {
		ICsvBeanWriter beanWriter = null;
		try {
			beanWriter = new CsvBeanWriter(new FileWriter(CSV_FILENAME, true), CsvPreference.STANDARD_PREFERENCE);

			// the header elements are used to map the bean values to each
			// column (names must match)
			final String[] header = new String[] { "codigo", "descripcion", "precio", "iva", "pvp", "stock" };
			final CellProcessor[] processors = getWriteProcessors();

			beanWriter.write(this, header, processors);

		} finally {
			if (beanWriter != null) {
				beanWriter.close();
			}
		}
	}
}
