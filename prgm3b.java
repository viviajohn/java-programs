class Compute
{ 
  int n;
  int flag=0, flag1=0;
  synchronized void generate()
  { 
    while(flag==1 || flag1==1)
    { 
      try
      {
        wait();
      }
      catch(InterruptedException e)
      {
        System.out.println("Interrupted Exception caught");
      }
    }
    try
    {
      Thread.sleep(5000);
    }
    catch(InterruptedException e)
    {
      System.out.println("Interrupted Exception caught");
    }
    n = (int) (Math.random()*100+1);
    System.out.println("The random number generated is " + n);
    flag = flag1 = 1;
    notifyAll();
  }

  synchronized void square()
  { 
    while(flag==0)
    { 
      try
      {
        wait();
      }
      catch(InterruptedException e)
      {
        System.out.println("Interrupted Exception caught");
      }
    }
    System.out.println("Square of " +n + " is " + (n*n));
    flag = 0;
    notify();
  }

  synchronized void cube()
  { 
    while(flag1==0)
    { 
      try
      {
        wait();
      }
      catch(InterruptedException e)
      {
        System.out.println("Interrupted Exception caught");
      }
    }
    System.out.println("Cube of "+ n + " is " + (n*n*n));
    flag1=0;
    notify();
  }
}

public class prgm3b
{ 
  public static void main(String[] args)
  { 
    final Compute c = new Compute();
    new Thread()
    { 
      public void run()
      { 
        for(int i=1;i<=10;i++)
          c.generate();
      }
    }.start();
    
    new Thread()
    { 
      public void run()
      { 
        for(int i=1;i<=10;i++)
          c.square();
      }
    }.start();
    
    new Thread()
    { 
      public void run()
      { 
        for(int i=1;i<=10;i++)
          c.cube();
      }
    }.start();
  }
}