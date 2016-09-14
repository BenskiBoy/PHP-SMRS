package stockitem;
public class SalesRecord {
	private int saleId;
	private java.sql.Date date;
	public StockItem (int saleId, java.sql.Date date)
	{
		this.saleId = saleId;
		this.date = date;
	}

	public int getSaleId ()
	{
		return this.saleId;
	}
	
	public String getDate ()
	{
		return this.name;
	}
}
