package com.ssm.adminlte.util;

import com.ssm.adminlte.entity.Page;

/* 
 * 分页信息辅助类 
 */  
public class PageUtil {  
      
    public static Page createPage(int everyPage,int totalCount,int currentPage) {  
        everyPage = getEveryPage(everyPage);   
        int totalPage = getTotalPage(everyPage, totalCount); 
        currentPage = getCurrentPage(currentPage,totalPage); 
        int beginIndex = getBeginIndex(everyPage, currentPage);  
        boolean hasPrePage = getHasPrePage(currentPage);  
        boolean hasNextPage = getHasNextPage(totalPage, currentPage);  
        return new Page(everyPage, totalCount, totalPage, currentPage,  
                beginIndex, hasPrePage,  hasNextPage);  
    }  
      
    public static Page createPage(Page page,int totalCount) {  
        int everyPage = getEveryPage(page.getEveryPage());  
        int totalPage = getTotalPage(everyPage, totalCount);  
        int currentPage = getCurrentPage(page.getCurrentPage(),totalPage);  
        int beginIndex = getBeginIndex(everyPage, currentPage);  
        boolean hasPrePage = getHasPrePage(currentPage);  
        boolean hasNextPage = getHasNextPage(totalPage, currentPage);  
        return new Page(everyPage, totalCount, totalPage, currentPage,  
                beginIndex, hasPrePage,  hasNextPage);  
    }  
      
    //设置每页显示记录数  
    public static int getEveryPage(int everyPage) {  
        return everyPage == 0 ? 10 : everyPage;  
    }  
      
    //设置当前页  
    public static int getCurrentPage(int currentPage,int totalPage) { 
    	if(currentPage>totalPage) {
    		return totalPage; 
    	}else if(currentPage<1) {
    		return 1;
    	}else {
    		return currentPage;
    	}

    }  
      
    //设置总页数,需要总记录数，每页显示多少  
    public static int getTotalPage(int everyPage,int totalCount) {  
        int totalPage = 0;  
        if(totalCount % everyPage == 0) {  
            totalPage = totalCount / everyPage;  
        } else {  
            totalPage = totalCount / everyPage + 1;  
        }  
        return totalPage;  
    }  
      
    //设置起始点，需要每页显示多少，当前页  
    public static int getBeginIndex(int everyPage,int currentPage) {  
        return (currentPage - 1) * everyPage;  
    }  
      
    //设置是否有上一页，需要当前页  
    public static boolean getHasPrePage(int currentPage) {  
        return currentPage == 1 ? false : true;  
    }  
      
    //设置是否有下一个，需要总页数和当前页  
    public static boolean getHasNextPage(int totalPage, int currentPage) {  
        return currentPage == totalPage || totalPage == 0 ? false : true;  
    }  
      
}  
