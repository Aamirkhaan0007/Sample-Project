package com.selenium.MCX.infra;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {

	protected Properties properties;

	public PropertiesFileReader() throws IOException {

		properties = new Properties();
		File file = new File("F:\\Selenium\\SeleniumWorkplace\\SampleProject\\MCXindia\\MCX.properties");
		FileInputStream fis = new FileInputStream(file);
		properties.load(fis);

	}

	public String GetUrl() {
		String url = properties.getProperty("URL");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not found in properties file");
	}

}
