package common.security;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import common.logger.LoggerInterceptor;

public class SCRFInterceptor extends HandlerInterceptorAdapter {
	protected Log log = LogFactory.getLog(LoggerInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		log.debug("preHandle");
		int check=0;
		if(!request.getMethod().equalsIgnoreCase("post")){
			log.debug("not post");
			return true;
		}else{
			if(request instanceof MultipartHttpServletRequest){
				Enumeration<String> names=request.getParameterNames();
				while (names.hasMoreElements()) {
					String ele = (String) names.nextElement();
					log.debug("ele:"+ele);
					if ("csrf".equals(ele)) {
						check=1;
						String value=request.getParameter(ele);
						if (value.equals(request.getSession().getAttribute("CSRF_TOKEN"))) {
							log.debug("value:"+value);
							return true;
						}
					}
				}
				log.debug("check:"+check);
				if(check==0){
					log.debug("csrfError");
					request.getSession().setAttribute("csrfError", "true");
					response.sendRedirect("boardList");
					return false;
				}
			}
		}
		return true;
		//return super.preHandle(request, response, handler);
	}
}
