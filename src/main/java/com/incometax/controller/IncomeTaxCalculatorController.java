package com.incometax.controller;

import com.incometax.dto.IncomeTaxFormDTO;
import com.incometax.service.IncomeTaxCalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/income-tax/")
public class IncomeTaxCalculatorController {

    private static final Logger log = LoggerFactory.getLogger(IncomeTaxCalculatorController.class);

    @Autowired
    public IncomeTaxCalculatorService incomeTaxCalculatorService;

    @PostMapping("/calculate-tax")
    public ResponseEntity<String> calculateIncomeTaxToBePaid(@RequestBody IncomeTaxFormDTO incomeTaxDTO) {
        try {
            Double taxAmount = incomeTaxCalculatorService.calculateIncomeTaxToBePaid(incomeTaxDTO);
            log.debug("taxAmount === " + taxAmount);
            return ResponseEntity.status(HttpStatus.OK).body(String.valueOf(taxAmount));
        } catch (Exception e) {
            log.error("Error : " + e.getMessage());
            return new ResponseEntity<>("", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
