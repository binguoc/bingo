package com.ztkj.service.sysService.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ztkj.entity.sys.Log;
import com.ztkj.entity.sys.User;
import com.ztkj.service.sysService.LogService;

public class RequestLog implements HandlerInterceptor {
	
	@Resource(name="logService")
	private LogService logService;

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)
			throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		String uri=request.getRequestURI();
		String f_context="";
		String f_module="";
		User user = (User) request.getSession().getAttribute("loginUser");
		if(uri.contains("add")) {
			f_context="添加";
		}else if (uri.contains("updateOrderStatus")) {
			f_context="提交审核";
		}else if (uri.contains("updateOrderExamine")) {
			f_context="审核";
		}else if (uri.contains("updateClientF_isallot")) {
			f_context="分配";
		}else if (uri.contains("update")) {
			f_context="修改";
		}else if (uri.contains("delete")) {
			f_context="删除";
		}else if (uri.contains("cancel")) {
			f_context="注销";
		}else if (uri.contains("recover")) {
			f_context="恢复";
		}else if (uri.contains("examine")) {
			f_context="审核";
		}else if (uri.contains("goodDelivery")) {
			f_context="发货";
		}else if (uri.contains("removeDelivery")) {
			f_context="取消订单";
		}else if (uri.contains("moneyBack")) {
			f_context="确定回款";
		}else if (uri.contains("goodsReturn")) {
			f_context="确定已退货";
		}
		
		if(uri.contains("/sys")) {
			if(uri.contains("/dept")) {
				f_module="部门管理";
				f_context="进行了"+f_context+"部门的操作";
			}else if (uri.contains("/modules")) {
				f_module="模块管理";
				f_context="进行了"+f_context+"模块的操作";
			}else if (uri.contains("/position")) {
				f_module="职位管理";
				f_context="进行了"+f_context+"职位的操作";
			}else if (uri.contains("/users")) {
				f_module="用户管理";
				f_context="进行了"+f_context+"用户的操作";
			}
		}else if (uri.contains("/storage")) {
			if(uri.contains("/delivery")) {
				f_module="出库管理";
				f_context="进行了"+f_context+"的操作";
			}else if (uri.contains("/stock")) {
				f_module="入库管理";
				f_context="进行了"+f_context+"入库的操作";
			}else if (uri.contains("/storage")) {
				f_module="仓库管理";
				f_context="进行了"+f_context+"仓库的操作";
			}
		}else if (uri.contains("/purchase")) {
			if(uri.contains("/brand")) {
				f_module="品牌管理";
				f_context="进行了"+f_context+"品牌的操作";
			}else if (uri.contains("/manufacturer")) {
				f_module="厂商管理";
				f_context="进行了"+f_context+"厂商的操作";
			}else if (uri.contains("/product")) {
				f_module="商品管理";
				f_context="进行了"+f_context+"商品的操作";
			}else if (uri.contains("/productType")) {
				f_module="商品类型管理";
				f_context="进行了"+f_context+"商品类型的操作";
			}else if (uri.contains("/purchase")) {
				f_module="采购单管理";
				f_context="进行了"+f_context+"采购单的操作";
			}else if (uri.contains("/purchaseExamine")) {
				f_module="采购单管理";
				f_context="进行了"+f_context+"采购单的操作";
			}
		}else if (uri.contains("/market")) {
			if(uri.contains("/customer")) {
				f_module="客户管理";
				f_context="进行了"+f_context+"客户的操作";
			}else if (uri.contains("/order")) {
				f_module="订购单管理";
				f_context="进行了"+f_context+"订购单的操作";
			}
		}
		if(f_context.contains("添加")||f_context.contains("修改")||f_context.contains("删除")||f_context.contains("注销")||f_context.contains("恢复")||f_context.contains("审核")
				||f_context.contains("发货")||f_context.contains("取消订单")||f_context.contains("确定回款")||f_context.contains("确定已退货")||f_context.contains("分配")
				||f_context.contains("提交审核")
				)
		{
			Log log=new Log(null,user.getF_id(),user.getF_name(),f_module,f_context,null,null,null);
			logService.addLog(log);
			
		}
		return true;
		
	}

}
