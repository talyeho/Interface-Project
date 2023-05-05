package logic;

public class Item {
	private String category;
	private String subcategory;
	private int itemID;
	private int restaurantID;
	private String name;
	private float price;
	private String description;
	private String ingrediants;
	private String photo;
	private int amount;

	public Item(String category, String subcategory, int itemID, int restaurantID, String name, float price,
			String description, String ingrediants, String photo, int amount) {
		this.category = category;
		this.subcategory = subcategory;
		this.itemID = itemID;
		this.restaurantID = restaurantID;
		this.name = name;
		this.price = price;
		this.description = description;
		this.ingrediants = ingrediants;
		this.photo = photo;
		this.amount = amount;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public int getRestaurantID() {
		return restaurantID;
	}

	public void setRestaurantID(int restaurantID) {
		this.restaurantID = restaurantID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIngrediants() {
		return ingrediants;
	}

	public void setIngrediants(String ingrediants) {
		this.ingrediants = ingrediants;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
