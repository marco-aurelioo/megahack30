package com.ambcard.controller;

import com.ambcard.business.CreditBusiness;
import com.ambcard.exception.FileStorageException;
import com.ambcard.model.Credit;
import com.ambcard.model.UploadFileResponse;
import com.ambcard.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cupom")
public class CuponController {

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private CreditBusiness creditBusiness;

    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam("walletId") String walletId) {
        String fileName = null;
        try {
            UUID wallet_id = UUID.fromString(walletId);
            UUID transaction = creditBusiness.makeCreditFromUpload(new Credit(wallet_id,5.32));//valor de exemplo
            fileName = fileStorageService.storeFile(file,transaction.toString());
        } catch (FileStorageException e) {
            e.printStackTrace();
        }
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();

        return new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
    }


}
