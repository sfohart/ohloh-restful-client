package br.ufba.dcc.mestrado.computacao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.BeforeClass;

import br.ufba.dcc.mestrado.computacao.ohloh.restful.client.OhLohRestfulClient;

public abstract class AbstractOhLohApiTest {

	private static Properties properties;
	private static String apiKey;
	private static OhLohRestfulClient ohLohRestfulClient;

	public AbstractOhLohApiTest() {
		super();
	}

	public static Properties getProperties() {
		return properties;
	}

	public static String getApiKey() {
		return apiKey;
	}
	
	public static OhLohRestfulClient getOhLohRestfulClient() {
		return ohLohRestfulClient;
	}

	@BeforeClass
	public static void beforeTest() throws IOException {
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("ohloh.properties");
		
		properties = new Properties();
		properties.load(is);
		
		apiKey = properties.getProperty("test.ohloh.api.key");
		
		ohLohRestfulClient = new OhLohRestfulClient();
		ohLohRestfulClient.setApiKey(apiKey);
	}

	

}