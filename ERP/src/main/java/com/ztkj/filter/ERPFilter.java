package com.ztkj.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ztkj.entity.sys.Auth;
import com.ztkj.entity.sys.Module;
import com.ztkj.entity.sys.User;

@WebFilter("/*")
public class ERPFilter implements Filter {
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request2=(HttpServletRequest) request;
		String url=request2.getRequestURI();
		String servletPath = request2.getServletPath();
		if(url.indexOf("login") !=-1||url.indexOf("js") !=-1||url.indexOf("css") !=-1||url.indexOf("images") !=-1||url.indexOf("getCode.action") !=-1||url.indexOf("LoginUser.action") !=-1) {
			filterChain.doFilter(request, response);
		}else {
			HttpSession session=request2.getSession();
			if(session.getAttribute("loginUser")==null) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out= response.getWriter();
				out.print("<script>window.alert('请登录！');</script>");
				out.print("<script>top.location.href='"+request2.getContextPath()+"/login.html';</script>");
			}else {
				if (servletPath.lastIndexOf("/")==0||url.indexOf("laydate") !=-1) {
					filterChain.doFilter(request, response);
				}else {
					List<Auth> Authlist = (List<Auth>) session.getAttribute("Auth");
					List<Module> Modulelist = (List<Module>) session.getAttribute("Module");
					if (Authlist!=null&&Modulelist!=null) {
						int lastIndexOf = servletPath.lastIndexOf("/");
						String vrl=servletPath.substring(1, lastIndexOf);
						String f_ids="";
						Integer f_id=null;
						for (Auth auth : Authlist) {
							f_ids+=auth.getF_authId();
						}
						for (Module module : Modulelist) {
							if (module.getF_url().indexOf(vrl)!=-1) {
								f_id = module.getF_id();
								break;
							}
						}
						if (f_id!=null&&f_ids.indexOf(f_id.toString())!=-1) {
							filterChain.doFilter(request, response);
						}else {
//							System.out.println(servletPath);
							if (((f_ids.contains("8")&&servletPath.contains("/storage/delivery/deliveryView.html"))
									||(f_ids.contains("16")&&servletPath.contains("/storage/stock/stockView.html"))
									||(f_ids.contains("8")&&servletPath.contains("/market/customer/customerView.html"))
									||(f_ids.contains("13")&&servletPath.contains("/market/customer/customerView.html"))
									||(f_ids.contains("22")&&(servletPath.contains("/purchase/purchase/purchaseView.html")||servletPath.contains("/market/order/orderView.html")))
									)||servletPath.contains(".action")) {
								filterChain.doFilter(request, response);
							} else {
								response.setContentType("text/html;charset=UTF-8");
								PrintWriter out= response.getWriter();
								session.removeAttribute("loginUser");
								session.invalidate();
								out.print("<script>window.alert('权限不足！请重新登录');</script>");
								out.print("<script>top.location.href='"+request2.getContextPath()+"/login.html';</script>");
							}
						}
					}
				}
			}
		}
	}

	@Override
	public void destroy() {
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}


}
