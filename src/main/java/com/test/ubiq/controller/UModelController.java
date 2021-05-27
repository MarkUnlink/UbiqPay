package com.test.ubiq.controller;

import com.test.ubiq.entity.UModel;
import com.test.ubiq.entity.data.Request;
import com.test.ubiq.entity.data.Response;
import com.test.ubiq.repository.UModelRepository;
import com.test.ubiq.service.UModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UModelController {

    @Autowired
    UModelService uModelService;

    // Partner A - Payment
    @RequestMapping(value = "/payments", method = RequestMethod.POST, consumes = { "application/json" }, produces = {"application/json"})
    public ResponseEntity payment (@RequestBody UModel uModel) {
        
        return uModelService.savePayment(uModel); //save to db/API service
    }

    // Partner B - Confirmation

    @RequestMapping(value = "/transactions", method = RequestMethod.POST, consumes = { "application/json" }, produces = {"application/json"})
    public ResponseEntity transactions (@RequestBody Request request) {

        return uModelService.confirmPayment(request);

    }

}
