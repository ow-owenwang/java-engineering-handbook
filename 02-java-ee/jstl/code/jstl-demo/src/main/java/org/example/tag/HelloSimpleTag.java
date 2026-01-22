package org.example.tag;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;

public class HelloSimpleTag implements SimpleTag {

	private String value;
	private String count;
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public void setCount(String count) {
		this.count = count;
	}

	@Override
	public void doTag() throws JspException, IOException {
		
		JspWriter out = pageContext.getOut();
		int c = 0;
		
		c = Integer.parseInt(count);
		for(int i = 0; i < c; i++){
			out.print((i + 1) + ": " + value);
			out.print("<br>");
		}
	}

	@Override
	public JspTag getParent() {
		System.out.println("getParent");
		return null;
	}

	@Override
	public void setJspBody(JspFragment arg0) {
		System.out.println("setJspBody");
	}

	private PageContext pageContext;

	@Override
	public void setJspContext(JspContext arg0) {
		System.out.println(arg0 instanceof PageContext);
		assert arg0 instanceof PageContext;
		this.pageContext = (PageContext) arg0;
	}

	@Override
	public void setParent(JspTag arg0) {
		System.out.println("setParent");
	}

}
