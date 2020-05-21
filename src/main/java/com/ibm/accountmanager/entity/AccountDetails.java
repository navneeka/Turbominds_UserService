package com.ibm.accountmanager.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;


/**
 * Entity class for User details
 * @author LingarajSahoo
 *
 */
@Entity
@Table(name="osb_account")
public class AccountDetails implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1537967026661376645L;
	
	@Id
    @Column(name = "user_id")
    private String userId;
    @Column(name = "user_name")
    private String username;
    @Column(name = "user_pwd")
    private String password;
    @Column(name = "user_email")
    private String email;
    @Column(name = "user_role")
    private String role;
    
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}