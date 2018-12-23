package com.junly.service;

import com.junly.pojo.Product;

import java.util.List;


public interface ProductService {

    List<Product> findAllByProductStatus(Integer productStatus);

    Product findByProductId(Integer productId);

}
