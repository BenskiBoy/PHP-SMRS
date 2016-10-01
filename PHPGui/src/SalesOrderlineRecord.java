import java.util.ArrayList;
import java.util.List;

//package SalesOrderlineRecord;
public class SalesOrderlineRecord {
	private int saleId;
	private int idOrderLine;
	private int itemId;
	private double price;
	private int qty;
	public SalesOrderlineRecord (int idOrderLine, int saleId, int itemId, double price, int qty)
	{
		this.saleId = saleId;
		this.itemId = itemId;
		this.price = price;
		this.qty = qty;
		this.idOrderLine = idOrderLine;
	}

	public int getSaleId ()
	{
		return this.saleId;
	}
	
	public int getIdOrderLine ()
	{
		return this.idOrderLine;
	}

	public int getItemId ()
	{
		return this.itemId;
	}

	public double getPrice ()
	{
		return this.price;
	}

	public int getQty ()
	{
		return this.qty;
	}
}
