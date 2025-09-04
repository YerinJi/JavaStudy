package com.multi.board.service;
import com.multi.board.dao.BoardDao;
import com.multi.board.dto.Board;
import com.multi.board.dto.PageRequest;
import com.multi.board.dto.PageResult;
import com.multi.board.util.Validation;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class BoardServiceImpl implements BoardService {
    private final BoardDao dao = new BoardDao();

    @Override public PageResult<Board> list(PageRequest pr, String type, String q){
        try{
            int total=dao.count(type,q);
            List<Board> items=dao.findAll(pr,type,q);
            if (items == null) items = Collections.emptyList();
            return new PageResult<>(items,total,pr.getPage(),pr.getSize());
        }catch(SQLException e){
            e.printStackTrace();
            return new PageResult<>(Collections.EMPTY_LIST,0,pr.getSize(),pr.getPage());
        }
    }

    @Override public Board view(long id){
        try{
            Board b=dao.viewAndIncrease(id);
            if(b==null) System.out.println("게시글이 없습니다.");;
            return b;
        }catch(SQLException e){
            System.out.println("상세 조회 오류");
            return null;
        }
    }

    @Override public long write(String title, String content, long writerId){
        try{
            Validation.requireText(title,1,200,"제목");
            Validation.requireText(content,1,10000,"내용");
            Board b=new Board(); b.setTitle(title); b.setContent(content); b.setWriterId((int) writerId);
            return dao.insert(b);
        }catch(SQLException e){
            System.out.println("작성오류");
            return 0L;
        }
    }

    @Override public void edit(long id, String title, String content, long loginMemberId){
        try{
            Validation.requireText(title,1,200,"제목");
            Validation.requireText(content,1,10000,"내용");
            Board origin=dao.findById(id);
            if(origin.getWriterId()!=loginMemberId) System.out.println("작성자만 수정할 수 있습니다.");
            origin.setTitle(title); origin.setContent(content);
            if(dao.update(origin, loginMemberId)==0) System.out.println("수정에 실패했습니다.");
        }catch(SQLException e){
            System.out.println("수정 오류"); }
    }

    @Override public void remove(long id, long loginMemberId){
        try{
            Board origin=dao.findById(id);
            if(origin.getWriterId()!=loginMemberId) System.out.println("작성자만 삭제할 수 있습니다.");
            if(dao.delete(id, loginMemberId)==0) System.out.println("삭제에 실패했습니다.");
        }catch(SQLException e){
            System.out.println("삭제 오류"); }
    }
}
