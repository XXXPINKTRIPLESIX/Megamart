package com.example.megamart.business.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Observable;

import lombok.Data;

@Data
public class Category implements Serializable {
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("slug")
    @Expose
    public String slug;
    @SerializedName("parent")
    @Expose
    public Integer parent;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("display")
    @Expose
    public String display;
    @SerializedName("image")
    @Expose
    public Image image;
    @SerializedName("menu_order")
    @Expose
    public Integer menuOrder;
    @SerializedName("count")
    @Expose
    public Integer count;
//    @SerializedName("_links")
//    @Expose
//    public Links links;
}

//    @SerializedName("id")
//    @Expose
//    public Integer id;
//    @SerializedName("name")
//    @Expose
//    public String name;
//    @SerializedName("slug")
//    @Expose
//    public String slug;
