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

    private Entry discountedEntry;

    public Discount(BigDecimal val, Simulation parent, LocalDate start, LocalDate end, Entry entry) {
        value = val;
        parentSimulation = parent;
        startDate = start;
        endDate = end;
        discountedEntry = entry;
    }

    public void run() {
        while(parentSimulation.getCurrentDate().isBefore(startDate));
        discountedEntry.setDiscount(value);
        while(parentSimulation.getCurrentDate().isBefore(endDate));
        discountedEntry.setDiscount(new BigDecimal(0));
    }
}
