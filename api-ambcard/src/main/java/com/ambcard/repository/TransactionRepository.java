package com.ambcard.repository;

import com.ambcard.entity.TransactionEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TransactionRepository extends CrudRepository<TransactionEntity, UUID> {

    @Query("SELECT SUM(t.value) FROM TransactionEntity t where t.walletId = :walletId")
    Double sumTransactionsByWallet(@Param("walletId") UUID uuid);

}
