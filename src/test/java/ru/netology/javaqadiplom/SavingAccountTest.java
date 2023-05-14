package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(5_000, account.getBalance());
    }
    @Test
    public void shouldAddMoreThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(9_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }
    @Test
    public void shouldAddThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(8_000);

        Assertions.assertEquals(10_000, account.getBalance());
    }
    @Test
    public void shouldAddZeroBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(0);

        Assertions.assertEquals(2_000, account.getBalance());
    }
    @Test
    public void shouldThrowExceptionNegativeBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(-250, 1_000, 10_000,5);
        });
    }
    @Test
    public void shouldMinBalanceGreaterMaxBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(2_000, 10_000, 1_000, 5);
        });
    }
    @Test
    public void shouldThrowExceptionNegativeRate() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(2_000, 1_000, 10_000,-5);
        });
    }
    @Test
    public void shouldReduceBalanceAmountIsPositive() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(500);

        Assertions.assertEquals(1_500, account.getBalance());
    }
    @Test
    public void shouldReduceBalanceAmountIsZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(0);

        Assertions.assertEquals(2_000, account.getBalance());
    }
    @Test
    public void shouldZeroBalanceWhenSameAmount() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(2_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }
    @Test
    public void shouldBalanceEqualMinBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        boolean result = account.pay(1_000);

        Assertions.assertEquals(1_000, account.getBalance());
        Assertions.assertEquals(true, result);
    }
    @Test
    public void shouldCalculatePercentOnThePositiveBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.yearChange();

        Assertions.assertEquals(100, account.yearChange());
    }

    @Test
    public void ifMinBalanceEqualZero() {
        SavingAccount account = new SavingAccount(
                0,
                0,
                10_000,
                5
        );

        Assertions.assertEquals(0, account.getMinBalance());
    }

    @Test
    public void ifMaxBalanceEqualZero() {
        SavingAccount account = new SavingAccount(
                0,
                0,
                0,
                5
        );

        Assertions.assertEquals(0, account.getMaxBalance());
    }
}
