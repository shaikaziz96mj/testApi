package org.bankapp.factory;

import org.bankapp.service.BankService;
import org.bankapp.serviceimpl.HDFCBankServiceImpl;

public class BankServiceFactory {

	public static BankService getInstance() {
		return new HDFCBankServiceImpl();
	}
	
}	