package kh.lclass.db1.opendata.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class APIController {
	
	private static final String serviceKey = "kRsT9NIhrHgcUIT0MItkMywlOeKWuTPjY1JLy0UFKoflI/QIWUQ8VxhpSt6aPr2zEcrsnJlyk6peyGwfUZ+a0g==";
	@ResponseBody
	@RequestMapping(value="air.do", produces="application/json; charset=utf-8")
	public String airPollution(String location) throws IOException {
		String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";
	       url +="?serviceKey"+serviceKey;
	       url +="&sidoName="+URLEncoder.encode(location,"UTF-8");
	       url +="&returnType=json";
	       URL requestUrl = new URL(url);
	        HttpURLConnection urlConnection = (HttpURLConnection) requestUrl.openConnection();
	        urlConnection.setRequestMethod("GET");
	        BufferedReader rd = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
	        String responseText = "";
	        String line;
	        while ((line = rd.readLine()) != null) {
	        	responseText+=line;
	        }
	        rd.close();
	        urlConnection.disconnect();
	        System.out.println(responseText);
	      return responseText;
	    }
}
