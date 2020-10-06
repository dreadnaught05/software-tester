package org.ssdt.ohio.interview.softwaretester.payrollaccount;

import org.ssdt.ohio.interview.softwaretester.AbstractModelObject;
import org.ssdt.ohio.interview.softwaretester.constants.RateType;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.ssdt.ohio.interview.softwaretester.constants.AccountStatus.Active;

public class PayrollAccounts extends AbstractModelObject {

    private Set<Account> accounts;

    public PayrollAccounts() {
        super();
        this.accounts = new HashSet<>();
    }

    /**
     * Finds the Accounts who's status is Active and charge amount or percent is not equal to zero.
     *
     * @return filtered Set of active accounts
     */
    public Set<Account> findActivePayrollAccounts() {
        return getAccounts().stream()
                .filter( it -> (it.getStatus() == Active || !it.getChargeAmountOrPercent().equals(BigDecimal.ZERO)))
                .collect(Collectors.toSet());
    }

    /**
     * Validate the set of Accounts stored in this container.
     * A set of accounts containing Percentage Accounts is valid if and only if all Percentage accounts total 100.00%.
     *
     * A set of accounts containing only Fixed Accounts is always valid.
     *
     * @return the validity of a set of accounts
     */
    public boolean validatePayAccounts() {
        Set<Account> accounts = this.findActivePayrollAccounts().stream()
                .filter( it -> (it.getRateType() == RateType.Percent) )
                .collect(Collectors.toSet());
        if (!accounts.isEmpty()) {
            BigDecimal percentageAccountTotal = accounts.stream()
                    .map(Account::getChargeAmountOrPercent)
                    .reduce(BigDecimal::add)
                    .orElse(BigDecimal.ZERO);
            return percentageAccountTotal.equals(new BigDecimal("100.00"));
        }

        return true;
    }

    public void add(Account account) {
        account.setPayrollAccounts(this);
        this.accounts.add(account);
    }

    //Factories
    public static PayrollAccounts create() {
        return new PayrollAccounts();
    }

    //Getters and Setters
    public Set<Account> getAccounts() {
        return this.accounts;
    }

}
