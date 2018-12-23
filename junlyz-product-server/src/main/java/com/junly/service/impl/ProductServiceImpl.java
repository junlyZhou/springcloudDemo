package com.junly.service.impl;

import com.junly.pojo.Product;
import com.junly.repository.ProductRepository;
import com.junly.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ProductServiceImpl
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/16 0016 11:50
 * @Version 1.0
 **/
@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAllByProductStatus(Integer productStatus) {

        System.out.println("这是service方法, productStatus:"+ productStatus);

        return productRepository.findAllByProductStatus(productStatus);

    }

    @Override
    public Product findByProductId(Integer productId) {
        log.info("根据产品id 查询产品：productId:" + productId);
        return productRepository.findByProductId(productId);
    }
}
