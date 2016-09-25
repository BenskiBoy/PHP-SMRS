import java.util.Date;

public class Model {
	
	//Sales Record SQL
	public String addSaleItem (String date)
	{
		String result = "INSERT INTO salesrecord (SaleDate) "
					+ "VALUES ('"+ java.sql.Date.valueOf(date) +"')";
		return result;
	}

	public String addOrderlineItem (int saleId, int itemId, double price, int qty)
	{
		String result = "INSERT INTO orderline (saleId, itemId, salePrice, qtySold) "
					+ "VALUES ('"+ saleId +"', '"+ itemId +"', '"+ price +"', '"+ qty +"')";
		return result;
	}
	
	public String displayAllSaleItems ()
	{
		String result = "SELECT * "
					+ "FROM salesrecord";
		return result;
	}

	public String displaySaleItem (int id)
	{
		String result = "SELECT * "
					+ "FROM salesrecord "
					+ "WHERE SaleID = '"+ id +"'";
		return result;
	}

	public String displayOrderlineItem (int id)
	{
		String result = "SELECT * "
					+ "FROM orderline "
					+ "WHERE saleId = '"+ id +"'";
		return result;
	}

	public String fetchSalesValue (String date)
	{
		String result = "SELECT orderline.qtySold, orderline.salePrice "
					+ "FROM orderline "
					+ "INNER JOIN salesrecord "
					+ "ON orderline.saleId = salesrecord.idSalesRecord "
					+ "WHERE salesrecord.SaleDate >= '"+ date +"';";
		return result;
	}

	//Stock Item SQL
	public String insertSaleItem(StockItem s){
		String price = Double.toString(s.getListPrice());
		String qty = Integer.toString(s.getQuantity());

		String result = "INSERT StockItems (Name, Manufacturer, Description, ListPrice, StockQuantity)"
					+ "VALUES ('"+ s.getName() +"', '"+ s.getManufacturer() +"', '"+ s.getDescription() +"',  '"+ price +"', '"+ qty +"')";
		return result;
	}

	public String updateStockItem(String id, StockItem s){
		
		String price = Double.toString(s.getListPrice());
		String qty = Integer.toString(s.getQuantity());

		String result = "UPDATE StockItems set Name = '"+ s.getName() +"', Manufacturer = '"+ s.getManufacturer() +", Description = '"
					+ s.getDescription()+ "', ListPrice = '"+ price +"', StockQuantity = '"+ qty +"'' WHERE idStockItems = '"+ id +"'";
		return result;
	}

	public String updateStockItem(int id, StockItem s){
		
		String price = Double.toString(s.getListPrice());
		String qty = Integer.toString(s.getQuantity());
		String strId = Integer.toString(id);

		String result = "UPDATE StockItems set Name = '"+ s.getName() +"', Manufacturer = '"+ s.getManufacturer() +"', Description = '"
					+ s.getDescription() + "', ListPrice = '"+ price +"', StockQuantity = '"+ qty +"'' WHERE idStockItems = '"+ strId +"'";
		return result;
	}

	public String selectStockItem(){
		String result = "SELECT * FROM StockItems";
		return result;
	}

	public String selectStockItem(int id){
		String strId = Integer.toString(id);

		String result = "SELECT * FROM StockItems" 
					+ "WHERE idStockItems = '"+ strId +"'";
		return result;
	}

	public String selectStockItemByName(String name){
		String result = "SELECT * FROM StockItems" 
					+ "WHERE Name = '"+ name +"'";
		return result;
	}

	public String deleteStockItem(int id){
		String strId = Integer.toString(id);

		String result = "DELETE FROM StockItems" 
					+ "WHERE idStockItems = '"+ strId +"'";
		return result;
	}
}