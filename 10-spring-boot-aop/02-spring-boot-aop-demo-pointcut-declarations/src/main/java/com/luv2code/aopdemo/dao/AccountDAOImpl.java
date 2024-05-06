package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.model.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO{

    private String name;
    private String serviceCode;

    @Override
    public void addAccount(Account pAccount, boolean pVipFlag) {
        System.out.println(getClass()+" Doing my DB work :: Adding account");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass()+" doWork()");
        return false;
    }

    public String getName() {
        System.out.println(getClass()+" getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass()+" setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass()+" getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass()+" setServiceCode()");
        this.serviceCode = serviceCode;
    }

    @Override
    public List<Account> findAccounts() {
        return  findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean pTripeWire) {
        if(pTripeWire){
            throw new RuntimeException("Wire is tripe!!!!");
        }
        List<Account> lAccounts = new ArrayList<Account>();
        Account lAccount1 = new Account("Ken","Gold");
        Account lAccount2 = new Account("Sam","Gold");
        Account lAccount3 = new Account("Ben","Platinum");
        lAccounts.add(lAccount1);
        lAccounts.add(lAccount2);
        lAccounts.add(lAccount3);
        return  lAccounts;
    }

}
