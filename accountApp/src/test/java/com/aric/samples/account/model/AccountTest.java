package com.aric.samples.account.model;

import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import junit.framework.Assert;


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
		account.setId(15);
		final long actual = account.getId();
		final long expected = 15;
		Assert.assertEquals(expected, actual);
	}
	
}
