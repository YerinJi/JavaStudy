package com.multi.di.di3;

public class MemberServiceWithSetter {
    private MemberRepository memberRepository;

    public MemberServiceWithSetter() {
        System.out.println("MemberServiceWithSetter");
    }

    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void  join(Member m){
        memberRepository.save(m);
    }
    public Member get(Long id) {
        return memberRepository.findById(id);
    }
}
