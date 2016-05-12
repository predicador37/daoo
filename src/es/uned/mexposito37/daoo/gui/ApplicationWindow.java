package es.uned.mexposito37.daoo.gui;

import java.awt.EventQueue;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import es.uned.mexposito37.daoo.model.Cliente;
import es.uned.mexposito37.daoo.model.LineaTicket;
import es.uned.mexposito37.daoo.model.Ticket;
import es.uned.mexposito37.daoo.model.factura.Factura;
import es.uned.mexposito37.daoo.model.factura.FacturaGenerica;
import es.uned.mexposito37.daoo.model.producto.MovilLG;
import es.uned.mexposito37.daoo.model.producto.MovilSamsung;
import es.uned.mexposito37.daoo.model.producto.Producto;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JList;
import org.jdesktop.beansbinding.BeanProperty;
import java.util.List;
import es.uned.mexposito37.daoo.model.AbstractModelObjectInterface;
import org.jdesktop.swingbinding.JListBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.ELProperty;
import org.jdesktop.beansbinding.ObjectProperty;
import org.jdesktop.beansbinding.Property;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.swingbinding.JTableBinding;
import java.awt.FlowLayout;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class ApplicationWindow {

	private JFrame frame;
	
	List<Cliente> listaClientes = new ArrayList<Cliente>();
	List<Factura> listaFacturas = new ArrayList<Factura>();
	
	private JTable table;
	 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationWindow window = new ApplicationWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ApplicationWindow() {
		setDefaultValues();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1356, 754);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBounds(0, 0, 174, 678);
		frame.getContentPane().add(leftPanel);
		leftPanel.setLayout(null);
		
		JButton btnClientes = new JButton("Clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JTableBinding<Cliente, List<Cliente>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, listaClientes, table);
				//
				BeanProperty<Cliente, String> clienteBeanProperty = BeanProperty.create("codigo");
				jTableBinding.addColumnBinding(clienteBeanProperty).setColumnName("C\u00F3digo");
				//
				BeanProperty<Cliente, String> clienteBeanProperty_1 = BeanProperty.create("nif");
				jTableBinding.addColumnBinding(clienteBeanProperty_1).setColumnName("NIF");
				//
				BeanProperty<Cliente, String> clienteBeanProperty_2 = BeanProperty.create("razonSocial");
				jTableBinding.addColumnBinding(clienteBeanProperty_2).setColumnName("Razón social");
				BeanProperty<Cliente, String> clienteBeanProperty_3 = BeanProperty.create("domicilio");
				jTableBinding.addColumnBinding(clienteBeanProperty_3).setColumnName("Domicilio");
				BeanProperty<Cliente, String> clienteBeanProperty_4 = BeanProperty.create("fechaAlta");
				jTableBinding.addColumnBinding(clienteBeanProperty_4).setColumnName("Fecha de alta");
				jTableBinding.bind();
				
			}
		});
		btnClientes.setBounds(12, 45, 117, 25);
		leftPanel.add(btnClientes);
		
		JButton btnNewButton = new JButton("Facturas");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTableBinding<Factura, List<Factura>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, listaFacturas, table);
				//
				BeanProperty<Factura, String> facturaBeanProperty = BeanProperty.create("numeroFactura");
				jTableBinding.addColumnBinding(facturaBeanProperty).setColumnName("No. Factura");
				//
				BeanProperty<Factura, String> facturaBeanProperty_1 = BeanProperty.create("cifVendedor");
				jTableBinding.addColumnBinding(facturaBeanProperty_1).setColumnName("CIF");
				//
				BeanProperty<Factura, String> facturaBeanProperty_2 = BeanProperty.create("razonSocialVendedor");
				jTableBinding.addColumnBinding(facturaBeanProperty_2).setColumnName("Razón social");
				//
				BeanProperty<Factura, String> facturaBeanProperty_3 = BeanProperty.create("fechaEmision");
				jTableBinding.addColumnBinding(facturaBeanProperty_3).setColumnName("Fecha de emisión");
				//
				BeanProperty<Factura, String> facturaBeanProperty_4 = BeanProperty.create("importeTotal");
				jTableBinding.addColumnBinding(facturaBeanProperty_4).setColumnName("Importe total");
				//
				BeanProperty<Factura, String> facturaBeanProperty_5 = BeanProperty.create("cliente.razonSocial");
				jTableBinding.addColumnBinding(facturaBeanProperty_5).setColumnName("Cliente");
				//
				jTableBinding.bind();
			}
		});
		btnNewButton.setBounds(12, 81, 117, 25);
		leftPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Productos");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(12, 117, 117, 25);
		leftPanel.add(btnNewButton_1);
		
		JPanel rightPanel = new JPanel();
		rightPanel.setBounds(187, 0, 1155, 678);
		frame.getContentPane().add(rightPanel);
		rightPanel.setLayout(null);
		
		JPanel topPanel = new JPanel();
		topPanel.setBounds(12, 12, 1131, 196);
		rightPanel.add(topPanel);
		topPanel.setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(12, 12, 1093, 27);
		topPanel.add(toolBar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setBounds(22, 49, 1084, 135);
		topPanel.add(scrollPane);
		
		table = new JTable();
		table.setShowVerticalLines(true);
		table.setShowHorizontalLines(true);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBounds(12, 220, 1131, 446);
		rightPanel.add(bottomPanel);
		bottomPanel.setLayout(null);
		initDataBindings();
		
	}
	
	private void setDefaultValues() {
		Cliente clienteVip = new Cliente("12345", "72056097H", "Miguel Expósito Martín", "c\\ El Campizo 10 2A",
				new Date("02/04/2016"));
		Cliente clienteNoFidelizado = new Cliente("12346", "72090875J", "Pepito Pérez",
				"c\\ Las Acacias 2, esc. izq, 5ºB", new Date("15/04/2016"));
		Ticket primerTicket = new Ticket("00001", clienteVip);
		Ticket segundoTicket = new Ticket("00002", clienteVip);
		Ticket tercerTicket = new Ticket("00003", clienteNoFidelizado);
		Producto primerProducto = new MovilSamsung("1234567891236", "Samsung Galaxy S7", new BigDecimal("517.39"), 21,
				5);
		Producto segundoProducto = new MovilLG("1234567891237", "LG G3", new BigDecimal("222.31"), 21, 10);
		Producto tercerProducto = new MovilLG("1234567891238", "LG G4", new BigDecimal("305.781"), 21, 10);
		LineaTicket primeraLineaTicket = new LineaTicket(2, primerProducto, primerTicket);
		LineaTicket segundaLineaTicket = new LineaTicket(1, segundoProducto, primerTicket);
		LineaTicket terceraLineaTicket = new LineaTicket(1, tercerProducto, segundoTicket);
		LineaTicket cuartaLineaTicket = new LineaTicket(1, tercerProducto, tercerTicket);
		Factura facturaClienteVip = new FacturaGenerica("2016/1", "Q3900764F", "The Phone House",
				new Date("01/05/2016"), clienteVip);
		facturaClienteVip.addToTickets(primerTicket);
		facturaClienteVip.addToTickets(segundoTicket);
		Factura facturaClienteNoFidelizado = new FacturaGenerica("2016/2", "Q3900764F", "The Phone House",
				new Date("03/05/2016"), clienteNoFidelizado);
		facturaClienteNoFidelizado.addToTickets(tercerTicket);
		
		
		listaClientes.add(clienteVip);
		listaClientes.add(clienteNoFidelizado);
		listaFacturas.add(facturaClienteVip);
		listaFacturas.add(facturaClienteNoFidelizado);
		
	
	}
	protected void initDataBindings() {
		
	}
}
