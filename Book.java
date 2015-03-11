public class Book {
	private String name;
	private Money price;
	
	public Book(String name, Money price) {
		this.name = name;
		this.price = price;
	}

	public Money getPrice() {
		return price;
	}
	
	public String getDisplayLine() {
		return name + " " + price.asText();
	}

	public String getName() {
		return name;
	}
	
}
