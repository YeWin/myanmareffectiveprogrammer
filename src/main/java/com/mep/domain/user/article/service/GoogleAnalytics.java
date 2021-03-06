package com.mep.domain.user.article.service;

import java.io.FileNotFoundException;
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
 * To access the Google Analytics using Google Analytics Core API account.
 */
public class GoogleAnalytics {

	private static final String APPLICATION_NAME = "Myanmar Effective Programmer";
	private static final JsonFactory JSON_FACTORY = GsonFactory
			.getDefaultInstance();
	private static final String KEY_FILE_LOCATION = "MEP.json";

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
			throws GeneralSecurityException, FileNotFoundException, IOException {
		
		HttpTransport httpTransport = GoogleNetHttpTransport
				.newTrustedTransport();
		GoogleCredential credential = GoogleCredential.fromStream(
				new ClassPathResource(KEY_FILE_LOCATION).getInputStream())
				.createScoped(AnalyticsScopes.all());

		// Construct the Analytics service object.
		return new Analytics.Builder(httpTransport, JSON_FACTORY, credential)
				.setApplicationName(APPLICATION_NAME).build();
	}

	private static List<GoogleAnalyticsDto> getCoreData(Analytics analytics)
			throws IOException {
		
		String currentDate = DateUtil.changeDateFormat(
				new Date(), "yyyy-MM-dd");

		Get apiQuery = analytics
				.data()
				.ga()
				.get("ga:167291616", // Google analytics profile ID
						"2018-01-12", currentDate, "ga:pageviews")
				// Metrics.
				.setDimensions(
						"ga:pagePathLevel1, ga:pagePathLevel2,ga:pageTitle")
				.setSort("-ga:pageviews").setMaxResults(7);

		GaData gaData = apiQuery.execute();

		return getDataTable(gaData);
	}

	private static List<GoogleAnalyticsDto> getDataTable(GaData gaData) {

		if (gaData.getTotalResults() > 0) {
			List<GoogleAnalyticsDto> googleAnalyticsDto = new ArrayList<>();

			setAnalyticsDataTableToDtoRelatedFields(gaData, googleAnalyticsDto);

			return googleAnalyticsDto;
		}

		return Collections.emptyList();
	}

	private static void setAnalyticsDataTableToDtoRelatedFields(GaData gaData,
			List<GoogleAnalyticsDto> googleAnalyticsDto) {
		GoogleAnalyticsDto dto;
		for (List<String> rowValues : gaData.getRows()) {
			dto = new GoogleAnalyticsDto();
			for (String value : rowValues) {
				if (dto.getCreatedDate() != null) {
					if (!isNumeric(value)) {
						if (value.contains("- Myanmar Effective Programmer")) {
							dto.setPostTitle(value.replace(
									"- Myanmar Effective Programmer", ""));
						} else {
							String uniquePath = value.replace("/", "");
							dto.setPageUniquePath(uniquePath.replace("=", ""));
						}
					}
				} else {
					dto.setCreatedDate(value.replace("/", ""));
				}
			}
			googleAnalyticsDto.add(dto);
		}
	}

	private static boolean isNumeric(String s) {
		return s != null && s.matches("[-+]?\\d*\\.?\\d+");
	}
}
