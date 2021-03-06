package simulation;

import account.Account;
import account.Distributor;
import account.User;
import entry.Discount;
import entry.Entry;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import storage.Pool;

import java.io.Serializable;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.util.*;

public class Simulation implements Runnable, Serializable {

    private volatile boolean run;

    private Pool pool;

    private ArrayList<Account> accounts = new ArrayList<Account>();

    private ArrayList<BigDecimal> tierCosts =
            new ArrayList<BigDecimal>(Arrays.asList(
                    new BigDecimal(0),
                    new BigDecimal(10),
                    new BigDecimal(20),
                    new BigDecimal(50)));

    private ArrayList<Discount> discounts = new ArrayList<Discount>();

    private Map<LocalDate, BigDecimal> data = new HashMap<LocalDate, BigDecimal>();

    private LocalDate startDate;

    private LocalDate currentDate;

    private int lossCounter = 0;

    private int probability = 10;

    private int maxUsers = 100;

    private int maxEntries = 1000;
    private volatile BigDecimal balance = new BigDecimal(0);

    public Simulation() {
        pool = new Pool(this);
    }

    @NotNull
    @Contract(" -> new")
    private static String getRandomString() {
        byte[] array = new byte[8];
        new Random().nextBytes(array);
        return new String(array, Charset.forName("UTF-8"));
    }

    /**
     * Metoda run jest główną pętlą symulacji
     * Program wykonuje 10 czynności dziennie
     * Ilość ta jest spowodowane potrzebą zapewnienia szybkiego działania symulacji
     */
    public void run() {
        Timer time;
        for (Account temp : accounts) {
            new Thread(temp).start();
        }
        for (Discount temp : discounts) {
            new Thread(temp).start();
        }
        currentDate = startDate;
        run = true;
        while (run) {
            for (int i = 0; i < 10; i++) {
                randomAction();
            }
            currentDate = currentDate.plusDays(1);
            if (currentDate.getDayOfMonth() == 1) {
                monthlyCheck();
            }
            try {
                Thread.sleep(500);
            }catch(InterruptedException x) {
                System.out.println(x.toString());
            }
        }
    }

    private void randomAction() {
        int choice = new Random().nextInt(10);
        if (pool.isEmpty()) choice = new Random().nextInt(3);
        switch (choice) {
            case 0:
                synchronized (pool) {
                    if (pool.sizeOf() < maxEntries)
                        pool.genRandomEvent();
                }
                break;
            case 1:
                synchronized (pool) {
                    if (pool.sizeOf() < maxEntries)
                        pool.genRandomMovie();
                }
                break;
            case 2:
                synchronized (pool) {
                    if (pool.sizeOf() < maxEntries)
                        pool.genRandomSeries();
                }
                break;
            case 3:
                LocalDate dDate = currentDate.plusDays(new Random().nextInt(100));
                createDiscount(pool.getRandomEntry(), dDate, dDate.plusDays(new Random().nextInt(20) + 20), new BigDecimal(new Random().nextDouble() * 0.45 + 0.05));
            default:
                    if (accounts.size() < maxUsers)
                        createRandomUser();
        }
    }

    public void createUser(String name, String psswd, String email, int tier) {
        Random generator = new Random();
        User temp = new User(this);
        temp.setUsername(name);
        temp.setEmail(email);
        temp.setPasswordHash(psswd);
        temp.setSubscriptionTier(tier);
        int tempID;
        do {
            tempID = generator.nextInt(maxUsers * 10);
        } while (existAccount(tempID));
        temp.setId(tempID);
        accounts.add(temp);
        new Thread(temp).start();
    }

    public void createDistributor(String name, String psswd, String email, BigDecimal payment, int account) {
        Random generator = new Random();
        Distributor temp = new Distributor(this);
        temp.setUsername(name);
        temp.setPasswordHash(psswd);
        temp.setEmail(email);
        temp.setAccountNumber(account);
        temp.setMonthlyCost(payment);
        int tempID;
        do {
            tempID = generator.nextInt(maxUsers * 10);
        } while (existAccount(tempID));
        temp.setId(tempID);
        accounts.add(temp);
        new Thread(temp).start();
    }

    private void createRandomUser() {
        createUser(getRandomString(), getRandomString(), getRandomString(), new Random().nextInt(4));
    }

    private void monthlyCheck() {
        checkBalance();
        data.put(currentDate, balance);
    }

    public void checkBalance() {
        if (balance.compareTo(new BigDecimal(0)) == -1) {
            lossCounter += 1;
            if (lossCounter > 3) {
                run = false;
            }
        } else {
            lossCounter = 0;
        }
    }

    public boolean isRun() {
        return run;
    }

    public void setRun(boolean setVal) {
        run = setVal;
    }

    public BigDecimal getSubCost(int tier) {
        return tierCosts.get(tier);
    }


    public void getPaid(BigDecimal ammount) {
        balance = balance.add(ammount);
    }

    public void pay(BigDecimal ammount) {
        balance = balance.subtract(ammount);
    }

    public LocalDate getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(LocalDate currentDate) {
        this.currentDate = currentDate;
    }

    public int getProbability() {
        return probability;
    }

    public void setProbability(int probability) {
        this.probability = probability;
    }

    public void addEntry(Entry newEntry) {
        pool.addEntry(newEntry);
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void createDiscount(Entry entry, LocalDate start, LocalDate finish, BigDecimal val) {
        Discount temp = new Discount(val, this, start, finish, entry);
        discounts.add(temp);
        new Thread(temp).start();
    }

    public boolean existAccount(int id) {
        return accounts.stream().anyMatch(x -> x.getId() == id);
    }

    public Pool getPool() {
        return pool;
    }

    public void setPool(Pool pool) {
        this.pool = pool;
    }

    public void setTierCosts(ArrayList<BigDecimal> tierCosts) {
        this.tierCosts = tierCosts;
    }

    public void setDiscounts(ArrayList<Discount> discounts) {
        this.discounts = discounts;
    }

    public void setLossCounter(int lossCounter) {
        this.lossCounter = lossCounter;
    }

    public void setMaxUsers(int maxUsers) {
        this.maxUsers = maxUsers;
    }

    public void setMaxEntries(int maxEntries) {
        this.maxEntries = maxEntries;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public Map<LocalDate, BigDecimal> getData() {
        return data;
    }

    public void setData(Map<LocalDate, BigDecimal> data) {
        this.data = data;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
