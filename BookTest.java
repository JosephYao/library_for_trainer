import static org.junit.Assert.assertEquals;

import org.junit.Test;



public class BookTest {
	
	@Test
	public void canGenerateDisplayLine() {
		assertEquals("Milk $70.00", new Book("Milk", new Money(7000)).getDisplayLine());
	}

}
