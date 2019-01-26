package account;

import java.math.BigDecimal;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of Distributor.
 *
 * @author Wombat
 */
public class Distributor extends Account {
    /**
     * Description of the property monthlyCost.
     */
    private BigDecimal monthlyCost;

    /**
     * Description of the property accountNumber.
     */
    private int accountNumber;

    // Start of user code (user defined attributes for Distributor)

    // End of user code

    /**
     * The constructor.
     */
    public Distributor() {
        // Start of user code constructor for Distributor)
        super();
        // End of user code
    }

    // Start of user code (user defined methods for Distributor)

    // End of user code

    /**
     * Returns monthlyCost.
     *
     * @return monthlyCost
     */
    public BigDecimal getMonthlyCost() {
        return this.monthlyCost;
    }

    /**
     * Returns accountNumber.
     *
     * @return accountNumber
     */
    public int getAccountNumber() {
        return this.accountNumber;
    }

}
