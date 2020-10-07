package org.ssdt.ohio.interview.softwaretester.payrollaccount;

import org.ssdt.ohio.interview.softwaretester.AbstractModelObject;
import org.ssdt.ohio.interview.softwaretester.constants.RateType;

import java.math.BigDecimal;

public class Account extends AbstractModelObject {

    private PayrollAccounts payrollAccounts;

    private boolean active;

    private RateType rateType;

    private BigDecimal chargeAmountOrPercent;

    private String accountNumber;

    public Account() {
        super();
        this.active = true;
        this.rateType = RateType.Percent;
        this.chargeAmountOrPercent = BigDecimal.ZERO;
    }

    //Factories
    public static Account create() {
        return new Account();
    }

    public static Account create(boolean active, RateType rateType, BigDecimal chargeAmountOrPercent, String accountNumber) {
        Account account = new Account();
        account.setActive(active);
        account.setRateType(rateType);
        account.setChargeAmountOrPercent(chargeAmountOrPercent);
        account.setAccountNumber(accountNumber);
        return account;
    }

    //Getters and Setters
    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public BigDecimal getChargeAmountOrPercent() {
        return chargeAmountOrPercent;
    }

    public void setChargeAmountOrPercent(BigDecimal chargeAmountOrPercent) {
        this.chargeAmountOrPercent = chargeAmountOrPercent;
    }

    public RateType getRateType() {
        return rateType;
    }

    public void setRateType(RateType rateType) {
        this.rateType = rateType;
    }

    public PayrollAccounts getPayrollAccounts() {
        return payrollAccounts;
    }

    public void setPayrollAccounts(PayrollAccounts payrollAccounts) {
        this.payrollAccounts = payrollAccounts;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
