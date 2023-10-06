/*
 * package kh.lclass.db1.opendata.run;
 * 
 * import java.io.BufferedReader; import java.io.IOException; import
 * java.io.InputStreamReader; import java.net.HttpURLConnection; import
 * java.net.URL; import java.net.URLEncoder; import java.util.ArrayList; import
 * java.util.HashMap; import java.util.Map;
 * 
 * import com.google.gson.Gson; import com.google.gson.JsonObject; import
 * com.google.gson.JsonParser;
 * 
 * public class AirPollutionJavaApp {
 * 
 * private static final String serviceKey =
 * "ey51rbqUG4nLxm%2FIMXybyk%2FsuSNe95v4aIgn4Ydn0UhcJl91gToKXy7htiiqkWXyGCVxm6xyZpakkO4hk%2FLs3w%3D%3D";
 * 
 * public static void main(String[] args) throws IOException { String url =
 * "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";
 * url +="?serviceKey"+serviceKey; url
 * +="&seidoName="+URLEncoder.encode("서울","UTF-8"); url +="&returnType=json";
 * URL requestUrl = new URL(url); HttpURLConnection urlConnection =
 * (HttpURLConnection) requestUrl.openConnection();
 * urlConnection.setRequestMethod("GET"); BufferedReader rd = new
 * BufferedReader(new InputStreamReader(urlConnection.getInputStream())); String
 * responseText = ""; String line; while ((line = rd.readLine()) != null) {
 * responseText+=line; } System.out.println(responseText); Map<String, Object>
 * apiMap= new HashMap<String, Object>(); apiMap =(Map)new
 * Gson().fromJson(responseText.toString(), apiMap.getClass()); Map<String,
 * Object> responseMap= (Map<String, Object>)apiMap.get("response"); Map<String,
 * Object> bodyMap= (Map<String, Object>)responseMap.get("body");
 * ArrayList<Object> items= (ArrayList<Object>)bodyMap.get("items"); for(int
 * i=0; i<items.size();i++) { Map<String, Object>item = (Map<String,
 * Object>)items.get(i); }
 * 
 * rd.close(); urlConnection.disconnect(); } }
 */