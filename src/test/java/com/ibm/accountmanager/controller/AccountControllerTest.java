package com.ibm.accountmanager.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.accountmanager.service.SecurityTokenGenerator;
import com.ibm.accountmanager.entity.AccountDetails;
import com.ibm.accountmanager.impl.AccountManagerServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Account Manager service control layer test cases.
 * 
 * @author LingarajSahoo
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest
public class AccountControllerTest {

    private AccountDetails accountDetails;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AccountManagerServiceImpl accountManagerService;
    @MockBean
    private SecurityTokenGenerator securityTokenGenerator;
    @InjectMocks
    private AccountManagerController accountManagerController;
    /**
     * Intializing the details.
     */
    @Before
    public void setUp() {
       // MockitoAnnotations.initMocks(this);
       // mockMvc = MockMvcBuilders.standaloneSetup(accountManagerController).build();
        accountDetails = new AccountDetails();
        accountDetails.setUsername("IBM1");
        accountDetails.setEmail("ibm@gmail.com");
        accountDetails.setRole("Admin");
        accountDetails.setPassword("ibm@1234");
    }
    @After
    public void tearDown() {
        accountDetails = null;
    }
    /**
     * test case to check saving accountDetails details successfully.
     * 
     * @throws Exception
     */
     @Test
     public void testSaveUserSuccess()throws Exception{
       // accountManagerService.saveUserDetails(accountDetails);
        
     }
    /**
     * Json to string.
     * 
     * @param obj
     * @return
     * @throws JsonProcessingException
     */
    private static String jsonToString(final Object obj) throws JsonProcessingException {
        String result;
        try{
            final ObjectMapper objectMapper = new ObjectMapper();
            final String jsonContent = objectMapper.writeValueAsString(obj);
            result=jsonContent;
        }catch(JsonProcessingException e){
            result="Json Processing error";
        }
        return result;
    }
}