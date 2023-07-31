package kh.test.jdbckh.common.filter.wrapper;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class PasswordWrapper extends HttpServletRequestWrapper{

	public PasswordWrapper(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String getParameter(String name) {
		System.out.println("암호화전 크기"+name.length()+","+name);
		if(name != null && name.equals("pwd")) { //request.getparameter("pwd")가 호출되면
			name= getSha512(super.getParameter(name));//88자 string
		}else {//request.getparameter("pwd외 다른이름")가 호출되면
			name = super.getParameter(name);
		}
		System.out.println("!!!!!!!!암호화후  크기"+name.length()+","+name);
		
		
		return name	;
				}
	
	
	
	private String getSha512(String pwd) {
		String result = null;
		//Sha-512 암호화메소드
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512"); //singleton
			byte[] pwdBytes = pwd.getBytes(Charset.forName("UTF-8"));
			
			md.update(pwdBytes);//이게 바이트형태로 돼있고 그 다음에 스트링형태로 바꿔줘야함
			//암호화된 BYTE[]를 다시 STRING형으로 변형
			
			result = Base64.getEncoder().encodeToString(pwdBytes);//88자 string형태
 			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result ;
	}
	
	
	
	
}
