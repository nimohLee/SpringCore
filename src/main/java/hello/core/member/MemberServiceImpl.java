package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Autowired // ac.getBean(MemberRepository.class)랑 비슷 ( 빈에서 가져와서 컴포넌트스캔으로 넣어줌)
    public MemberServiceImpl(MemberRepository memberRepository) { // 매개변수로서 memberRepository 구현체를 의존성 주입함
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
