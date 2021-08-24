package hello.core.discount;

import hello.core.member.Gradle;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000; //1000원 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGradle() == Gradle.VIP) { //회원의 등급이 VIP가 맞다면 할인금액 리턴
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
