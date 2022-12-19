package com.devfun.settingweb_boot.service;
 
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devfun.settingweb_boot.dao.StatisticMapper;
 
@Service
public class StatisticServiceImpl implements StatisticService {
    
    
    @Autowired
    private StatisticMapper uMapper;
    
    @Override
    // 년도, 월 별 접속자 수
    public HashMap<String, Object> yearMonthloginNum (String yearMonth) {

        HashMap<String, Object> retVal = new HashMap<String, Object>();
        
        try {
            retVal = uMapper.selectYearMonthLogin(yearMonth);
            retVal.put("yearMonth", yearMonth);
            retVal.put("is_success", true);
            
        }catch(Exception e) {
            retVal.put("totCnt", -999);
            retVal.put("yearMonth", yearMonth);
            retVal.put("is_success", false);
        }
        
        return retVal;
    }
    
    @Override
    // 날짜 별 접속자 수
    public HashMap<String, Object> DateloginNum (String date) {

        HashMap<String, Object> retVal = new HashMap<String, Object>();
        
        try {
            retVal = uMapper.selectDateLogin(date);
            retVal.put("date", date);
            retVal.put("is_success", true);
            
        }catch(Exception e) {
            retVal.put("totCnt", -999);
            retVal.put("date", date);
            retVal.put("is_success", false);
        }
        
        return retVal;
    }
    
    @Override
    // 평균 하루 접속자 수
    public HashMap<String, Object> yearAverageloginNum (String year) {

        HashMap<String, Object> retVal = new HashMap<String, Object>();
        
        try {
            retVal = uMapper.selectYearAverageLogin(year);
            retVal.put("year", year);
            retVal.put("is_success", true);
            
        }catch(Exception e) {
            retVal.put("totCnt", -999);
            retVal.put("year", year);
            retVal.put("is_success", false);
        }
        
        return retVal;
    }
    
    @Override
    // 휴일을 제외한 접속자 수
    public HashMap<String, Object> exceptionHolidayLoginNum () {

        HashMap<String, Object> retVal = new HashMap<String, Object>();
        
        try {
            retVal = uMapper.selectExceptionHolidayLogin();
            retVal.put("is_success", true);
            
        }catch(Exception e) {
            retVal.put("totCnt", -999);
            retVal.put("is_success", false);
        }
        
        return retVal;
    }

	@Override
	// 부서별 월별 접속자 수
	public HashMap<String, Object> OrganizationMonthloginNum (String organization, String month) {
		
		HashMap<String, Object> retVal = new HashMap<String, Object>();
        
        try {
            retVal = uMapper.selectOrganizationMonthLogin(organization, month);
            retVal.put("organization", organization);
            retVal.put("month", month);
            retVal.put("is_success", true);
            
        }catch(Exception e) {
            retVal.put("totCnt", -999);
            retVal.put("organization", organization);
            retVal.put("month", month);
            retVal.put("is_success", false);
        }
        
        return retVal;
	}
	
	
	
	
	// 부서별 월별 로그인 수 (group by 사용)
	@Override
    public List<HashMap> testNum (String month) {

        HashMap<String, Object> retVal = new HashMap<String, Object>();
        List<HashMap> result = new ArrayList<HashMap>();
        while (retVal != null) {
        	try {
                retVal = uMapper.selectTest(month);
                retVal.put("month", month);
                retVal.put("is_success", true);
                
            }catch(Exception e) {
                retVal.put("totCnt", -999);
                retVal.put("month", month);
                retVal.put("is_success", false);
            }
        	result.add(retVal);
        	if (retVal == null)
        		break;
        }
        
        
        
        
        return result;
    }

	
}