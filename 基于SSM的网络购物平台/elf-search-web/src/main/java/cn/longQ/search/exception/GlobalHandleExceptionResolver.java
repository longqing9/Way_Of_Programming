package cn.longQ.search.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class GlobalHandleExceptionResolver implements HandlerExceptionResolver {

	private final static Logger logger = LoggerFactory.getLogger(GlobalHandleExceptionResolver.class);
	
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		//控制台打印
		ex.printStackTrace();
		//写日志
		logger.debug("测试日志信息输出........");
		logger.info("系统发生异常........");
		logger.error("错误信息", ex);
		//显示错误信息
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("error/exception");
		return modelAndView;
	}

}
