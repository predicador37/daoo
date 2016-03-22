
package es.uned.mexposito37.daoo.model;

import java.math.BigDecimal;

public class Ticket {

	private String codigo; //no procede que haya dos ventas simultáneas; por sencillez, se desnormaliza la lista
    //cada registro con el mismo código pertenece al mismo ticket
    //un registro por cada producto vendido
private Producto producto;
private Integer cantidad;
private BigDecimal importeTotal;
}
