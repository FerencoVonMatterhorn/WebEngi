package main.java.util;

import javax.servlet.http.Cookie;

public class CookieUtil {

	private CookieUtil() {

	}

	public static Cookie loggedInCookie() {
		Cookie cookie = new Cookie("user", "true");
		cookie.setMaxAge(60 * 60); // 60 Minutes
		cookie.setPath("/");
		return cookie;
	}

	public static Cookie loggedOutCookie() {
		Cookie cookie = new Cookie("user", "false");
		return cookie;
	}

}
