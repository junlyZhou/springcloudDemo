package com.junly.service.impl;

import com.junly.pojo.Product;
import com.junly.service.ProductService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
/**
 * @description 测试类的编写
 * @author junly
 * @date 2018/12/16
 * @param
 * @throws
 * @return
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductServiceImplTest {

    @Autowired
    private ProductService productService;

    /**
     * @description 测试结束的时候执行此方法
     * @author junly
     * @date 2018/12/16
     * @param []
     * @throws
     * @return void
     */
    @After
    public void tearDown() throws Exception {
        System.out.println("执行完毕");
    }

    /**
     * @description 测试方法
     * @author junly
     * @date 2018/12/16
     * @param []
     * @throws
     * @return void
     */
    @Test
    public void findAllByProductStatus() {

        List<Product> allByProductStatus = productService.findAllByProductStatus(0);

        Assert.assertTrue(allByProductStatus.size()>0);
    }
}