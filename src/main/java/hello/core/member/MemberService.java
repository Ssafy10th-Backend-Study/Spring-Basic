package hello.core.member;

public interface MemberService {
    //회원가입, 회원조회 기능

    void join(Member member);
    Member findMember(Long memberId);
}
