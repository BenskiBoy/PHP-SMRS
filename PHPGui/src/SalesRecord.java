//package stockitem;
public class SalesRecord {
	private int saleId;
	private String date;
	public SalesRecord (int saleId, String date)
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
		return this.date;
	}
}
