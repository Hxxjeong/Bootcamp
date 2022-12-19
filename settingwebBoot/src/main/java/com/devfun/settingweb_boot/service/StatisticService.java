package com.devfun.settingweb_boot.service;
 
import java.util.HashMap;
import java.util.List;
 
public interface StatisticService {
	// 년도, 월 별 접속자 수
    public HashMap<String,Object> yearMonthloginNum (String yearMonth);
    
    // 날짜 별 접속자 수
    public HashMap<String,Object> DateloginNum (String date);
    
    // 평균 하루 접속자 수
    public HashMap<String,Object> yearAverageloginNum (String year);
    
    // 휴일을 제외한 로그인 수
    public HashMap<String, Object> exceptionHolidayLoginNum ();
    
    // 부서 별 월 별 접속자 수
    public HashMap<String, Object> OrganizationMonthloginNum (String organization, String month);
    
    
    // 부서별 월별 접속자 수 (group by 사용)
    public List<HashMap> testNum (String month);
}