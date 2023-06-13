package com.incometax.dto;

public class IncomeTaxFormDTO {

    private String basicSalary = "0";

    private String fixedSalary= "0";

    private String houseRentAllowance= "0";

    private String flexiSalary= "0";

    private String leaveTravelAllowance= "0";

    private String taxRegimeOption;



    public String getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(String basicSalary) {
        this.basicSalary = basicSalary;
    }

    public String getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(String fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    public String getHouseRentAllowance() {
        return houseRentAllowance;
    }

    public void setHouseRentAllowance(String houseRentAllowance) {
        this.houseRentAllowance = houseRentAllowance;
    }

    public String getFlexiSalary() {
        return flexiSalary;
    }

    public void setFlexiSalary(String flexiSalary) {
        this.flexiSalary = flexiSalary;
    }

    public String getLeaveTravelAllowance() {
        return leaveTravelAllowance;
    }

    public void setLeaveTravelAllowance(String leaveTravelAllowance) {
        this.leaveTravelAllowance = leaveTravelAllowance;
    }

    public String getTaxRegimeOption() {
        return taxRegimeOption;
    }

    public void setTaxRegimeOption(String taxRegimeOption) {
        this.taxRegimeOption = taxRegimeOption;
    }
}
