
package es.uned.mexposito37.daoo.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Ticket {

private String codigo; //no procede que haya dos ventas simultáneas; por sencillez, se desnormaliza la lista
    //cada registro con el mismo código pertenece al mismo ticket
    //un registro por cada producto vendido
private List<LineaTicket> lineasTicket;
private Cliente cliente;


//TODO: implementar métodos para añadir y quitar líneas de ticket


public Ticket() {
	
}

public Ticket(String codigo, Cliente cliente) {
	super();
	this.codigo = codigo;
	this.cliente = cliente;
	this.lineasTicket = new ArrayList();
}

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
public void addToLineasTicket(LineaTicket lineaTicket) {
	this.lineasTicket.add(lineaTicket);
}

}
