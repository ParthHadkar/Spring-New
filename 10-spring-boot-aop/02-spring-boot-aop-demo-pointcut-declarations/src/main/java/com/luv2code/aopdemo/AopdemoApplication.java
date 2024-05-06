package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.model.Account;
import com.luv2code.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO pAccountDAO, MembershipDAO pMembershipDAO,
											   TrafficFortuneService pTrafficFortuneService){
		return runner -> {
			//demoTheBeforeAdvice(pAccountDAO, pMembershipDAO);
			//demoTheAfterReturningAdvice(pAccountDAO);
			//demoTheAfterThrowingAdvice(pAccountDAO);
			//demoTheAfterAdvice(pAccountDAO);
			//demoTheAroundAdvice(pTrafficFortuneService);
			//demoTheAroundAdviceHandleException(pTrafficFortuneService);
			demoTheAroundAdviceRethrowException(pTrafficFortuneService);
		};
	}

	private void demoTheAroundAdviceRethrowException(TrafficFortuneService pTrafficFortuneService) {
		System.out.println("\nMain Program: demoTheAroundAdviceRethrowException");
		System.out.println("Calling getFortune()");
		boolean lTripeWire = true;
		String lFortune = pTrafficFortuneService.getFortune(lTripeWire);
		System.out.println("\nMy fortune :: "+lFortune);
		System.out.println("Finished!!!!");

	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService pTrafficFortuneService) {
		System.out.println("\nMain Program: demoTheAroundAdviceHandleException");
		System.out.println("Calling getFortune()");
		boolean lTripeWire = true;
		String lFortune = pTrafficFortuneService.getFortune(lTripeWire);
		System.out.println("\nMy fortune :: "+lFortune);
		System.out.println("Finished!!!!");

	}
	private void demoTheAroundAdvice(TrafficFortuneService pTrafficFortuneService) {
		System.out.println("\nMain Program: demoTheAroundAdvice");
		System.out.println("Calling getFortune()");
		String lFortune = pTrafficFortuneService.getFortune();
		System.out.println("\nMy fortune :: "+lFortune);
		System.out.println("Finished!!!!");

	}

	private void demoTheAfterAdvice(AccountDAO pAccountDAO) {
		List<Account> lAccounts = null;

		try{
			boolean lTripeWire = false;
			lAccounts = pAccountDAO.findAccounts(lTripeWire);
		} catch (Exception e){
			System.out.println("\n\nMain Program :: Exception oocur :: "+e);
		}

		System.out.println("\n\nMain Program :: demoTheAfterReturningAdvice");
		System.out.println("-----");
		System.out.println("lAccounts :: "+lAccounts);
		System.out.println("\nDone!!!!\n");
	}

	private void demoTheAfterThrowingAdvice(AccountDAO pAccountDAO) {
		List<Account> lAccounts = null;

		try{
			boolean lTripeWire = true;
			lAccounts = pAccountDAO.findAccounts(lTripeWire);
		} catch (Exception e){
			System.out.println("\n\nMain Program :: Exception oocur :: "+e);
		}

		System.out.println("\n\nMain Program :: demoTheAfterReturningAdvice");
		System.out.println("-----");
		System.out.println("lAccounts :: "+lAccounts);
		System.out.println("\nDone!!!!\n");
	}

	private void demoTheAfterReturningAdvice(AccountDAO pAccountDAO) {
		List<Account> lAccounts = pAccountDAO.findAccounts();

		System.out.println("\n\nMain Program :: demoTheAfterReturningAdvice");
		System.out.println("-----");
		System.out.println("lAccounts :: "+lAccounts);
		System.out.println("\nDone!!!!\n");
	}

	private void demoTheBeforeAdvice(AccountDAO pAccountDAO, MembershipDAO pMembershipDAO) {
		Account lAccount = new Account();
		lAccount.setName("Test");
		lAccount.setLevel("Test12");
		pAccountDAO.addAccount(lAccount, true);
		pAccountDAO.doWork();

		pAccountDAO.setName("Test");
		pAccountDAO.setServiceCode("Test12");

		String lName = pAccountDAO.getName();
		String lServiceCode = pAccountDAO.getServiceCode();

		pMembershipDAO.addPrimeMember();
		pMembershipDAO.goToSleep();

		//System.out.println("calling method again!");l

		//pAccountDAO.addAccount();
	}

}
