package edu.bw.dao.impl;

import cn.hutool.json.JSONUtil;
import edu.bw.dao.DeptDao;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class DeptDaoImplTest {
    DeptDao deptDao = new DeptDaoImpl();
    @Test
    public void selectDeptByCondition() {
        List<Map<String, Object>> list = deptDao.selectDeptByCondition(
                new SelectDeptByConditionForm("", 1, 10));
        System.out.println(JSONUtil.toJsonPrettyStr(list));

    }

    @Test
    public void selectDeptByConditionCount() {
        System.out.println(deptDao.selectDeptByConditionCount(
                new SelectDeptByConditionForm("", 1, 10)
        ));
    }
}