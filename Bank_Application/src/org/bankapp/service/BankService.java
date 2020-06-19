package org.bankapp.service;

import org.bankapp.exceptions.InsufficientBalanceException;
import org.bankapp.exceptions.InvalidAmountException;

public interface BankService {

	public default void deposit(double amount) throws InvalidAmountException{};
	public default void withdraw(double amount) throws InvalidAmountException,InsufficientBalanceException {};
	public default void balanceEnquiry() {};
	
}