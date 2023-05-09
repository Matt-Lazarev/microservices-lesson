package com.lazarev.orderservice.service;

import com.lazarev.orderservice.client.ProductClient;
import com.lazarev.orderservice.dto.OrderDto;
import com.lazarev.orderservice.dto.ProductDto;
import com.lazarev.orderservice.entity.Order;
import com.lazarev.orderservice.mapper.OrderMapper;
import com.lazarev.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final ProductClient productClient;

    public List<OrderDto> getAllOrders(){
        return orderMapper.toOrderDtoList(orderRepository.findAll());
    }

    public void saveNewOrder(OrderDto orderDto){
        ProductDto product = productClient.getProductById(orderDto.productId());
        if(product != null){
            Order order = orderMapper.toOrder(orderDto);
            orderRepository.save(order);
            return;
        }
        throw new RuntimeException("No such product");
    }
}
