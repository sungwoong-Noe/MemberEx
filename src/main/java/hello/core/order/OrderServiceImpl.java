package hello.core.order;

import hello.core.discount.DiscountPolicy;

import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    //MemberRepository에서 회원 찾아야함 
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    
    //DiscountPolicy 필요함
    private DiscountPolicy discountPolicy; //추상화한 인터페이스만 의존 : DIP 만족



    @Override
    public Order createOrder(Long memnberId, String itemName, int itemPrice) {
        //주문이 오면
        Member member = memberRepository.findById(memnberId); //회원정보를 찾아 Member 타입으로 member에 담는다.
        int discountPrice = discountPolicy.discount(member, itemPrice);//할인 정책에 회원을 넘김, discount 메서드에서 회원 등급을 보고 할인을 적용
        //OrderService는 할인에 관여하지 않는다. 할인은 discountPrice에서 알아서 하도록

        //Order를 만들어서 반환
        return new Order(memnberId, itemName, itemPrice, discountPrice);
    }
}
