package com.b2bgroup.controller.mapper;

import com.b2bgroup.datatransferobject.ProductDTO;
import com.b2bgroup.datatransferobject.ProductDTO.ProductDTOBuilder;
import com.b2bgroup.domainobject.ProductDO;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class ProductMapper
{
    public static ProductDO makeProductDO(ProductDTO ProductDTO)
    {
        return new ProductDO(ProductDTO.getId(),ProductDTO.getPrice(),ProductDTO.getVendor_ID(),ProductDTO.getImage_url(),ProductDTO.getTitle(), ProductDTO.getDescription(),ProductDTO.getDietaryFlags());
    }
    
    public static ProductDTO makeProductDTO(ProductDO ProductDO)
    {
        
        
        ProductDTOBuilder ProductDTOBuilder = ProductDTO.newBuilder()
            .setId(ProductDO.getId())
            .setTitle(ProductDO.getTitle())
            .setDateCreated(ProductDO.getDateCreated())
            .setDescription(ProductDO.getDescription())
            .setImage_url(ProductDO.getImage_url())
            .setDietaryFlags(ProductDO.getDietaryFlags())
            .setNumberOfViews(ProductDO.getNumberOfViews())
            .setPrice(ProductDO.getPrice())
            .setVendor_ID(ProductDO.getVendor_ID())
            .setDeleted(ProductDO.getDeleted());
             return ProductDTOBuilder.createProductDTO();
    }


    public static List<ProductDTO> makeProductDTOList(Collection<ProductDO> Products)
    {
        return Products.stream().map(ProductMapper::makeProductDTO).collect(Collectors.toList());
    }
    
  
}
