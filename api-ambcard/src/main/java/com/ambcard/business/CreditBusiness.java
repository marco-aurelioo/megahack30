package com.ambcard.business;

import com.ambcard.entity.TYPE_TRANSACTION;
import com.ambcard.entity.TransactionEntity;
import com.ambcard.model.Credit;
import com.ambcard.repository.TransactionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreditBusiness {

    @Autowired
    private TransactionRepository transactionRepository;

    public Boolean makeCredit(Credit credit) {
        createTramsaction(credit);
        return true;
    }

    private TransactionEntity createTramsaction(Credit credit) {
        TransactionEntity entity = new TransactionEntity();

        entity.setWalletId(credit.getWalletId());
        entity.setStoreId(credit.getStoreId());
        entity.setValue(credit.getValue());

        if (credit.getValue() > 0) {
            entity.setType(TYPE_TRANSACTION.CREDIT);
        } else {
            entity.setType(TYPE_TRANSACTION.DEBIT);
        }
        return transactionRepository.save(entity);
    }

    public UUID makeCreditFromUpload(Credit credit) {
        TransactionEntity entity = createTramsaction(credit);
        return entity.getId();
    }
}
