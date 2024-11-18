package utils;

import beans.LoginStatus;
import beans.User;
import org.junit.Test;
public class ResultUtilsTest {
    @Test
    public  void result(){
        String result = ResultUtils.result(LoginStatus.LOGIN_SUCCESS, new User("张三", "123456"));
        System.out.println(result);
    }
}