package stockitem;

public class StockItemSQLModel {
	public String insertSaleItem(StockItem s){
		String price = Double.toString(s.getListPrice());
		String qty = Integer.toString(s.getQuantity());
		String result = "INSERT StockItems (Name, Manufacturer, Description, ListPrice, StockQuantity)"
				+ " VALUES ('"+s.getName()+"', '"+s.getManufacturer()+"', '"+s.getDescription()+"',  "+price+", "+qty+")";
		return result;
	}
	public String updateStockItem(String id, StockItem s){
		
		String price = Double.toString(s.getListPrice());
		String qty = Integer.toString(s.getQuantity());
		String result = "UPDATE StockItems set Name = '"+s.getName()+"', Manufacturer = '"+s.getManufacturer()+", Description = '"
				+s.getDescription()+ "', ListPrice = "+price+", StockQuantity = "+qty +" WHERE idStockItems = "+id;
		return result;
	}
	public String updateStockItem(int id, StockItem s){
		
		String price = Double.toString(s.getListPrice());
		String qty = Integer.toString(s.getQuantity());
		String strId = Integer.toString(id);
		String result = "UPDATE StockItems set Name = '"+s.getName()+"', Manufacturer = '"+s.getManufacturer()+"', Description = '"
				+s.getDescription()+ "', ListPrice = "+price+", StockQuantity = "+qty +" WHERE idStockItems = "+strId;
		return result;
	}
	public String selectStockItem(){
		String result = "SELECT * FROM StockItems";
		return result;
	}
	public String selectStockItem(int id){
		String strId = Integer.toString(id);
		String result = "SELECT * FROM StockItems WHERE idStockItems = "+strId;
		return result;
	}
	public String selectStockItemByName(String name){
		String result = "SELECT * FROM StockItems WHERE Name = '"+name+"'";
		return result;
	}
	public String deleteStockItem(int id){
		String strId = Integer.toString(id);
		String result = "DELETE FROM StockItems WHERE idStockItems = "+strId;
		return result;
	}
}
