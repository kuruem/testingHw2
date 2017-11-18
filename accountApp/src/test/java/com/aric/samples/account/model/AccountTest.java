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
	public void getIdTest() throws Exception{
		final Account account = new Account();
		account.setId(14);
		final long actual = account.getId();
		final long expected = 14;
		Assert.assertEquals(expected, actual);
	}
	
}
