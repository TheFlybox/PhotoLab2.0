package com.example.photolab.data.model;

import com.example.photolab.data.model.Photo;

import java.util.List;

public class PhotoBase {
    private int total;
    private int totalHits;
    private List<Photo> hits;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalHits() {
        return totalHits;
    }

    public void setTotalHits(int totalHits) {
        this.totalHits = totalHits;
    }

    public List<Photo> getHits() {
        return hits;
    }

    public void setHits(List<Photo> hits) {
        this.hits = hits;
    }
}
