import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class QuickSortRandom
{
  public static void main(String args[]) 
  {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter how many numbers: ");
    int n = sc.nextInt();

    int[] unsorted=new int[n];

    for(int i=0;i<n;i++)
    { 
      Random random = new Random();
      unsorted[i]=random.nextInt(5000);
    }

    System.out.println("Unsorted array :" + Arrays.toString(unsorted));

    QuickSortClass qs = new QuickSortClass();
    qs.sort(unsorted);
    
    System.out.println("Sorted array :" + Arrays.toString(unsorted));

    sc.close();
  }
}

class QuickSortClass 
{
  private int input[];
  private int length;
  long t1,t2,t;

  public void sort(int[] numbers) 
  {
    if (numbers == null || numbers.length == 0) 
    {
      return;
    }

    this.input = numbers;
    length = numbers.length;
    t1=System.currentTimeMillis();
    
    quickSort(0, length - 1);
    t2=System.currentTimeMillis();
    

    t=t2-t1;

    System.out.println("Time taken is to sort elements is "+ t);
  }
  /* * This method implements in-place quicksort algorithm recursively*/
  private void quickSort(int low, int high) 
  {
    int i = low;
    int j = high;
    int pivot = input[low + (high - low) / 2];

    // Divide into two arrays
    while (i <= j) 
    {
      while (input[i] < pivot) 
      {
        i++;
      }
      while (input[j] > pivot) 
      {
        j--;
      }
      if (i <= j) 
      {
        swap(i, j);
        // move index to next position on both sides
        i++;
        j--;
      }
    }
    // calls quickSort() method recursively
    if (low < j) 
    {
      quickSort(low, j);
    }
    if (i < high) 
    {
      quickSort(i, high);
    }
  }
  private void swap(int i, int j) 
  {
    int temp = input[i];
    input[i] = input[j];
    input[j] = temp;
  }
}