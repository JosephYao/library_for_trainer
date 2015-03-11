import java.util.ArrayList;


public class Library {
	private LibraryEventListener listener;
	private Warehouse warehouse = new Warehouse();
	private ArrayList<Book> books = new ArrayList<Book>();


	public Library(LibraryEventListener listener) {
		this.listener = listener;
	}

	public void checkoutBook(String isbn) {
		Book book = warehouse.bookForIsbn(isbn);

        if (book != null) {
            books.add(book);
            listener.bookAdded(book);
        }

	}

	public void totalPrice() {
		Money sum = new Money();
		for(Book book : books) {
			sum = sum.add(book.getPrice());
		}
		listener.totaled(sum);
	}
	
}


