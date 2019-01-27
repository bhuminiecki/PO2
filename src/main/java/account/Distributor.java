package account;

import java.math.BigDecimal;
import simulation.Simulation;
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
    public Distributor(Simulation parent) {
        // Start of user code constructor for Distributor)
        super(parent);
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

    public void run()
    {
        while(super.getParentSimulation().isRun())
        {
            if(super.getParentSimulation().getCurrentDate().getDayOfMonth() == 1)
            {
                super.getParentSimulation().pay(monthlyCost);
            }
        }
    }
}
