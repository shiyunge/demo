package com.exam.demo.controller;

import com.exam.demo.util.WordUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@RestController
public class export2 {

    @RequestMapping("exportWord")
    public void exportSellPlan(HttpServletRequest request, HttpServletResponse httpServletResponse) {
        Calendar calendar = Calendar.getInstance();// 取当前日期。

//                     SellPlan plan=sellService.getSellPlanInfo(id);
        //获得数据
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "a");
//                        map.put("lYear", plan.getLiveYear()!=null?plan.getLiveYear():"");
//                       map.put("leader",plan.getLeader()!=null?plan.getLeader():"");
//                       map.put("phone", plan.getPhone()!=null?plan.getPhone():"");
//                       map.put("curYear", calendar.get(Calendar.YEAR)+"");
//                       map.put("image", getImageBase(plan.getPositionImage()));
        WordUtils wordUtils = new WordUtils();

        try {
            wordUtils.exportMillCertificateWord(httpServletResponse, map, "方案");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
