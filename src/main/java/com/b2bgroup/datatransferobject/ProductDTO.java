package com.b2bgroup.datatransferobject;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Component
public class ProductDTO
{

    private Long id;

    
    private Double price =0.0;

    @NotNull(message = "vendor can not be null!")
    private Long vendor_ID;

    private String image_url;
    
    private ZonedDateTime dateCreated;

    @NotNull(message = "title can not be null!")
    private String title;
    private String description;
    private String dietaryFlags;
    private int numberOfViews;
    private Boolean deleted;


    private ProductDTO()
    {
        
    }

    private ProductDTO(
        Long id, Double price, Long vendor_ID, String image_url, ZonedDateTime dateCreated, String title, String description,
        String dietaryFlags, int numberOfViews, Boolean deleted)
    {
        this.id = id;
        this.price = price;
        this.vendor_ID = vendor_ID;
        this.image_url = image_url;
        this.dateCreated = dateCreated;
        this.title = title;
        this.description = description;
        this.dietaryFlags = dietaryFlags;
        this.numberOfViews = numberOfViews;
        this.deleted = deleted;
    }


    public static ProductDTOBuilder newBuilder()
    {
        return new ProductDTOBuilder();
    }

    public Long getId()
    {
        return id;
    }

    
    public Double getPrice()
    {
        return price;
    }

    
    public Long getVendor_ID()
    {
        return vendor_ID;
    }


    public String getImage_url()
    {
        return image_url;
    }


    public ZonedDateTime getDateCreated()
    {
        return dateCreated;
    }


    public String getTitle()
    {
        return title;
    }


    public String getDescription()
    {
        return description;
    }


    public String getDietaryFlags()
    {
        return dietaryFlags;
    }


    public int getNumberOfViews()
    {
        return numberOfViews;
    }


    public Boolean getDeleted()
    {
        return deleted;
    }

    public static class ProductDTOBuilder
    {

        private Long id;
        private Double price;
        private Long vendor_ID;
        private String image_url;
        private ZonedDateTime dateCreated;
        private String title;
        private String description;
        private String dietaryFlags;
        private int numberOfViews;
        private Boolean deleted;


        public ProductDTOBuilder setId(Long id)
        {
            this.id = id;
            return this;
        }


        public ProductDTOBuilder setPrice(Double price)
        {
            this.price = price;
            return this;
        }


        public ProductDTOBuilder setVendor_ID(Long vendor_ID)
        {
            this.vendor_ID = vendor_ID;
            return this;
        }


        public ProductDTOBuilder setImage_url(String image_url)
        {
            this.image_url = image_url;
            return this;
        }


        public ProductDTOBuilder setDateCreated(ZonedDateTime dateCreated)
        {
            this.dateCreated = dateCreated;
            return this;
        }


        public ProductDTOBuilder setTitle(String title)
        {
            this.title = title;
            return this;
        }


        public ProductDTOBuilder setDescription(String description)
        {
            this.description = description;
            return this;
        }


        public ProductDTOBuilder setDietaryFlags(String dietaryFlags)
        {
            this.dietaryFlags = dietaryFlags;
            return this;
        }


        public ProductDTOBuilder setNumberOfViews(int numberOfViews)
        {
            this.numberOfViews = numberOfViews;
            return this;
        }


        public ProductDTOBuilder setDeleted(Boolean deleted)
        {
            this.deleted = deleted;
            return this;
        }

        
        public ProductDTO createProductDTO()
        {
            return new ProductDTO(this.id,this.price,this.vendor_ID, this.image_url,this.dateCreated,this.title,this.description,this.dietaryFlags,this.numberOfViews,this.deleted);
        }

    }
}
