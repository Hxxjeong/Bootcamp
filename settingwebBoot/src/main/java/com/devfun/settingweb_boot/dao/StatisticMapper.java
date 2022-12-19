package com.devfun.settingweb_boot.dao;
import java.util.HashMap;

//import com.devfun.settingweb_boot.dto.RequestInfo;

public interface  StatisticMapper {
	
	// 연도, 훨 별 접속자 수
    public HashMap<String, Object> selectYearMonthLogin(String yearMonth);	// selectYearLogin = xml 파일의 id 값
 
    // 날짜 별 접속자 수
    public HashMap<String, Object> selectDateLogin(String date);
    
    // 평균 하루 로그인 수
    public HashMap<String, Object> selectYearAverageLogin(String year);
    
    // 휴일을 제외한 로그인 수
    public HashMap<String, Object> selectExceptionHolidayLogin();
    
    // 부서 별 월 별 로그인 수
    public HashMap<String, Object> selectOrganizationMonthLogin(String organization, String month);
    
    
    
    // 부서별 월별 로그인 수 (group by 사용)
    public HashMap<String, Object> selectTest(String month);
}