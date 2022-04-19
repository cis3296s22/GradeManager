package com.grademanager.demo.model;
import com.google.gson.annotations.SerializedName;

public class Id {
    public Id(){}
    @SerializedName("baseId")
    private String baseId;



    
    /** 
     * @return String
     */
    public String getBaseId(){
        return this.baseId;
    }

    
    
    /** 
     * @param baseId
     */
    public void setBaseId(String baseId) {
        this.baseId=baseId;
    }
}
