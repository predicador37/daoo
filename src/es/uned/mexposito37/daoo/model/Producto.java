package es.uned.mexposito37.daoo.model;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.supercsv.cellprocessor.ParseBigDecimal;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.constraint.StrRegEx;
import org.supercsv.cellprocessor.constraint.UniqueHashCode;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

public class Producto {
	
	final static String CSV_FILENAME="./data/productos.csv";

	private String codigo;
    private String descripcion;
    private BigDecimal precio;
    private Integer iva;
    private BigDecimal pvp;
    private Integer stock;
    
    public Producto(){
    	
    }

    public Producto(String codigo, String descripcion, BigDecimal precio, Integer iva, BigDecimal pvp, Integer stock) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.iva = iva;
        this.pvp = pvp;
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

    public void setPvp(BigDecimal pvp) {
        this.pvp = pvp;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
    
    /**
     * Sets up the processors used for the examples. There are 10 CSV columns, so 10 processors are defined. Empty
     * columns are read as null (hence the NotNull() for mandatory columns).
     * 
     * @return the cell processors
     */
    private static CellProcessor[] getProcessors() {
            
            final CellProcessor[] processors = new CellProcessor[] { 
                    new UniqueHashCode(), // código de producto
                    new NotNull(), // descripción
                    new ParseBigDecimal(), // precio sin iva
                    new ParseInt(), // iva
                    new ParseBigDecimal(), // pvp
                    new ParseInt() // stock
            };
            
            return processors;
    }
    
    public static List<Producto> importar() throws Exception {
    	ICsvBeanReader beanReader = null;
    	List<Producto> productos = new ArrayList();
    	try {
    		beanReader = new CsvBeanReader(new FileReader(CSV_FILENAME), CsvPreference.STANDARD_PREFERENCE);
    		final String[] header = beanReader.getHeader(true);
            final CellProcessor[] processors = getProcessors();
            Producto producto;
            while( (producto = beanReader.read(Producto.class, header, processors)) != null ) {
                productos.add(producto);
            	
        }
        
}
finally {
        if( beanReader != null ) {
                beanReader.close();
                
        }
        
}
    	return productos;
    }
}
