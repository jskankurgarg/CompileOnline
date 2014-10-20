package foo;
import java.io.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
public class ASimpleTag extends SimpleTagSupport{
	public void dotag()throws JspException,IOException{
		System.out.println("inside doTag method of SimpletagSupport.....");
		getJspBody().invoke(null);
	}
}