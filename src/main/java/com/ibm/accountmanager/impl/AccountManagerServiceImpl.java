package com.ibm.accountmanager.impl;

import com.ibm.accountmanager.api.AccountAPI;
import com.ibm.accountmanager.domain.RoleAndUser;
import com.ibm.accountmanager.domain.User;
import com.ibm.accountmanager.domain.UserData;
import com.ibm.accountmanager.entity.AccountDetails;
import com.ibm.accountmanager.exception.PasswordNotMatchException;
import com.ibm.accountmanager.exception.UserAlreadyExistsException;
import com.ibm.accountmanager.exception.UserNotFoundException;
import com.ibm.accountmanager.repository.AccountRepository;
import com.ibm.accountmanager.service.SecurityTokenGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * User service implementation class.
 * 
 * @author LingarajSahoo
 *
 */
@Service
public class AccountManagerServiceImpl implements AccountAPI {
    
	@Autowired
	private AccountRepository accountManagerRepository;
	
	@Autowired
	private SecurityTokenGenerator securityTokenGenerator;
    
    public AccountDetails findByUserId(String userId) throws UserNotFoundException,PasswordNotMatchException {
        AccountDetails userDetailsObj = accountManagerRepository.findByUserId(userId);
        if(userDetailsObj == null){
            throw new UserNotFoundException("User with user id = " + userId + " is not found");
        }
        return userDetailsObj;
    }
    
	@Override
	public String login(User user) throws UserNotFoundException {
		String userToken = null;
		AccountDetails userObj = accountManagerRepository.findByUserId(user.getLoginId());
		if (userObj == null) throw new UserNotFoundException("User with user id = " + user.getLoginId() + " not Found");
		if (userObj.getPassword().equals(user.getLoginPwd())) {
			userToken = securityTokenGenerator.generateToken(user, userObj.getRole());
		}
		return userToken;
	}
	
	@Override
	public Boolean logout(String tokenId) {
		if (securityTokenGenerator.isUserLoggedIn(tokenId)) {
			securityTokenGenerator.removeToken(tokenId);
		}
		return true;
	}
	
	@Override
	public Boolean registerUser(UserData userData) {
		AccountDetails fetchUserObj = accountManagerRepository.findByUserId(userData.getEmailId());
        if(fetchUserObj != null){
        	throw new UserAlreadyExistsException("User with emaild is " + userData.getEmailId() + " already exist");
        }else {
        	AccountDetails account = new AccountDetails();
        	account.setEmail(userData.getEmailId());
        	account.setPassword(userData.getUserPwd());
        	account.setRole(userData.getRoleName());
        	account.setUserId(userData.getEmailId());
        	account.setUsername(userData.getUserName()); 
        	accountManagerRepository.saveAndFlush(account);
        }
        return true;
	}
	
	@Override
	public Boolean validateUser(String tokenId) {
		RoleAndUser roleAndUser =  securityTokenGenerator.extractRoleAndUserId(tokenId);
		if (roleAndUser.getRole() == null || roleAndUser.getUserId() == null) return false;
		AccountDetails accountDetails = accountManagerRepository.findByUserId(roleAndUser.getUserId());
		if (accountDetails.getRole().equalsIgnoreCase(roleAndUser.getRole()))
			return true;
		return false;
	}
}