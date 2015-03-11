import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class Warehouse {
	private HashMap<String, Book> items = new HashMap<String, Book>();
	
	public Warehouse() {
        items.put("0321146530", new Book("Test Driven Development By Example", new Money(3835)));
		items.put("0201485672", new Book("Refactoring", new Money(4784)));
		items.put("0321503627", new Book("Growing the Object Oriented Design, Guided by Test", new Money(4798)));
	}

	public List<Book> bookForIsbn(String isbn) {
        if (!items.containsKey(isbn))
            return new ArrayList<Book>();

		return Arrays.asList(items.get(isbn));
	}

}
