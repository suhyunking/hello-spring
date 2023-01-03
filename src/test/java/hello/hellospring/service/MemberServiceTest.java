package hello.hellospring.service;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

//test
class MemberServiceTest {

    MemberService memberService = new MemberService();



    @Test
    void 회원가입() {
        //given : 어떤 상황이 주어졌다.
        Member member = new Member();
        member.setName("hello");

        //when : 이것을 실행 했을 때,
        Long saveId = memberService.join(member);

        //then : 이런 결과가 나와야한다.
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }


    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");


        //when
        memberService.join(member1);

        try {
            memberService.join(member2);
            fail();
        } catch (IllegalStateException e) {

        }



        //then


    }
    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}