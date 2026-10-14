package com.service;

import java.util.*;

import com.model.Employee;


public class EmployeeImplementation implements EmployeeInterface{

	Scanner sc = new Scanner(System.in);
	List<Employee> el = new ArrayList<>();
	
	@Override
	public void addDetail() 
	{
		System.out.println("How Many Employee U Want to Enter : ");
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++)
		{
			Employee emp = new Employee();
			System.out.print("Enter Id : ");
			emp.setEmid(sc.nextInt());
			
			System.out.print("Enter Name : ");
			emp.setName(sc.next());
			
			System.out.print("Enter Salary : ");
			emp.setSalary(sc.nextFloat());
			
			System.out.print("Enter Mobile no : ");
			emp.setMob(sc.nextLong());
			
			System.out.println("----------------------------------------");
			
			el.add(emp);
		}
		
	}

	@Override
	public void seeDetail() 
	{
		Set<Employee> s = null;
		
		System.out.print("Do you want see Sorted Data if yes then type 'y' otherwise type 'n' : ");
		char ch = sc.next().charAt(0);
		
		if(ch == 'y')
		{
			System.out.println("----------------------------------------");
			System.out.println("              1. Sort by Id             ");
			System.out.println("              2. Sort by Name           ");
			System.out.println("              3. Sort by Salary         ");
			System.out.println("              4. Sort by Mobile No      ");
			System.out.println("----------------------------------------");

			System.out.print("Enter Choice : ");
			int cs = sc.nextInt();
			
			if(cs==1)
			{
				Comparator<Employee> crid =  Comparator.comparingInt(Employee::getEmid);
				
				s = new TreeSet<>(crid);
			}
			else if(cs==2)
			{
                Comparator<Employee> crnm =  Comparator.comparing(Employee::getName);
				
				s = new TreeSet<>(crnm);
			}
			else if(cs==3)
			{         
                Comparator<Employee> crsl =  Comparator.comparingDouble(Employee::getSalary);
				
				s = new TreeSet<>(crsl);
			}
			else if(cs==4)
			{
                Comparator<Employee> crmb =  Comparator.comparingLong(Employee::getMob);
				
				s = new TreeSet<>(crmb);
			}

            
			s.addAll(el);
			
			s.forEach((em)->{System.out.println("Id : "+em.getEmid());
			System.out.println("Name : "+em.getName());
			System.out.println("Salary : "+em.getSalary());
			System.out.println("Mobile no : "+em.getMob());
			System.out.println("----------------------------------------");
});
		}
		
		else
		{
			el.forEach((em)->{System.out.println("Id : "+em.getEmid());
			System.out.println("Name : "+em.getName());
			System.out.println("Salary : "+em.getSalary());
			System.out.println("Mobile no : "+em.getMob());
			System.out.println("----------------------------------------");
});
		}
		
		
	}

	@Override
	public void updateDetail() 
	{
		if(el.isEmpty())
		{
			System.out.println("No Record Founded...!");
		}
		else
		{
			System.out.println("----------------------------------------");

			System.out.println("Enter Id for Update Details : ");
			int targetId = sc.nextInt();
			
			Employee targetEmp = null;
			
			for(Employee emp : el)
			{
				if(emp.getEmid()==targetId)
				{
					targetEmp = emp;
					break;
				}
			}
			
			if(targetEmp == null)
			{
				System.out.println("Employee is Not Present...!");
				
			}
			else
			{
				System.out.println("----------------------------------------");
				System.out.println("              1. Update Name            ");
				System.out.println("              2. Update Salary          ");
				System.out.println("              3. Update Mobile No       ");
				System.out.println("----------------------------------------");
				
				System.out.println("Enter Your Choice : ");
				int ce = sc.nextInt();
				
				if(ce==1)
				{
					System.out.print("Enter Updated Name : ");
					targetEmp.setName(sc.next());
					System.out.println("----------------------------------------");

				}
				else if(ce==2)
				{
					System.out.println("Enter Updated Salary : ");
					targetEmp.setSalary(sc.nextFloat());
					System.out.println("----------------------------------------");

				}
				else if(ce==3)
				{
					System.out.println("Enter Updated Mobile no : ");
					targetEmp.setMob(sc.nextLong());
					System.out.println("----------------------------------------");

				}
			}
			
		}
		
		
	}

	@Override
	public void deleteDetail() 
	{
		if(el.isEmpty())
		{
			System.out.println("Nothing is Present in List...!");
		}
		else
		{
			System.out.print("Enter Id to Delete : ");
			int id = sc.nextInt();
			
			boolean remove = el.removeIf(emp-> emp.getEmid() == id);
			
			if(remove)
			{
				System.out.println("Record Deleted Successfully..!");
				System.out.println("----------------------------------------");
			}
		}
		
	}

}
