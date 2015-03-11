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
	Money lastTotal;
	
	public void bookAdded(Book book) {
		lastBook = book;
	}

	public void subtotaled(Money subtotal) {	
		lastSubtotal = subtotal;
	}

	public void totalled(Money total) {		
		lastTotal = total;
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
		library.addBook("1");
		assertEquals(150000, listener.lastBook.getPrice().getCents());
		assertEquals("Test Driven Development By Example", listener.lastBook.getName());
	}
	
	@Test
	public void canAddRefactoring() {
		library.addBook("3");
		assertEquals("Refactoring $70.00", display.lastShownLine);
	}
	
	@Test
	public void canAddGoosBook() {
		library.addBook("4");
		assertEquals("Growing the Object Oriented Design, Guided by Test $1,000.00", display.lastShownLine);
	}
	
	@Test
	public void canSubtotalASale() {
		library.addBook("1");
		library.addBook("3");
		library.subtotal();
		assertEquals("Subtotal $1,570.00", display.lastShownLine);	
	}
	
	@Test
	public void canTotalASale() {
		library.addBook("3");
		library.total();
		assertEquals("Total $70.00", display.lastShownLine);	
	}

}
