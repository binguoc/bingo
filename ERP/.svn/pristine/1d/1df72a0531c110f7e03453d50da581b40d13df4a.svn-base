package com.ztkj.controller.sysController;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.ztkj.entity.sys.Log;
import com.ztkj.service.sysService.LogService;

@Controller
@RequestMapping("/sys/logs")
public class LogController {
	
	@Resource(name="logService")
	private LogService logService;
	/**
	 * 日志查询
	 * @param pageNum
	 * @param log
	 * @return
	 */
	@RequestMapping("/log.action")
	@ResponseBody
	public PageInfo<Log> queryLog(Integer pageNum,Log log){
		try {
			PageInfo<Log> pageInfo = logService.queryLog(pageNum, log);
			return pageInfo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	/**
	 * 日志详情
	 * @throws Exception 
	 */
	@RequestMapping("/logView.action")
	@ResponseBody
	public Log queryLogView(Integer f_id) throws Exception{
		System.out.println("l"+f_id);
		Log log =new Log();
		log.setF_id(f_id);
		return logService.queryLogView(log);
	}
		
}
