package com.example.SpringBootDemo;
import object.*;

import java.time.LocalDateTime;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
public class MainController 
{
	@Autowired
	private ProductDao productDao;
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private CartDao cartDao;
	@Autowired
	private RecodeDao recodeDao;

	private String old_ID;
	private String remove_ID;
	private String receive_old_ID;
	private String receive_new_ID;
	private String refund_ID;
	
	//main
	@RequestMapping( {"/", "/home"} )
	public String home() 
	{ 
		return "home"; 
	}
	
	@RequestMapping( {"/login"} )
	public String login() 
	{ 
		return "login"; 
	}
	@RequestMapping( {"/logout"} )
	public String logout(HttpServletRequest request) 
	{ 
        HttpSession session = request.getSession();
        session.invalidate();
		return "home"; 
	}
	
	@RequestMapping(value ="/login", method = RequestMethod.POST)
	public String handleLogin(HttpServletRequest request)
	{
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		Member result = memberDao.login(id, pw);
		
		if (result == null)
		{
			return "redirect:login?error";
		}
		else
		{
			HttpSession session = request.getSession();
			
			session.setAttribute("sessionId", id);
			session.setAttribute("sessionrole", result.getRole());
			return "home";
		}
			
	}
	///////////////////////////////////////////////////////////////////////////////////
	//product
	@RequestMapping( {"/product", "/product/home"} )
	public String product_home() 
	{ 
		return "product/product_home"; 
	}
	@RequestMapping( {"/product/receive"} )
	public String product_receive(Model model) 
	{
		List<Product> productList = productDao.selectAll();
		model.addAttribute("products", productList);
		
		return "product/product_receive"; 
	}
	@RequestMapping(value ="/product/receive", method = RequestMethod.POST)
	public String Handlereceive(Model model, HttpServletRequest request)
	{
		String new_receive = request.getParameter("new_receive");
		String old_receive = request.getParameter("old_receive");
		
		if (new_receive != null && new_receive.equals("true"))
		{
			//System.out.print("new");
			
			String new_product_id = request.getParameter("newproduct_ID");
			String new_manufacturer = request.getParameter("newManufacturer");
			String new_product_name = request.getParameter("newProduct_name");
			long new_price = Long.parseLong(request.getParameter("newPrice"));
			long new_productInStock = Long.parseLong(request.getParameter("newProductInStock"));
			
			//System.out.print(new_product_id + new_manufacturer + new_product_name + new_price + new_productInStock);
			
			productDao.insert(new_product_id, new_product_name, new_manufacturer, new_price, new_productInStock);
			
			receive_new_ID = null;
			receive_old_ID = null;
		}
		if (old_receive != null && old_receive.equals("true"))
		{
			
			
			long new_productInStock = Long.parseLong(request.getParameter("newProductInStock"));
			
			//System.out.print(receive_old_ID + new_productInStock);
			
			productDao.restock(receive_old_ID , new_productInStock);
			
			receive_new_ID = null;
			receive_old_ID = null;
		}
		
		String restock_id = request.getParameter("restock_ID");
		if(restock_id != null && restock_id.equals("new_product"))
		{
			receive_new_ID ="";
			receive_old_ID = null;
		}
		else if (restock_id != null)
		{
			receive_new_ID = null;
			receive_old_ID = restock_id;
		}
		
		List<Product> productList = productDao.selectAll();
		model.addAttribute("products", productList);
		if(receive_old_ID != null)
		{
			List<Product> result = productDao.selectListByID(receive_old_ID);
			model.addAttribute("old_products", result);
		}
		else if(receive_new_ID != null)
		{
			model.addAttribute("new_products", " ");
		}

		
		
		return "product/product_receive"; 
	}
	@RequestMapping( {"/product/update"} )
	public String product_update(Model model) 
	{
		List<Product> productList = productDao.selectAll();
		model.addAttribute("products", productList);
		
		System.out.print("update");
		return "product/product_update"; 
	}
	
