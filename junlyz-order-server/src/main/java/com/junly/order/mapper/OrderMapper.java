package com.junly.order.mapper;

import com.junly.order.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface OrderMapper {

    public List<Order> queryOrderByStatus(Integer orderStatus);

}
