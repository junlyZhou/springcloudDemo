package com.junly.repository;

import com.junly.pojo.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * @description
 * @author junly
 * @date 2018/12/16
 * @param
 * @throws
 * @return
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAll();

    List<Product> findAllByProductStatus(Integer productStatus);


}
