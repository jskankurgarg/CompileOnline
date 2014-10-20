package foo;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Dog implements Serializable,HttpSessionBindingListener{//{,HttpSessionActivationListener,HttpSessionAttributeListener{
	public void valueBound(HttpSessionBindingEvent evt){
		System.out.println("inside valueBound  : "+evt.getName()+"--->"+evt.getValue()+"  @  "+evt.getSession());	
	}
	public void valueUnbound(HttpSessionBindingEvent evt){
		System.out.println("inside valueUnbound  : "+evt.getName()+"--->"+evt.getValue()+"  @  "+evt.getSession());	
	}

	public void sessionCreated(HttpSessionEvent evt){
		System.out.println("inside sessionCreated  :"+evt.getSession());	
	}
	public void sessionDestroyed(HttpSessionEvent evt){
		System.out.println("inside sessionDestroyed  : "+evt.getSession());	
	}

	public void attributeAdded(HttpSessionBindingEvent evt){
		System.out.println("inside attribtueAdded  : "+evt.getName()+"--->"+evt.getValue()+"  @  "+evt.getSession());	
	}
	public void attributeReplaced(HttpSessionBindingEvent evt){
		System.out.println("inside attribtueReplaced  : "+evt.getName()+"--->"+evt.getValue()+"  @  "+evt.getSession());	
	}
	public void attributeRemoved(HttpSessionBindingEvent evt){
		System.out.println("inside attributeRemoved  : "+evt.getName()+"--->"+evt.getValue()+"  @  "+evt.getSession());	
	}
	public Dog(){}
	public Dog(String breed){
		this.breeds=breed;
	}
	public String getBreed(){
		return breeds;
	}
	public void setBreed(String breed){
		System.out.println("setting breed of the doog...");
		this.breeds=breed;
	}
	public String toString(){
		return getBreed();
	}
	private String breeds;
}