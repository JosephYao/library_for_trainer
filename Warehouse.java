import java.util.HashMap;


public class Warehouse {
	private HashMap<String, Book> items = new HashMap<String, Book>();
	
	public Warehouse() {
        items.put("1", new Book("Test Driven Development By Example", new Money(150000)));
		items.put("3", new Book("Refactoring", new Money(7000)));
		items.put("4", new Book("Growing the Object Oriented Design, Guided by Test", new Money(100000)));
	}

	public Book bookForIsbn(String isbn) {
		return items.get(isbn);
	}

}
