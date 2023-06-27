package com.mantvydas.restaurant.rest;

import com.mantvydas.restaurant.mapper.MenuMapper;
import com.mantvydas.restaurant.mapper.OrderMapper;
import com.mantvydas.restaurant.model.Order;
import com.mantvydas.restaurant.model.User;
import com.mantvydas.restaurant.rest.dto.MenuDto;
import com.mantvydas.restaurant.rest.dto.OrderDto;
import com.mantvydas.restaurant.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mantvydas.restaurant.config.SwaggerConfig.BEARER_KEY_SECURITY_SCHEME;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/order")
public class OrderController {

    private final OrderService orderService;

    @Operation(security = {@SecurityRequirement(name = BEARER_KEY_SECURITY_SCHEME)})
    @GetMapping("/get-order/{orderID}")
    public ResponseEntity<Order> getOrderByID (@PathVariable String orderID) {
        return ResponseEntity.ok(orderService.getOrderByID(orderID));
    }

    @Operation(security = {@SecurityRequirement(name = BEARER_KEY_SECURITY_SCHEME)})
    @GetMapping("/get-my-orders")
    public ResponseEntity<List<Order>> getOrdersOfUser (@RequestParam String email) {
        return ResponseEntity.ok(orderService.getUserOrders(email));
    }

    @Operation(security = {@SecurityRequirement(name = BEARER_KEY_SECURITY_SCHEME)})
    @GetMapping("/get-all-orders")
    public ResponseEntity<List<Order>> getAllOrders () {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @Operation(security = {@SecurityRequirement(name = BEARER_KEY_SECURITY_SCHEME)})
    @DeleteMapping("/delete-order")
    public void deleteOrder (@RequestParam String orderID) {
        orderService.deleteOrder(orderID);
    }

    @Operation(security = {@SecurityRequirement(name = BEARER_KEY_SECURITY_SCHEME)})
    @PutMapping("/accept-order")
    public void acceptOrder (@RequestParam String orderID) {
        orderService.acceptOrder(orderID);
    }

    @Operation(security = {@SecurityRequirement(name = BEARER_KEY_SECURITY_SCHEME)})
    @PostMapping("/create-order")
    public ResponseEntity<Boolean> createOrder (@RequestParam String email, @RequestParam String menuID, @RequestBody OrderDto orderDtoToCreate) {
        return ResponseEntity.ok(orderService.createNewOrder(email, menuID, OrderMapper.orderDtoToNewOrder(orderDtoToCreate)));
    }
}
