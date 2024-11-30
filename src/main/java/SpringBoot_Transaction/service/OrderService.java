package SpringBoot_Transaction.service;

import SpringBoot_Transaction.dto.OrderRequest;
import SpringBoot_Transaction.dto.OrderResponse;

public interface OrderService{
    OrderResponse placeOrder(OrderRequest orderRequest);
}
