import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


class FakeDisplay implements Display
{
	String lastShownLine;
	
	public void showLine(String line) {
		lastShownLine = line;
	}
}

class FakeListener implements LibraryEventListener
{
	Book lastBook;
	Money lastSubtotal;

	public void bookAdded(Book book) {
		lastBook = book;
	}

	public void totaled(Money total) {
		lastSubtotal = total;
	}

}

public class LibraryTest {
	FakeDisplay display;
	Monitor listener;
	Library library;

	@Before
	public void setUp() {
		display = new FakeDisplay();
		listener = new Monitor(display);
		library = new Library(listener);
	}
	
	@Test
	public void canAddTestDrivenDevelopmentByExample() {
		FakeListener listener = new FakeListener();
		library = new Library(listener);
		library.checkoutBook("0321146530");
		assertEquals(3835, listener.lastBook.getPrice().getCents());
		assertEquals("Test Driven Development By Example", listener.lastBook.getName());
	}
	
	@Test
	public void canAddRefactoring() {
		library.checkoutBook("0201485672");
		assertEquals("Refactoring $47.84", display.lastShownLine);
	}
	
	@Test
	public void canAddGoosBook() {
		library.checkoutBook("0321503627");
		assertEquals("Growing the Object Oriented Design, Guided by Test $47.98", display.lastShownLine);
	}
	
	@Test
	public void canSubtotalACheckout() {
		library.checkoutBook("0321146530");
		library.checkoutBook("0201485672");
		library.totalPrice();
		assertEquals("Subtotal $86.19", display.lastShownLine);
	}
    
    @Test
    public void total_on_not_existing_isbn() {
        library.checkoutBook("notExistingIsbn");
        library.totalPrice();
        assertEquals("Subtotal $0.00", display.lastShownLine);
    }

	@Test
	public void total_count_on_not_existing_isbn() {
		library.checkoutBook("notExistingIsbn");
		assertEquals(0, library.totalCount());
	}
}
