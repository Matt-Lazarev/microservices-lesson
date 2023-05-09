package com.lazarev.orderservice.controller;

import com.lazarev.orderservice.dto.OrderDto;
import com.lazarev.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public List<OrderDto> getAllOrders(){
        return orderService.getAllOrders();
    }

    @PostMapping
    public void saveOrder(@RequestBody OrderDto orderDto){
        orderService.saveNewOrder(orderDto);
    }
}
