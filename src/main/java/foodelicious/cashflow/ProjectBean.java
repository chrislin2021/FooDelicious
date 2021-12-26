package foodelicious.cashflow;

public class ProjectBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String member_id;
	private String order_id;
	private String product_name;
	private String product_sales_figures;
	private String product_price;
	private String product_total_price;
	private String order_date;
	private String order_state;
	
	

	public String getMember_id() {return member_id;}
	public String getOrder_id() {  return order_id;  }
	public String getProduct_name() {  return product_name;  }
	public String getProduct_sales_figures() { return product_sales_figures;  }
	public String getProduct_price() {  return product_price;  }
	public String getProduct_total_price() {  return product_total_price;  }
	public String getOrder_date() {  return order_date;  }
	public String getOrder_state() { return order_state;}
	
	public void setMember_id(String member_id) {this.member_id = member_id; }
	public void setOrder_id(String order_id) {  this.order_id = order_id;  }
	public void setProduct_name(String product_name) {  this.product_name = product_name;  }
	public void setProduct_sales_figures(String product_sales_figures) {  this.product_sales_figures= product_sales_figures;  }
	public void setProduct_price(String product_price) {  this.product_price = product_price;  }
	public void setProduct_total_price(String product_total_price) {  this.product_total_price= product_total_price;	}
	public void setOrder_date(String order_date) {  this.order_date= order_date;	}
	public void setOrder_state(String order_state) {this.order_state=order_state;}

		
	}
