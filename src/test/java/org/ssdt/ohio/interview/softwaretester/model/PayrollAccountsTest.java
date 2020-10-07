package org.ssdt.ohio.interview.softwaretester.model;

import org.junit.jupiter.api.Test;
import org.ssdt.ohio.interview.softwaretester.constants.RateType;
import org.ssdt.ohio.interview.softwaretester.payrollaccount.Account;
import org.ssdt.ohio.interview.softwaretester.payrollaccount.PayrollAccounts;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class PayrollAccountsTest {

    @Test
    void testPayrollAccountsFactoryWithNoArgs() {
        PayrollAccounts payrollAccounts = PayrollAccounts.create();
        Account account = Account.create();
        payrollAccounts.add(account);

        assertTrue(account.isActive());
        assertEquals(account.getPayrollAccounts(), payrollAccounts);
        assertEquals(account.getChargeAmountOrPercent(), BigDecimal.ZERO);
        assertEquals(account.getRateType(), RateType.Percent);
    }

    @Test
    void testPayrollAccountsFactoryWithArgs() {
        PayrollAccounts payrollAccounts = PayrollAccounts.create();
        Account account = Account.create(true, RateType.Fixed, new BigDecimal("100.00"), "412001");
        payrollAccounts.add(account);

        assertTrue(account.isActive());
        assertEquals(account.getPayrollAccounts(), payrollAccounts);
        assertEquals(account.getChargeAmountOrPercent(), new BigDecimal("100.00"));
        assertEquals(account.getRateType(), RateType.Fixed);
        assertEquals(account.getAccountNumber(), "412001");
    }

    //TODO: Write unit test to verify findActiveAccounts filters different account sets correctly
    @Test
    void testFindActiveAccounts() {
        fail();
    }

    //TODO: Write unit tests to verify validate accounts method
    @Test
    void testValidateAccounts() {
        fail();
    }
}
