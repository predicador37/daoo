package es.uned.mexposito37.daoo.gui;

import java.awt.EventQueue;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JToolBar;

import es.uned.mexposito37.daoo.controller.ProductoController;
import es.uned.mexposito37.daoo.model.Producto;

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

public class ApplicationWindow implements Observer{

	private JFrame frame;
	private JScrollPane scrollPane;
	private JTable table;
	private List<Producto> productos;

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
	
	@Override // Observer interface's implemented method
    public void update(Observable o, Object data) {
		System.out.println("Observado cambio");
		ProductoController productoController = new ProductoController();
	
		try {
			productos = productoController.importar();
			initDataBindings();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		try {
			productos = productoController.importar();
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
				ProductoController productoController = new ProductoController();
				Producto nuevoProducto = new Producto("1234567891236", "Vernee Thor", new BigDecimal("85.48"), 21, new BigDecimal("103.43"), 5);
				nuevoProducto.addObserver(this);
				productoController.crear(nuevoProducto);
			}
		});
		btnNewButton.setBounds(35, 229, 117, 25);
		frame.getContentPane().add(btnNewButton);
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
	}
}
