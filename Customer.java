
public class Customer extends Thread{
	public CustomerSemaphore cs;
	public Customer(CustomerSemaphore c){
		this.cs = c;
	}
}
