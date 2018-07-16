package com.jeff.yue.system.controller;

import com.jeff.yue.common.controller.BaseController;
import com.jeff.yue.system.domain.User;
import com.jeff.yue.system.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/sys/user")
@Controller
public class UserController extends BaseController {
	private String prefix = "system/user"  ;

	@Autowired
	UserService userService;



	@RequestMapping(value="/login",method= RequestMethod.GET)
	public String login(HttpServletRequest request, User user, Model model){
		if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
			request.setAttribute("msg", "用户名或密码不能为空！");
			return "login";
		}
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken(user.getUsername(),user.getPassword());
		try {
			subject.login(token);
			return "redirect:usersPage";
		}catch (LockedAccountException lae) {
			token.clear();
			request.setAttribute("msg", "用户已经被锁定不能登录，请与管理员联系！");
			return "login";
		} catch (AuthenticationException e) {
			token.clear();
			request.setAttribute("msg", "用户或密码不正确！");
			return "login";
		}
	}
	@GetMapping("/list")
	@ResponseBody
	public List<User> list() {
		User user = new User();
		user.setUserId(1L);
		List<User> list = userService.findUserList(user);
		return list;
	}

}
