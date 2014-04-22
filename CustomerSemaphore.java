
public class CustomerSemaphore {
	public int[] cusDemand;
	public int start;
	public int end;
	
	public CustomerSemaphore(int c){
		start = 0;
		end = 0;
		cusDemand = new int[c];//c is the number of customers;
	}
	
	public int getNextCustomerDemand(){
		int d = 0;
		
		return d;
	}
}
