package com.company.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.Spring_Annotation_Board.user.UserDAO;
import com.company.Spring_Annotation_Board.user.UserDO;

/* LoginControlle Class = POJO Class*/

@Controller
public class LoginController {
	
	@RequestMapping("/login.do")
	public String login(UserDO userDO, UserDAO userDAO, HttpSession session) {
		
		UserDO user= userDAO.getUser(userDO);
		
		if(user != null) {
			session.setAttribute("idkey", user.getId());
			System.out.println("Login Soccess");
			return "getBoardList.do";
		}else {
			System.out.println("Login Faild");
			return "login.jsp";
		}
	}
}
