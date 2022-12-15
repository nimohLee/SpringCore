package hello.core.discount;

import hello.core.member.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_o() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);
        //when
        int result = discountPolicy.discount(member, 20000);
        //then
        assertThat(result).isEqualTo(2000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    void vip_x() {
        //given
        Member member = new Member(1L, "memberB", Grade.BASIC);
        //when
        int result = discountPolicy.discount(member, 20000);
        //then
        assertThat(result).isEqualTo(0);
    }

}