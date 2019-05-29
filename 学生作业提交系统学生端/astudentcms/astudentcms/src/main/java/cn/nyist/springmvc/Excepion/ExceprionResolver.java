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
		logger.debug("�����������־������������");
		logger.info("ϵͳ�����쳣��............");
		logger.error( "ϵͳ�����쳣", e);
		
		ModelAndView mav = new ModelAndView();		
		mav.setViewName("error/404");
		return mav;
	}

}
