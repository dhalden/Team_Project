
public class Main {
	public static void main(String[] args){
	    Clock clock = new Clock();
        Inventory inv = new Inventory(1000, 10);
        CustomerSemaphore cs = new CustomerSemaphore(20);
        Store store = new Store(inv, cs);
        Factory f1 = new Factory(clock, inv, 10);
        Factory f2 = new Factory(clock, inv, 20);
        Factory f3 = new Factory(clock, inv, 30);
        Factory f4 = new Factory(clock, inv, 40);
        Factory f5 = new Factory(clock, inv, 50);
        
        Customer c1 = new Customer(cs, 10);
        Customer c2 = new Customer(cs, 10);
        Customer c3 = new Customer(cs, 10);
        Customer c4 = new Customer(cs, 10);
        Customer c5 = new Customer(cs, 10);
        Customer c6 = new Customer(cs, 10);
        Customer c7 = new Customer(cs, 10);
        Customer c8 = new Customer(cs, 10);
        Customer c9 = new Customer(cs, 10);
        Customer c10 = new Customer(cs, 10);

        clock.start();
        store.start();
        f1.start();
        f2.start();
        f3.start();
        f4.start();
        f5.start();
        
        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
        c6.start();
        c7.start();
        c8.start();
        c9.start();
        c10.start();

	}
}
