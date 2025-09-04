package com.multi.board.service;
import com.multi.board.dao.MemberDao;
import com.multi.board.dto.Member;
import com.multi.board.exception.AppException;
import com.multi.board.exception.AuthException;
import com.multi.board.util.PasswordEncoder;
import com.multi.board.util.Validation;
import java.sql.SQLException;

public class MemberServiceImpl implements MemberService {
    private final MemberDao dao = new MemberDao();

    @Override public Member join(String u, String p, String n) {
        try{
            Validation.requireText(u,3,30,"아이디");
            Validation.requireText(p,8,100,"비밀번호");
            Validation.requireText(n,1,30,"닉네임");
            if(dao.existsByUsername(u)) System.out.println("이미 존재하는 아이디입니다.");
            Member m=new Member(); m.setUsername(u); m.setPassword(PasswordEncoder.hash(p)); m.setNickname(n);
            long id=dao.insert(m); return dao.findById(id);
        }catch(SQLException e){
            System.out.println("회원가입 오류");
        }
        return null;
    }

    @Override public Member login(String u, String p) {
        try{
            Validation.requireText(u,1,30,"아이디"); Validation.requireText(p,1,100,"비밀번호");
            Member m=dao.findByUsername(u);
            if(m==null || !PasswordEncoder.matches(p, m.getPassword())) System.out.println("아이디 또는 비밀번호가 올바르지 않습니다.");;
            m.setPassword(null); return m;
        }catch(SQLException e){
            System.out.println("로그인 오류");
        }
        return null;
    }

    @Override public Member findById(long id){
        try{ return dao.findById(id); }catch(SQLException e){
            System.out.println("회원조회 오류");
        }
        return null;
    }
}
