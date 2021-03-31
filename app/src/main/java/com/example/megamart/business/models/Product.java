package com.example.megamart.business.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class Product implements Serializable {
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("slug")
    @Expose
    public String slug;
    @SerializedName("permalink")
    @Expose
    public String permalink;
    @SerializedName("date_created")
    @Expose
    public String dateCreated;
    @SerializedName("date_created_gmt")
    @Expose
    public String dateCreatedGmt;
    @SerializedName("date_modified")
    @Expose
    public String dateModified;
    @SerializedName("date_modified_gmt")
    @Expose
    public String dateModifiedGmt;
    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("featured")
    @Expose
    public Boolean featured;
    @SerializedName("catalog_visibility")
    @Expose
    public String catalogVisibility;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("short_description")
    @Expose
    public String shortDescription;
    @SerializedName("sku")
    @Expose
    public String sku;
    @SerializedName("price")
    @Expose
    public String price;
    @SerializedName("regular_price")
    @Expose
    public String regularPrice;
    @SerializedName("sale_price")
    @Expose
    public String salePrice;
    @SerializedName("date_on_sale_from")
    @Expose
    public Object dateOnSaleFrom;
    @SerializedName("date_on_sale_from_gmt")
    @Expose
    public Object dateOnSaleFromGmt;
    @SerializedName("date_on_sale_to")
    @Expose
    public Object dateOnSaleTo;
    @SerializedName("date_on_sale_to_gmt")
    @Expose
    public Object dateOnSaleToGmt;
    @SerializedName("on_sale")
    @Expose
    public Boolean onSale;
    @SerializedName("purchasable")
    @Expose
    public Boolean purchasable;
    @SerializedName("total_sales")
    @Expose
    public Integer totalSales;
    @SerializedName("virtual")
    @Expose
    public Boolean virtual;
    @SerializedName("downloadable")
    @Expose
    public Boolean downloadable;
    @SerializedName("downloads")
    @Expose
    public List<Object> downloads = null;
    @SerializedName("download_limit")
    @Expose
    public Integer downloadLimit;
    @SerializedName("download_expiry")
    @Expose
    public Integer downloadExpiry;
    @SerializedName("external_url")
    @Expose
    public String externalUrl;
    @SerializedName("button_text")
    @Expose
    public String buttonText;
    @SerializedName("tax_status")
    @Expose
    public String taxStatus;
    @SerializedName("tax_class")
    @Expose
    public String taxClass;
    @SerializedName("manage_stock")
    @Expose
    public Boolean manageStock;
    @SerializedName("stock_quantity")
    @Expose
    public Object stockQuantity;
    @SerializedName("backorders")
    @Expose
    public String backorders;
    @SerializedName("backorders_allowed")
    @Expose
    public Boolean backordersAllowed;
    @SerializedName("backordered")
    @Expose
    public Boolean backordered;
    @SerializedName("sold_individually")
    @Expose
    public Boolean soldIndividually;
    @SerializedName("weight")
    @Expose
    public String weight;
    @SerializedName("shipping_required")
    @Expose
    public Boolean shippingRequired;
    @SerializedName("shipping_taxable")
    @Expose
    public Boolean shippingTaxable;
    @SerializedName("shipping_class")
    @Expose
    public String shippingClass;
    @SerializedName("shipping_class_id")
    @Expose
    public Integer shippingClassId;
    @SerializedName("reviews_allowed")
    @Expose
    public Boolean reviewsAllowed;
    @SerializedName("average_rating")
    @Expose
    public String averageRating;
    @SerializedName("rating_count")
    @Expose
    public Integer ratingCount;
    @SerializedName("upsell_ids")
    @Expose
    public List<Object> upsellIds = null;
    @SerializedName("cross_sell_ids")
    @Expose
    public List<Object> crossSellIds = null;
    @SerializedName("parent_id")
    @Expose
    public Integer parentId;
    @SerializedName("purchase_note")
    @Expose
    public String purchaseNote;
    @SerializedName("categories")
    @Expose
    public List<Category> categories = null;
    @SerializedName("tags")
    @Expose
    public List<Object> tags = null;
    @SerializedName("images")
    @Expose
    public List<Image> images = null;
    @SerializedName("attributes")
    @Expose
    public List<Object> attributes = null;
    @SerializedName("default_attributes")
    @Expose
    public List<Object> defaultAttributes = null;
    @SerializedName("variations")
    @Expose
    public List<Object> variations = null;
    @SerializedName("grouped_products")
    @Expose
    public List<Object> groupedProducts = null;
    @SerializedName("menu_order")
    @Expose
    public Integer menuOrder;
    @SerializedName("price_html")
    @Expose
    public String priceHtml;
    @SerializedName("related_ids")
    @Expose
    public List<Integer> relatedIds = null;
    @SerializedName("stock_status")
    @Expose
    public String stockStatus;
    @SerializedName("brands")
    @Expose
    public List<Brand> brands = null;
//    @SerializedName("_links")
//    @Expose
//    public Links links;
//    @SerializedName("dimensions")
//    @Expose
//    public Dimensions dimensions;
//    @SerializedName("meta_data")
//    @Expose
//    public List<MetaDatum> metaData = null;
}

