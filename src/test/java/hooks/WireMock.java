package hooks;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

import com.github.tomakehurst.wiremock.WireMockServer;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class WireMock {
	
	private WireMockServer wireMockServer;
	private static final int PORT = 8089;
	private static final String HOST = "localhost";
	
	@Before("@wiremock")
	public void setUp() {
		wireMockServer = new WireMockServer(PORT);
		wireMockServer.start();
		
		configureFor(HOST,PORT);
		
		startRecording("https://petstore.swagger.io/v2");
	}	

	@After("@wiremock")
	public void teardown()
	{
		stopRecording();
		if(wireMockServer!=null && wireMockServer.isRunning())
			wireMockServer.stop();
	}
}

