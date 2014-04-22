/*
 *  Authors: Yang Yu & Derek Halden
 *  Team: Dang
 *  Date: 4/15/14
 *  
 *  Class creates a "tick" every second on which the class will signal the 
 *  factories, and let them know to create an object.
 *
 */

public class Clock extends Thread
{
	public final int TICK = 1000;

	//default clock with a TICK of 1 second
	public Clock(){}

	//Class cares only about itself.Every second it returns itself
	public void run()
	{
		while(true) // We might want to make this something else?
		{
			synchronized(this)
			{
				try
				{
					this.sleep(TICK);
				}
				catch(InterruptedException e)
				{
					System.out.println("Error: Interrupted Exception " + e);
				}
				this.notifyAll();
			}   
		}
	}

}
