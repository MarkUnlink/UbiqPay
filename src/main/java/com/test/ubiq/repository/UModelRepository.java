package com.test.ubiq.repository;

import com.test.ubiq.entity.UModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UModelRepository extends JpaRepository<UModel, Integer> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE UModel u SET u.transactionStatus = ?1 WHERE u.externalTransactionId = ?2")
    void updateTransactionStatus (String transactionStatus,  String transactionID);

    @Query(value = "SELECT * FROM ubiq where external_transaction_id = ?1", nativeQuery = true)
    UModel findByReference (String reference);

}
