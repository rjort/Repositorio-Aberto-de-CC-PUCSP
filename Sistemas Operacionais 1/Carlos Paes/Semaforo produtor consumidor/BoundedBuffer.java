
 
public class BoundedBuffer  
{     
   public BoundedBuffer()
   {
      // buffer is initially empty
      count = 0;
      in = 0;
      out = 0;
      
      buffer = new Object[BUFFER_SIZE];
   }

 // producer and consumer will call this to nap
   public static void napping() {
     int sleepTime = (int) (NAP_TIME * Math.random() );
     try { Thread.sleep(sleepTime*1000); }
     catch(InterruptedException e) { }
   }

   public void enter(Object item) {
           
      // add an item to the buffer
      ++count;
      buffer[in] = item;
      in = (in + 1) % BUFFER_SIZE;

	if (count == BUFFER_SIZE)
		System.out.println("Producer Entered " + item + " Buffer FULL");
	else
		System.out.println("Producer Entered " + item + " Buffer Size = " +  count);
      
     
   }
   
   // consumer calls this method
   public Object remove() {
      Object item;
      
      
      
      // remove an item from the buffer
      --count;
      item = buffer[out];
      out = (out + 1) % BUFFER_SIZE;
      
	if (count == 0)
		System.out.println("Consumer Consumed " + item + " Buffer EMPTY");
	else
		System.out.println("Consumer Consumed " + item + " Buffer Size = " + count);

     
      
      return item;
   }
   
   public int size() {
	   return BUFFER_SIZE;
   }
   
   public static final int    NAP_TIME = 5;
   private static final int   BUFFER_SIZE = 5;
    
   private int count; // number of items in the buffer
   private int in;   // points to the next free position in the buffer
   private int out;  // points to the next full position in the buffer
   private Object[] buffer;
}
