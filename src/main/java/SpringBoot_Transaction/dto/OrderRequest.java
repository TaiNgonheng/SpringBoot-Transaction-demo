package SpringBoot_Transaction.dto;

import SpringBoot_Transaction.entity.Order;
import SpringBoot_Transaction.entity.Payment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class OrderRequest {
    private Order order;
    private Payment payment;
}
