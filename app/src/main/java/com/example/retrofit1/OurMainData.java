package com.example.retrofit1;

import java.util.List;

public class OurMainData {
  private List<ObjectData> data;

    public List<ObjectData> getData() {
        return data;
    }

    public void setData(List<ObjectData> data) {
        this.data = data;
    }

    public OurMainData() {
    }

    public OurMainData(List<ObjectData> data) {
        this.data = data;
    }
}
