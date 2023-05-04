package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void shouldAddZeroToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                500,
                5_000,
                15
        );

        account.add(0);

        Assertions.assertEquals(500, account.getBalance());
    }

    @Test
    public void shouldNotAddNegativeBalance() {
        CreditAccount account = new CreditAccount(
                500,
                5_000,
                15
        );

        account.add(-1_000);

        Assertions.assertEquals(500, account.getBalance());
    }

    @Test
    public void enterZeroInitialBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void enterZeroCreditLimit() {
        CreditAccount account = new CreditAccount(
                500,
                0,
                15
        );

        Assertions.assertEquals(0, account.getCreditLimit());
    }

    @Test
    public void enterZeroRate() {
        CreditAccount account = new CreditAccount(
                500,
                5_000,
                0
        );

        Assertions.assertEquals(0, account.getRate());
    }

    @Test
    public void shouldBeThrowExceptionWhenNegativeBalance() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(-500, 5_000, 15);
        });
    }

    @Test
    public void shouldBeThrowExceptionWhenNegativeCreditLimit() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(500, -5_000, 15);
        });
    }

    @Test
    public void shouldBeThrowExceptionWhenNegativeRate() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(500, 5_000, -15);
        });
    }

    @Test
    public void shouldDecreaseBalanceWhenAmountPositive() {
        CreditAccount account = new CreditAccount(
                500,
                5_000,
                15
        );

        account.pay(200);

        Assertions.assertEquals(300, account.getBalance());
    }

    @Test
    public void shouldNotChangeBalanceWhenAmountZero() {
        CreditAccount account = new CreditAccount(
                500,
                5_000,
                15
        );

        account.pay(0);

        Assertions.assertEquals(500, account.getBalance());
    }

    @Test
    public void shouldZeroBalanceWhenSameAmount() {
        CreditAccount account = new CreditAccount(
                500,
                5_000,
                15
        );

        account.pay(500);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldDecreaseToMinusBalanceWhenAmountWithinLimit() {
        CreditAccount account = new CreditAccount(
                500,
                5_000,
                15
        );

        account.pay(1_000);

        Assertions.assertEquals(-500, account.getBalance());
    }

    @Test
    public void shouldDecreaseToMinusBalanceWhenAmountPlusBalanceEqualLimit() {
        CreditAccount account = new CreditAccount(
                500,
                5_000,
                15
        );

        account.pay(5_500);

        Assertions.assertEquals(-5_000, account.getBalance());
    }

    @Test
    public void shouldNotChangeBalanceWhenAmountPlusBalanceMoreThanLimit() {
        CreditAccount account = new CreditAccount(
                500,
                5_000,
                15
        );

        account.pay(8_000);

        Assertions.assertEquals(500, account.getBalance());
    }

    @Test
    public void shouldNotChangeBalanceWhenAmountNegative() {
        CreditAccount account = new CreditAccount(
                500,
                5_000,
                15
        );

        account.pay(-2_000);

        Assertions.assertEquals(500, account.getBalance());
    }

    @Test
    public void shouldNotCalculatePercentOnThePositiveBalance() {
        CreditAccount account = new CreditAccount(
                500,
                5_000,
                15
        );

        account.pay(200);

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void shouldNotCalculatePercentOnAZeroBalance() {
        CreditAccount account = new CreditAccount(
                500,
                5_000,
                15
        );

        account.pay(500);

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void shouldCalculatePercentOnTheNegativeBalance() {
        CreditAccount account = new CreditAccount(
                500,
                5_000,
                15
        );

        account.pay(1_500);

        Assertions.assertEquals(150, account.yearChange());
    }
}
