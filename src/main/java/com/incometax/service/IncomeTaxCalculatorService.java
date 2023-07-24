package com.incometax.service;

import com.incometax.dto.IncomeTaxFormDTO;
import com.incometax.util.individual.CalculateIndividualNewTax;
import com.incometax.util.individual.CalculateIndividualOldTax;
import com.incometax.util.seniorCitizen.CalculateSeniorCitizenNewTax;
import com.incometax.util.Constant;
import com.incometax.util.seniorCitizen.CalculateSeniorCitizenOldTax;
import com.incometax.util.superSeniorCitizen.CalculateSuperSeniorCitizenNewTax;
import com.incometax.util.superSeniorCitizen.CalculateSuperSeniorCitizenOldTax;
import org.springframework.stereotype.Service;

@Service
public class IncomeTaxCalculatorService {

    public Double calculateIncomeTaxToBePaid(IncomeTaxFormDTO incomeTaxDTO){
        Double taxAmount;
        if (incomeTaxDTO.getTaxRegimeOption().equals(Constant.OLD_TAX_REGIME)){
            if (incomeTaxDTO.getAge() > 80){
                Double taxableIncome =  CalculateSuperSeniorCitizenOldTax.calculateTaxableIncome(incomeTaxDTO);
                Double taxableIncomeAfterDeductingSection80 = CalculateSuperSeniorCitizenOldTax.deductSection80Amount(taxableIncome, incomeTaxDTO.getSection80DeductionDTO());
                taxAmount =  CalculateSuperSeniorCitizenOldTax.fetchTax(taxableIncomeAfterDeductingSection80);
            } else if (incomeTaxDTO.getAge() > 60){
                Double taxableIncome =  CalculateSeniorCitizenOldTax.calculateTaxableIncome(incomeTaxDTO);
                Double taxableIncomeAfterDeductingSection80 = CalculateSeniorCitizenOldTax.deductSection80Amount(taxableIncome, incomeTaxDTO.getSection80DeductionDTO());
                taxAmount =  CalculateSeniorCitizenOldTax.fetchTax(taxableIncomeAfterDeductingSection80);
            } else {
                Double taxableIncome =  CalculateIndividualOldTax.calculateTaxableIncome(incomeTaxDTO);
                Double taxableIncomeAfterDeductingSection80 = CalculateIndividualOldTax.deductSection80Amount(taxableIncome, incomeTaxDTO.getSection80DeductionDTO());
                taxAmount =  CalculateIndividualOldTax.fetchTax(taxableIncomeAfterDeductingSection80);
            }
        } else {
            if (incomeTaxDTO.getAge() > 80){
                Double taxableIncome =  CalculateSuperSeniorCitizenNewTax.calculateTaxableIncome(incomeTaxDTO);
                taxAmount =  CalculateSuperSeniorCitizenNewTax.fetchTax(taxableIncome);
            } else if (incomeTaxDTO.getAge() > 60){
                Double taxableIncome =  CalculateSeniorCitizenNewTax.calculateTaxableIncome(incomeTaxDTO);
                taxAmount =  CalculateSeniorCitizenNewTax.fetchTax(taxableIncome);
            } else {
                Double taxableIncome =  CalculateIndividualNewTax.calculateTaxableIncome(incomeTaxDTO);
                taxAmount =  CalculateIndividualNewTax.fetchTax(taxableIncome);
            }

        }
        return taxAmount;
    }

}
