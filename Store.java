
public class Store extends Thread{
	public Inventory inv;
	public int demand;
	public CustomerSemaphore cs;

	public Store(Inventory i, CustomerSemaphore c){
		this.inv = i;
		this.cs = c;
		demand = 0;
	}

	public void sendEmail(){
		this.notifyAll();
	}
	
	public void run(){
		while(true){
			if(inv.getSupply()<=demand){
				
				synchronized(inv)
				{
					try {
						this.wait();
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					this.sendEmail();
				}
			}
			inv.sell(demand);
			
			demand = cs.getNextCustomerDemand();
		}
	}
}
