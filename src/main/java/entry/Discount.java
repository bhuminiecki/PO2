package entry;

import simulation.Simulation;

import java.io.Serializable;
import java.time.LocalDate;

public class Discount implements Runnable, Serializable {

    private Simulation parentSimulation;

    private LocalDate startDate;

    private LocalDate endDate;

    private Entry discountedRntry;

    public Discount(Simulation parent, LocalDate start, LocalDate end, Entry entry) {
        parentSimulation = parent;
        startDate = start;
        endDate = end;
        discountedRntry = entry;
    }

    public void run() {

    }

}
