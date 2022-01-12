package foodelicious.member.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

@Controller
public class MemberLoginController {

//	@GetMapping("/oauth")
//	public String oauthPage(@RequestParam(name = "code") String authCode, Model model) throws IOException{
//	
//		// Google取得access_token的url
//		  URL urlObtainToken =  new URL("https://accounts.google.com/o/oauth2/token");
//		  HttpURLConnection connectionObtainToken =  (HttpURLConnection) urlObtainToken.openConnection();
//		    
//		  // 設定此connection使用POST
//		  connectionObtainToken.setRequestMethod("POST");
//		  connectionObtainToken.setDoOutput(true);
//		   
//		  // 開始傳送參數 
//		  OutputStreamWriter writer  = new OutputStreamWriter(connectionObtainToken.getOutputStream());
//		  
//		  String clientID = "676062096-k5fqunhdmjc9ptf2p6f0ul2igb3hsti0.apps.googleusercontent.com";   // 這裡請將xxxx替換成自己的client_id
//		  String clientSecret ="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";   // 這裡請將xxxx替換成自己的client_serect
//		  String redirectUri ="http://localhost:8080/oauth";   // 這裡請將xxxx替換成自己的redirect_uri
//		  
//		  String postBody = String.format(
//				  "code=%s&client_id=%s&client_secret=%s&redirect_uri%s&grant_type=authorization_code", authCode,
//				  clientID, clientSecret, redirectUri);
//		  writer.write(postBody);
//		  writer.close();
//				  
//		  // 如果認證成功
//		  if (connectionObtainToken.getResponseCode() == HttpURLConnection.HTTP_OK){
//		   StringBuilder sbLines   = new StringBuilder("");
//		   
//		   // 取得Google回傳的資料(JSON格式)
//		   BufferedReader reader = 
//		       new BufferedReader(new InputStreamReader(connectionObtainToken.getInputStream(),"utf-8"));
//		   String strLine = "";
//		   while((strLine=reader.readLine())!=null){
//		    sbLines.append(strLine);
//		   }
//		  
//		   try {
//		       // 把上面取回來的資料，放進JSONObject中，以方便我們直接存取到想要的參數
//		    JSONObject jo = new JSONObject(sbLines.toString());
//		    URL urUserInfo = new URL("https://www.googleapis.com/oauth2/v1/userinfo?alt=json&access_token="
//		    		+ jo.getString("access_token"));
//		    HttpURLConnection connObtainUserInfo = (HttpURLConnection) urUserInfo.openConnection();
//		    
//		    // 印出Google回傳的access token
//		    resp.getWriter().println(jo.getString("access_token")); 
//		   } catch (JSONException e) {
//		    e.printStackTrace();
//		   }
//		  }
//		 }

	@GetMapping("/normallogout")
	public String logout(HttpServletRequest request, HttpServletResponse response, SessionStatus status) {
		HttpSession session = request.getSession();
		status.setComplete();
		session.invalidate(); // session.invalidate()讓SESSION失效.

		return "redirect:/";
	}
}
