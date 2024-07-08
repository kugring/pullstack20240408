package frontproject.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import frontproject.dao.SampleTBDAO;
import frontproject.vo.SampleTBVO;

public class SampleTBController {

   
   public void getAction(HttpServletRequest request, HttpServletResponse response, String[] uris) throws ServletException, IOException {
      //frontcontroller에서 sampleTB관련 모든 요청을 받아서
      //각 목적에 맞는 메소드로 분기하는 영역
	   
	   System.out.println(uris);
      
      if(uris[1].equals("list.do")) {
         list(request, response);
      }else if(uris[1].equals("view.do")) {
         view(request, response);
      }
   }
   
   
   
   private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      SampleTBDAO sampleTBDao = new SampleTBDAO();
      
      List<SampleTBVO> slist = sampleTBDao.selectList();
      
      System.out.println(sampleTBDao.selectList()+"??????????????????????????");
      
      request.setAttribute("slist", slist);
      
      System.out.println("list.do 실행!!");
      
      RequestDispatcher rd = request.getRequestDispatcher("/sampleTB/list.jsp");
      rd.forward(request, response);
      
   }

   private void view(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      String snoParam = request.getParameter("sno");
      int sno = 0;
      
      if(snoParam != null && snoParam.equals("")) {
         sno = Integer.parseInt(snoParam);
      }else {
         response.sendRedirect("list.do");
      }
      
      SampleTBDAO sampleTBDao = new SampleTBDAO();
      
      SampleTBVO svo = sampleTBDao.selectOne(sno);
      
      request.setAttribute("svo", svo);
      
      RequestDispatcher rd = request.getRequestDispatcher("/sampleTB/view.jsp");
      rd.forward(request, response);
   }
   
  
   private void modify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      
	      String snoParam = request.getParameter("sno");
	      int sno = 0;
	      
	      if(snoParam != null && snoParam.equals("")) {
	         sno = Integer.parseInt(snoParam);
	      }else {
	         response.sendRedirect("list.do");
	      }
	      
	      SampleTBDAO sampleTBDao = new SampleTBDAO();
	      
	      SampleTBVO svo = sampleTBDao.selectOne(sno);
	      
	      request.setAttribute("svo", svo);
	      
	      RequestDispatcher rd = request.getRequestDispatcher("/sampleTB/modify.jsp");
	      rd.forward(request, response);
	   }
   
   
   private void modifyOk(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
	   String snoParam = request.getParameter("sno");
	      int sno = 0;
	      
	      if(snoParam != null && snoParam.equals("")) {
	         sno = Integer.parseInt(snoParam);
	      }
	      
	      String title = request.getParameter("title");
	      String writer = request.getParameter("writer");
	      String body = request.getParameter("body");
	      
	      SampleTBVO svo = new SampleTBVO();
	      svo.setSno(sno);
	      svo.setTitle(title);
	      svo.setWriter(writer);
	      svo.setBody(body);
	   
	      SampleTBDAO sampleTBDao = new SampleTBDAO();
	      int result = sampleTBDao.update(svo);
	      
	      if(result>0) {
	    	  // 수정 성공
	    	  response.sendRedirect("view.do?sno="+sno);
	      }else {
	    	  // 수정 실패
	    	  response.sendRedirect("modify.do?sno="+sno+"&msg=fail");
	      }
   }

   
   private void postAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      
	      String snoParam = request.getParameter("sno");
	      int sno = 0;
	      
	      if(snoParam != null && snoParam.equals("")) {
	         sno = Integer.parseInt(snoParam);
	      }else {
	         response.sendRedirect("modify.do");
	      }
	      
	      SampleTBDAO sampleTBDao = new SampleTBDAO();
	      
	      SampleTBVO svo = sampleTBDao.selectOne(sno);
	      
	      request.setAttribute("svo", svo);
	      
	      RequestDispatcher rd = request.getRequestDispatcher("/sampleTB/modifiy.jsp");
	      rd.forward(request, response);
	   }
   

   
   private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      
	      String snoParam = request.getParameter("sno");
	      int sno = 0;
	      
	      if(snoParam != null && snoParam.equals("")) {
	         sno = Integer.parseInt(snoParam);
	      }else {
	         response.sendRedirect("modify.do");
	      }
	      
	      SampleTBDAO sampleTBDao = new SampleTBDAO();
	      
	      SampleTBVO svo = sampleTBDao.selectOne(sno);
	      
	      request.setAttribute("svo", svo);
	      
	      RequestDispatcher rd = request.getRequestDispatcher("/sampleTB/modifiy.jsp");
	      rd.forward(request, response);
	   }   
   private void insertOk(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      
	      request.setCharacterEncoding("utf-8");
	      
	      SampleTBVO svo = new SampleTBVO();
	      svo.setTitle(request.getParameter("title"));
	      svo.setWriter(request.getParameter("writer"));
	      svo.setBody(request.getParameter("body"));
	   }
   
   
   
}
