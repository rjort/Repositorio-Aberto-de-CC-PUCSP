public class Semaforo {

  public Semaforo() {
      value = 0;
  }

  public Semaforo(int v) {
      value = v;
  }

  public synchronized void P() {
     while (value <= 0) {
       try {
         wait();
       }
       catch (InterruptedException e) { }
     }
     value --;
  }

  public synchronized void V() {
    ++value;
    notify();
  }

  private int value;
}