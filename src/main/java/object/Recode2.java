package object;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class Recode2
{
	private String recode_ID;		//기록 아이디
	private String product_ID;		//제품코드
	private String product_name;	//제품이름
	private String manufacturer;	//제조사
	private String price;				//제품가격
	private String amount;			//제품수량
	private String sum;
	private String sellingTime;		//판매시간
	private String recode_type;		//기록 종류
	
	@Override
	public String toString()
	{
		return "recode_ID = " + recode_ID + "product_ID= " + product_ID + "product_name= " + product_name + "manufacturer= " + manufacturer +
				"price= " + price + "amount= " + amount + "sum= " + sum + "sellingTime= " + sellingTime + "recode_type= " + recode_type;
 	}
	
	public Recode2(String recode_ID, String product_ID, String product_name, String manufacturer, String price,
			String amount, String sum, String sellingTime, String recode_type) {
		super();
		this.recode_ID = recode_ID;
		this.product_ID = product_ID;
		this.product_name = product_name;
		this.manufacturer = manufacturer;
		this.price = price;
		this.amount = amount;
		this.sum = sum;
		this.sellingTime = sellingTime;
		this.recode_type = recode_type;
	}

	public String getRecode_ID() {
		return recode_ID;
	}

	public void setRecode_ID(String recode_ID) {
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getSum() {
		return sum;
	}

	public void setSum(String sum) {
		this.sum = sum;
	}

	public String getSellingTime() {
		return sellingTime;
	}

	public void setSellingTime(String sellingTime) {
		this.sellingTime = sellingTime;
	}

	public String getRecode_type() {
		return recode_type;
	}

	public void setRecode_type(String recode_type) {
		this.recode_type = recode_type;
	}
	
	
	
	
	
	
}