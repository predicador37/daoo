package es.uned.mexposito37.daoo.model;
import java.math.BigDecimal;

public class Producto {

	private Integer codigo;
    private String descripcion;
    private BigDecimal precio;
    private BigDecimal iva;
    private BigDecimal pvp;
    private Integer stock;

    public Producto(int codigo, String descripcion, BigDecimal precio, BigDecimal iva, BigDecimal pvp, Integer stock) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.iva = iva;
        this.pvp = pvp;
        this.stock = stock;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
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

    public BigDecimal getIva() {
        return iva;
    }

    public void setIva(BigDecimal iva) {
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
}
