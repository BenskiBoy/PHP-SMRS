package stockitem;
public class SalesOrderlineRecord {
	private int saleId;
	private java.sql.Date date;
	private List<int> itemId = new ArrayList<int>();
	private List<double> price = new ArrayList<double>();
	private List<int> qty = new ArrayList<int>();
	public StockItem (int saleId, java.sql.Date date, List<int> itemId, List<double> price, List<int> qty)
	{
		this.saleId = saleId;
		this.date = date;
		this.itemId = itemId;
		this.price = price;
		this.qty = qty;
	}

	public int getSaleId ()
	{
		return this.saleId;
	}
	
	public String getDate ()
	{
		return this.name;
	}

	public List<int> getItemId ()
	{
		return this.itemId;
	}

	public List<double> getPrice ()
	{
		return this.price;
	}

	public List<int> getQty ()
	{
		return this.qty;
	}
}
