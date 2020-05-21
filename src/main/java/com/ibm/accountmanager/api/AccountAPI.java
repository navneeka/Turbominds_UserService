package com.ibm.accountmanager.api;

import com.ibm.accountmanager.domain.User;
import com.ibm.accountmanager.domain.UserData;

public interface AccountAPI {

	String login(User validUser);

	Boolean logout(String tokenId);

    Boolean registerUser(UserData userData);

    Boolean validateUser(String tokenId);

}
