class Monitor implements LibraryEventListener
{
	private Display display;
	
	public Monitor(Display display) {
		this.display = display;
	}
	
	public void bookAdded(Book book) {
		display.showLine(book.getDisplayLine());
	}

	public void totaled(Money total) {
		display.showLine("Subtotal " + total.asText());
	}
	
	public void totalled(Money total) {		
		display.showLine("Total " + total.asText());

	}
}
