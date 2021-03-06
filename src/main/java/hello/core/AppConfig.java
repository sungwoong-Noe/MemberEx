package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//앱 전체를 설정하고 구성하는 클래스

@Configuration  //설정 정보라는걸 나타냄.
public class AppConfig {

    //MemberService 역할
    @Bean   //Bean: spring 컨테이너에 등록된다.
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
        //memberService를 호출하면 new MemberServiceImpl을 생성하면서 MemoryMemberRepository의 구현체를 주입시켜준다.
    }

    //구현 클래스
    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();    //회원 저장은 메모리 방식을 쓸거야.
    }


    //누군가 OrderService를 조회하면 OrderServiceImpl이 반환이 되는데 거기에는 MemoryMemberRepository와 FixDiscountPolicy가 들어감

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    //할인정책 구현 클래스
    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy(); //할인정책을 RateDiscountPolicy 쓸거야.
    }
}
