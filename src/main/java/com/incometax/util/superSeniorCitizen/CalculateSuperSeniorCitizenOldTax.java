package com.incometax.util.superSeniorCitizen;

import com.incometax.dto.IncomeTaxFormDTO;
import com.incometax.dto.Section80DeductionDTO;

public class CalculateSuperSeniorCitizenOldTax {

    private static final  Integer TWENTY_PERCENT_LIMIT = 500000;

    private static final  Integer THIRTY_PERCENT_LIMIT = 1000000;

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
            taxAmount = taxValue * .3 + 100000;
            income = income - taxValue;
        }
        if (income > TWENTY_PERCENT_LIMIT && income <= THIRTY_PERCENT_LIMIT ){
            Double taxValue = income - TWENTY_PERCENT_LIMIT;
            taxAmount = taxAmount +  taxValue * .2;
        }
        return taxAmount;
    }

    public static Double deductSection80Amount(Double taxableIncome, Section80DeductionDTO section80DeductionDTO){

        if (section80DeductionDTO.getInvestment80C() >= 150000){
            taxableIncome = taxableIncome - 150000;
        } else if(section80DeductionDTO.getInvestment80C() > 0) {
            taxableIncome = taxableIncome - section80DeductionDTO.getInvestment80C();
        }

        if (section80DeductionDTO.getInsurancePremium80CCC() >= 150000){
            taxableIncome = taxableIncome - 150000;
        } else if (section80DeductionDTO.getInsurancePremium80CCC() > 0) {
            taxableIncome = taxableIncome - section80DeductionDTO.getInsurancePremium80CCC();
        }

        if (section80DeductionDTO.getPensionContribution80CCD() > 0) {
            taxableIncome = taxableIncome - section80DeductionDTO.getPensionContribution80CCD();
        }

        if (section80DeductionDTO.getInterestOnSavingAccount80TTA() >= 10000) {
            taxableIncome = taxableIncome - 10000;
        } else if (section80DeductionDTO.getInterestOnSavingAccount80TTA() > 0) {
            taxableIncome = taxableIncome - section80DeductionDTO.getInterestOnSavingAccount80TTA();
        }

        if (section80DeductionDTO.getHouseRentPaid80GG() > 0) {
            taxableIncome = taxableIncome - section80DeductionDTO.getHouseRentPaid80GG();
        }

        if (section80DeductionDTO.getInterestOnEducationLoan80E() > 0) {
            taxableIncome = taxableIncome - section80DeductionDTO.getInterestOnEducationLoan80E();
        }

        return taxableIncome;



    }
}
