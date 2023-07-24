package com.incometax.dto;

import com.incometax.util.Constant;

public class IncomeTaxFormDTO {

    private Double basicSalary = 0.0;

    private Double fixedSalary = 0.0;

    private Double houseRentAllowance = 0.0;

    private Double flexiSalary = 0.0;

    private Double leaveTravelAllowance = 0.0;

    private Double dearnessAllowance = 0.0;

    private String taxRegimeOption = Constant.OLD_TAX_REGIME;

    private Integer age = 30;

    private Section80DeductionDTO section80DeductionDTO;

    public Double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(Double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public Double getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(Double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    public Double getHouseRentAllowance() {
        return houseRentAllowance;
    }

    public void setHouseRentAllowance(Double houseRentAllowance) {
        this.houseRentAllowance = houseRentAllowance;
    }

    public Double getFlexiSalary() {
        return flexiSalary;
    }

    public void setFlexiSalary(Double flexiSalary) {
        this.flexiSalary = flexiSalary;
    }

    public Double getLeaveTravelAllowance() {
        return leaveTravelAllowance;
    }

    public void setLeaveTravelAllowance(Double leaveTravelAllowance) {
        this.leaveTravelAllowance = leaveTravelAllowance;
    }

    public String getTaxRegimeOption() {
        return taxRegimeOption;
    }

    public void setTaxRegimeOption(String taxRegimeOption) {
        this.taxRegimeOption = taxRegimeOption;
    }

    public Section80DeductionDTO getSection80DeductionDTO() {
        return section80DeductionDTO;
    }

    public void setSection80DeductionDTO(Section80DeductionDTO section80DeductionDTO) {
        this.section80DeductionDTO = section80DeductionDTO;
    }

    public Double getDearnessAllowance() {
        return dearnessAllowance;
    }

    public void setDearnessAllowance(Double dearnessAllowance) {
        this.dearnessAllowance = dearnessAllowance;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
