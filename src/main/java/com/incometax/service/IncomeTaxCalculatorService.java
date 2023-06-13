package com.incometax.service;

import com.incometax.dto.IncomeTaxFormDTO;
import com.incometax.util.CalculateOldTax;
import org.springframework.stereotype.Service;

@Service
public class IncomeTaxCalculatorService {

    public Double calculateIncomeTaxToBePaid(IncomeTaxFormDTO incomeTaxDTO){
        Double taxableIncome =  CalculateOldTax.calculateTaxableIncome(incomeTaxDTO);
        Double taxAmount =  CalculateOldTax.fetchTax(taxableIncome);
        return taxAmount;
    }

}
