package hello.core.discount;

import hello.core.member.Gradle;
import hello.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{
    private int discountPercent = 10;   //할인율 10퍼센트

    @Override
    public int discount(Member member, int price) {
        if(member.getGradle() == Gradle.VIP){
            return price * discountPercent/100;
        }else{
            return 0;
        }
    }
}
