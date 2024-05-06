package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.model.Account;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO pAccountDAO, MembershipDAO pMembershipDAO){
		return runner -> {
			demoTheBeforeAdvice(pAccountDAO, pMembershipDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO pAccountDAO, MembershipDAO pMembershipDAO) {
		Account lAccount = new Account();
		pAccountDAO.addAccount(lAccount, true);
		pAccountDAO.doWork();

		pMembershipDAO.addPrimeMember();
		pMembershipDAO.goToSleep();

		//System.out.println("calling method again!");

		//pAccountDAO.addAccount();
	}

}
