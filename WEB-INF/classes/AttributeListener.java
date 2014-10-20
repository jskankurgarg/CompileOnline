import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class AttributeListener implements HttpSessionAttributeListener{
	public void attributeAdded(HttpSessionBindingEvent evt){
		System.out.println("inside attribtueAdded  : "+evt.getName()+"--->"+evt.getValue()+"  @  "+evt.getSession());	
	}
	public void attributeReplaced(HttpSessionBindingEvent evt){
		System.out.println("inside attribtueReplaced  : "+evt.getName()+"--->"+evt.getValue()+"  @  "+evt.getSession());	
	}
	public void attributeRemoved(HttpSessionBindingEvent evt){
		System.out.println("inside attributeRemoved  : "+evt.getName()+"--->"+evt.getValue()+"  @  "+evt.getSession());	
	}
}