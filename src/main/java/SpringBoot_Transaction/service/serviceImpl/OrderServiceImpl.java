package SpringBoot_Transaction.service.serviceImpl;

import SpringBoot_Transaction.dto.OrderRequest;
import SpringBoot_Transaction.dto.OrderResponse;
import SpringBoot_Transaction.entity.Order;
import SpringBoot_Transaction.entity.Payment;
import SpringBoot_Transaction.exception.PaymentException;
import SpringBoot_Transaction.repository.OrderRepository;
import SpringBoot_Transaction.repository.PaymentRepository;
import SpringBoot_Transaction.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;
    @Override
    public OrderResponse placeOrder(OrderRequest orderRequest) {
        Order order = orderRequest.getOrder();
        order.setStatus("INPROGRESS");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        Payment payment = orderRequest.getPayment();
        if (!payment.getType().equals("DEBIT")){
            throw new PaymentException("Payment card type do not support");
        }
        payment.setOrderId(order.getId());
        paymentRepository.save(payment);
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESS.!!");
        return null;
    }
}