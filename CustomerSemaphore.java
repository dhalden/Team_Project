
public class CustomerSemaphore {
	public int[] cusDemand;
	public int start;
	public int end;

	public CustomerSemaphore(int c){
		start = 0;
		end = 0;
		cusDemand = new int[c];//c is the number of customers;
	}

	public void sendEmail(){
		this.notifyAll();
	}
	public int fillOrder(){
		int d = 0;
		if(getLength() == 0){
			return 0;
		}else{
			synchronized(this){
				notify();
				d = cusDemand[start];
				start++;
				start %= cusDemand.length;
				return d;
			}
		}
	}

	public synchronized boolean order(int d){
		if(getLength() != cusDemand.length){
			cusDemand[end] = d;
			end++;
			end %= cusDemand.length;
			return true;
		}else{
			return false;
		}
	}

	public synchronized int getLength(){
		return (end-start)%cusDemand.length+1;
	}

}
