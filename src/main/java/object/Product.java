package object;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class Product
{
	private String product_ID;		//제품코드
	private String product_name;	//제품이름
	private String manufacturer;	//제조사
	private long price;				//제품가격
	private long productInStock;		//제품수량
	private LocalDateTime restockDate;		//최근입고기간
	
	public Product() {}
	
	public Product(String product_ID, String product_name, String manufacturer, long price, long productInStock,
			LocalDateTime restockDate) {
		super();
		this.product_ID = product_ID;
		this.product_name = product_name;
		this.manufacturer = manufacturer;
		this.price = price;
		this.productInStock = productInStock;
		this.restockDate = restockDate;
	}

	public void setAllwithoutTime(String product_ID, String product_name, String manufacturer, long price, long productInStock)
	{
		this.product_ID = product_ID;
		this.product_name = product_name;
		this.manufacturer = manufacturer;
		this.price = price;
		this.productInStock = productInStock;
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

	public long getProductInStock() {
		return productInStock;
	}

	public void setProductInStock(long productInStock) {
		this.productInStock = productInStock;
	}

	public LocalDateTime getRestockDate() {
		return restockDate;
	}

	public void setRestockDate(LocalDateTime restockDate) {
		this.restockDate = restockDate;
	}
//	public void setAutoTime()
//	{
//		Date day =new java.util.Date();
//		SimpleDateFormat simpleDataFormat = new SimpleDateFormat("yyyy-MM-dd");
//		this.restockDate = simpleDataFormat.format(day);
//	}
}