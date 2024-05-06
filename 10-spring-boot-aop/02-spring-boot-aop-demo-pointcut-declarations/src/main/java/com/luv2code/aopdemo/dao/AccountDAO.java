package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.model.Account;

import java.util.List;

public interface AccountDAO {
    void addAccount(Account pAccount, boolean pVipFlag);

    boolean doWork();

    public String getName();

    public void setName(String name);

    public String getServiceCode();

    public void setServiceCode(String serviceCode);

    List<Account> findAccounts();

    List<Account> findAccounts(boolean pTripeWire);

}
