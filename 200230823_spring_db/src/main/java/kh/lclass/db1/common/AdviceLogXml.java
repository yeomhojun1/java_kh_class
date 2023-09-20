package kh.lclass.db1.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AdviceLogXml {
	private static final Logger logger = LoggerFactory.getLogger(AdviceLogXml.class);
	
	public Object aroundDaoLog ( ProceedingJoinPoint pjp) throws Throwable{
		Object robj = null;//타겟 메소드로부터 return 값을 받아 저장할 공간
		logger.debug("★[aroundDaoLog "+pjp.getThis()+":"+pjp.getSignature().getName()+"]");
		//타겟메소드로 전달되는 매개인자들
		Object[] args = pjp.getArgs();
		for(int i=0; i<args.length;i++) {
			logger.debug("--args["+i+"]"+args[i]+"");
		}
		robj = pjp.proceed();
		logger.debug("★[dao] "+robj);
		return robj;//타겟 메소드를 호출한 메소드에 return함
		
	}
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
	public Object aroundCtrLog( ProceedingJoinPoint pjp) throws Throwable{
		Object robj = null;//타겟 메소드로부터 return 값을 받아 저장할 공간
		logger.debug("★★★[aroundCtrLog "+pjp.getThis()+":"+pjp.getSignature().getName()+"]");
		//타겟메소드로 전달되는 매개인자들
		Object[] args = pjp.getArgs();
		for(int i=0; i<args.length;i++) {
			logger.debug("--args["+i+"]"+args[i]+"\n");
		}
		robj = pjp.proceed();
		logger.debug("★★★[ctr] "+robj);
		return robj;//타겟 메소드를 호출한 메소드에 return함
		
	}
	
}
