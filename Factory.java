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
	public Inventory inv;
	public Clock clock;
	public int base;
	//We are going to want an array of the 

	public void Factory(Clock tick, Inventory i, int b)
	{
		this.clock = tick;
		this.inv = i;
		this.base = b;
	}

	public void run()
	{
		//I'm just making these all "while(true)"s we can change them later
		while(true)
		{
			synchronized(clock)
			{
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			inv.stockUp(produce());
		}
	}


	public int produce()
	{
		/*
		 * producing some amount of goods.
		 */
		int r = 0;
		synchronized(inv)
		{
			r = base+(int)(inv.getDiff()*Math.random()); //make sure r is not negative
		}
		return r;
	}
}