//-----------------------------------com.project.Brand.java-----------------------------------
//
//        package com.project;
//
//        import com.google.gson.annotations.Expose;
//        import com.google.gson.annotations.SerializedName;
//
//public class Brand {
//
//    @SerializedName("id")
//    @Expose
//    public Integer id;
//    @SerializedName("name")
//    @Expose
//    public String name;
//    @SerializedName("slug")
//    @Expose
//    public String slug;
//
//}
//-----------------------------------com.project.Category.java-----------------------------------
//
//        package com.project;
//
//        import com.google.gson.annotations.Expose;
//        import com.google.gson.annotations.SerializedName;
//
//public class Category {
//
//    @SerializedName("id")
//    @Expose
//    public Integer id;
//    @SerializedName("name")
//    @Expose
//    public String name;
//    @SerializedName("slug")
//    @Expose
//    public String slug;
//
//}
//-----------------------------------com.project.Collection.java-----------------------------------
//
//        package com.project;
//
//        import com.google.gson.annotations.Expose;
//        import com.google.gson.annotations.SerializedName;
//
//public class Collection {
//
//    @SerializedName("href")
//    @Expose
//    public String href;
//
//}
//-----------------------------------com.project.Dimensions.java-----------------------------------
//
//        package com.project;
//
//        import com.google.gson.annotations.Expose;
//        import com.google.gson.annotations.SerializedName;
//
//public class Dimensions {
//
//    @SerializedName("length")
//    @Expose
//    public String length;
//    @SerializedName("width")
//    @Expose
//    public String width;
//    @SerializedName("height")
//    @Expose
//    public String height;
//
//}
//-----------------------------------com.project.Image.java-----------------------------------
//
//        package com.project;
//
//        import com.google.gson.annotations.Expose;
//        import com.google.gson.annotations.SerializedName;
//
//public class Image {
//
//    @SerializedName("id")
//    @Expose
//    public Integer id;
//    @SerializedName("date_created")
//    @Expose
//    public String dateCreated;
//    @SerializedName("date_created_gmt")
//    @Expose
//    public String dateCreatedGmt;
//    @SerializedName("date_modified")
//    @Expose
//    public String dateModified;
//    @SerializedName("date_modified_gmt")
//    @Expose
//    public String dateModifiedGmt;
//    @SerializedName("src")
//    @Expose
//    public String src;
//    @SerializedName("name")
//    @Expose
//    public String name;
//    @SerializedName("alt")
//    @Expose
//    public String alt;
//
//}
//-----------------------------------com.project.Links.java-----------------------------------
//
//        package com.project;
//
//        import java.util.List;
//        import com.google.gson.annotations.Expose;
//        import com.google.gson.annotations.SerializedName;
//
//public class Links {
//
//    @SerializedName("self")
//    @Expose
//    public List<Self> self = null;
//    @SerializedName("collection")
//    @Expose
//    public List<Collection> collection = null;
//
//}
//-----------------------------------com.project.MetaDatum.java-----------------------------------
//
//        package com.project;
//
//        import com.google.gson.annotations.Expose;
//        import com.google.gson.annotations.SerializedName;
//
//public class MetaDatum {
//
//    @SerializedName("id")
//    @Expose
//    public Integer id;
//    @SerializedName("key")
//    @Expose
//    public String key;
//    @SerializedName("value")
//    @Expose
//    public String value;
//
//}
//-----------------------------------com.project.Product.java-----------------------------------
//
//        package com.project;
//
//        import java.util.List;
//        import com.google.gson.annotations.Expose;
//        import com.google.gson.annotations.SerializedName;
//
//public class Product {
//
//    @SerializedName("id")
//    @Expose
//    public Integer id;
//    @SerializedName("name")
//    @Expose
//    public String name;
//    @SerializedName("slug")
//    @Expose
//    public String slug;
//    @SerializedName("permalink")
//    @Expose
//    public String permalink;
//    @SerializedName("date_created")
//    @Expose
//    public String dateCreated;
//    @SerializedName("date_created_gmt")
//    @Expose
//    public String dateCreatedGmt;
//    @SerializedName("date_modified")
//    @Expose
//    public String dateModified;
//    @SerializedName("date_modified_gmt")
//    @Expose
//    public String dateModifiedGmt;
//    @SerializedName("type")
//    @Expose
//    public String type;
//    @SerializedName("status")
//    @Expose
//    public String status;
//    @SerializedName("featured")
//    @Expose
//    public Boolean featured;
//    @SerializedName("catalog_visibility")
//    @Expose
//    public String catalogVisibility;
//    @SerializedName("description")
//    @Expose
//    public String description;
//    @SerializedName("short_description")
//    @Expose
//    public String shortDescription;
//    @SerializedName("sku")
//    @Expose
//    public String sku;
//    @SerializedName("price")
//    @Expose
//    public String price;
//    @SerializedName("regular_price")
//    @Expose
//    public String regularPrice;
//    @SerializedName("sale_price")
//    @Expose
//    public String salePrice;
//    @SerializedName("date_on_sale_from")
//    @Expose
//    public Object dateOnSaleFrom;
//    @SerializedName("date_on_sale_from_gmt")
//    @Expose
//    public Object dateOnSaleFromGmt;
//    @SerializedName("date_on_sale_to")
//    @Expose
//    public Object dateOnSaleTo;
//    @SerializedName("date_on_sale_to_gmt")
//    @Expose
//    public Object dateOnSaleToGmt;
//    @SerializedName("on_sale")
//    @Expose
//    public Boolean onSale;
//    @SerializedName("purchasable")
//    @Expose
//    public Boolean purchasable;
//    @SerializedName("total_sales")
//    @Expose
//    public Integer totalSales;
//    @SerializedName("virtual")
//    @Expose
//    public Boolean virtual;
//    @SerializedName("downloadable")
//    @Expose
//    public Boolean downloadable;
//    @SerializedName("downloads")
//    @Expose
//    public List<Object> downloads = null;
//    @SerializedName("download_limit")
//    @Expose
//    public Integer downloadLimit;
//    @SerializedName("download_expiry")
//    @Expose
//    public Integer downloadExpiry;
//    @SerializedName("external_url")
//    @Expose
//    public String externalUrl;
//    @SerializedName("button_text")
//    @Expose
//    public String buttonText;
//    @SerializedName("tax_status")
//    @Expose
//    public String taxStatus;
//    @SerializedName("tax_class")
//    @Expose
//    public String taxClass;
//    @SerializedName("manage_stock")
//    @Expose
//    public Boolean manageStock;
//    @SerializedName("stock_quantity")
//    @Expose
//    public Object stockQuantity;
//    @SerializedName("backorders")
//    @Expose
//    public String backorders;
//    @SerializedName("backorders_allowed")
//    @Expose
//    public Boolean backordersAllowed;
//    @SerializedName("backordered")
//    @Expose
//    public Boolean backordered;
//    @SerializedName("sold_individually")
//    @Expose
//    public Boolean soldIndividually;
//    @SerializedName("weight")
//    @Expose
//    public String weight;
//    @SerializedName("dimensions")
//    @Expose
//    public Dimensions dimensions;
//    @SerializedName("shipping_required")
//    @Expose
//    public Boolean shippingRequired;
//    @SerializedName("shipping_taxable")
//    @Expose
//    public Boolean shippingTaxable;
//    @SerializedName("shipping_class")
//    @Expose
//    public String shippingClass;
//    @SerializedName("shipping_class_id")
//    @Expose
//    public Integer shippingClassId;
//    @SerializedName("reviews_allowed")
//    @Expose
//    public Boolean reviewsAllowed;
//    @SerializedName("average_rating")
//    @Expose
//    public String averageRating;
//    @SerializedName("rating_count")
//    @Expose
//    public Integer ratingCount;
//    @SerializedName("upsell_ids")
//    @Expose
//    public List<Object> upsellIds = null;
//    @SerializedName("cross_sell_ids")
//    @Expose
//    public List<Object> crossSellIds = null;
//    @SerializedName("parent_id")
//    @Expose
//    public Integer parentId;
//    @SerializedName("purchase_note")
//    @Expose
//    public String purchaseNote;
//    @SerializedName("categories")
//    @Expose
//    public List<Category> categories = null;
//    @SerializedName("tags")
//    @Expose
//    public List<Object> tags = null;
//    @SerializedName("images")
//    @Expose
//    public List<Image> images = null;
//    @SerializedName("attributes")
//    @Expose
//    public List<Object> attributes = null;
//    @SerializedName("default_attributes")
//    @Expose
//    public List<Object> defaultAttributes = null;
//    @SerializedName("variations")
//    @Expose
//    public List<Object> variations = null;
//    @SerializedName("grouped_products")
//    @Expose
//    public List<Object> groupedProducts = null;
//    @SerializedName("menu_order")
//    @Expose
//    public Integer menuOrder;
//    @SerializedName("price_html")
//    @Expose
//    public String priceHtml;
//    @SerializedName("related_ids")
//    @Expose
//    public List<Integer> relatedIds = null;
//    @SerializedName("meta_data")
//    @Expose
//    public List<MetaDatum> metaData = null;
//    @SerializedName("stock_status")
//    @Expose
//    public String stockStatus;
//    @SerializedName("brands")
//    @Expose
//    public List<Brand> brands = null;
//    @SerializedName("_links")
//    @Expose
//    public Links links;
//
//}
//-----------------------------------com.project.Self.java-----------------------------------
//
//        package com.project;
//
//        import com.google.gson.annotations.Expose;
//        import com.google.gson.annotations.SerializedName;
//
//public class Self {
//
//    @SerializedName("href")
//    @Expose
//    public String href;
//
//}

