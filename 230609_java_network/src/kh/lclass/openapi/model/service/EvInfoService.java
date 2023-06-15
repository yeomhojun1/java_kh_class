package kh.lclass.openapi.model.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import kh.lclass.openapi.model.vo.EvInfoVO;

public class EvInfoService extends Thread {
	List<EvInfoVO> evFolist = new ArrayList<EvInfoVO>();

	@Override
	public void run() {
		int failCnt = 3;
		for (int i = 0; i < 1; i++) {
			BufferedReader rd = null;
			HttpURLConnection conn = null;
			StringBuilder sb = null;
			try {
				// TODO Auto-generated method stub
				String serviceKey = "kRsT9NIhrHgcUIT0MItkMywlOeKWuTPjY1JLy0UFKoflI%2FQIWUQ8VxhpSt6aPr2zEcrsnJlyk6peyGwfUZ%2Ba0g%3D%3D";
				StringBuilder urlBuilder = new StringBuilder(
						"http://openapi.kepco.co.kr/service/EvInfoServiceV2/getEvSearchList"); /* URL */
				urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + serviceKey);
				urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "="
						+ URLEncoder.encode(String.valueOf(i + 1), "UTF-8")); /* 페이지번호 */
				urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="
						+ URLEncoder.encode("5", "UTF-8")); /* 한 페이지 결과 수 */
//				urlBuilder.append("&" + URLEncoder.encode("addr", "UTF-8") + "="
//						+ URLEncoder.encode("전라남도 나주시 빛가람동 120", "UTF-8")); /* 검색대상 충전소주소 */
				URL url = new URL(urlBuilder.toString());
				conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Content-type", "application/json");
				System.out.println("Response code: " + conn.getResponseCode());

				if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
					rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				} else {
					rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
				}
				Document doc=  parseXML(conn.getInputStream());
				NodeList descNodes = doc.getElementsByTagName("item");
				for(int j = 0; j<descNodes.getLength();j++) {
					EvInfoVO vo = new EvInfoVO();
					Node item = descNodes.item(j);
					for(Node node = item.getFirstChild();//초기식
							node!=null;//조건식 T/F
							node=node.getNextSibling()//증감식
					) {
						System.out.println(node.getNodeName()+" : "+node.getTextContent());
						switch(node.getNodeName()) {
						case "chargeTp":
							try {
							vo.setChargeTp(node.getTextContent());
							}catch(NumberFormatException e) {
							}
							break;
						case "cpId":
							vo.setCpId(node.getTextContent());
							break;
						case "cpNm":
							vo.setCpNm(node.getTextContent());
							break;
						case "csNm":
							vo.setCsNm(node.getTextContent());
							break;
						}
					}
					evFolist.add(vo);
				}
				System.out.println(evFolist);
				
				
				
				
				
				
//				sb = new StringBuilder();
				String line = null;
				while ((line = rd.readLine()) != null) {
					sb.append(line);
				}
			} catch (IOException e) {
				failCnt--;
				i--;
				if (failCnt < 0) {
					break;
				}
				e.printStackTrace();
			} finally {
				try {
					if (rd != null)
						rd.close();
					if (conn != null)
						conn.disconnect();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

		super.run();
	}

	private Document parseXML(InputStream stream) {
		//factory pattern
		DocumentBuilderFactory objDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder objDocumentBuilder = null;
		Document doc = null;

		try {
			objDocumentBuilder = objDocumentBuilderFactory.newDocumentBuilder();
			doc = objDocumentBuilder.parse(stream);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) { // Simple API for XML
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return doc;
	}

}
