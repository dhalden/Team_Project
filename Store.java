
public class Store extends Thread{
	public Inventory inv;
	public int demand;
	public CustomerSemaphore cs;

	public Store(Inventory i, CustomerSemaphore c){
		this.inv = i;
		this.cs = c;
		demand = 0;
	}

	
	
	public void run(){
		while(true){
			if(inv.getSupply()<=demand){
				
				synchronized(inv)
				{
					try {
					inv.wait();
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
					cs.sendEmail();
				}
			}
			inv.sell(demand);
			
			demand = cs.fillOrder();
		}
	}
}
