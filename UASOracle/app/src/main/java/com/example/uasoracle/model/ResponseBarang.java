package com.example.uasoracle.model;
/**
 * Created by Suci Sukma Melati.
 * github : https://github.com/SuciSukmaMelati
 */
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseBarang {

    @SerializedName("items")
    private List<BarangItem> semuabarang;

    public List<BarangItem> getSemuabarang() {
        return semuabarang;
    }

    public void setSemuabarang(List<BarangItem> semuabarang) {
        this.semuabarang = semuabarang;
    }


    @Override
    public String toString(){
        return
                "ResponseBarang{" +
                        "items = '" + semuabarang + '\'' +
                        "}";
    }

}
