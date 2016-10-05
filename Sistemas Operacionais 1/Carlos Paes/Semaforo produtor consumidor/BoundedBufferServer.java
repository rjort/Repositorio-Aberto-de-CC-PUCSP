

public class BoundedBufferServer
{
	public static void main(String args[]) {
		BoundedBuffer server = new BoundedBuffer();

		   	Semaforo mutex = new Semaforo(1);
		   	Semaforo empty = new Semaforo(server.size());
   	   		Semaforo full  = new Semaforo(0);
		    // now create the producer and consumer threads
      		Producer producerThread = new Producer(server,mutex,empty,full);
      		Consumer consumerThread = new Consumer(server,mutex,empty,full);
      		
     		
      		producerThread.start();
      		consumerThread.start();               
	}
}
