package com.aric.samples.account.controller;


import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.aric.samples.account.model.Account;
import com.aric.samples.account.service.AccountService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTest {
	

		private static List<Account> account;
		private static List<Account> accountson;
		private static Account account1;
		private static Account account2; 
		private static Account account3; 
		private static final String FIRST_NAME1= "kursat";
		private static final String LAST_NAME1= "yasar";
		private static final String FIRST_NAME2= "emre";
		private static final String LAST_NAME2= "kuru";
		private static final long tckn1=161;
		private static final long tckn2=292;
		private static final long id1=1;
		private static final long id2=2;
		private static final long balance1=1500;
		private static final long balance2=2500;
	    private AccountService mockAccountService;

	    
		@BeforeClass
		public static void setUpBeforeClass() {
			account =  new ArrayList<Account>();
			accountson =  new ArrayList<Account>();
			account1= new Account();
			account2=new Account();
			account1.setId(id1);
			account2.setId(id2);
			account1.setOwnerFirstName(FIRST_NAME1);
			account2.setOwnerFirstName(FIRST_NAME2);
			account1.setOwnerLastName(LAST_NAME1);
			account2.setOwnerLastName(LAST_NAME2);
			account1.setOwnerTckn(tckn1);
			account2.setOwnerTckn(tckn2);
			account1.setBalance(balance1);
			account2.setBalance(balance2);
			account.add(account1);
			account.add(account2);
		}
	    
	    @Autowired
	    private AccountController accountingController;
	    
	    
	    @Before
	    public void setUp() {
			mockAccountService = Mockito.mock(AccountService.class);
			ReflectionTestUtils.setField(accountingController,"accountSerive",mockAccountService);
			Mockito.when(mockAccountService.findPersonsByTckn(161)).thenReturn(Arrays.asList(account1));
			Mockito.when(mockAccountService.findPersonsByTckn(292)).thenReturn(Arrays.asList(account2));

	    }
	
	
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void testAccountController() throws Exception {
    	accountson = accountingController.account(161);
		Mockito.verify(mockAccountService);
    	
        this.mockMvc.perform(get("/query")).andExpect(status().isOk());
	
    }  
}
