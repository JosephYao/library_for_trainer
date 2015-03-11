import java.util.HashMap;


public class Warehouse {
	private HashMap<String, Book> items = new HashMap<String, Book>();
	
	public Warehouse() {
		Book milk = new Book("Milk", new Money(7000));
		items.put("1", new Book("Preserved Duck Eggs", new Money(150000)));
		items.put("3", milk);
		items.put("4", new Book("Growing the Object Oriented Design, Guided by Test", new Money(100000)));
	}

	public Book bookForIsbn(String barcode) {
		return items.get(barcode);
	}

}
