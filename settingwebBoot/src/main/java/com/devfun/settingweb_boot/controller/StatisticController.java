package com.devfun.settingweb_boot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.devfun.settingweb_boot.service.StatisticService;

 
@Controller
public class StatisticController {
    
 
    @Autowired
    private StatisticService service;
    
    // 월별 접속자 수
    @ResponseBody 
    @RequestMapping("/monthLogin")
    public Map<String, Object> sqltest(String yearMonth) throws Exception{ 
        
        return service.yearMonthloginNum(yearMonth);
    }
    
    // 일자별 접속자 수
    @ResponseBody
    @RequestMapping("/dateLogin")
    public Map<String, Object> sqltest2(String date) throws Exception{ 
        
        return service.DateloginNum(date);
    }
    
    // 평균 하루 로그인 수
    @ResponseBody
    @RequestMapping("/average")
    public Map<String, Object> sqltest3(String year) throws Exception{ 
        
        return service.yearAverageloginNum(year);
    }
    
    // 공휴일을 제외한 접속자 수
    @ResponseBody
    @RequestMapping("/exceptionHoliday")
    public Map<String, Object> sqltest4() throws Exception{ 
        
        return service.exceptionHolidayLoginNum();
    }
    
    // 부서별 월별 로그인 수
    @ResponseBody
    @RequestMapping("/organizationMonthLogin")
    public Map<String, Object> sqltest5(String organization, String month) throws Exception{ 
        
        return service.OrganizationMonthloginNum(organization, month);
    }
    
    
    
    
    
    
    // 부서별 월별 로그인 수 (group by 사용)
    @ResponseBody
    @RequestMapping("/organization")
    public List<HashMap> test(String month) throws Exception{ 
        
        return service.testNum(month);
    }
    
    
    
    
    
}