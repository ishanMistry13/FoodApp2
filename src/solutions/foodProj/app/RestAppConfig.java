package solutions.foodProj.app;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api")
public class RestAppConfig extends ResourceConfig {
	
	
	public RestAppConfig(){
		packages("solutions.foodProj.rest");
		
		
	}

}
