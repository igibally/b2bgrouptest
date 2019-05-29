package com.b2bgroup.dataaccessobject;

import java.util.List;

import com.b2bgroup.domainobject.ProductDO;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Database Access Object for product table.
 * <p/>
 */
public interface ProductRepository extends CrudRepository<ProductDO, Long>
{

     public List<ProductDO> findByTitle(String title);
     public List<ProductDO> findByDescription(String title);
     @Query(value="select * from product p where p.title like %:title% or p.description like %:description%", nativeQuery=true)
     List<ProductDO> findproductByNameOrDescription(@Param("title") String keyword,@Param("description")String description);
     
     
     
     
   
}
