package com.test.ubiq.service;

import com.test.ubiq.entity.data.Request;
import com.test.ubiq.repository.UModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.test.ubiq.entity.UModel;

public interface UModelService {

    ResponseEntity savePayment(UModel uModel);

    ResponseEntity confirmPayment (Request request);



}
