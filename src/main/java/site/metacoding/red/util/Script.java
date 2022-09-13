package site.metacoding.red.util;

public class Script {
	
	public static String back(String msg) { 
		StringBuilder sb = new StringBuilder();
		sb.append("<script>");
		sb.append("alert('"+msg+"');"); // 경고창
		sb.append("history.back();"); // 뒤로가기
		sb.append("</script>");
		return sb.toString();
	}
	
	public static String href(String url) { // 메시지 없이 이동
		StringBuilder sb = new StringBuilder();
		sb.append("<script>");
		sb.append("location.href='"+url+"';"); 
		sb.append("</script>");
		return sb.toString();
	}
	
	public static String href(String url, String msg) {
		StringBuilder sb = new StringBuilder();
		sb.append("<script>");
		sb.append("alert('"+msg+"');"); 
		sb.append("location.href='"+url+"';"); 
		sb.append("</script>");
		return sb.toString();
	}
}
