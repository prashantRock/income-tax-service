package com.incometax.util.seniorCitizen;

import com.incometax.dto.IncomeTaxFormDTO;

public class CalculateSeniorCitizenNewTax {

    private static final Integer FIVE_PERCENT_LIMIT = 250000;

    private static final Integer TEN_PERCENT_LIMIT = 500000;

    private static final Integer FIFTEEN_PERCENT_LIMIT = 750000;

    private static final  Integer TWENTY_PERCENT_LIMIT = 1000000;

    private static final  Integer TWENTY_FIVE_PERCENT_LIMIT = 1250000;

    private static final  Integer THIRTY_PERCENT_LIMIT = 1500000;

    public static Double calculateTaxableIncome(IncomeTaxFormDTO incomeTaxDTO){
        Double totalAmount = incomeTaxDTO.getHouseRentAllowance() + incomeTaxDTO.getFixedSalary()
                + incomeTaxDTO.getBasicSalary() + incomeTaxDTO.getDearnessAllowance();
        Double taxableIncome = totalAmount - incomeTaxDTO.getLeaveTravelAllowance();
        return taxableIncome;
    }

    public static Double fetchTax(Double taxableIncome){

        Double taxAmount = 0.0;
        Double income = taxableIncome;
        if (income > THIRTY_PERCENT_LIMIT){
            Double taxValue = income - THIRTY_PERCENT_LIMIT;
            taxAmount = taxValue * .3 + 187500;
            income = income - taxValue;
        }
        if (income > TWENTY_FIVE_PERCENT_LIMIT && income <= THIRTY_PERCENT_LIMIT ){
            Double taxValue = income - TWENTY_FIVE_PERCENT_LIMIT;
            taxAmount = taxAmount +  taxValue * .25 + 125000;
            income = income - taxValue;
        }
        if (income > TWENTY_PERCENT_LIMIT && income <= TWENTY_FIVE_PERCENT_LIMIT ){
            Double taxValue = income - TWENTY_PERCENT_LIMIT;
            taxAmount = taxAmount +  taxValue * .2 + 75000;
            income = income - taxValue;
        }
        if (income > FIFTEEN_PERCENT_LIMIT && income <= TWENTY_PERCENT_LIMIT ){
            Double taxValue = income - FIFTEEN_PERCENT_LIMIT;
            taxAmount = taxAmount +  taxValue * .15 + 37500;
            income = income - taxValue;
        }
        if (income > TEN_PERCENT_LIMIT && income <= FIFTEEN_PERCENT_LIMIT ){
            Double taxValue = income - TEN_PERCENT_LIMIT;
            taxAmount = taxAmount +  taxValue * .10 + 12500;
            income = income - taxValue;
        }
        if (income > FIVE_PERCENT_LIMIT && income <= TEN_PERCENT_LIMIT ){
            Double taxValue = income - FIVE_PERCENT_LIMIT;
            taxAmount = taxAmount +  taxValue * .05;
        }
        return taxAmount;
    }

}
