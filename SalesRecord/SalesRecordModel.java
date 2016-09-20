public class SalesRecordModel {
	
	public String addSaleItem (String date)
	{
		String result = "INSERT INTO salesrecord (SaleDate) VALUES ('"+ java.sql.Date.valueOf(date) +"')";
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

	public String fetchSalesValue (String date)
	{
		String result = "SELECT orderline.qtySold, orderline.salePrice FROM orderline INNER JOIN salesrecord ON orderline.saleId = salesrecord.idSalesRecord WHERE salesrecord.SaleDate >= '"+ java.sql.Date.valueOf(date) +"'";
	}
}
