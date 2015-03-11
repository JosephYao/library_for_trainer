import java.util.ArrayList;
import java.util.List;



public class Book {
	private String name;
	private Money price;
	
	public Book(String name, Money price) {
		this.name = name;
		this.price = price;
	}

	public Money getValue() {
		return price;
	}
	
	public String getDisplayLine() {
		return name + " " + price.asText();
	}

	public Money getPrice(List<Book> books) {
		return price;
	}

	public Money getPrice() {
		return getPrice(new ArrayList<Book>());
	}
	
	public Money getTaxedPrice(List<Book> books) {
		return getPrice(books);
	}

	public Money getTaxedPrice() {
		return getTaxedPrice(new ArrayList<Book>());
	}
	

	public String getName() {
		return name;
	}
	
}
