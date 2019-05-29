package com.b2bgroup.service.product;

import com.b2bgroup.dataaccessobject.ProductRepository;
import com.b2bgroup.domainobject.ProductDO;
import com.b2bgroup.exception.ConstraintsViolationException;
import com.b2bgroup.exception.EntityNotFoundException;
import com.b2bgroup.service.product.ProductService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service to encapsulate the link between DAO and controller and to have business logic for some product specific things.
 * <p/>
 */
@Service
public class DefaultProductService implements ProductService
{

    private static final Logger LOG = LoggerFactory.getLogger(DefaultProductService.class);

    private final ProductRepository productRepository;


    public DefaultProductService(final ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    @PersistenceContext
    private EntityManager entityManager;


    /**
     *.select the product by id
     * @param productId
     * @return found product
     * @throws EntityNotFoundException if no product with the given id was found.
     */
    @Override
    public ProductDO find(Long productId) throws EntityNotFoundException
    {
        return findproductChecked(productId);
    }


    /**
     * Creates a new product and save it in the database.
     * @param productDO
     * @return the prsisted object in the database.
     * @throws ConstraintsViolationException if a product already exists with the given username, ... .
     */
    @Override
    public ProductDO create(ProductDO productDO) throws ConstraintsViolationException
    {
        ProductDO product;
        try
        {
            product = productRepository.save(productDO);
        }
        catch (DataIntegrityViolationException e)
        {
            LOG.warn("ConstraintsViolationException while creating a product: {}", productDO.getId(), e);
            throw new ConstraintsViolationException(e.getMessage());
        }
        return product;
    }


    /**
     * Deletes an existing product object by id.(soft-delete)  
     * set the delete flag to true
     * @param productId
     * @throws EntityNotFoundException if no product with the given id was found.
     */
    @Override
    @Transactional
    public void delete(Long productId) throws EntityNotFoundException
    {
        ProductDO productDO = findproductChecked(productId);
        productDO.setDeleted(true);
    }


    /**
     *  method to be used to find the product by id.
     * @param productId
     * @return product selected
     * @throws EntityNotFoundException
     */

    private ProductDO findproductChecked(Long productId) throws EntityNotFoundException
    {
        return productRepository.findById(productId)
            .orElseThrow(() -> new EntityNotFoundException("Could not find entity with id: " + productId));
    }

   
    /**
     * method to be used to update the  product id.
     * @param productId and product data to be updated
     * @return product updated
     * @throws EntityNotFoundException
     */
    @Transactional
    @Override
    public ProductDO update(ProductDO productDO, Long productId) throws EntityNotFoundException
    {
        ProductDO productDO_ = findproductChecked(productId);
        productDO_.setTitle(productDO.getTitle());
        productDO_.setDietaryFlags(productDO.getDietaryFlags());
        productDO_.setId(productId);
        productDO_.setDescription(productDO.getDescription());
        productDO_.setImage_url(productDO.getImage_url());
        productDO_.setVendor_ID(productDO.getVendor_ID());
        productDO_.setPrice(productDO.getPrice());
        return productDO_;
    }

    /**
     * Method to be used to search  for product by title and description 
     * @param search criteria object {title and description}
     * @return list of products
     */
    @Override
    public List<ProductDO> search(String productTitle, String productDescription)
    {
        // TODO Auto-generated method stub
        List<ProductDO> productList = null;
        if (productTitle != null && productDescription != null)
            productList = productRepository.findproductByNameOrDescription(productTitle, productDescription);

        else if (productTitle != null && productDescription == null)
            productList = productRepository.findByTitle(productTitle);

        else if (productDescription != null && productTitle == null)
            productList = productRepository.findByDescription(productDescription);

        return productList;
    }


    @Override
    public void removeData()
    {
        productRepository.deleteAll();
    }

}
