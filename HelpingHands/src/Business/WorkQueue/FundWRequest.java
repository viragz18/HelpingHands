/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.Date;


public class FundWRequest extends WorkRequest{

    private String source;
    private double fundingamt;
    private Date estimateDate;
    private String transferMode;
    private String descriptionfn;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public double getFundingamt() {
        return fundingamt;
    }

    public void setFundingamt(double fundingamt) {
        this.fundingamt = fundingamt;
    }

    public Date getEstimateDate() {
        return estimateDate;
    }

    public void setEstimateDate(Date estimateDate) {
        this.estimateDate = estimateDate;
    }

    public String getTransferMode() {
        return transferMode;
    }

    public void setTransferMode(String transferMode) {
        this.transferMode = transferMode;
    }  

    public String getDescriptionfn() {
        return descriptionfn;
    }

    public void setDescriptionfn(String descriptionfn) {
        this.descriptionfn = descriptionfn;
    }    
}
