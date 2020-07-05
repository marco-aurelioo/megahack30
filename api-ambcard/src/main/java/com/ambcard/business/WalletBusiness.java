package com.ambcard.business;

import com.ambcard.entity.WalletEntity;
import com.ambcard.model.Wallet;
import com.ambcard.repository.TransactionRepository;
import com.ambcard.repository.WalletRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class WalletBusiness {

    @Autowired
    private WalletRepository repositoryCRUD;

    @Autowired
    private TransactionRepository transactionRepository;

    public Wallet createWallet(Wallet wallet){
        WalletEntity entity = fromPojo(wallet);
        entity = repositoryCRUD.save(entity);
        Wallet createdWallet = fromEntity(entity);
        return createdWallet;
    }

    public Boolean deleteWallet(String uuid){
        UUID id = UUID.fromString(uuid);
        Optional<WalletEntity> entityOptional = repositoryCRUD.findById(id);
        if(entityOptional.isPresent()){
            repositoryCRUD.delete(entityOptional.get());
            return true;
        }else{
            throw new RuntimeException("wallet not found.");
        }
    }

    public Wallet findWalletById(String uuid){
        UUID id =  UUID.fromString(uuid);
        Optional<WalletEntity> entityOptional = repositoryCRUD.findById(id);
        if(entityOptional.isPresent()){
            Wallet wallet = fromEntity(entityOptional.get());
            wallet.setBalance(getBalance(id));
            return wallet;
        }else{
            throw new RuntimeException("wallet not found.");
        }
    }


    public Wallet update(Wallet wallet, String uuid) {
        UUID id = UUID.fromString(uuid);
        if(wallet.getId().equals(id)) {
            Optional<WalletEntity> entityOptional = repositoryCRUD.findById(id);
            if(entityOptional.isPresent()){
                WalletEntity entity = entityOptional.get();
                BeanUtils.copyProperties(wallet,entity);
                entity = repositoryCRUD.save(entity);
                Wallet walletUpdated = fromEntity(entity);
                return walletUpdated;
            }else{
                throw new RuntimeException("wallet not found.");
            }
        }else{
            throw new RuntimeException("incompatible customerId");
        }
    }

    private Wallet fromEntity(WalletEntity entity){
        Wallet wallet = new Wallet();
        BeanUtils.copyProperties(entity,wallet);
        return wallet;
    }

    private WalletEntity fromPojo(Wallet wallet){
        Optional<WalletEntity> entityOptional = repositoryCRUD.findById(wallet.getId());
        WalletEntity entity = new WalletEntity();
        if(!entityOptional.isPresent()) {
            entity = entityOptional.get();
        }
        BeanUtils.copyProperties(wallet,entity);
        return entity;
    }

    private Double getBalance(UUID uuid) {
        return transactionRepository.sumTransactionsByWallet(uuid);
    }

}
