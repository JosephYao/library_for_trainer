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
		library.checkoutBook("1");
		assertEquals(150000, listener.lastBook.getPrice().getCents());
		assertEquals("Test Driven Development By Example", listener.lastBook.getName());
	}
	
	@Test
	public void canAddRefactoring() {
		library.checkoutBook("3");
		assertEquals("Refactoring $70.00", display.lastShownLine);
	}
	
	@Test
	public void canAddGoosBook() {
		library.checkoutBook("4");
		assertEquals("Growing the Object Oriented Design, Guided by Test $1,000.00", display.lastShownLine);
	}
	
	@Test
	public void canSubtotalACheckout() {
		library.checkoutBook("1");
		library.checkoutBook("3");
		library.totalPrice();
		assertEquals("Subtotal $1,570.00", display.lastShownLine);	
	}
	
}
