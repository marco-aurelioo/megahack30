package com.ambcard.business;

import com.ambcard.entity.TYPE_TRANSACTION;
import com.ambcard.entity.TransactionEntity;
import com.ambcard.model.Credit;
import com.ambcard.repository.TransactionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Beans;
import java.sql.Date;

@Service
public class CreditBusiness {

    @Autowired
    private TransactionRepository transactionRepository;

    public Boolean makeCredit(Credit credit) {
        TransactionEntity entity = new TransactionEntity();
        BeanUtils.copyProperties(credit,entity);
        if (credit.getValor() > 0) {
            entity.setType(TYPE_TRANSACTION.CREDIT);
        } else {
            entity.setType(TYPE_TRANSACTION.DEBIT);
        }
        transactionRepository.save(entity);
        return true;
    }

}
