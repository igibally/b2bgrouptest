package com.b2bgroup.controller;

import com.b2bgroup.controller.mapper.ProductMapper;
import com.b2bgroup.datatransferobject.ProductDTO;
import com.b2bgroup.datatransferobject.SearchCriteriaDTO;
import com.b2bgroup.domainobject.ProductDO;
import com.b2bgroup.exception.ConstraintsViolationException;
import com.b2bgroup.exception.EntityNotFoundException;
import com.b2bgroup.exception.SearchCriteriaException;
import com.b2bgroup.service.product.ProductService;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * All operations with a Product will be routed by this controller.
 * <p/>
 */
@RestController
@RequestMapping("v1/products")
public class ProductController
{

    private final ProductService ProductService;


    @Autowired
    public ProductController(final ProductService ProductService)
    {
        this.ProductService = ProductService;
    }

    /**
     *  APi for retrieving product with /{id}   
     * @param ProductId
     * @return productDTO
     * @throws EntityNotFoundException
     */
    @GetMapping("/{ProductId}")
    public ProductDTO getProduct(@PathVariable long ProductId) throws EntityNotFoundException
    {
        return ProductMapper.makeProductDTO(ProductService.find(ProductId));
    }

    /**
     * API for creating product in the DB 
     * @param ProductDTO
     * @return productDTO the product created.
     * @throws ConstraintsViolationException
     */

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO createProduct(@Valid @RequestBody ProductDTO ProductDTO) throws ConstraintsViolationException
    {
        ProductDO ProductDO = ProductMapper.makeProductDO(ProductDTO);
        return ProductMapper.makeProductDTO(ProductService.create(ProductDO));
    }


    /**
     * API for delete product, it set the deleted flag in the database by false.
     * @param ProductId
     * @throws EntityNotFoundException
     */
    @DeleteMapping("/{ProductId}")
    public void deleteProduct(@PathVariable long ProductId) throws EntityNotFoundException
    {
        ProductService.delete(ProductId);
    }
    
    
    /**
     * API for update product, 
     * @param ProductDTO
     * @param ProductId
     * @return productDTO the product updated 
     * @throws ConstraintsViolationException
     * @throws EntityNotFoundException
     */
    @PutMapping("/{ProductId}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO updateProduct(@Valid @RequestBody ProductDTO ProductDTO,@PathVariable long ProductId) throws ConstraintsViolationException, EntityNotFoundException
    {
        ProductDO ProductDO = ProductMapper.makeProductDO(ProductDTO);
        return ProductMapper.makeProductDTO(ProductService.update(ProductDO,ProductId));
    }
   
    /**
     * This API for search for product by title or description
     * @param searchCriteria
     * @return the search result list of products.
     * @throws SearchCriteriaException
     */

    @PostMapping("/search")
    public  List<ProductDTO> sarchProduct(@RequestBody SearchCriteriaDTO searchCriteria)
    {

        return ProductMapper.makeProductDTOList(ProductService.search(searchCriteria.getTitle(),searchCriteria.getDescription()));
    }
    
    
   
    
    
    
}
