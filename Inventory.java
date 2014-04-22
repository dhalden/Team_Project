public class Inventory {
	private int currSupply;
	private int maxSupply;
	private int minLimit;
	
	public Inventory(int max, int min){
		maxSupply = max;
		minLimit = min;
		currSupply = 0;
	}
	
	public synchronized void stockUp(int r){
		/*
		 * Increment currSupply by amount produced
		 * or the difference between max and curr if there is a chance to 
		 * go over max.
		 */
		if(currSupply+r>maxSupply)
			currSupply = maxSupply;
		else
			currSupply += r;
		
		/*
		 * signaling the store 
		 * when the inventory is over minLimit
		 */
		if(currSupply>=minLimit)
			this.notify(); 
	}
	
	public synchronized void sell(int s){
		currSupply -= s;
	}
	
	public int getMax(){
		return maxSupply;
	}
	
	public int getSupply(){
		return currSupply;
	}
	
	public synchronized int getDiff(){
		return minLimit - currSupply;
	}
}
