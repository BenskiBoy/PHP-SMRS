import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.JEditorPane;

public class GUI {
	private static final String PROGRAM_NAME = "PHP Sales Management And Reporting System";
	
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
	
	private static final String NAME = "Name";
	private static final String DESCRIPTION = "Description";
	private static final String SALE_PRICE = "Sale Price";
	private static final String WHOLESALE_PRICE = "Whole Sale Price";
	private static final String QUANTITY = "Quantity";
	private static final String ADD = "Add";
	
	private static final String PASSED_DATA_ERROR = "Error, passed data incorrect";
	private static final String DATA_INPUT_ERROR = "Data Input Error";
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
					window.frame.setSize(450, 300);
					window.frame.setResizable(false);
					window.frame.setTitle(PROGRAM_NAME);
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
		
		final JPanel AddStockItemPanel = new JPanel();
		frame.getContentPane().add(AddStockItemPanel, "name_11894877285834");
		AddStockItemPanel.setLayout(null);
		
		//******************************************************************
		
		//***************************ADD STOCK ITEM PANEL*******************
		
		JTextPane NameHeading = new JTextPane();
		NameHeading.setText(ADD_STOCK_ITEM);
		NameHeading.setEnabled(false);
		NameHeading.setEditable(false);
		NameHeading.setBounds(10, 72, 100, 20);
		AddStockItemPanel.add(NameHeading);
		
		JTextPane DescriptionHeading = new JTextPane();
		DescriptionHeading.setEnabled(false);
		DescriptionHeading.setEditable(false);
		DescriptionHeading.setText(DESCRIPTION);
		DescriptionHeading.setBounds(10, 103, 100, 20);
		AddStockItemPanel.add(DescriptionHeading);
		
		JTextPane SalePriceHeading = new JTextPane();
		SalePriceHeading.setEnabled(false);
		SalePriceHeading.setEditable(false);
		SalePriceHeading.setText(SALE_PRICE);
		SalePriceHeading.setBounds(10, 134, 100, 20);
		AddStockItemPanel.add(SalePriceHeading);
		
		JTextPane WholeSalePriceHeading = new JTextPane();
		WholeSalePriceHeading.setEnabled(false);
		WholeSalePriceHeading.setEditable(false);
		WholeSalePriceHeading.setText(WHOLESALE_PRICE);
		WholeSalePriceHeading.setBounds(10, 165, 100, 20);
		AddStockItemPanel.add(WholeSalePriceHeading);
		
		JTextPane QuantityHeading = new JTextPane();
		QuantityHeading.setEnabled(false);
		QuantityHeading.setEditable(false);
		QuantityHeading.setText(QUANTITY);
		QuantityHeading.setBounds(10, 196, 100, 20);
		AddStockItemPanel.add(QuantityHeading);
		
		JEditorPane NameEditorPane = new JEditorPane();
		NameEditorPane.setBounds(120, 72, 304, 20);
		AddStockItemPanel.add(NameEditorPane);
		
		JEditorPane DescriptionEditorPane = new JEditorPane();
		DescriptionEditorPane.setBounds(120, 103, 304, 20);
		AddStockItemPanel.add(DescriptionEditorPane);
		
		JEditorPane WholeSalePriceEditerPane = new JEditorPane();
		WholeSalePriceEditerPane.setBounds(120, 165, 304, 20);
		AddStockItemPanel.add(WholeSalePriceEditerPane);
		
		JEditorPane QuantityEditorPane = new JEditorPane();
		QuantityEditorPane.setBounds(120, 196, 304, 20);
		AddStockItemPanel.add(QuantityEditorPane);
		
		JEditorPane SaleEditorPane = new JEditorPane();
		SaleEditorPane.setBounds(120, 134, 304, 20);
		AddStockItemPanel.add(SaleEditorPane);
		
		JFormattedTextField AddStockItemHeading = new JFormattedTextField();
		AddStockItemHeading.setText(STOCK_MANAGEMENT);
		AddStockItemHeading.setHorizontalAlignment(SwingConstants.CENTER);
		AddStockItemHeading.setEnabled(false);
		AddStockItemHeading.setEditable(false);
		AddStockItemHeading.setBounds(10, 11, 414, 23);
		AddStockItemPanel.add(AddStockItemHeading);
		
