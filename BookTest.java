import org.junit.Test;

import static org.junit.Assert.assertEquals;



public class BookTest {
	
	@Test
	public void canGenerateDisplayLine() {
		assertEquals("Refactoring $70.00", new Book("Refactoring", new Money(7000)).getDisplayLine());
	}

}
