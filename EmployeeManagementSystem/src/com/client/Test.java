package com.client;

import java.util.*;
import com.service.*;

public class Test {

	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		EmployeeInterface em = new EmployeeImplementation();
		
		char c;
		
		do
		{
			System.out.println("----------------------------------------");
			System.out.println("           1. Add Employee              ");
			System.out.println("           2. See Employee Detail       ");
			System.out.println("           3. Update Employee           ");
			System.out.println("           4. Delete Employee           ");
			System.out.println("----------------------------------------");
			
			System.out.println("Enter Choice : ");
			int ch = sc.nextInt();
			
			switch(ch)
			{
			case 1:
				em.addDetail();
				break;
				
			case 2:
				em.seeDetail();
				break;
				
			case 3:
				em.updateDetail();
				break;
				
			case 4:
				em.deleteDetail();
				break;
				
				default:
					System.out.println("What Are You Doing ");
			}
			
			System.out.println("If you want to continue Enter 'y' : ");
			c = sc.next().charAt(0);
		}
		while(c != 'n');
	}
}
