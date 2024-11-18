package beans;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum LoginStatus {
    LOGIN_SUCCESS(100,"登录成功"),
    LOGIN_FAIL(101,"用户名或者密码错误"),
    LOGIN_OUT(102,"用户已注销");
    private Integer code;
    private String msg;
}
