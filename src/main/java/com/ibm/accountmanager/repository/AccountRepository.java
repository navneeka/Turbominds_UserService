package com.ibm.accountmanager.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ibm.accountmanager.entity.AccountDetails;
/**
 * User service repository layer.
 * 
 * @author LingarajSahoo
 *
 */
@Repository
@Qualifier("accountRepository")
@EntityScan(basePackages = {"com.ibm.accountmanager.domain"})
public interface AccountRepository extends JpaRepository<AccountDetails,Integer> {

	@Query("SELECT a FROM AccountDetails a WHERE LOWER(a.userId) = LOWER(:userId)")
	public AccountDetails findByUserId(@Param("userId")String userId);
}