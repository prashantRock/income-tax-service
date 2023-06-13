package com.incometax.util;

import com.incometax.dto.IncomeTaxFormDTO;

public class CalculateOldTax {


    private static final Integer FIVE_PERCENT_LIMIT = 250000;

    private static final  Integer TWENTY_PERCENT_LIMIT = 500000;

    private static final  Integer THIRTY_PERCENT_LIMIT = 1000000;

    public static Double calculateTaxableIncome(IncomeTaxFormDTO incomeTaxDTO){

        Double totalAmount = Double.parseDouble(incomeTaxDTO.getHouseRentAllowance()) + Double.parseDouble(incomeTaxDTO.getFixedSalary()) + Double.parseDouble(incomeTaxDTO.getBasicSalary());
      //  Double taxableIncome = totalAmount - 250000;         //deduct 250000
        Double taxableIncome = totalAmount - Double.parseDouble(incomeTaxDTO.getLeaveTravelAllowance());
        return taxableIncome;
    }

    public static Double fetchTax(Double taxableIncome){

        Double taxAmount = 0.0;
        Double income = taxableIncome;
        if (income > THIRTY_PERCENT_LIMIT){
            Double taxValue = income - THIRTY_PERCENT_LIMIT;
            taxAmount = taxValue * .3;
            income = income - taxValue;
        }
        if (income > TWENTY_PERCENT_LIMIT && income <= THIRTY_PERCENT_LIMIT ){
            Double taxValue = income - TWENTY_PERCENT_LIMIT;
            taxAmount = taxAmount +  taxValue * .2;
            income = income - taxValue;
        }
        if (income > FIVE_PERCENT_LIMIT && income <= TWENTY_PERCENT_LIMIT ){
            Double taxValue = income - FIVE_PERCENT_LIMIT;
            taxAmount = taxAmount +  taxValue * .05;

        }
        return taxAmount;
    }
}
