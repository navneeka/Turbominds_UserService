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
 * User
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-05-19T07:51:01.013Z")

public class User   {
  @JsonProperty("login_id")
  private String loginId = null;

  @JsonProperty("login_pwd")
  private String loginPwd = null;

  public User loginId(String loginId) {
    this.loginId = loginId;
    return this;
  }

  /**
   * User login id to login into the system
   * @return loginId
  **/
  @ApiModelProperty(value = "User login id to login into the system")


  public String getLoginId() {
    return loginId;
  }

  public void setLoginId(String loginId) {
    this.loginId = loginId;
  }

  public User loginPwd(String loginPwd) {
    this.loginPwd = loginPwd;
    return this;
  }

  /**
   * User login password to login into the system
   * @return loginPwd
  **/
  @ApiModelProperty(value = "User login password to login into the system")


  public String getLoginPwd() {
    return loginPwd;
  }

  public void setLoginPwd(String loginPwd) {
    this.loginPwd = loginPwd;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(this.loginId, user.loginId) &&
        Objects.equals(this.loginPwd, user.loginPwd);
  }

  @Override
  public int hashCode() {
    return Objects.hash(loginId, loginPwd);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    
    sb.append("    loginId: ").append(toIndentedString(loginId)).append("\n");
    sb.append("    loginPwd: ").append(toIndentedString(loginPwd)).append("\n");
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

