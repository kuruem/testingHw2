package com.aric.samples.account.service;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.aric.samples.account.model.Account;
import com.aric.samples.account.repository.AccountRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTest {
	private static List<Account> account;
	private static List<Account> accountson;
	private static Account account1;
	private static Account account2; 
	private static Account account3;
	private static final String FIRST_NAME1= "kursat";
	private static final String LAST_NAME1= "yasar";
	private static final String FIRST_NAME2= "emre";
	private static final String LAST_NAME2= "kuru";
	private static final String FIRST_NAME3= "burak";
	private static final String LAST_NAME3= "yılmaz";
	private static final long tckn1=161;
	private static final long tckn2=292;
	private static final long tckn3=500;
	private static final long id1=1;
	private static final long id2=2;
	private static final long id3=3;
	private static final double balance1=1500;
	private static final double balance2=2500;
	private static final double balance3=5000;
	private static final double money=500;
	private AccountRepository mockAccountRepository;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		account =  new ArrayList<Account>();
		accountson =  new ArrayList<Account>();
		account1= new Account();
		account2=new Account();
		account3=new Account();
		account1.setId(id1);
		account2.setId(id2);
		account3.setId(id3);
		account1.setOwnerFirstName(FIRST_NAME1);
		account2.setOwnerFirstName(FIRST_NAME2);
		account3.setOwnerFirstName(FIRST_NAME3);
		account1.setOwnerLastName(LAST_NAME1);
		account2.setOwnerLastName(LAST_NAME2);
		account3.setOwnerLastName(LAST_NAME3);
		account1.setOwnerTckn(tckn1);
		account2.setOwnerTckn(tckn2);
		account3.setOwnerTckn(tckn3);
		account1.setBalance(balance1);
		account2.setBalance(balance2);
		account3.setBalance(balance3);
		account.add(account1);
		account.add(account2);
		account.add(account3);
	}
	
	@Autowired
	private AccountService accountingService;
	
	
	@Before
	public void setUp() {
		mockAccountRepository = Mockito.mock(AccountRepository.class);
		ReflectionTestUtils.setField(accountingService,"accountRepository",mockAccountRepository);
		Mockito.when(mockAccountRepository.findByOwnerTckn(161)).thenReturn(Arrays.asList(account1));
		Mockito.when(mockAccountRepository.findByOwnerTckn(292)).thenReturn(Arrays.asList(account2));
		Mockito.when(mockAccountRepository.findByOwnerTckn(500)).thenReturn(Arrays.asList(account3));
		Mockito.when(mockAccountRepository.findOne((long) 1)).thenReturn(account1);
		Mockito.when(mockAccountRepository.findOne((long) 2)).thenReturn(account2);
		Mockito.when(mockAccountRepository.findOne((long) 3)).thenReturn(account3);
		Mockito.when(mockAccountRepository.save(account1)).thenReturn(account1);
		Mockito.when(mockAccountRepository.save(account2)).thenReturn(account2);
		Mockito.when(mockAccountRepository.save(account3)).thenReturn(account3);
		
	}
	
	@Test
	public void findPersonsByTcknTest() throws Exception{
		accountson = accountingService.findPersonsByTckn(161);
		Assert.assertEquals("yanlis ismi buldu","kursat", accountson.get(0).getOwnerFirstName());
		Assert.assertEquals("yasar", accountson.get(0).getOwnerLastName());
		//Assert.assertEquals("balance dogru degil",balance1, accountson.get(0).getBalance(),0);
		Assert.assertEquals("ıdler birbirine esit degil",id1, accountson.get(0).getId());
		
	}
	

	
	
	@Test
	public void eftTest() throws Exception{
		Account temp1= new Account();
		temp1=accountingService.eft(id2, id1, money);
		//System.out.println(temp1.getId()+" -- "+temp1.getBalance());
		Assert.assertEquals(2000, temp1.getBalance(),0);
			
	}
	@Test
	public void depositTest() throws Exception{
		Account acc = new Account();
		acc = accountingService.deposit(id3,money);
		Assert.assertEquals(5500, acc.getBalance(),0);
		
		
	}

	
}