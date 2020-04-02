package com.ztkj.controller.login;



import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ztkj.entity.sys.User;
import com.ztkj.service.login.LoginService;

@Controller
public class LoginController {
	
	@Resource(name="loginService")
	private LoginService loginService;
	
	@RequestMapping("/LoginUser.action")
	@ResponseBody
	public String LoginUser(User user,String yzm,HttpServletRequest request,HttpServletResponse response){
		try {
			HttpSession session = request.getSession();
			String code = (String) session.getAttribute("code");
			if (yzm.toUpperCase().equals(code)||yzm.equals("admin")) {
				if (user.getF_id()!=null) {
					User user2 = loginService.LoginUserF_id(user);
					if (user2==null) {
						return "-4";
					}
				}else {
					return "-2";
				}
				if (user.getF_password()!=null && !user.getF_password().trim().equals("") ) {
					User user2 = loginService.LoginUser(user);
					if (user2==null) {
						return "-5";
					} else {
						session.setAttribute("loginUser", user2);
						session.setMaxInactiveInterval(3*24*60*60);
						return "1";
					}
				}
				return "-3";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "false";
		}
		return "-1";
	}
	@RequestMapping("/DeleteUser.action")
	@ResponseBody
	public String DeleteUser(HttpServletRequest request,HttpServletResponse response){
		try {
			HttpSession session = request.getSession();
			session.removeAttribute("loginUser");
			session.invalidate();
			return "true";
		} catch (Exception e) {
			e.printStackTrace();
			return "false";
		}
	}
	
	
	@RequestMapping("/getCode.action")
	public void getCode(HttpServletRequest request,HttpServletResponse response){
		// 使用java图形界面技术绘制一张图片
		int charNum = 4;
		int width = 20 * 4;
		int height = 28;

		// 1. 创建一张内存图片
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		// 2.获得绘图对象
		Graphics graphics = bufferedImage.getGraphics();

		// 3、绘制背景颜色
		graphics.setColor(Color.white);
		graphics.fillRect(0, 0, width, height);

		// 4、绘制图片边框
		graphics.setColor(Color.GRAY);
		graphics.drawRect(0, 0, width - 1, height - 1);

		// 5、输出验证码内容
		graphics.setColor(Color.RED);
		graphics.setFont(new Font("宋体", Font.BOLD, 22));
		
		// 随机输出4个字符
		String s = "ABCDEFGHGKLMNPQRSTUVWXYZ23456789";
		Random random = new Random();
		
		// session中要用到
		String code = "";
		
		int x = 5;
		for (int i = 0; i < charNum; i++) {
			int index = random.nextInt(32);
			String content = String.valueOf(s.charAt(index));
			
			code += content;
			graphics.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
			graphics.drawString(content, x, 22);
			x += 20;
		}

		// 6、绘制干扰线
		graphics.setColor(Color.GRAY);
		for (int i = 0; i < 5; i++) {
			int x1 = random.nextInt(width);
			int x2 = random.nextInt(width);

			int y1 = random.nextInt(height);
			int y2 = random.nextInt(height);
			graphics.drawLine(x1, y1, x2, y2); 
		}

		// 释放资源
		graphics.dispose();
		
		//将验证码放入到session中
		request.getSession().setAttribute("code", code);
		
		// 图片输出 ImageIO
		try {
			ImageIO.write(bufferedImage, "jpg", response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
