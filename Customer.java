
public class Customer extends Thread{
	public CustomerSemaphore cs;
    public int demand;
    public int range;
	public Customer(CustomerSemaphore c, int r){
		this.cs = c;
        this.demand = (int)(Math.random() * r);
	    range = r;
    }

    public void run()
    {
       while(true)
       {
       if(cs.order(demand))
       {
           this.demand = (int)(Math.random() * this.range);
       }
       else
           {
                synchronized(cs)
                {
                    try
                    {
                        cs.wait();
                    }
                    catch(InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }     
        } 
    }
}
