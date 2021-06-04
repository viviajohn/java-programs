import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class MergeWithRandom 
{
  private int[] array;
  private int[] temp;
  private int length;

  public static void main(String a[])
  {
    Random random = new Random();
    Scanner scan = new Scanner( System.in );

    int l;
    long t1,t2,t;

    System.out.println("Enter number of integer elements");
    int n = scan.nextInt();
    
    int arr[] = new int[ n ];
    
    for (l = 0; l < n; l++)
      arr[l] = random.nextInt(5000);

    MergeWithRandom m = new MergeWithRandom();

    System.out.println("Unsorted Elements are :");
    for(int i : arr)
    {
      System.out.print(i);
      System.out.print(" ");
    }

    t1=System.currentTimeMillis();
    m.sort(arr);
    t2=System.currentTimeMillis();
    System.out.println();
    
    t=t2-t1;
    System.out.println("Time taken is to sort "+ n +"numbers is "+ t);
    System.out.println("Sorted Elements are :");
    for(int i:arr)
    {
      System.out.print(i);
      System.out.print(" ");
    }
  }


  public void sort(int inputArr[]) 
  {
    this.array = inputArr;
    this.length = inputArr.length;
    this.temp = new int[length];
    doMergeSort(0, length - 1);
  }

  private void doMergeSort(int low, int high) 
  {
    if (low < high) 
    {
      int middle = low + (high - low) / 2;
      
      doMergeSort(low, middle);
      
      doMergeSort(middle + 1, high);
      
      mergeParts(low, middle, high);
    }
  }

  private void mergeParts(int low, int middle, int high) 
  {
    for (int i = low; i <= high; i++) 
    {
      temp[i] = array[i];
    }

    int i = low;
    int j = middle + 1;
    int k = low;
    while (i <= middle && j <= high) 
    {
      if (temp[i] <= temp[j]) 
      {
        array[k] = temp[i];
        i++;
      } else 
      {
        array[k] = temp[j];
        j++;
      }
      k++;
    }
    while (i <= middle) {
    array[k] = temp[i];
    k++;
    i++;
    }
  }
}
