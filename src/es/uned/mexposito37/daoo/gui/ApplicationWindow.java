package es.uned.mexposito37.daoo.gui;

import java.awt.EventQueue;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JToolBar;

import es.uned.mexposito37.daoo.controller.ProductoController;
import es.uned.mexposito37.daoo.model.producto.Movil;
import es.uned.mexposito37.daoo.model.producto.MovilSamsung;
import es.uned.mexposito37.daoo.model.producto.Producto;

import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import java.math.BigDecimal;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import org.jdesktop.beansbinding.ObjectProperty;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.Converter;

import javax.swing.JSpinner;

public class ApplicationWindow {

	private JFrame frame;
	private JScrollPane scrollPane;
	private JTable table;
	private List<Producto> productos;
	private Producto producto;
	private JTextField txtCdigo;
	private JTextField txtDescripcin;
	private JSpinner spinner;

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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		ProductoController productoController = new ProductoController();
		producto = new MovilSamsung("123456", "Prueba", new BigDecimal(550.0), 21, 3);
		try {
			productos = productoController.importar(Movil.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame = new JFrame();
		
		frame.setBounds(100, 100, 1240, 588);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 1238, 19);
		frame.getContentPane().add(toolBar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 31, 1181, 186);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setShowVerticalLines(true);
		table.setShowHorizontalLines(true);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Añadir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//initDataBindings();
				Producto nuevoProducto = new MovilSamsung();
				nuevoProducto.setCodigo(txtCdigo.getText());
				nuevoProducto.setDescripcion(txtDescripcin.getText());
				nuevoProducto.setIva((Integer) spinner.getValue());
				System.out.println(nuevoProducto.getDescripcion());
				ProductoController productoController = new ProductoController();
				//Producto nuevoProducto = new Producto("1234567891236", "Vernee Thor", new BigDecimal("85.48"), 21, new BigDecimal("103.43"), 5);
				
				productoController.add(nuevoProducto, productos);
				//table.revalidate();
				//table.repaint();
				initDataBindings();
			}
		});
		btnNewButton.setBounds(35, 229, 117, 25);
		frame.getContentPane().add(btnNewButton);
		
		txtCdigo = new JTextField();
		txtCdigo.setText("Código");
		txtCdigo.setBounds(38, 280, 114, 19);
		frame.getContentPane().add(txtCdigo);
		txtCdigo.setColumns(10);
		
		txtDescripcin = new JTextField();
		txtDescripcin.setText("Descripción");
		txtDescripcin.setBounds(38, 311, 114, 19);
		frame.getContentPane().add(txtDescripcin);
		txtDescripcin.setColumns(10);
		
		spinner = new JSpinner();
		spinner.setBounds(35, 342, 104, 19);
		frame.getContentPane().add(spinner);
		initDataBindings();
	}
	protected void initDataBindings() {
		JTableBinding<Producto, List<Producto>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, productos, table);
		//
		BeanProperty<Producto, String> productoBeanProperty = BeanProperty.create("codigo");
		jTableBinding.addColumnBinding(productoBeanProperty).setColumnName("C\u00F3digo");
		//
		BeanProperty<Producto, String> productoBeanProperty_1 = BeanProperty.create("descripcion");
		jTableBinding.addColumnBinding(productoBeanProperty_1).setColumnName("Descripci\u00F3n");
		//
		BeanProperty<Producto, Integer> productoBeanProperty_2 = BeanProperty.create("iva");
		jTableBinding.addColumnBinding(productoBeanProperty_2).setColumnName("IVA");
		//
		BeanProperty<Producto, BigDecimal> productoBeanProperty_3 = BeanProperty.create("precio");
		jTableBinding.addColumnBinding(productoBeanProperty_3).setColumnName("Precio");
		//
		BeanProperty<Producto, BigDecimal> productoBeanProperty_4 = BeanProperty.create("pvp");
		jTableBinding.addColumnBinding(productoBeanProperty_4).setColumnName("PVP");
		//
		BeanProperty<Producto, Integer> productoBeanProperty_5 = BeanProperty.create("stock");
		jTableBinding.addColumnBinding(productoBeanProperty_5).setColumnName("Stock");
		//
		jTableBinding.bind();
		//
		BeanProperty<Producto, String> productoBeanProperty_6 = BeanProperty.create("codigo");
		BeanProperty<JTextField, String> jTextFieldBeanProperty = BeanProperty.create("text");
		AutoBinding<Producto, String, JTextField, String> autoBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, producto, productoBeanProperty_6, txtCdigo, jTextFieldBeanProperty);
		autoBinding.bind();
		//
		BeanProperty<Producto, String> productoBeanProperty_7 = BeanProperty.create("descripcion");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_1 = BeanProperty.create("text");
		AutoBinding<Producto, String, JTextField, String> autoBinding_1 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, producto, productoBeanProperty_7, txtDescripcin, jTextFieldBeanProperty_1, "descripcion");
		autoBinding_1.bind();
		//
		BeanProperty<Producto, Integer> productoBeanProperty_8 = BeanProperty.create("iva");
		BeanProperty<JSpinner, Object> jSpinnerBeanProperty = BeanProperty.create("value");
		AutoBinding<Producto, Integer, JSpinner, Object> autoBinding_2 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, producto, productoBeanProperty_8, spinner, jSpinnerBeanProperty);
		autoBinding_2.bind();
	}
}
