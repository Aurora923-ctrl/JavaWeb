package utils;


import jakarta.servlet.http.Cookie;

/**
 * 处理Cookie的工具类
 */
public class CookieUtils {
	private CookieUtils() {

	}

	/**
	 *
	 * @param name 要查找的cookie的name
	 * @param cookies 存储了浏览器携带的所有cookie对象
	 * @return  如果找到返回这个cookie对象,如果没找到返回null
	 */
	public static Cookie getCookie(String name, Cookie[] cookies) {
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(name)) {
					return cookie;
				}
			}

			return null; //在数组找不到需要cookie,直接返回null

		} else {
			return null;
		}
	}
}
