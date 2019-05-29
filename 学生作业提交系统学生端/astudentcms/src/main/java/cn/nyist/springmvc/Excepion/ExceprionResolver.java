package cn.nyist.springmvc.Excepion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class ExceprionResolver implements HandlerExceptionResolver {

	private static final Logger logger =LoggerFactory.getLogger(ExceprionResolver.class);


	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
			Object obj,Exception e) {
		e.printStackTrace();
		logger.debug("测试输出的日志。。。。。。");
		logger.info("系统发生异常了............");
		logger.error( "系统发生异常", e);
		
		ModelAndView mav = new ModelAndView();		
		mav.setViewName("error/404");
		return mav;
	}

}