		JButton StockManagementHomePageButton = new JButton(HOME_PAGE);
		StockManagementHomePageButton.setBounds(10, 227, 100, 23);
		AddStockItemPanel.add(StockManagementHomePageButton);
		StockManagementHomePageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePagePanel.setVisible(true);
				AddStockItemPanel.setVisible(true);
			}
		});

		//Add Stock Item
		JButton AddButton = new JButton(ADD);
		AddButton.setBounds(324, 227, 100, 23);
		AddStockItemPanel.add(AddButton);
		AddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					//TODO This is a dummy function. Add real method.
					AddStockItem(NameEditorPane.getText(), DescriptionEditorPane.getText(), Integer.parseInt(SaleEditorPane.getText()), Integer.parseInt(WholeSalePriceEditerPane.getText()), Integer.parseInt(QuantityEditorPane.getText()));
				} catch (IndexOutOfBoundsException e) {
					
				    //System.err.println("IndexOutOfBoundsException: " + e.getMessage());
				} catch( NumberFormatException e){
					JOptionPane.showMessageDialog(frame, PASSED_DATA_ERROR, DATA_INPUT_ERROR, JOptionPane.ERROR_MESSAGE);
					NameEditorPane.setText(""); DescriptionEditorPane.setText(""); SaleEditorPane.setText(""); WholeSalePriceEditerPane.setText(""); QuantityEditorPane.setText("");
				}
			}
		});
		
		//******************************************************************
		
		//**************************HOME PAGE*******************************
		JButton StockManagementButton = new JButton(STOCK_MANAGEMENT);
		StockManagementButton.setBounds(10, 46, 180, 49);
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
		
		SalesManagerButton.setBounds(10, 106, 180, 49);
		HomePagePanel.add(SalesManagerButton);
		
		JButton ReportGeneratorButton = new JButton(REPORT_GENERATOR);
		ReportGeneratorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO Implement Report Generator
			}
		});
		ReportGeneratorButton.setBounds(10, 166, 180, 49);
		HomePagePanel.add(ReportGeneratorButton);
		
		//******************************************************************
		
		//*****************STOCK MANAGER************************************
		JButton AddStockItemButton = new JButton(ADD_STOCK_ITEM);
		AddStockItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStockItemPanel.setVisible(true);
				StockManagerPanel.setVisible(false);
			}
		});
		AddStockItemButton.setBounds(145, 81, 160, 49);
		StockManagerPanel.add(AddStockItemButton);
		
		JButton DisplayStockItemButton = new JButton(DISPLAY_STOCK_ITEM);
		DisplayStockItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		DisplayStockItemButton.setBounds(145, 201, 161, 49);
		StockManagerPanel.add(DisplayStockItemButton);
		
		JButton EditStockItemButton = new JButton(EDIT_STOCK_ITEM);
		EditStockItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		EditStockItemButton.setBounds(145, 141, 161, 49);
		StockManagerPanel.add(EditStockItemButton);

		JButton StockReturnToHome = new JButton(HOME_PAGE);
		StockReturnToHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HomePagePanel.setVisible(true);
				StockManagerPanel.setVisible(false);
			}
		});
		StockReturnToHome.setBounds(10, 227, 100, 23);
		StockManagerPanel.add(StockReturnToHome);
		//******************************************************************
		
		//**************************SALE MANAGER****************************
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
		SalesReturnToHome.setBounds(10, 227, 100, 23);
		SalesManagerPanel.add(SalesReturnToHome);
		
		JButton AddSalesRecordButton = new JButton(ADD_SALES_RECORD);
		AddSalesRecordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		AddSalesRecordButton.setBounds(140, 81, 160, 49);
		SalesManagerPanel.add(AddSalesRecordButton);
		
		JButton EditSalesRecordButton = new JButton(EDIT_SALES_RECORD);
		EditSalesRecordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		EditSalesRecordButton.setBounds(140, 141, 160, 49);
		SalesManagerPanel.add(EditSalesRecordButton);
		
		JButton DisplaySalesRecordButton = new JButton(DISPLAY_SALES_RECORD);
		DisplaySalesRecordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		DisplaySalesRecordButton.setBounds(140, 201, 160, 49);
		SalesManagerPanel.add(DisplaySalesRecordButton);
		
		JFormattedTextField SalesManagerHeading = new JFormattedTextField(SALES_MANAGEMENT);
		SalesManagerHeading.setHorizontalAlignment(SwingConstants.CENTER);
		SalesManagerHeading.setEditable(false);
		SalesManagerHeading.setEnabled(false);
		SalesManagerHeading.setBounds(10, 11, 414, 23);
		SalesManagerPanel.add(SalesManagerHeading);
		//******************************************************************
		
	}
	
	void AddStockItem(String name, String description, int SalePrice, int WholeSalePrice, int Quantity){
		int i = 0;
		i++;
	}
}

