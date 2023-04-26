package com.example.countries.models;
import com.fasterxml.jackson.annotation.*;

public class Idd {
    private String root;
    private String[] suffixes;

    @JsonProperty("root")
    public String getRoot() { return root; }
    @JsonProperty("root")
    public void setRoot(String value) { this.root = value; }

    @JsonProperty("suffixes")
    public String[] getSuffixes() { return suffixes; }
    @JsonProperty("suffixes")
    public void setSuffixes(String[] value) { this.suffixes = value; }
}
