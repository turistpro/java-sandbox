package com.github.turistpro.sandbox.interview.bank;

import java.util.List;

public abstract class Bank {
    protected Office office = buildOffice();
    protected List<Employee> staff = Staff.hireEmployees();

    public void transfer(Client a, Client b, double amount, String currency) {
        a.documents.passport.seriesAndNumber.validate();

        if (a.type == "type1") {
            // do something
        } else if (a.type == "type2") {
            // do another thing
        } else if (a.type == "type3") {
            // do other thing
        }

        // ...
    }

    public abstract Office buildOffice();

    // invoked on every frame update on UI
    public UIBankInfo render() {
        UIBankInfo bankInfoFrame = new UIBankInfo();
        bankInfoFrame.setBankInfo(generateBankInfo());
        // ...

        return bankInfoFrame;
    }

    public BankInfo generateBankInfo() {
        BankInfo bankInfo = new BankInfo();
        // ...

        return bankInfo;
    }

    protected void notifyEmail(String email) {

    }
}