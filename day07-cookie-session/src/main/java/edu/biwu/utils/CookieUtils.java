package edu.biwu.utils;

import jakarta.servlet.http.Cookie;

public class CookieUtils {
    private CookieUtils() {
    }
    public static Cookie getCookie(Cookie[] cookies, String name){
        if (cookies!=null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    return cookie;
                }
            }
        }
        return null;
    }
}
