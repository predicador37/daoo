
package es.uned.mexposito37.daoo.model;

import java.math.BigDecimal;
import java.util.List;

public class Ticket {

	private String codigo; //no procede que haya dos ventas simultáneas; por sencillez, se desnormaliza la lista
    //cada registro con el mismo código pertenece al mismo ticket
    //un registro por cada producto vendido
private List<LineaTicket> lineasTicket;
private Integer cantidad;
private BigDecimal importeTotal;
private Cliente cliente;


//TODO: implementar métodos para añadir y quitar líneas de ticket


public Cliente getCliente() {
	return cliente;
}

public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}


public String getCodigo() {
	return codigo;
}

public void setCodigo(String codigo) {
	this.codigo = codigo;
}
public List<LineaTicket> getLineasTicket() {
	return lineasTicket;
}
public void setLineasTicket(List<LineaTicket> lineasTicket) {
	this.lineasTicket = lineasTicket;
}
public Integer getCantidad() {
	return cantidad;
}
public void setCantidad(Integer cantidad) {
	this.cantidad = cantidad;
}
public BigDecimal getImporteTotal() {
	return importeTotal;
}
public void setImporteTotal(BigDecimal importeTotal) {
	this.importeTotal = importeTotal;
}


}
