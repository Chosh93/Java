package com.kh.jdbc.dao;

import com.kh.jdbc.util.Common;
import com.kh.jdbc.vo.EmpVO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmpDAO {
    Connection conn = null; // 자바와 오라클에 대한 연결 설정
    Statement stmt = null; // SQL문을 수행하기 위한 객체
    ResultSet rset = null; // statement 동작에 대한 결과로 전달되는 db의 내용
    Scanner sc = new Scanner(System.in);
    public List<EmpVO> empSelect(){
        List<EmpVO> list = new ArrayList<>(); // 반환할 리스트를 위해 객체 생성
        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String query = "SELECT * FROM EMP";
            rset = stmt.executeQuery(query); // select 문과 같이 여러개의 레코드(행)로 결과가 반환 될 때 사용

            while(rset.next()){ // 읽을 행이 있으면 참
                int empNo = rset.getInt("EMPNO");
                String name = rset.getString("ENAME");
                String job = rset.getString("JOB");
                int mgr = rset.getInt("MGR");
                Date date = rset.getDate("HIREDATE");
                int sal = rset.getInt("SAL");
                int comm = rset.getInt("COMM");
                int deptNo = rset.getInt("DEPTNO");

                EmpVO vo = new EmpVO(empNo, name, job, mgr, date, sal, comm, deptNo); // 하나의 행
                list.add(vo);
            }
            Common.close(rset); // 연결과 역순으로 해제
            Common.close(stmt);
            Common.close(conn);
        } catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public void empSelectPrint(List<EmpVO> list){
        for(EmpVO e : list){
            System.out.println("사원번호 : " + e.getEmpNo());
            System.out.println("이름 : " + e.getName());
            System.out.println("직책 : " + e.getJob());
            System.out.println("매니저 : " + e.getMgr());
            System.out.println("입사일 : " + e.getDate());
            System.out.println("급여 : " + e.getSal());
            System.out.println("성과금 : " + e.getComm());
            System.out.println("부서번호 : " + e.getDeptNo());
            System.out.println("--------------------------------------------");
        }
    }
    public void empInsert(){
        System.out.println("사원 정보를 입력하세요.");
        System.out.print("사원번호(4자리) : ");
        int empNo = sc.nextInt();
        System.out.print("사원이름 : ");
        String name = sc.next();
        System.out.print("직책 : ");
        String job = sc.next();
        System.out.print("매니저 : ");
        int mgr = sc.nextInt();
        System.out.print("입사일 : ");
        String date = sc.next();
        System.out.print("급여 : ");
        int sal = sc.nextInt();
        System.out.print("성과금 : ");
        int comm = sc.nextInt();
        System.out.print("부서번호 : ");
        int deptNo = sc.nextInt();

        String query = "INSERT INTO EMP(EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES("
                + empNo + ", " + "'" + name + "'" + ", " + "'" + job + "'" + ", " + mgr + ", " + "'" + date + "'" +
                ", " + sal + ", " + comm + ", " + deptNo + ")";

        try{
            conn = Common.getConnection();
            stmt = conn.createStatement();
            int rst = stmt.executeUpdate(query);
            System.out.println("Return : " + rst);
        } catch (Exception e){
            e.printStackTrace();
        }
        Common.close(stmt);
        Common.close(conn);
    }
}
