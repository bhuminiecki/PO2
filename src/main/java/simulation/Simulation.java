package simulation;

import account.*;
import entry.Discount;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import storage.Pool;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.nio.charset.Charset;
import java.util.Timer;

public class Simulation implements Runnable, Serializable {

    private volatile boolean run;

    private Pool pool;

    private ArrayList<Account> accounts = new ArrayList<Account>();

    private ArrayList<BigDecimal> tierCosts = new ArrayList<BigDecimal>();

    private ArrayList<Discount> discounts = new ArrayList<Discount>();

    private LocalDate startDate;

    private LocalDate currentDate;

    private int lossCounter = 0;

    private int probability;

    private volatile BigDecimal balance;
    /**
     * Metoda run jest główną pętlą symulacji
     * Program wykonuje 10 czynności dziennie
     * Ilość ta jest spowodowane potrzebą zapewnienia szybkiego działania symulacji
     */
    public void run() {
        Timer time;
        for(Account temp : accounts){
            temp.run();
        }
        for(Discount temp : discounts){
            temp.run();
        }
        run = true;
        while(run) {
            for(int i = 0; i<10; i++) {
                randomAction();
            }
            currentDate.plusDays(1);
            if(currentDate.getDayOfMonth() == 1) {
                monthlyCheck();
            }
        }
    }

    @NotNull
    @Contract(" -> new")
    private String getRandomString() {
        byte[] array = new byte[8];
        new Random().nextBytes(array);
        return new String(array, Charset.forName("UTF-8"));
    }

    private void randomAction() {

    }

    public void createUser(String name, String psswd, String email, int tier) {
        User temp = new User(this);
        temp.setUsername(name);
        temp.setEmail(email);
        temp.setPasswordHash(psswd);
        temp.setSubscriptionTier(tier);
    }

    private void createRandomUser() {
        createUser(getRandomString(),getRandomString(),getRandomString(),new Random().nextInt(4));
    }

    private void monthlyCheck() {
        checkBalance();
    }

    public void checkBalance() {
        if (balance.compareTo(new BigDecimal(0)) == -1){
            lossCounter += 1;
            if(lossCounter>3){
                run = false;
            }
        } else {
            lossCounter = 0;
        }
    }

    public void setRun(boolean setVal) {
        run = setVal;
    }

    public boolean isRun() {
        return run;
    }

    public BigDecimal getSubCost(int tier) {
        return tierCosts.get(tier);
    }


    public void getPaid(BigDecimal ammount) {
        balance.add(ammount);
    }

    public void pay(BigDecimal ammount) {
        balance.subtract(ammount);
    }

    public LocalDate getCurrentDate() {
        return currentDate;
    }

    public int getProbability() {
        return probability;
    }

    public void setProbability(int probability) {
        this.probability = probability;
    }
}
