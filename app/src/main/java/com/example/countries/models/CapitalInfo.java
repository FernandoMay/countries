package com.example.countries.models;
import com.fasterxml.jackson.annotation.*;

public class CapitalInfo {
    private double[] latlng;

    @JsonProperty("latlng")
    public double[] getLatlng() { return latlng; }
    @JsonProperty("latlng")
    public void setLatlng(double[] value) { this.latlng = value; }
}