	@RequestMapping(value ="/product/update", method = RequestMethod.POST)
	public String Handleupdate(Model model, HttpServletRequest request)
	{
		String edit_id = request.getParameter("edit_ID");
		String is_update = request.getParameter("is_update");
		//System.out.print(edit_id);
		
		if (edit_id != null)
		{
			List<Product> result = productDao.selectListByID(edit_id);
			model.addAttribute("edit_products", result);
			old_ID = edit_id;
		}
		if (is_update != null && is_update.equals("true"))
		{
			String new_product_id = request.getParameter("newproduct_ID");
			String new_manufacturer = request.getParameter("newManufacturer");
			String new_product_name = request.getParameter("newProduct_name");
			long new_price = Long.parseLong(request.getParameter("newPrice"));
			long new_productInStock = Long.parseLong(request.getParameter("newProductInStock"));
			LocalDateTime new_restockDate = LocalDateTime.parse(request.getParameter("newRestockDate"));
			
			
			if(new_price > 0 && new_productInStock >= 0)
			{
				productDao.updateById(old_ID, new_product_id, new_product_name, new_manufacturer, new_price,
						new_productInStock, new_restockDate);
			}
		}
		
		List<Product> productList = productDao.selectAll();
		model.addAttribute("products", productList);
		
		return "product/product_update"; 
	}
	
	@RequestMapping( {"/product/remove"} )
	public String product_remove(Model model) 
	{
		List<Product> productList = productDao.selectAll();
		model.addAttribute("products", productList);
		
		return "product/product_remove"; 
	}
	
	@RequestMapping(value ="/product/remove", method = RequestMethod.POST)
	public String Handleremove(Model model, HttpServletRequest request)
	{
		String remove_id = request.getParameter("remove_ID");
		String is_remove = request.getParameter("is_remove");
		System.out.println("remove_id:"+remove_id);
		
		if (remove_id != null)
		{
			List<Product> result = productDao.selectListByID(remove_id);
			model.addAttribute("remove_products", result);
			remove_ID = remove_id;
		}
		if (is_remove != null && is_remove.equals("true"))
		{
			//System.out.print("remove_ID:"+remove_ID);
			productDao.deleteById(remove_ID);
		}
		
		List<Product> productList = productDao.selectAll();
		model.addAttribute("products", productList);
		
		return "product/product_remove"; 
	}
	///////////////////////////////////////////////////////////////////////////////////
	//sale
	@RequestMapping( {"/sale", "/sale/home"} )
	public String sale_home() 
	{ 
		return "sale/sale_home"; 
	}
	@RequestMapping( {"/sale/sell"} )
	public String sale_sell(Model model) 
	{ 
		List<Product> productList = productDao.selectAll();
		model.addAttribute("products", productList);
		return "sale/sale_sell"; 
	}
	
	@RequestMapping(value ="/sale/sell", method = RequestMethod.POST)
	public String Handlesell(HttpServletRequest request)
	{
		String product_id = request.getParameter("product_ID");
		String delete_id = request.getParameter("delete_ID");
		String is_pay = request.getParameter("is_pay");
		if (is_pay != null && is_pay.equals("true"))
		{
			if(cartDao.getCartlist().size() > 0)
				return "redirect:/sale/pay"; 
		}
		//System.out.print(id);
		if(product_id != null)
		{
			Product result = productDao.selectByID(product_id);
			cartDao.add(product_id , result.getProduct_name(), result.getManufacturer(), result.getPrice(), result.getProductInStock());
		}
		else if(delete_id != null)
		{
			
			//System.out.print(delete_id);
			if (delete_id.equals("all_delete"))
			{
				cartDao.deleteAll();
			}
			else
			{
				cartDao.deleteById(delete_id);
			}
		}
		
		return "redirect:/sale/sell"; 
	}
	@RequestMapping( {"/sale/pay"} )
	public String sale_pay(Model model) 
	{
		ArrayList<Cart> cartlist = cartDao.getCartlist();
		model.addAttribute("carts", cartlist);
		return "sale/sale_pay"; 
	}
	
