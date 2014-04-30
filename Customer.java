
public class Customer extends Thread{
	public CustomerSemaphore cs;
	public int demand;
	public int range;
	public Customer(CustomerSemaphore c, int r){
		this.cs = c;
		this.range = r;
		this.demand = (int)(Math.random()*range);
	}
	public void run(){

		while(true){
			if(cs.order(demand)){
				this.demand = (int)(Math.random()*range);
			}else{
				synchronized(cs){
					try{
						cs.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
				}
			}


		}
	}
}
