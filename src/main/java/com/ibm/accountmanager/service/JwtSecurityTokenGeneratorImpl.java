package com.ibm.accountmanager.service;

import com.ibm.accountmanager.domain.RoleAndUser;
import com.ibm.accountmanager.domain.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.DatatypeConverter;
/**
 * Security token generator implementation class.
 * 
 * @author LingarajSahoo
 *
 */
@Service
public class JwtSecurityTokenGeneratorImpl implements SecurityTokenGenerator {
	
	Map<String, String> userToken = new HashMap<>();
	
    public String generateToken(User userData, String role) {
        String jwtToken = null;
        jwtToken = Jwts.builder().claim("role",role).setSubject(userData.getLoginId()).setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,"secretkey").compact();
        userToken.put(userData.getLoginId(),jwtToken);
        return jwtToken;
    }

	@Override
	public void removeToken(String userId) {
		userToken.remove(userId);
	}

	@Override
	public boolean isUserLoggedIn(String tokenId) {
		return userToken.containsValue(tokenId);
	}
	
	@Override
	public RoleAndUser extractRoleAndUserId(String jwt) {
		RoleAndUser roleAndUser = new RoleAndUser();
		if (!userToken.containsKey(jwt)) {
			return roleAndUser ;
		}
		Claims claims = Jwts.parser()
	            .setSigningKey(DatatypeConverter.parseBase64Binary("secretkey"))
	            .parseClaimsJws(jwt).getBody();
	    String role = (String)claims.get("role");
	    String userId = claims.getSubject();
	    roleAndUser.setRole(role);
	    roleAndUser.setUserId(userId);
	    return roleAndUser; 
	}
}
