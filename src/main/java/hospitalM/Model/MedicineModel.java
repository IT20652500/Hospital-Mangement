package hospitalM.Model;

public class MedicineModel {
	private int id;
	private String name;
	private int avl_stock;
	private String category;
	private float price;
	private int quantity;
	private String expdate;
	private String fabDate;
	private String company;
	
	public MedicineModel() {
		super();
	}


	public String getExpdate() {
		return expdate;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	public void setExpdate(String expdate) {
		this.expdate = expdate;
	}


	public String getFabDate() {
		return fabDate;
	}


	public void setFabDate(String fabDate) {
		this.fabDate = fabDate;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAvl_stock() {
		return avl_stock;
	}


	public void setAvl_stock(int avl_stock) {
		this.avl_stock = avl_stock;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}
