import static org.junit.Assert.*;

import org.junit.Test;



public class CouponTest {
	@Test
	public void canGetCouponsInformation() {
		Coupon coupon = new Coupon(new Book("Milk", new Money(100)), new Money(10));
		
		assertEquals("($0.10)", coupon.getValue().asText());	
		assertEquals("Coupon for Milk", coupon.getName());	
	}

}
