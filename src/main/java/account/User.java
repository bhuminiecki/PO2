package account;

import simulation.Simulation;

import java.math.BigDecimal;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of User.
 *
 * @author Wombat
 */
public class User extends Account {
    /**
     * Description of the property subscriptionTier.
     */
    private int subscriptionTier;

    /**
     * Description of the property cardNumber.
     */
    private int cardNumber;

    // Start of user code (user defined attributes for User)

    // End of user code

    /**
     * The constructor.
     */
    public User(Simulation parent) {
        // Start of user code constructor for User)
        super(parent);
        // End of user code
    }

    // Start of user code (user defined methods for User)

    // End of user code

    public void setSubscriptionTier(int subscriptionTier) {
        this.subscriptionTier = subscriptionTier;
    }

    /**
     * Returns subscriptionTier.
     *
     * @return subscriptionTier
     */
    public int getSubscriptionTier() {
        return this.subscriptionTier;
    }

    /**
     * Returns cardNumber.
     *
     * @return cardNumber
     */
    public int getCardNumber() {
        return this.cardNumber;
    }

    public void watch()
    {

    }

    public void run() {
        while(super.getParentSimulation().isRun()) {

        }
    }
}
