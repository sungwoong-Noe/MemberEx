package hello.core;

import hello.core.member.Gradle;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();


        Long memberId = 1L; //id = 1
        Member member = new Member(memberId, "memberA", Gradle.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 100000);
        System.out.println("order = " + order); //order는 toString으로 출력됨.
        System.out.println("order.calculatePrice() = " + order.calculatePrice());
    }
}
