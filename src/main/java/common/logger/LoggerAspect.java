package common.logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LoggerAspect {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	static String name = "";
	static String type = "";

	/**
	 * 대상 객체의 메서드 실행 전, 후 또는 예외 발생 시점에 공통 기능을 실행
	 * Around Advice를 구현한 메서드는 org.aspectj.lang.ProceedingJoinPoint를 반드시 첫 번째
	 * 파리미터로 지정해야 함 -> 그렇지 않을 경우 예외 발생
	 * http://snoopy81.tistory.com/292
	 * 
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 */
	@Around("execution(* first..*Controller.*(..)) or execution(* first..*Service.*(..)) or execution(* first..*DAO.*(..))")
	public Object logPrint(ProceedingJoinPoint joinPoint) throws Throwable {
		type = joinPoint.getSignature().getDeclaringTypeName();

//		if (type.indexOf("Controller") > -1) {
//			name = "Controller  \t: ";
//		} else if (type.indexOf("Service") > -1) {
//			name = "ServiceImpl  \t: ";
//		} else if (type.indexOf("DAO") > -1) {
//			name = "DAO  \t\t: ";
//		}
		log.debug(name + type + "." + joinPoint.getSignature().getName() + "()");
		return joinPoint.proceed();
	}
	
	
}
