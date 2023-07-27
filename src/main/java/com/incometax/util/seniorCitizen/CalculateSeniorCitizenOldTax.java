package com.incometax.util.seniorCitizen;

import com.incometax.dto.IncomeTaxFormDTO;
import com.incometax.dto.Section80DeductionDTO;
import com.incometax.util.Constant;

public class CalculateSeniorCitizenOldTax {


    private static final Integer FIVE_PERCENT_LIMIT = 300000;

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
            taxAmount = taxValue * .3 + 110000;
            income = income - taxValue;
        }
        if (income > TWENTY_PERCENT_LIMIT && income <= THIRTY_PERCENT_LIMIT ){
            Double taxValue = income - TWENTY_PERCENT_LIMIT;
            taxAmount = taxAmount +  taxValue * .2 + 10000;
            income = income - taxValue;
        }
        if (income > FIVE_PERCENT_LIMIT && income <= TWENTY_PERCENT_LIMIT ){
            Double taxValue = income - FIVE_PERCENT_LIMIT;
            taxAmount = taxAmount +  taxValue * .05;

        }
        return taxAmount;
    }

    public static Double deductSection80Amount(Double taxableIncome, IncomeTaxFormDTO incomeTaxDTO){
        Section80DeductionDTO section80DeductionDTO = incomeTaxDTO.getSection80DeductionDTO();
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

        if (section80DeductionDTO.getInterestOnHomeLoan80EE() >= 50000) {
            taxableIncome = taxableIncome - 50000;
        } else if (section80DeductionDTO.getInterestOnHomeLoan80EE() > 0){
            taxableIncome = taxableIncome - section80DeductionDTO.getInterestOnHomeLoan80EE();
        }

        if (section80DeductionDTO.getMedicalInsurance80D() > 0) {
            //Need to work on it
        }

        if (section80DeductionDTO.getDisabledDependent80DD() >= 125000) {
            taxableIncome = taxableIncome - 125000;
        } else if (section80DeductionDTO.getDisabledDependent80DD() > 0){
            taxableIncome = taxableIncome - section80DeductionDTO.getDisabledDependent80DD();
        }

        if (section80DeductionDTO.getMedicalExpenditure80DDB() >= 100000) {
            taxableIncome = taxableIncome - 100000;
        } else if (section80DeductionDTO.getMedicalExpenditure80DDB() > 0){
            taxableIncome = taxableIncome - section80DeductionDTO.getMedicalExpenditure80DDB();
        }

        if (section80DeductionDTO.getPhysicalDisability80U() >= 125000) {
            taxableIncome = taxableIncome - 125000;
        } else if (section80DeductionDTO.getPhysicalDisability80U() > 0){
            taxableIncome = taxableIncome - section80DeductionDTO.getPhysicalDisability80U();
        }

        if (section80DeductionDTO.getDonations80G() > 0) {
            //Need to work on it
        }

        // it is for company so not required for individual
        if (section80DeductionDTO.getCompanyContribution80GGB() > 0 && incomeTaxDTO.getTaxPayer().equals(Constant.COMPANY)) {
            taxableIncome = taxableIncome - section80DeductionDTO.getCompanyContribution80GGB();
        }

        if (section80DeductionDTO.getContributionToPoliticalParties80GGC() > 0) {
            taxableIncome = taxableIncome - section80DeductionDTO.getContributionToPoliticalParties80GGC();
        }

        if (section80DeductionDTO.getRoyaltyOfPatent80RRB() >= 300000) {
            taxableIncome = taxableIncome - 300000;
        } else if (section80DeductionDTO.getRoyaltyOfPatent80RRB() > 0){
            taxableIncome = taxableIncome - section80DeductionDTO.getRoyaltyOfPatent80RRB();
        }

        if (section80DeductionDTO.getInterestIncome80TTB() >= 50000 && incomeTaxDTO.getAge() > 60)  {
            taxableIncome = taxableIncome - 50000;
        } else if (section80DeductionDTO.getInterestIncome80TTB() > 0 && incomeTaxDTO.getAge() > 60){
            taxableIncome = taxableIncome - section80DeductionDTO.getInterestIncome80TTB();
        }
        return taxableIncome;



    }
}
