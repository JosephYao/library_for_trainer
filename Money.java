import java.text.NumberFormat;
import java.util.Locale;

public class Money {
	private int valueInCents = 0;
	
	public Money(int valueInCents) {
		this.valueInCents = valueInCents;
	}

	public Money() {
	}

	public String asText() {
		return NumberFormat.getCurrencyInstance(Locale.US).format(valueInCents / 100.0);
	}

	public Money add(Money money) {
		return new Money(money.valueInCents + valueInCents);
	}

	public int getCents() {
		return valueInCents;
	}

	public Money negate() {
		return new Money(-valueInCents);
	}

}
