package RestAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GreetingController {

    private static final String template = "The Avengers, %s!";
    private final AtomicLong counter = new AtomicLong();
    List <Greeting> greetings = new ArrayList<>();

    @RequestMapping(value ="/greeting", method=RequestMethod.GET, produces= {"application/xml"})
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    
    // Works only with @Controller, With @RestController it will just return the string 
    @RequestMapping(value="/home", method=RequestMethod.GET, produces="text/html;charset=UTF-8")
    public String homePageJson() {
		
		return "index.html";
    }
    
    
    
    // if the return type is POJO, produces works with either JSON or XML
    @PostMapping(value="/post", produces= {"application/xml"})
    public Greeting Post(@RequestBody  Map<String, String> payload) {
    	 return new Greeting(counter.incrementAndGet(), 
    			 String.format(template, payload.get("content")));
                 
    }
    
    @PostMapping(value="/post1", consumes= "application/json", produces= {"application/json", "application/xml"})
    public Greeting Post1(@RequestBody Greeting greet) {
    		
    	greet.setId(counter.incrementAndGet());
    	greet.setContent(String.format(template, greet.getContent()));
    	return greet;
                 
    }
    
    
    // No restriction on produces
    @PostMapping(value="/post2", consumes="text/plain")
    
    public String Post2(@RequestBody String name ) {
    		
    	return  String.format(template, name);
    	
                 
    }
    
}