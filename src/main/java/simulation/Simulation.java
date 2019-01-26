package simulation;

import storage.Pool;

public class Simulation implements Runnable {

    private volatile boolean run;

    private Pool pool;

    /**
     * Metoda run jest główną pętlą symulacji
     */
    public void run()
    {
        run = true;
        while(run)
        {

        }
    }

    public void setRun(boolean setVal)
    {
        run = setVal;
    }

    public void loadPool()
    {

    }

    public void restePool()
    {

    }

    public void savePool()
    {

    }
}
