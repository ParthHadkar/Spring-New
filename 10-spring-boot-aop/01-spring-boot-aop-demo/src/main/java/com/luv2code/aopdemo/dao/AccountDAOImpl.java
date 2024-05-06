package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.model.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{
    @Override
    public void addAccount(Account pAccount, boolean pVipFlag) {
        System.out.println(getClass()+" Doing my DB work :: Adding account");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass()+" doWork()");
        return false;
    }

}
