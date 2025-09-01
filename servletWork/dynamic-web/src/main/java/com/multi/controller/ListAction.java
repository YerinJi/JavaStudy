package com.multi.controller;

import com.multi.util.DBUtil;
import com.multi.vo.EmpVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListAction implements Action {
    private String path;
    private boolean isRedirect;

    public ListAction(String path, boolean isRedirect) {
        this.path = path;
        this.isRedirect = isRedirect;
    }

    @Override
    public ActionForWard execute(HttpServletRequest request, HttpServletResponse response){
        //비즈니스 로직
        System.out.println("ListAction execute");
        request.setAttribute("arraylist","hello world");
//        System.out.println("Connection=" + DBUtil.getConnection());
        Connection connection = null;
        String sql = "SELECT * FROM EMP";
        PreparedStatement pstmt=null;
        ResultSet resultSet = null;
        List<EmpVO> empVOList=new ArrayList<EmpVO>();
        try{
            connection=DBUtil.getConnection();
            pstmt=connection.prepareStatement(sql);
            resultSet=pstmt.executeQuery();
            while(resultSet.next()){
                EmpVO empVO=new EmpVO();
                empVO.setEmpno(resultSet.getInt("empno"));
                empVO.setEname(resultSet.getString("ename"));
                empVO.setJob(resultSet.getString("job"));
                empVO.setSal(resultSet.getInt("sal"));
//                empVO.setComm(resultSet.getInt("comm"));
//                empVO.setDeptno(resultSet.getInt("deptno"));
                empVO.setHiredate(resultSet.getString("hiredate"));
//                empVO.setMgr(resultSet.getInt("mgr"));
                empVOList.add(empVO);

            }
        }catch(Exception e){ //tuple별로 데이터를 가져온다
            e.printStackTrace(); //console Exception 발생

        }finally {
            try{
                if(connection!=null||pstmt!=null ||resultSet!=null){
                    connection.close();
                    pstmt.close();
                    resultSet.close();

                }
            }catch(Exception e){

            }

        }
        //empVOList를 list라는 이름으로 request에 저장
        request.setAttribute("list",empVOList);

        return new ActionForWard(path, isRedirect);
    }
}
