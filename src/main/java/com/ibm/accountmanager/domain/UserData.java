package com.ibm.accountmanager.domain;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * UserData
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-05-19T07:51:01.013Z")

public class UserData   {
  @JsonProperty("user_name")
  private String userName = null;

  @JsonProperty("email_id")
  private String emailId = null;
  
  @JsonProperty("user_pwd")
  private String userPwd = null;
  
  @JsonProperty("role_name")
  private String roleName = null;

  public UserData userName(String userName) {
    this.userName = userName;
    return this;
  }

  /**
   * User first name
   * @return userName
  **/
  @ApiModelProperty(value = "User first name")


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public UserData userPwd(String userPwd) {
    this.userPwd = userPwd;
    return this;
  }

  /**
   * Cloud admin user password. Retrieving service details can be done any valid user in a valid role in a valid branch
   * @return userPwd
  **/
  @ApiModelProperty(value = "Cloud admin user password. Retrieving service details can be done any valid user in a valid role in a valid branch")


  public String getUserPwd() {
    return userPwd;
  }

  public void setUserPwd(String userPwd) {
    this.userPwd = userPwd;
  }

  public UserData emailId(String emailId) {
    this.emailId = emailId;
    return this;
  }

  /**
   * User email id
   * @return emailId
  **/
  @ApiModelProperty(value = "User email id")


  public String getEmailId() {
    return emailId;
  }

  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }

  public UserData roleName(String roleName) {
    this.roleName = roleName;
    return this;
  }

  /**
   * User Role Name
   * @return roleName
  **/
  @ApiModelProperty(value = "User Role Name")


  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserData userData = (UserData) o;
    return Objects.equals(this.userName, userData.userName) &&
        Objects.equals(this.userPwd, userData.userPwd) &&
        Objects.equals(this.emailId, userData.emailId) &&
        Objects.equals(this.roleName, userData.roleName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userName, userPwd, emailId, roleName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserData {\n");
    
    sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
    sb.append("    userPwd: ").append(toIndentedString(userPwd)).append("\n");
    sb.append("    emailId: ").append(toIndentedString(emailId)).append("\n");
    sb.append("    roleName: ").append(toIndentedString(roleName)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

