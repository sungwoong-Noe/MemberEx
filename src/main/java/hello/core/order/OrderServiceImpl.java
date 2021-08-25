package hello.core.order;

import hello.core.discount.DiscountPolicy;

import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    //MemberRepository에서 회원 찾아야함 
    private final MemberRepository memberRepository;
    //DiscountPolicy 필요함
    private final DiscountPolicy discountPolicy; //추상화한 인터페이스만 의존 : DIP 만족

    //final로 되어있으면 무조건 기본으로 할당하든 생성자를 통해 할당하든 해야함.

    //생성자
    //생성자에서는 인터페이스를 통해 구현체가 뭐가 들어올지 알 수 없음. 그냥 구현하는 것임
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }



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
