public class SalesRecordModel {
	
	public String addSaleItem (String date)
	{
		String result = "INSERT INTO SalesRecord (SaleDate) VALUES ('"+ java.sql.Date.valueOf(date) +"')";
		return result;
	}

	public String addOrderlineItem (int saleId, int itemId, double price, int qty)
	{
		String result = "INSERT INTO OrderLine (saleId, itemId, salePrice, qtySold) VALUES ('"+ saleId +"', '"+ itemId +"', '"+ price +"', '"+ qty +"')";
		return result;
	}
	
	public String displayAllSaleItems ()
	{
		String result = "SELECT * FROM SalesRecord";
		return result;
	}

	public String displaySaleItem (int id)
	{
		String result = "SELECT * FROM SalesRecord WHERE saleID = '"+ id +"'";
		return result;
	}

	public String displayOrderlineItem (int id)
	{
		String result = "SELECT * FROM OrderLine WHERE saleID = '"+ id +"'";
		return result;
	}
}