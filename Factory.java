/*
 *  Authors: Yang Yu & Derek Halden
 *  Team: Dang
 *  Date: 4/15/14
 *  
 * A factory thread that waits for a clock signal, and then it produces an
 * object and lets the store know that it has it.
 */
public class Factory extends Thread
{
    public Clock() clock;
    public int supply;
    public int maxSupply;
    //We are going to want an array of the 

    public void Factory(Clock() tick, int max)
    {
        this.clock = tick;
        this.maxSupply = max;
        this.supply = 0;
    }
    
    public void run()
    {
        //I'm just making these all "while(true)"s we can change them later
        while(true)
        {
            synchronized(clock)
            {
                this.wait();
            }
            this.produce();
            this.notifyStore();
        }

    }


    public void produce()
    {
        //This should probably syncrhonized on a shared variable for the
        //factories. For now each factory's supply will be synchronized on
        //itself
        synchronized(this)
        {
            if(supply < maxSupply)
            {
                supply++;
            }
        }
    }
    
    //Maybe we want to make a group object that signals the store when it's
    //ready instead of just sending a signal every time something is produced?
    public synchronized void notifyStore()
    {
        notify();
    }
    
}
