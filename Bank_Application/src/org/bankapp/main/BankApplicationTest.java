package org.bankapp.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.bankapp.exceptions.InsufficientBalanceException;
import org.bankapp.exceptions.InvalidAmountException;
import org.bankapp.factory.BankServiceFactory;
import org.bankapp.service.BankService;

public class BankApplicationTest {

	public static void main(String[] args) {
		
		//declaring local variables
		BankService acc=null;
		BufferedReader br=null;
		String option=null;
		
		try {
			//get instance of serviceImpl class
			acc=BankServiceFactory.getInstance();
			//instantiating BufferedReader
			br=new BufferedReader(new InputStreamReader(System.in));
			
			do {
				try {
					System.out.println("Choose an option::");
					System.out.println("1.Deposit");
					System.out.println("2.Withdraw");
					System.out.println("3.Balance Enquiry");
					System.out.println("Enter option::");
					option=br.readLine();
					
					switch(option) {
						case"1":{
							System.out.println("Enter deposit Amount::");
							String s=br.readLine();
							double amt=Double.parseDouble(s);
							
							acc.deposit(amt);
							acc.balanceEnquiry();
							break;
						}//case 1
						case"2":{
							System.out.println("Enter amount to withdraw::");
							String s=br.readLine();
							double amt=Double.parseDouble(s);
							
							acc.withdraw(amt);
							acc.balanceEnquiry();
							break;
						}
						case"3":{
							acc.balanceEnquiry();
							break;
						}
						default:
							System.out.println("Invalid option");
					}//switch
				}//inner try
				catch(InvalidAmountException iae) {
					System.out.println(iae.getMessage());
				}
				catch(InsufficientBalanceException ise) {
					System.out.println(ise.getMessage());
				}
				catch(NumberFormatException nfe) {
					nfe.printStackTrace();
				}
				System.out.println("Do you want to continue(YES/NO)??");
				option=br.readLine();
			}//do
			while(option.equalsIgnoreCase("yes"));
			System.out.println("Thank You! Happy Banking");
		}//outer try
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			acc=null;
			try {
				if(br!=null)
					br.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}//finally
		
	}//main
	
}//class