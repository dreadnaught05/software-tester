package org.ssdt.ohio.interview.softwaretester.payrollaccount;

import org.ssdt.ohio.interview.softwaretester.AbstractModelObject;
import org.ssdt.ohio.interview.softwaretester.constants.AccountStatus;
import org.ssdt.ohio.interview.softwaretester.constants.RateType;

import java.math.BigDecimal;

public class Account extends AbstractModelObject {

    private PayrollAccounts payrollAccounts;

    private AccountStatus status;

    private RateType rateType;

    private BigDecimal chargeAmountOrPercent;

    private String accountNumber;

    public Account() {
        super();
        this.status = AccountStatus.Active;
        this.rateType = RateType.Percent;
        this.chargeAmountOrPercent = BigDecimal.ZERO;
    }

    //Factories
    public static Account create() {
        return new Account();
    }

    //Getters and Setters
    public AccountStatus getStatus() {
        return this.status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
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
