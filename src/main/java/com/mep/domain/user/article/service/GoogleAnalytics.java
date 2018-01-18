package com.mep.domain.user.article.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.core.io.ClassPathResource;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.analytics.Analytics;
import com.google.api.services.analytics.Analytics.Data.Ga.Get;
import com.google.api.services.analytics.AnalyticsScopes;
import com.google.api.services.analytics.model.GaData;
import com.mep.domain.user.article.dto.GoogleAnalyticsDto;
import com.mep.util.DateUtil;

/**
 * A simple example of how to access the Google Analytics API using a service
 * account.
 */
public class GoogleAnalytics {

	private static final String APPLICATION_NAME = "Hello Analytics";
	private static final JsonFactory JSON_FACTORY = GsonFactory
			.getDefaultInstance();
	private static final String KEY_FILE_LOCATION = "My Project-d33d112cb58b.json";

	public static List<GoogleAnalyticsDto> getGoogleAnalyticsTopPageViews()
			throws GeneralSecurityException, IOException {

		Analytics analytics = initializeAnalytics();

		return getCoreData(analytics);

	}

	/**
	 * Initializes an Analytics service object.
	 *
	 * @return An authorized Analytics service object.
	 * @throws IOException
	 * @throws GeneralSecurityException
	 */
	private static Analytics initializeAnalytics()
			throws GeneralSecurityException, IOException {

		HttpTransport httpTransport = GoogleNetHttpTransport
				.newTrustedTransport();
		GoogleCredential credential = GoogleCredential.fromStream(
				new FileInputStream(new ClassPathResource(KEY_FILE_LOCATION)
						.getFile())).createScoped(AnalyticsScopes.all());

		// Construct the Analytics service object.
		return new Analytics.Builder(httpTransport, JSON_FACTORY, credential)
				.setApplicationName(APPLICATION_NAME).build();
	}

	private static List<GoogleAnalyticsDto> getCoreData(Analytics analytics)
			throws IOException {

		String currentDate = DateUtil.changeDateFormat(
				DateUtil.getCurrentTime(), "YYY-MM-DD");

		Get apiQuery = analytics.data().ga().get("ga:167291616", // Table Id.
				"2018-01-12", // Start date.
				currentDate, // End date.
				"ga:pageviews")
				// Metrics.
				.setDimensions("ga:pagePathLevel2,ga:pageTitle").setSort("-ga:pageviews")
				.setMaxResults(25);

		GaData gaData = apiQuery.execute();

		return getDataTable(gaData);
	}	

	private static List<GoogleAnalyticsDto> getDataTable(GaData gaData) {
		if (gaData.getTotalResults() > 0) {

			List<GoogleAnalyticsDto> googleAnalyticsDto = new ArrayList<>();

			GoogleAnalyticsDto dto;

			for (List<String> rowValues : gaData.getRows()) {
				dto = new GoogleAnalyticsDto();
				for (String value : rowValues) {
					if(dto.getPostTitle() != null) {
						if(!isNumeric(value))
						dto.setPostTitle(dto.getPostTitle() + value);
					} else {
						dto.setPostTitle(value);	
					}									
				}
				googleAnalyticsDto.add(dto);
			}
			return googleAnalyticsDto;
		} else {
			System.out.println("No Results Found");
		}

		return Collections.emptyList();
	}
	
	private static boolean isNumeric(String s) {  
	    return s != null && s.matches("[-+]?\\d*\\.?\\d+");  
	} 
}
