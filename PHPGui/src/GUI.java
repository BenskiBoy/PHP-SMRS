import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;




public class GUI {
	private static final String HOME_PAGE = "Home Page";
	private static final String STOCK_MANAGEMENT = "Stock Management";
	private static final String SALES_MANAGEMENT = "Sales Management";
	private static final String REPORT_GENERATOR = "Report Generator";
	
	private static final String ADD_STOCK_ITEM = "Add Stock Item";
	private static final String EDIT_STOCK_ITEM = "Edit Stock Item";
	private static final String DISPLAY_STOCK_ITEM = "Display Stock Item";
	
	private static final String ADD_SALES_RECORD = "Add Sales Record";
	private static final String EDIT_SALES_RECORD = "Edit Sales Record";
	private static final String DISPLAY_SALES_RECORD = "Display Sales Record";
	
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
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
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		//******************************************************************
		
		final JPanel HomePagePanel = new JPanel();
		frame.getContentPane().add(HomePagePanel, "name_11891297357392");
		HomePagePanel.setLayout(null);
		
		final JPanel StockManagerPanel = new JPanel();
		frame.getContentPane().add(StockManagerPanel, "name_11893316052823");
		StockManagerPanel.setLayout(null);
		
		final JPanel SalesManagerPanel = new JPanel();
		frame.getContentPane().add(SalesManagerPanel, "name_11894877285838");
		SalesManagerPanel.setLayout(null);
		
		//******************************************************************
		
		//******************************************************************
		JButton StockManagementButton = new JButton(STOCK_MANAGEMENT);
		StockManagementButton.setBounds(39, 46, 123, 49);
		HomePagePanel.add(StockManagementButton);
		
		StockManagementButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				StockManagerPanel.setVisible(true);
				HomePagePanel.setVisible(false);
			}
		});
		
		JButton SalesManagerButton = new JButton(SALES_MANAGEMENT);
		SalesManagerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePagePanel.setVisible(false);
				SalesManagerPanel.setVisible(true);
			}
		});
		
		SalesManagerButton.setBounds(39, 106, 123, 49);
		HomePagePanel.add(SalesManagerButton);
		
		JButton ReportGeneratorButton = new JButton(REPORT_GENERATOR);
		ReportGeneratorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO Implement Report Generator
			}
		});
		ReportGeneratorButton.setBounds(39, 166, 123, 49);
		HomePagePanel.add(ReportGeneratorButton);
		
		//******************************************************************
		
		//******************************************************************
		JButton AddStockItemButton = new JButton(ADD_STOCK_ITEM);
		AddStockItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		AddStockItemButton.setBounds(160, 81, 123, 49);
		StockManagerPanel.add(AddStockItemButton);
		
		JButton DisplayStockItemButton = new JButton(DISPLAY_STOCK_ITEM);
		DisplayStockItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		DisplayStockItemButton.setBounds(160, 201, 123, 49);
		StockManagerPanel.add(DisplayStockItemButton);
		
		JButton EditStockItemButton = new JButton(EDIT_STOCK_ITEM);
		EditStockItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		EditStockItemButton.setBounds(160, 141, 123, 49);
		StockManagerPanel.add(EditStockItemButton);
		//******************************************************************
		
		//******************************************************************
		JButton StockReturnToHome = new JButton(HOME_PAGE);
		StockReturnToHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HomePagePanel.setVisible(true);
				StockManagerPanel.setVisible(false);
			}
		});
		StockReturnToHome.setBounds(10, 227, 89, 23);
		StockManagerPanel.add(StockReturnToHome);
		
		JFormattedTextField StockManagerHeading = new JFormattedTextField();
		StockManagerHeading.setEnabled(false);
		StockManagerHeading.setEditable(false);
		StockManagerHeading.setHorizontalAlignment(SwingConstants.CENTER);
		StockManagerHeading.setText(STOCK_MANAGEMENT);
		StockManagerHeading.setBounds(10, 11, 414, 23);
		StockManagerPanel.add(StockManagerHeading);
		
		JButton SalesReturnToHome = new JButton(HOME_PAGE);
		SalesReturnToHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePagePanel.setVisible(true);
				SalesManagerPanel.setVisible(false);
			}
		});
		SalesReturnToHome.setBounds(10, 227, 89, 23);
		SalesManagerPanel.add(SalesReturnToHome);
		
		JButton AddSalesRecordButton = new JButton(ADD_SALES_RECORD);
		AddSalesRecordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		AddSalesRecordButton.setBounds(160, 81, 123, 49);
		SalesManagerPanel.add(AddSalesRecordButton);
		
		JButton EditSalesRecordButton = new JButton(EDIT_SALES_RECORD);
		EditSalesRecordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		EditSalesRecordButton.setBounds(160, 141, 123, 49);
		SalesManagerPanel.add(EditSalesRecordButton);
		
		JButton DisplaySalesRecordButton = new JButton(DISPLAY_SALES_RECORD);
		DisplaySalesRecordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		DisplaySalesRecordButton.setBounds(160, 201, 123, 49);
		SalesManagerPanel.add(DisplaySalesRecordButton);
		
		JFormattedTextField SalesManagerHeading = new JFormattedTextField(SALES_MANAGEMENT);
		SalesManagerHeading.setEditable(false);
		SalesManagerHeading.setEnabled(false);
		SalesManagerHeading.setBounds(10, 11, 414, 23);
		SalesManagerPanel.add(SalesManagerHeading);
		//******************************************************************
		
	}
}
