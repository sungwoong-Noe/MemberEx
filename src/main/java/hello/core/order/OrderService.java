package hello.core.order;

public interface OrderService {
    //주문할 때 회원ID, 상품명, 상품 가격을 넘겨야한다. 리턴으로 주문결과를 반환
    Order createOrder(Long memnberId, String itemName, int itemPrice);

}
