package cn.pingweb.util;

import org.json.JSONException;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@ServerEndpoint(value = "/ws")
public class WebSocket {

    private static Map<String,Session> sessions=new HashMap<String,Session>();
    private static Map<Session,String> keys=new HashMap<Session,String>();

	@OnOpen
    public void onOpen(Session session) throws IOException, JSONException {
    //    String id=java.net.URLDecoder.decode(session.getQueryString(),"utf-8");
		String key=session.getRequestParameterMap().get("openid").get(0);
        WebSocket.sessions.put(key, session); //openid为key session为value
        WebSocket.keys.put(session, key);
        System.out.println("有新连接加入！:"+key);
        //websocket的json结构 0 1 2
//        JSONObject json=new JSONObject();
//        json.put("action", 1);
//        send(key,json.toString());
    }

    @OnClose
    public void onClose(Session session){
    	String key=WebSocket.keys.get(session);
    	WebSocket.sessions.remove(key);
    	WebSocket.keys.remove(session);
        System.out.println("有一连接关闭 sessionId:"+key);
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        System.out.println("来自客户端的消息:" + message);
    }

    @OnError
    public void onError(Session session, Throwable error){
        System.out.println("发生错误");
        error.printStackTrace();
    }


    public static void sendMessage(Session session, String message) throws IOException{
    	System.out.println("发送websocket："+message);
        session.getBasicRemote().sendText(message);
        //this.session.getAsyncRemote().sendText(message);
    }

    public static void  send(String openid, String jsonmsg) throws IOException{
    	Session s=WebSocket.sessions.get(openid);
    	if(s!=null){
    		sendMessage(s,jsonmsg);
    	}
    }
}
