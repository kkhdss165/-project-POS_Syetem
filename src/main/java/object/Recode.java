package object;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class Recode
{
	private int recode_ID;		//기록 아이디
	private String product_ID;		//제품코드
	private String product_name;	//제품이름
	private String manufacturer;	//제조사
	private long price;				//제품가격
	private long amount;			//제품수량
	private LocalDateTime sellingTime;		//판매시간
	private String recode_type;		//기록 종류
	
	public Recode() {}
	
	public Recode(int recode_ID, String product_ID, String product_name, String manufacturer, long price,
			long amount, LocalDateTime sellingTime, String recode_type) {
		super();
		this.recode_ID = recode_ID;
		this.product_ID = product_ID;
		this.product_name = product_name;
		this.manufacturer = manufacturer;
		this.price = price;
		this.amount = amount;
		this.sellingTime = sellingTime;
		this.recode_type = recode_type;
	}

	public void setAllwithoutTime(String product_ID, String product_name, String manufacturer, long price, long amount)
	{
		this.product_ID = product_ID;
		this.product_name = product_name;
		this.manufacturer = manufacturer;
		this.price = price;
		this.amount = amount;
	}
	
	public int getRecode_ID() {
		return recode_ID;
	}

	public void setRecode_ID(int recode_ID) {
		this.recode_ID = recode_ID;
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

	public LocalDateTime getSellingTime() {
		return sellingTime;
	}

	public void setSellingTime(LocalDateTime sellingTime) {
		this.sellingTime = sellingTime;
	}

	public String getRecode_type() {
		return recode_type;
	}

	public void setRecode_type(String recode_type) {
		this.recode_type = recode_type;
	}

//	public void setAutoTime()
//	{
//		Date day =new java.util.Date();
//		SimpleDateFormat simpleDataFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
//		this.sellingTime = simpleDataFormat.format(day);
//	}
	
}