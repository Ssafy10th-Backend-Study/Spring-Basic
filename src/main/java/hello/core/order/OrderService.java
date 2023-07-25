package hello.core.order;

public interface OrderService {

    Order createService(Long memberId, String itemName, int itemPrice);
}
