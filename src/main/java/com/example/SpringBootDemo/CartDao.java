package com.example.SpringBootDemo;
import java.util.ArrayList;

import object.Cart;

public class CartDao {

	ArrayList<Cart> cartlist;
	
	public CartDao()
	{
		cartlist = new ArrayList<Cart>();
	}
	//제품 추가
	public void add(String product_ID, String product_name, String manufacturer, long price, long max_amount)
	{
		int index = getCartIndexById(product_ID);
		
		if (index == -1)
		{
			long amount = 1;
			Cart cart = new Cart(product_ID, product_name, manufacturer, price, amount);
			cartlist.add(cart);
		}
		else
		{
			Cart cart = cartlist.get(index);
			if (cart.getAmount() < max_amount)
			{
				cart.setAmount(cart.getAmount()+1);
			}
		}
	}
	public void deleteAll()
	{
		cartlist.clear();
	}
	public void deleteById(String product_ID)
	{
		for (int i = 0; i < cartlist.size(); i++)
		{
			Cart cart = cartlist.get(i);
			if (cart.getProduct_ID().equals(product_ID))
			{
				cartlist.remove(i);
				return;
			}
		}
	}
	public int getCartIndexById(String product_ID)
	{
		for (int i = 0; i < cartlist.size(); i++)
		{
			Cart cart = cartlist.get(i);
			if (cart.getProduct_ID().equals(product_ID))
			{
				return i;
			}
		}
		return -1;
	}
	public long getTotal()
	{
		long sum = 0;
		
		for (int i = 0; i < cartlist.size(); i++)
		{
			Cart cart = cartlist.get(i);
			sum = sum + cart.getAmount() * cart.getPrice();
		}
		
		return sum;
	}

	public ArrayList<Cart> getCartlist() {
		return cartlist;
	}

	public void setCartlist(ArrayList<Cart> cartlist) {
		this.cartlist = cartlist;
	}
	
}