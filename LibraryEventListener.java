
public interface LibraryEventListener {
	public void bookAdded(Book book);
	public void subtotaled(Money subtotal);
	public void totalled(Money total);
}
