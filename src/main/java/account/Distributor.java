package account;

import simulation.Simulation;

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

    private boolean gotPaid = false;

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

    public void setMonthlyCost(BigDecimal monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    /**
     * Returns accountNumber.
     *
     * @return accountNumber
     */
    public int getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void run() {
        synchronized (getParentSimulation()) {
            while (super.getParentSimulation().isRun()) {
                if (super.getParentSimulation().getCurrentDate().getDayOfMonth() == 1) {
                    if (!gotPaid) {
                        super.getParentSimulation().pay(monthlyCost);
                        gotPaid = true;
                    }
                } else {
                    gotPaid = false;
                }
            }
        }
    }

    public void setGotPaid(boolean gotPaid) {
        this.gotPaid = gotPaid;
    }
}
