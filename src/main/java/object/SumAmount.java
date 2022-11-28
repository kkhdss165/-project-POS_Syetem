package object;

public class SumAmount {
	private String product_ID;		//제품코드
	private String product_name;	//제품이름
	private String manufacturer;	//제조사
	private long price;				//제품가격
	private long amount;			//제품수량
	private long total;
	
	public SumAmount(String product_ID, String product_name, String manufacturer, long price, long amount, long total) {
		super();
		this.product_ID = product_ID;
		this.product_name = product_name;
		this.manufacturer = manufacturer;
		this.price = price;
		this.amount = amount;
		this.total = total;
	}
	
	
	public String getProduct_ID() {
		return product_ID;
	}
	public void setProduct_ID(String product_ID) {
		this.product_ID = product_ID;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}

}
