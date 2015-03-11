import java.util.ArrayList;
import java.util.List;


public class Library {
	private LibraryEventListener listener;
	private Warehouse warehouse = new Warehouse();
	private ArrayList<Book> books = new ArrayList<Book>();


	public Library(LibraryEventListener listener) {
		this.listener = listener;
	}

	public void checkoutBook(String isbn) {
		List<Book> book = warehouse.bookForIsbn(isbn);

        for (Book onlyOne : book) {
            books.add(onlyOne);
            listener.bookAdded(onlyOne);
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


