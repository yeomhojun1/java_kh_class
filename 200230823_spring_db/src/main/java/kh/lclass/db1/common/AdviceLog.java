package kh.lclass.db1.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class AdviceLog {
	private static final Logger logger = LoggerFactory.getLogger(AdviceLog.class);
	//@Pointcut("execution(타겟 메소드)")
	//파라멘타에 들어가는 ..은 모든 것, 여러개를 의미함
	//* 1개 이상일때 씀
	@Pointcut("execution(public * kh.lclass.db1..*Dao.*(..))")
	public void daoPointCut() {}
	@Pointcut("execution(public * kh.lclass.db1..*Service.*(..))")
	public void servicePointCut() {}
	@Pointcut("execution(public * kh.lclass.db1..*Controller.*(..))")
	public void controllerPointCut() {}
	
//	@Before("daoPointCut()")
//	public void beforeDaoLog( JoinPoint jp) {
//		//공통코드
//		logger.debug("[beforeDaoLog"+jp.getThis()+":"+jp.getSignature().getName()+"]");
//		//타겟메소드로 전달되는 매개인자들
//		Object[] args = jp.getArgs();
//		for(int i=0; i<args.length;i++) {
//			logger.debug("--args["+i+"]"+args[i]+"\n");
//		}
//	}
//	@AfterReturning(pointcut="daoPointCut()", returning = "returnObj")
//	public Object afterDaoLog(JoinPoint jp,Object returnObj) {
//		//공통코드
//		logger.debug("[afterDaoLog"+jp.getThis()+":"+jp.getSignature().getName()+"]");
//		//타겟메소드로 전달되는 매개인자들
//		Object[] args = jp.getArgs();
//		for(int i=0; i<args.length;i++) {
//			logger.debug("--args["+i+"]"+args[i]+"\n");
//		}
//		logger.debug("[returnObj] "+returnObj);
//		return returnObj;
//	}
	@Around("daoPointCut()")
	public Object aroundDaoLog ( ProceedingJoinPoint pjp) throws Throwable{
		Object robj = null;//타겟 메소드로부터 return 값을 받아 저장할 공간
		logger.debug("★[aroundDaoLog "+pjp.getThis()+":"+pjp.getSignature().getName()+"]");
		//타겟메소드로 전달되는 매개인자들
		Object[] args = pjp.getArgs();
		for(int i=0; i<args.length;i++) {
			logger.debug("--args["+i+"]"+args[i]+"");
		}
		robj = pjp.proceed();
		
		logger.debug("★[dao]  "+robj);
		return robj;//타겟 메소드를 호출한 메소드에 return함
		
	}
	@Around("servicePointCut()")
	public Object aroundSrvLog( ProceedingJoinPoint pjp) throws Throwable{
		Object robj = null;//타겟 메소드로부터 return 값을 받아 저장할 공간
		logger.debug("★★[aroundSrvLog "+pjp.getThis()+":"+pjp.getSignature().getName()+"]");
		//타겟메소드로 전달되는 매개인자들
		Object[] args = pjp.getArgs();
		for(int i=0; i<args.length;i++) {
			logger.debug("--args["+i+"]"+args[i]+"\n");
		}
		robj = pjp.proceed();
		logger.debug("★★[Service] "+robj);
		return robj;//타겟 메소드를 호출한 메소드에 return함
		
	}
	@Around("controllerPointCut()")
	public Object aroundCtrLog( ProceedingJoinPoint pjp) throws Throwable{
		Object robj = null;//타겟 메소드로부터 return 값을 받아 저장할 공간
		logger.debug("★★★[aroundCtrLog "+pjp.getThis()+":"+pjp.getSignature().getName()+"]");
		//타겟메소드로 전달되는 매개인자들
		Object[] args = pjp.getArgs();
		for(int i=0; i<args.length;i++) {
			logger.debug("--args["+i+"]"+args[i]+"\n");
		}
		StopWatch stopwatch = new StopWatch();
		stopwatch.start();
		robj = pjp.proceed();
		stopwatch.stop();
		logger.debug("★★★[ctr "+stopwatch.getTotalTimeMillis()+" (ms)]"+robj);
		return robj;//타겟 메소드를 호출한 메소드에 return함
		
	}
	
}
