import java.util.Scanner;

class Staff {
  String StaffID, Name;
  int Contact;
  float Salary;

  Staff(String ID, String SName, int PNo, float Sal) {
    StaffID = ID;
    Name = SName;
    Contact = PNo;
    Salary = Sal;
  }

  public void dispInfo() {
    System.out.println("Staff Details are: ");
    System.out.println("Staff ID: " + StaffID );
    System.out.println("Staff Name: " + Name );
    System.out.println("Staff Contact: " + Contact );
    System.out.println("Salary: Rs. " + Salary );
  }
}

class TStaff extends Staff {
  String Dept;
  int NoP;

  TStaff(String ID, String SName, int PNo, float Sal, String Branch, int num) {
    super(ID, SName, PNo, Sal);
    Dept = Branch;
    NoP = num;
  }

  public void dispInfo() {
    super.dispInfo();

    System.out.println("Department: " + Dept );
    System.out.println("No. of Publications: " + NoP );
  }
}

class TechStaff extends Staff {
  String Skills;

  TechStaff(String ID, String SName, int PNo, float Sal, String TSkills) {
    super(ID, SName, PNo, Sal);
    Skills = TSkills;
  }

  public void dispInfo() {
    super.dispInfo();

    System.out.println("Skills: " + Skills );
  }
}

class ContractStaff extends Staff {
  float exp;

  ContractStaff(String ID, String SName, int PNo, float Sal, float period) {
    super(ID, SName, PNo, Sal);

    exp = period;
  }

  public void dispInfo() {
    super.dispInfo();

    System.out.println("Contract Period: " + exp );
  }
}

class StaffDet {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    String ID, SName, Branch, TSkills; 
    int PNo, num, n, i; 
    float Sal, period;

    System.out.println("Enter number of Staffs: ");
    n = sc.nextInt();

    System.out.println("Enter details for Teaching Staff: ");
    TStaff TS[] = new TStaff[n];

    for(i=0;i<n;i++) {
      System.out.println("Enter ID: ");
      ID = sc.next();
      System.out.println("Enter Name: ");
      SName = sc.next();
      System.out.println("Enter Contact Number: ");
      PNo = sc.nextInt();
      System.out.println("Enter Salary: ");
      Sal = sc.nextFloat();
      System.out.println("Enter Branch: ");
      Branch = sc.next();
      System.out.println("Enter Number of Publications: ");
      num = sc.nextInt();

      TS[i] = new TStaff(ID, SName, PNo, Sal, Branch, num);
    }

    System.out.println("Enter details for Technical Staff: ");
    TechStaff TE[] = new TechStaff[n];

    for(i=0;i<n;i++) {
      System.out.println("Enter ID: ");
      ID = sc.next();
      System.out.println("Enter Name: ");
      SName = sc.next();
      System.out.println("Enter Contact Number: ");
      PNo = sc.nextInt();
      System.out.println("Enter Salary: ");
      Sal = sc.nextFloat();
      System.out.println("Enter Skills: ");
      TSkills = sc.next();

      TE[i] = new TechStaff(ID, SName, PNo, Sal, TSkills);
    }


    System.out.println("Enter details for Contract Staff: ");
    ContractStaff CS[] = new ContractStaff[n];

    for(i=0;i<n;i++) {
      System.out.println("Enter ID: ");
      ID = sc.next();
      System.out.println("Enter Name: ");
      SName = sc.next();
      System.out.println("Enter Contact Number: ");
      PNo = sc.nextInt();
      System.out.println("Enter Salary: ");
      Sal = sc.nextFloat();
      System.out.println("Enter Contract Period: ");
      period = sc.nextFloat();

      CS[i] = new ContractStaff(ID, SName, PNo, Sal, period);
    }

    for(i=0;i<n;i++) {
      TS[i].dispInfo();
      TE[i].dispInfo();
      CS[i].dispInfo();
    }
  }
}