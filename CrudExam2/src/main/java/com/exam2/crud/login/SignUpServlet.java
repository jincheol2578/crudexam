package com.exam2.crud.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/view/signup.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		LoginVO vo = new LoginVO();
		vo.setUserName(userName);
		vo.setPassword(password);
		boolean check = LoginDAO.check(vo);
		if(check == false) {
			LoginDAO.signup(vo);
			System.out.println("회원가입 성공");
			response.sendRedirect("/login");
		}else {
			System.out.println("중복된 아이디입니다.");
			request.setAttribute("alert", "중복된 아이디입니다.");
			response.sendRedirect("/signup");
			
		}
		
	}

}
