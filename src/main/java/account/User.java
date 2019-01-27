package account;

import simulation.Simulation;

import java.math.BigDecimal;
import java.util.Random;
import entry.*;
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

    private boolean paid = false;
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

    public BigDecimal monthlyPayment() {
        return super.getParentSimulation().getSubCost(subscriptionTier);
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
        synchronized (getParentSimulation().getPool()) {
            Entry wanted = getParentSimulation().getPool().getRandomEntry();
            if (!wanted.getReleaseDate().isBefore(getParentSimulation().getCurrentDate())) {
                if (!wanted.canWatchTier(this)) {
                    getParentSimulation().getPaid(getParentSimulation().getSubCost(subscriptionTier));
                }
            }
        }
    }

    public void run() {
        Random generator = new Random();
        synchronized (getParentSimulation()) {
            while (super.getParentSimulation().isRun()) {
                if (super.getParentSimulation().getCurrentDate().getDayOfMonth() == 1) {
                    if (!paid) {
                        super.getParentSimulation().getPaid(monthlyPayment());
                        paid = true;
                    }
                } else {
                    paid = false;
                }
                if (generator.nextInt(getParentSimulation().getProbability()) == 0) {
                    watch();
                }
            }
        }
    }
}
