package room.system.jetty9demo.cdi;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * 
 * @author Uros Majeric
 *
 */
@SessionScoped
@Named
public class HelloWorld implements Serializable {
	private String message;
	private String append;
	
	public HelloWorld() {
		super();
                System.out.println("public HelloWorld()");
	}
	
	@PostConstruct
	public void postConstruct() {
		this.message = "Hello ";
		this.append = "World";
                System.out.println("postConstruct()");
	}
	
	public void appendString() {
		this.message += append + " ";
		this.append = "";
	}

	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	public void setAppend(String append) {
		this.append = append;
	}

	public String getAppend() {
		return append;
	}
}
