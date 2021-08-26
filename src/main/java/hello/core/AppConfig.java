package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

//앱 전체를 설정하고 구성하는 클래스
public class AppConfig {

    //
    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
        //memberService를 호출하면 new MemberServiceImpl을 생성하면서 MemoryMemberRepository의 구현체를 주입시켜준다.
    }

    //누군가 OrderService를 조회하면 OrderServiceImpl이 반환이 되는데 거기에는 MemoryMemberRepository와 FixDiscountPolicy가 들어감
    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
