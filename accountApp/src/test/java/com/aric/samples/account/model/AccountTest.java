package com.aric.samples.account.model;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;



/**
 * @author emre
 *
 */

public class AccountTest {

	@Rule
    public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void TestGetId() throws Exception{
		final Account account = new Account();
		account.setId(14);
		final long actual = account.getId();
		final long expected = 14;
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void TestGetBalance() throws Exception{
		final Account account = new Account();
		account.setBalance(1000);
		final double actual = account.getBalance();
		final double expected = 1000;
		Assert.assertEquals(expected, actual, 1000);
	}
	
	@Test
	public void TestGetOwnerTckn() throws Exception{
		final Account account = new Account();
		account.setOwnerTckn(1234567890);
		final long actual = account.getOwnerTckn();
		final long expected = 1234567890;
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void TestGetOwnerFirstName() throws Exception{
		final Account account = new Account();
		account.setOwnerFirstName("Emre");
		final String actual = account.getOwnerFirstName();
		final String expected = "Emre";
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void TestGetOwnerLastName() throws Exception{
		final Account account = new Account();
		account.setOwnerLastName("Kuru");
		final String actual = account.getOwnerLastName();
		final String expected = "Kuru";
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void TestDepositPositive() throws Exception{
		final Account account = new Account();
		account.setBalance(1000);
		account.deposit(2500);
		final double actual = account.getBalance();
		final double expected = 3500;
		Assert.assertEquals(expected, actual, 0);
	}
	
	@Test
	public void TestDepositNegative() throws Exception{
		final Account account = new Account();
		account.setBalance(1000);
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Amount should be a positive value");
		account.deposit(-1000);
		
		
	}

	@Test
	public void TestWithdrawGreaterBalance() throws Exception{
		final Account account = new Account();
		account.setBalance(1000);
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Amount cannot be greater than balance");
		account.withdraw(1500);
	
	}
	
	
	@Test
	public void TestWithdrawBalance() throws Exception{
		final Account account = new Account();
		account.setBalance(1000);
		account.withdraw(500);
		final double actual = account.getBalance();
		final double expected = 500;
		Assert.assertEquals(expected, actual, 0);
	}
	
}