	@RequestMapping(value ="/sale/pay", method = RequestMethod.POST)
	public String Handlesale_pay(Model model, HttpServletRequest request) 
	{
		String payment = request.getParameter("payment");
		long total = cartDao.getTotal();
		
		//System.out.print(payment);
		if (payment != null && payment.equals("cash"))
		{
			long money = Long.parseLong(request.getParameter("money"));
			long change = money - total;
			
			if(change < 0)
			{
				return "redirect:/sale/pay?error"; 
			}
			else
			{
				ArrayList<Cart> cartlist = cartDao.getCartlist();
				for (int i=0 ; i< cartlist.size(); i++)
				{
					Cart cart = cartlist.get(i);
					recodeDao.insert(cart.getProduct_ID(), cart.getProduct_name(), cart.getManufacturer(), 
							cart.getPrice(), cart.getAmount(), "normal");
					productDao.sell(cart.getProduct_ID(), cart.getAmount());
				}
				cartDao.deleteAll();
				return "redirect:/sale/pay_success?change="+change; 
			}
		}
		else if (payment != null && payment.equals("card"))
		{
			ArrayList<Cart> cartlist = cartDao.getCartlist();
			for (int i=0 ; i< cartlist.size(); i++)
			{
				Cart cart = cartlist.get(i);
				recodeDao.insert(cart.getProduct_ID(), cart.getProduct_name(), cart.getManufacturer(), 
						cart.getPrice(), cart.getAmount(), "normal");
				productDao.sell(cart.getProduct_ID(), cart.getAmount());
			}
			cartDao.deleteAll();
			return "redirect:/sale/pay_success?change=card"; 
		}
		
		ArrayList<Cart> cartlist = cartDao.getCartlist();
		model.addAttribute("carts", cartlist);
		return "sale/sale_pay"; 
	}
	@RequestMapping( {"/sale/pay_success"} )
	public String sale_pay_success() 
	{
		return "sale/sale_pay_success"; 
	}
	@RequestMapping( {"/sale/refund"} )
	public String sale_refund(Model model) 
	{
		List<Recode> recodeList = recodeDao.selectAll();
		model.addAttribute("recodes", recodeList);
		return "sale/sale_refund"; 
	}
	@RequestMapping(value ="/sale/refund", method = RequestMethod.POST)
	public String Handlesale_refund(Model model, HttpServletRequest request) 
	{
		String refund_id = request.getParameter("refund_id");
		String is_refund = request.getParameter("is_refund");
		
		//System.out.println(refund_id);
		if (refund_id != null)
		{
			List<Recode> result = recodeDao.selectListByID(Integer.parseInt(refund_id));
			model.addAttribute("refund_recodes", result);
			refund_ID = refund_id;
		}
		if (is_refund != null && is_refund.equals("true"))
		{
			//System.out.print("refund_ID:"+refund_ID);
			recodeDao.change_refund(Integer.parseInt(refund_ID));
			String product_id = recodeDao.selectByID(Integer.parseInt(refund_ID)).getProduct_ID();
			Long amount = recodeDao.selectByID(Integer.parseInt(refund_ID)).getAmount();
			productDao.refund(product_id, amount);
		}
		
		List<Recode> recodeList = recodeDao.selectAll();
		model.addAttribute("recodes", recodeList);
		return "sale/sale_refund"; 
	}
	@RequestMapping( {"/sale/recode"} )
	public String sale_recode(Model model) 
	{
		List<Recode> recodeList = recodeDao.selectAll();
		model.addAttribute("recodes", recodeList);
		return "sale/sale_recode"; 
	}

	
	
	@RequestMapping( {"/product_list"} )
	public String product_list(Model model) 
	{
		List<Product> productList = productDao.selectAll();
		model.addAttribute("products", productList);
		return "product_list"; 
	}

	
	@RequestMapping( {"/cart"} )
	public String cart(Model model) 
	{
		ArrayList<Cart> cartlist = cartDao.getCartlist();
		model.addAttribute("carts", cartlist);
		return "cart"; 
	}
	

	
	
	
	
	///////////////////////////////////////////////////////////////////////////////////
	//member
	@RequestMapping( {"/member/home"} )
	public String member_home() 
	{
		return "member/member_home"; 
	}
	@RequestMapping(value ="/member/home", method = RequestMethod.POST)
	public String Handlemember_home(HttpServletRequest request)
	{
		String is_update = request.getParameter("is_update");
		if (is_update!=null && is_update.equals("true"))
		{
			HttpSession session = request.getSession();
			String password = request.getParameter("password");
			String id = (String)session.getAttribute("sessionId");
			
			Member result = memberDao.login(id, password);
			//System.out.print(id+password);
			if (result == null)
			{
				return "redirect:/member/home?error";

			}
			else
			{
				return "redirect:/member/update";
			}
		}
		else
		{
			return "member/home"; 
		}
	}
	@RequestMapping( {"/member/update"} )
	public String member_update(Model model,HttpServletRequest request) 
	{
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("sessionId");
		List<Member> results = memberDao.selectListAll(id);
		
		model.addAttribute("members", results);
		
		return "member/member_update"; 
	}
	@RequestMapping(value ="/member/update", method = RequestMethod.POST)
	public String Handlemember_update(Model model,HttpServletRequest request) 
	{
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("sessionId");
		List<Member> results = memberDao.selectListAll(id);
		
		model.addAttribute("members", results);
		
		String member_id = request.getParameter("member_ID");
		String member_pw = request.getParameter("member_PW");
		String member_name = request.getParameter("member_name");
		String member_address = request.getParameter("member_address");
		String member_phone = request.getParameter("member_phone");
		
		System.out.print(member_id + member_pw + member_name + member_address + member_phone);
		
		memberDao.update(member_id, member_pw, member_name, member_address, member_phone);
		
		return "redirect:/member/update_success"; 
	}
	@RequestMapping( {"/member/update_success"} )
	public String member_update_success() 
	{
		return "member/member_update_success"; 
	}
	@RequestMapping( {"/member/create"} )
	public String member_create() 
	{
		return "member/member_create"; 
	}
	@RequestMapping(value ="/member/create", method = RequestMethod.POST)
	public String Handlemember_create(Model model,HttpServletRequest request) 
	{
		String member_id = request.getParameter("member_ID");
		String member_pw = request.getParameter("member_PW");
		String member_role = request.getParameter("member_role");
		String member_name = request.getParameter("member_name");
		String member_address = request.getParameter("member_address");
		String member_phone = request.getParameter("member_phone");
		
		//System.out.print(member_id + member_pw + member_role+member_name + member_address + member_phone);
		
		if (memberDao.is_ID_overlap(member_id)== true)
		{
			return "redirect:/member/create?error"; 
		}
		else
		{
			memberDao.insert(member_id, member_pw, member_role, member_name, member_address, member_phone);
			return "redirect:/member/create_success"; 
		}
	}
	
