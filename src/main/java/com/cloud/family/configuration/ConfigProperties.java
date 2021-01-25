
package com.cloud.family.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class ConfigProperties {

    @Value("${api.title}")
    private String apiTitle;

    @Value("${api.description}")
    private String apiDescription;

    @Value("${api.version}")
    private String apiVersion;

    @Value("${api.contactname}")
    private String contactName;

    @Value("${api.contacturl}")
    private String contactUrl;

    @Value("${api.contactemail}")
    private String contactEmail;

    @Value("${api.basepackage}")
    private String basePackage;

	public String getApiTitle() {
		return apiTitle;
	}

	public String getApiDescription() {
		return apiDescription;
	}

	public String getApiVersion() {
		return apiVersion;
	}

	public String getContactName() {
		return contactName;
	}

	public String getContactUrl() {
		return contactUrl;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public String getBasePackage() {
		return basePackage;
	}
    
    

}
