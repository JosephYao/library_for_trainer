import java.util.ArrayList;


public class Library {
	private LibraryEventListener listener;
	private Warehouse warehouse = new Warehouse();
	private ArrayList<Book> books = new ArrayList<Book>();


	public Library(LibraryEventListener listener) {
		this.listener = listener;
	}

	public void addBook(String isbn) {
		Book book = warehouse.bookForIsbn(isbn);
		books.add(book);
		
		listener.bookAdded(book);
	}

	public void subtotal() {
		Money sum = new Money();
		for(Book book : books) {
			sum = sum.add(book.getPrice(books));
		}
		listener.subtotaled(sum);
	}
	
	public void total() {
		Money sum = new Money();
		for(Book book : books) {
			sum = sum.add(book.getTaxedPrice(books));
		}
		listener.totalled(sum);	
	}
}


