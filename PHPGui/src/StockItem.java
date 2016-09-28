import javax.swing.JOptionPane;

public class StockItem {
	private int stockId;
	private String name;
	private String manufacturer;
	private String description;
	private double listPrice;
	private int quantity;
	
	public StockItem(int id, String nam, String man, String desc, double price, int quan){
		this.stockId = id;
		this.name = nam;
		this.manufacturer = man;
		this.description = desc;
		this.listPrice = price;
		this.quantity = quan;
	}
	public void setStockId(int value){
		this.stockId = value;
	}
	public int getStockId(){
		return this.stockId;
	}
	public void setName(String str){
		this.name = str;
	}
	public String getName(){
		return this.name;
	}
	public void setManufacturer(String man){
		this.manufacturer = man;
	}
	public String getManufacturer(){
		return this.manufacturer;
	}
	public void setDescription(String desc){
		this.description = desc;
	}
	public String getDescription(){
		return this.description;
	}
	public void setListPrice(double price){
		this.listPrice = price;
	}
	public double getListPrice(){
		return this.listPrice;
	}
	public void setQuantity(int amount){
		this.quantity = amount;
	}
	public int getQuantity(){
		return this.quantity;
	}
	public void incrementQuantity(int amount){
		this.quantity += amount;
	}
	public void decrementQuantity(int amount){
		this.quantity += amount;
	}
	
	
	
	
//	public void checkQuantityBelow(int value){
//		if(this.quantity<=value){
//			String str = this.name+" is currently low on stock";
//			JOptionPane.showMessageDialog(null, str);
//		}
//	}
	/**
	 * Check if the stock level of an item is below a certain value
	 * @param value
	 * @return true if value is lower than this.quantity
	 */
	public boolean checkQuanitityBelow(int value){
		if(this.quantity<=value){
			return true;
		}
		return false;
	}
}
