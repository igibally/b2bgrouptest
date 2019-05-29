package com.b2bgroup.domainobject;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "product")
public class ProductDO
{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private Double price;


    private Long vendor_ID;

    private String image_url;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateCreated = ZonedDateTime.now();

    private String title;

    private String description;

    private String dietaryFlags;

    private int numberOfViews=0;

    @Column(nullable = false)
    private Boolean deleted= false;


    public ProductDO()
    {

    }
    public ProductDO(
        Long id, Double price, Long vendor_ID, String image_url,String title, String description, String dietaryFlags)
    {
        this.id = id;
        this.price = price;
        this.vendor_ID = vendor_ID;
        this.image_url = image_url;
        this.title = title;
        this.description = description;
        this.dietaryFlags = dietaryFlags;
    }
    public Long getId()
    {
        return id;
    }


    public void setId(Long id)
    {
        this.id = id;
    }


    public Double getPrice()
    {
        return price;
    }


    public void setPrice(Double price)
    {
        this.price = price;
    }


    public Long getVendor_ID()
    {
        return vendor_ID;
    }


    public void setVendor_ID(Long vendor_ID)
    {
        this.vendor_ID = vendor_ID;
    }


    public String getImage_url()
    {
        return image_url;
    }


    public void setImage_url(String image_url)
    {
        this.image_url = image_url;
    }


    public ZonedDateTime getDateCreated()
    {
        return dateCreated;
    }


    public void setDateCreated(ZonedDateTime dateCreated)
    {
        this.dateCreated = dateCreated;
    }


    public String getTitle()
    {
        return title;
    }


    public void setTitle(String title)
    {
        this.title = title;
    }


    public String getDescription()
    {
        return description;
    }


    public void setDescription(String description)
    {
        this.description = description;
    }


    public String getDietaryFlags()
    {
        return dietaryFlags;
    }


    public void setDietaryFlags(String dietaryFlags)
    {
        this.dietaryFlags = dietaryFlags;
    }


    public int getNumberOfViews()
    {
        return numberOfViews;
    }


    public void setNumberOfViews(int numberOfViews)
    {
        this.numberOfViews = numberOfViews;
    }
    
    public Boolean getDeleted()
    {
        return deleted;
    }


    public void setDeleted(Boolean deleted)
    {
        this.deleted = deleted;
    }

}
