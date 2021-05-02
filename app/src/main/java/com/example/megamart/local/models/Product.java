package com.example.megamart.local.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.megamart.business.models.Brand;
import com.example.megamart.business.models.Category;
import com.example.megamart.business.models.Image;

import java.util.List;
@Entity
public class Product {
    @PrimaryKey
    public Integer id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "slug")
    public String slug;

    @ColumnInfo(name = "permalink")
    public String permalink;

    @ColumnInfo(name = "date_created")
    public String dateCreated;

    @ColumnInfo(name = "date_created_gmt")
    public String dateCreatedGmt;

    @ColumnInfo(name = "date_modified")
    public String dateModified;

    @ColumnInfo(name = "date_modified_gmt")
    public String dateModifiedGmt;

    @ColumnInfo(name = "type")
    public String type;

    @ColumnInfo(name = "status")
    public String status;

    @ColumnInfo(name = "featured")
    public Boolean featured;

    @ColumnInfo(name = "catalog_visibility")
    public String catalogVisibility;

    @ColumnInfo(name = "description")
    public String description;

    @ColumnInfo(name = "short_description")
    public String shortDescription;

    @ColumnInfo(name = "sku")
    public String sku;

    @ColumnInfo(name = "price")
    public String price;

    @ColumnInfo(name = "regular_price")
    
    public String regularPrice;
    @ColumnInfo(name = "sale_price")
    
    public String salePrice;
    @ColumnInfo(name = "date_on_sale_from")
    
    public Object dateOnSaleFrom;
    @ColumnInfo(name = "date_on_sale_from_gmt")
    
    public Object dateOnSaleFromGmt;
    @ColumnInfo(name = "date_on_sale_to")
    
    public Object dateOnSaleTo;
    @ColumnInfo(name = "date_on_sale_to_gmt")
    
    public Object dateOnSaleToGmt;
    @ColumnInfo(name = "on_sale")
    
    public Boolean onSale;
    @ColumnInfo(name = "purchasable")
    
    public Boolean purchasable;
    @ColumnInfo(name = "total_sales")
    
    public Integer totalSales;
    @ColumnInfo(name = "virtual")
    
    public Boolean virtual;
    @ColumnInfo(name = "downloadable")
    
    public Boolean downloadable;
    @ColumnInfo(name = "downloads")
    
    public List<Object> downloads = null;
    @ColumnInfo(name = "download_limit")
    
    public Integer downloadLimit;
    @ColumnInfo(name = "download_expiry")
    
    public Integer downloadExpiry;
    @ColumnInfo(name = "external_url")
    
    public String externalUrl;
    @ColumnInfo(name = "button_text")
    
    public String buttonText;
    @ColumnInfo(name = "tax_status")
    
    public String taxStatus;
    @ColumnInfo(name = "tax_class")
    
    public String taxClass;
    @ColumnInfo(name = "manage_stock")
    
    public Boolean manageStock;
    @ColumnInfo(name = "stock_quantity")
    
    public Object stockQuantity;
    @ColumnInfo(name = "backorders")
    
    public String backorders;
    @ColumnInfo(name = "backorders_allowed")
    
    public Boolean backordersAllowed;
    @ColumnInfo(name = "backordered")
    
    public Boolean backordered;
    @ColumnInfo(name = "sold_individually")
    
    public Boolean soldIndividually;
    @ColumnInfo(name = "weight")
    
    public String weight;
    @ColumnInfo(name = "shipping_required")
    
    public Boolean shippingRequired;
    @ColumnInfo(name = "shipping_taxable")
    
    public Boolean shippingTaxable;
    @ColumnInfo(name = "shipping_class")
    
    public String shippingClass;
    @ColumnInfo(name = "shipping_class_id")
    
    public Integer shippingClassId;
    @ColumnInfo(name = "reviews_allowed")
    
    public Boolean reviewsAllowed;
    @ColumnInfo(name = "average_rating")
    
    public String averageRating;
    @ColumnInfo(name = "rating_count")
    
    public Integer ratingCount;
    @ColumnInfo(name = "upsell_ids")
    
    public List<Object> upsellIds = null;
    @ColumnInfo(name = "cross_sell_ids")
    
    public List<Object> crossSellIds = null;
    @ColumnInfo(name = "parent_id")
    
    public Integer parentId;
    @ColumnInfo(name = "purchase_note")
    
    public String purchaseNote;
    @ColumnInfo(name = "categories")
    
    public List<Category> categories = null;
    @ColumnInfo(name = "tags")
    
    public List<Object> tags = null;
    @ColumnInfo(name = "images")
    
    public List<Image> images = null;
    @ColumnInfo(name = "attributes")
    
    public List<Object> attributes = null;
    @ColumnInfo(name = "default_attributes")
    
    public List<Object> defaultAttributes = null;
    @ColumnInfo(name = "variations")
    
    public List<Object> variations = null;
    @ColumnInfo(name = "grouped_products")
    
    public List<Object> groupedProducts = null;
    @ColumnInfo(name = "menu_order")
    
    public Integer menuOrder;
    @ColumnInfo(name = "price_html")
    
    public String priceHtml;
    @ColumnInfo(name = "related_ids")
    
    public List<Integer> relatedIds = null;
    @ColumnInfo(name = "stock_status")
    
    public String stockStatus;
    @ColumnInfo(name = "brands")
    
    public List<Brand> brands = null;
}
