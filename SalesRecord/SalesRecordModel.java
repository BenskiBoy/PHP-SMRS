public class SalesRecordModel {
	
	public String addSaleItem (String name, String date, String qty)
	{
		String result = "INSERT INTO salesrecord (ItemName, SaleDate, SaleQuantity) VALUES ('"+ name +"', '"+ date +"', '"+ qty +"')";
		return result;
	}

	public String editSaleItem (String id, String name, String date, String qty)
	{
		String result = "UPDATE salesrecord SET ItemName = '"+ name +"', SaleDate = '"+ date +"', SaleQuantity = '"+ qty +"' WHERE SaleID = '"+ id +"'";
		return result;
	}
	
	public String displaySaleItem (String id)
	{
		String result = "SELECT * FROM salesrecord WHERE SaleID = '"+ id +"'";
		return result;
	}
	
	public String deleteSaleItem (String id)
	{
		String result = "DELETE FROM salesrecord WHERE SaleID = '"+ id +"'";
		return result;
	}
}
