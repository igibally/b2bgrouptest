package com.b2bgroup.service.product;

import com.b2bgroup.domainobject.ProductDO;
import com.b2bgroup.exception.ConstraintsViolationException;
import com.b2bgroup.exception.EntityNotFoundException;
import com.b2bgroup.exception.SearchCriteriaException;

import java.util.List;

public interface ProductService
{

    ProductDO find(Long productId) throws EntityNotFoundException;


    ProductDO create(ProductDO productDO) throws ConstraintsViolationException ;

    ProductDO update(ProductDO productDO,Long productId) throws EntityNotFoundException;

    void delete(Long productId) throws EntityNotFoundException;
    void removeData();
    List<ProductDO> search(String productTitle,String productDescription);
    
    

}
