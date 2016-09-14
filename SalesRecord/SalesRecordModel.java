public class SalesRecordModel {
	
	public String addSaleItem (java.sql.Date date)
	{
		String result = "INSERT INTO salesrecord (SaleDate) VALUES ('"+ date +"')";
		return result;
	}

	public String addOrderlineItem (int saleId, int itemId, double price, int qty)
	{
		String result = "INSERT INTO orderline (saleId, itemId, salePrice, qtySold) VALUES ('"+ saleId +"', '"+ itemId +"', '"+ price +"', '"+ qty +"')";
		return result;
	}
	
	public String displayAllSaleItems ()
	{
		String result = "SELECT * FROM salesrecord";
		return result;
	}

	public String displaySaleItem (int id)
	{
		String result = "SELECT * FROM salesrecord WHERE SaleID = '"+ id +"'";
		return result;
	}

	public String displayOrderlineItem (int id)
	{
		String result = "SELECT * FROM orderline WHERE saleId = '"+ id +"'";
		return result;
	}
}
