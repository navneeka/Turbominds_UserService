package com.ibm.accountmanager.service;

import com.ibm.accountmanager.domain.RoleAndUser;
import com.ibm.accountmanager.domain.User;

/**
 * security token generator service class
 */
public interface SecurityTokenGenerator {
    //Generating JWT token
    String generateToken(User user, String role);
    
    void removeToken(String tokenId);
    
    boolean isUserLoggedIn(String tokenId);
    
    RoleAndUser extractRoleAndUserId(String tokenId);
}
