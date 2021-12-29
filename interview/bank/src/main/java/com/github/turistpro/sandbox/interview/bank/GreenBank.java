package com.github.turistpro.sandbox.interview.bank;

public class GreenBank extends Bank {
    public Office buildOffice() {
        OfficeBuilder builder = new SomeBuildingCompany();
        return builder.use(staff).buildOffice();
    }

    public BankInfo generateBankInfo() {
        BankInfo bankInfo = super.generateBankInfo();
        notifyEmail(Config.getAdminEmail());

        return bankInfo;
    }
}