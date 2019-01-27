package entry;

import simulation.Simulation;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Discount implements Runnable, Serializable {

    private BigDecimal value;

    private Simulation parentSimulation;

    private LocalDate startDate;

    private LocalDate endDate;

    private Entry discountedRntry;

    public Discount(BigDecimal val, Simulation parent, LocalDate start, LocalDate end, Entry entry) {
        value = val;
        parentSimulation = parent;
        startDate = start;
        endDate = end;
        discountedRntry = entry;
    }

    public void run() {
        while(parentSimulation.getCurrentDate().isBefore(startDate));
        discountedRntry.setDiscount(value);
        while(parentSimulation.getCurrentDate().isBefore(endDate));
        discountedRntry.setDiscount(new BigDecimal(0));
    }
}
