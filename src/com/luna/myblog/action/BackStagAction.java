package com.luna.myblog.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luna.myblog.entity.LunaManager;

@Controller
public class BackStagAction {
	@RequestMapping("/goBackStag")
	public String goBackStag(Model model,@ModelAttribute("form")LunaManager lunaManager,HttpServletRequest request){
		if(lunaManager.getUserName().equals("shixiaoxuan")&&lunaManager.getPassword().equals("111111")){
			HttpSession session=request.getSession();
			session.setMaxInactiveInterval(30 * 60);
			session.setAttribute("lunaManager", lunaManager);
			return "backstagenav";
		}
		return "error";
	}
	@RequestMapping("/clearSession")
	public void clearSession(HttpServletRequest request,HttpServletResponse response) throws IOException{
		HttpSession session=request.getSession();
		session.removeAttribute("lunaManager");
		response.sendRedirect("tobackstag.jsp");
	}
	
	
}
