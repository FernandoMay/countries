package com.example.countries.models;
import com.example.countries.models.Side;
import com.fasterxml.jackson.annotation.*;

public class Car {
    private String[] signs;
    private Side side;

    @JsonProperty("signs")
    public String[] getSigns() { return signs; }
    @JsonProperty("signs")
    public void setSigns(String[] value) { this.signs = value; }

    @JsonProperty("side")
    public Side getSide() { return side; }
    @JsonProperty("side")
    public void setSide(Side value) { this.side = value; }
}
