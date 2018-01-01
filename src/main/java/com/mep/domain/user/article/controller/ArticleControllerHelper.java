package com.mep.domain.user.article.controller;

import java.util.LinkedList;
import java.util.List;

import com.mep.domain.user.article.dto.ArticleDashboardDto;

public abstract class ArticleControllerHelper {

	/*
	 * Trick for iterate 3 time per one row.
	 */
	protected List<List<ArticleDashboardDto>> getMaxonaryList(List<ArticleDashboardDto> dashboardList) {
		
		List<List<ArticleDashboardDto>> articleDashboardList = new LinkedList<List<ArticleDashboardDto>>();
	    List<ArticleDashboardDto> tempList = new LinkedList<ArticleDashboardDto>();

	    int listSize = dashboardList.size();
	    for ( int i = 0; i < listSize; i++ )
	    {
	        tempList.add( dashboardList.get( i ) );
	        if ( listSize == ( i+1 ) || tempList.size() == 3 )
	        {
	        	articleDashboardList.add( tempList );
	            tempList = new LinkedList<ArticleDashboardDto>();
	        }
	    }
	    
	    return articleDashboardList; 
	}
}
