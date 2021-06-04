
import java.util.Scanner;

public class student {
	
	//name, usn, branch, contact
	String name, usn, branch;
	int contact;
	
	public void getInfo()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Name: ");
		name = sc.nextLine();
		
		System.out.println("Enter USN: ");
		usn = sc.nextLine();
		
		System.out.println("Enter Branch: ");
		branch = sc.nextLine();
		
		System.out.println("Enter Contact No: ");
		contact = sc.nextInt();
	}
	
	public void dispInfo()
	{
		System.out.println("Name: " + name);
		System.out.println("USN: " + usn);
		System.out.println("Branch: " + branch);
		System.out.println("Contact: " + contact);
	}

	public static void main(String[] args) {
		
		int n, i;
				
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter number of students: ");
		n = sc.nextInt();
		
		student[] s = new student[n];
		
		for(i=0;i<n;i++)
		{
			s[i] = new student();
			s[i].getInfo();
		}
		
		for(i=0;i<n;i++)
		{
			System.out.println("\n\nStudent " + (i + 1) + " Details: ");
			s[i].dispInfo();
		}
	}
}
