package entry;

import java.math.BigDecimal;
import java.util.HashSet;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of Event.
 * 
 * @author Wombat
 */
public class Event extends Entry {
	/**
	 * Description of the property discount.
	 */
	private BigDecimal discount = null;
	
	// Start of user code (user defined attributes for Event)
	
	// End of user code
	
	/**
	 * The constructor.
	 */
	public Event() {
		// Start of user code constructor for Event)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for Event)

	// End of user code
	/**
	 * Returns discount.
	 * @return discount 
	 */
	public BigDecimal getDiscount() {
		return this.discount;
	}

}
