package com.ssm.adminlte.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.adminlte.entity.ActiveUser;




@Controller
public class LoginController {
	  @RequestMapping("loginUI")
	  public String loginUI(){
		  return "login";
	  }
	@RequestMapping(value ="getLoginInfo", method = RequestMethod.GET)
	@ResponseBody
	public String getLoginInfo(HttpSession httpSession) {
	        String login_msg = (String) httpSession.getAttribute("login_msg");
	        return login_msg;
	}
	@RequestMapping(value ="getUserName", method = RequestMethod.GET)
	@ResponseBody
	public String getUserName(HttpSession httpSession) {
		//从shiro的session中取activeUser
		Subject subject = SecurityUtils.getSubject();
		//取身份信息
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		String userName = activeUser.getUsername();
	    return userName;
	}
      //登陆提交地址，和spring-shiro.xml中配置的loginurl一致
	  @RequestMapping("/login")
	  public String doLogin(HttpServletRequest request,HttpServletResponse response,HttpSession httpSession)throws Exception{
		 response.setHeader( "Cache-Control" , "no-store" ); 
		 String  login_msg = "";
		  //如果登陆失败从request中获取认证异常信息，shiroLoginFailure就是shiro异常类的全限定名
			String exceptionClassName =  (String) request.getAttribute("shiroLoginFailure");
				//根据shiro返回的异常类路径判断，抛出指定异常信息
				if(exceptionClassName!=null){
					if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
						//最终会抛给异常处理器
						System.out.println("账号不存在");
						login_msg ="账号不存在";
					} else if (IncorrectCredentialsException.class.getName().equals(
							exceptionClassName)) {
						System.out.println("用户名/密码错误");
						login_msg ="用户名/密码错误";
					} else {
						System.out.println("其它错误");
					}
				}
				//此方法不处理登陆成功（认证成功），shiro认证成功会自动跳转到上一个请求路径
				//登陆失败还到login页面
				httpSession.setAttribute("login_msg",login_msg);
		  return "login";
	  }
}
