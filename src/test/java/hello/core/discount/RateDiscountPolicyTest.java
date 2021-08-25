package hello.core.discount;

import hello.core.member.Gradle;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    //성공 테스트
    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")  //한글로 이름 쓸 수 있음 Junit 기능
    void vip_o(){
        //given
        Member member = new Member(1L, "memberVIP", Gradle.VIP);

        //when
        int discount = discountPolicy.discount(member, 10000);  //멤버와 가격을 넘겨서 할인된 가격을 받음

        //then
        assertThat(discount).isEqualTo(1000);    //할인된 가격이 저장된 변수 discount와 1000이 같은지 비교
    }


    @Test
    @DisplayName("Vip가 아니면 할인이 적용되면 안된다.")
    void vip_x(){
        //given
        Member member = new Member(2L, "memberVIP", Gradle.BASIC);

        //when
        int discount = discountPolicy.discount(member, 10000);  //멤버와 가격을 넘겨서 할인된 가격을 받음

        //then
        assertThat(discount).isEqualTo(0);    //할인된 가격이 저장된 변수 discount와 1000이 같은지 비교
    }
}