import java.util.List;


public class Coupon extends Book {
	private Book bookFor;
	
	public Coupon(Book bookFor, Money amount) {
		super("Coupon for " + bookFor.getName(), amount.negate());
		this.bookFor = bookFor;
	}
	
	public Money getPrice(List<Book> books) {
		for(Book book : books) {
			if (book.getName().equals(bookFor.getName()))
			   return super.getPrice();
		}
		return new Money(0);
	}
	
	public Money getTaxedPrice(List<Book> books) {
		for(Book book : books) {
			if (book.getName().equals(bookFor.getName()))
					return super.getTaxedPrice();
		}
		return new Money(0);
		
	}
}