	@RequestMapping( {"/member/create_success"} )
	public String member_create_success() 
	{
		return "member/member_create_success"; 
	}
	@RequestMapping( {"/member/showlist"} )
	public String member_list(Model model) 
	{
		List<Member> memberList = memberDao.selectAll();
		model.addAttribute("members", memberList);
		return "member/member_showlist"; 
	}
	@RequestMapping( {"/member/remove"} )
	public String member_remove(Model model) 
	{
		List<Member> memberList = memberDao.selectAll();
		model.addAttribute("members", memberList);
		return "member/member_remove"; 
	}
	@RequestMapping(value ="/member/remove", method = RequestMethod.POST)
	public String Handlemember_remove(Model model, HttpServletRequest request)
	{
		String remove_id = request.getParameter("remove_ID");
		String is_remove = request.getParameter("is_remove");
		//System.out.println("remove_id:"+remove_id);
		
		if (remove_id != null)
		{
			List<Member> result = memberDao.selectListAll(remove_id);
			model.addAttribute("remove_members", result);
			remove_ID = remove_id;
		}
		if (is_remove != null && is_remove.equals("true"))
		{
			//System.out.print("remove_ID:"+remove_ID);
			memberDao.deleteById(remove_ID);
		}
		
		List<Member> memberList = memberDao.selectAll();
		model.addAttribute("members", memberList);
		
		return "member/member_remove"; 
	}
	
	///////////////////////////////////////////////////////////////////////////////////
	//stat
	@RequestMapping( {"/stat/home"} )
	public String stat_home(Model model) 
	{
		List<Recode> recodeList = recodeDao.selectListByNormal();
		model.addAttribute("recodes", recodeList);
		return "stat/stat_home"; 
	}
	
	/////////////////////////////////////////////////////
	//stat_date
	
	@RequestMapping( {"/stat/date_year"} )
	public String stat_date_year(Model model) 
	{
		List<Recode2> recodeList = recodeDao.statDate("year");
		model.addAttribute("recodes", recodeList);
		return "stat/stat_date_year"; 
	}
	@RequestMapping( {"/stat/date_month"} )
	public String stat_date_month(Model model) 
	{
		List<Recode2> recodeList = recodeDao.statDate("month");
		model.addAttribute("recodes", recodeList);
		return "stat/stat_date_month"; 
	}
	@RequestMapping( {"/stat/date_week"} )
	public String stat_date_week(Model model) 
	{
		List<Recode2> recodeList = recodeDao.statWeek();
		model.addAttribute("recodes", recodeList);
		return "stat/stat_date_week"; 
	}
	@RequestMapping( {"/stat/date_day"} )
	public String stat_date_day(Model model) 
	{
		List<Recode2> recodeList = recodeDao.statDate("day");
		model.addAttribute("recodes", recodeList);
		return "stat/stat_date_day"; 
	}
	
	
	@RequestMapping( {"/stat/sum_amount"} )
	public String stat_sum_amount(Model model) 
	{
		List<SumAmount> recodeList = recodeDao.groupingbyamount();
		model.addAttribute("sums", recodeList);
		return "stat/stat_sum_amount"; 
	}

	@RequestMapping( {"/stat/sum_total"} )
	public String stat_sum_total(Model model) 
	{
		List<SumAmount> recodeList = recodeDao.groupingbyTotal();
		model.addAttribute("sums", recodeList);
		return "stat/stat_sum_total"; 
	}
}	