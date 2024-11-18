package utils;

import beans.ResponseData;
import cn.hutool.json.JSONUtil;

import java.lang.reflect.Method;

public class ResultUtils {
    /**
     *
     * @param anEnum 任意一个枚举,要求自定义枚举中需要含有getCode和getMsg方法
     * @param data 数据
     * @return
     */
    public static <T> String result(Enum anEnum, T data) {
        try {
            ResponseData<T> responseData = new ResponseData<>();
            responseData.setData(data);
            if (anEnum!=null) {
                Method getCodeMethod = anEnum.getClass().getMethod("getCode");
                Method getMsgMethod = anEnum.getClass().getMethod("getMsg");
                if (getCodeMethod != null) {
                    responseData.setCode((Integer)getCodeMethod.invoke(anEnum, null));
                }
                if (getMsgMethod != null) {
                    responseData.setMsg((String)getMsgMethod.invoke(anEnum, null));
                }
            }

            return JSONUtil.toJsonStr(responseData);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}