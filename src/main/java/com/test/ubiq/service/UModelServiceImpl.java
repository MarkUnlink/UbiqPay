package com.test.ubiq.service;

import com.test.ubiq.entity.UModel;
import com.test.ubiq.entity.data.Request;
import com.test.ubiq.entity.data.Response;
import com.test.ubiq.repository.UModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UModelServiceImpl implements UModelService {

    @Autowired
    UModelRepository uModelRepository;

    @Override
    public ResponseEntity savePayment (UModel uModel) {

        System.out.println(uModel.getAccountID());

        try {

            uModelRepository.save(uModel);

            // if successful, then: Then forward payment to B:
            // Call Function to perform a HTTP Call:

        } catch (Exception e) {

            return new ResponseEntity<>(new Response(), HttpStatus.OK);

        }

        return ResponseEntity.ok(uModel);

    }

    @Override
    public ResponseEntity confirmPayment (Request request) {

        UModel uModel;

        try {

            uModel = uModelRepository.findByReference(request.getReference());

            if (uModel.getExternalTransactionId().equalsIgnoreCase("INITIATED")) {

                uModelRepository.updateTransactionStatus("CONFIRMED",  request.getReference());
                uModel = uModelRepository.findByReference(request.getReference());

            }

            // if successful, then: Then forward confirmation to A:
            // Call Function to perform a HTTP Call:


        } catch (Exception exception) {
            return new ResponseEntity<>(new Response(), HttpStatus.OK);
        }

        return ResponseEntity.ok(uModel);

    }

}
