package org.bankapp.serviceimpl;

import org.bankapp.exceptions.InsufficientBalanceException;
import org.bankapp.exceptions.InvalidAmountException;
import org.bankapp.service.BankService;

public final class HDFCBankServiceImpl implements BankService {

	private double balance;
	
	@Override
	public void deposit(double amount) throws InvalidAmountException {
		
		if(amount<=0) {
			throw new InvalidAmountException(amount+" is invalid amount");
		}
		balance=balance+amount;
		
	}

	@Override
	public void withdraw(double amount) throws InvalidAmountException, InsufficientBalanceException {
		
		if(amount<=0) {
			throw new InvalidAmountException(amount+" is invalid amount");
		}
		else if(balance<amount) {
			throw new InsufficientBalanceException("Insufficient funds");
		}
		balance=balance-amount;
		
	}

	@Override
	public void balanceEnquiry() {
		
		System.out.println("Current Balance is::"+balance);
		
	}

}