package com.b2bgroup;

import static org.junit.Assert.*;

import  org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.b2bgroup.B2BGroupServerApplicantTestApplication;
import com.b2bgroup.controller.mapper.ProductMapper;
import com.b2bgroup.datatransferobject.ProductDTO;
import com.b2bgroup.exception.ConstraintsViolationException;
import com.b2bgroup.exception.EntityNotFoundException;
import com.b2bgroup.service.product.ProductService;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = B2BGroupServerApplicantTestApplication.class)
public class B2BGroupServerApplicantTest
{

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductDTO productDTO;

    @Autowired
    private ProductMapper productMapper;


    @Test
    public void testCreateProduct() throws ConstraintsViolationException
    {

        ProductDTO productDto = ProductDTO.newBuilder()
            .setTitle("chipsey2")
            .setDietaryFlags(" vegan, lactose-free,")
            .setImage_url("http://image.com/1.jpg")
            .setPrice(3.55).setVendor_ID(12L)
            .setDescription("this is my first test chipcy product").createProductDTO();

        ProductDTO createdProductDto = ProductMapper.makeProductDTO(productService.create(ProductMapper.makeProductDO(productDto)));

        assertEquals("create test fail", productDto.getTitle(), createdProductDto.getTitle());
        assertEquals("create test fail", productDto.getDescription(), createdProductDto.getDescription());
    }


    @Test
    public void testUpdateProduct() throws ConstraintsViolationException, EntityNotFoundException
    {

        ProductDTO productDto = ProductDTO.newBuilder()
            .setTitle("chipsey7727")
            .setDietaryFlags(" vegan, lactose-free,")
            .setImage_url("http://image.com/1.jpg")
            .setPrice(3.55).setVendor_ID(13L)
            .setDescription("this is my first test chipcy product").createProductDTO();

        ProductDTO createdProductDto = ProductMapper.makeProductDTO(productService.create(ProductMapper.makeProductDO(productDto)));

        ProductDTO productDtoUpdate = ProductDTO.newBuilder()
            .setTitle("chipsey772799999999")
            .setDietaryFlags(" vegan, lactose-free,")
            .setImage_url("http://image.com/1.jpg")
            .setPrice(3.55).setVendor_ID(12L)
            .setDescription("this is my first test chipcy product").createProductDTO();

        ProductDTO UpdatedProductDto = ProductMapper.makeProductDTO(productService.update(ProductMapper.makeProductDO(productDtoUpdate), createdProductDto.getId()));

        assertEquals("update test fail", UpdatedProductDto.getTitle(), productDtoUpdate.getTitle());

    }
    @Test
    public void testDeleteProduct() throws ConstraintsViolationException, EntityNotFoundException
    {

        ProductDTO productDto = ProductDTO.newBuilder()
            .setTitle("chipsey7727")
            .setDietaryFlags(" vegan, lactose-free,")
            .setImage_url("http://image.com/1.jpg")
            .setPrice(3.55).setVendor_ID(13L)
            .setDescription("this is my first test chipcy product").createProductDTO();

        ProductDTO createdProductDto = ProductMapper.makeProductDTO(productService.create(ProductMapper.makeProductDO(productDto)));

        ProductDTO productDtoUpdate = ProductDTO.newBuilder()
            .setTitle("chipsey772799999999")
            .setDietaryFlags(" vegan, lactose-free,")
            .setImage_url("http://image.com/1.jpg")
            .setPrice(3.55).setVendor_ID(12L)
            .setDescription("this is my first test chipcy product").createProductDTO();
        productService.delete(createdProductDto.getId());
        assertEquals(true, productService.find(createdProductDto.getId()).getDeleted());
    }
    
    
    @Before
    @After
    public void removeTableData()
    {
        System.out.println("remove all data");
        productService.removeData();
    }

}
