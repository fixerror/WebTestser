package ua.radchenko.jee.services.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import ua.radchenko.jee.services.ConfigApplicationService;

/**
 * @author radchenko.as
 * @version 1.0
 */
@Service
public class ConfigApplicationServiceImpl implements ConfigApplicationService {
	@Value("${ua.radchenko.supportEmailAddress}")
	private String supportEmailAddress;
	@Value("${ua.radchenko.cssJsVersion}")
	private String cssJsVersion;

	@Override
	public String getSupportEmailAddress() {
		return supportEmailAddress;
	}

	@Override
	public String getCssJsVersion() {
		return cssJsVersion;
	}
}
