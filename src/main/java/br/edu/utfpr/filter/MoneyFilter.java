package br.edu.utfpr.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

@WebFilter(dispatcherTypes = { DispatcherType.REQUEST }, urlPatterns = { "/user/saque" , "/user/deposito" })
public class MoneyFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		String withdraw = ((HttpServletRequest) request).getParameter("withdraw");
		String deposit = ((HttpServletRequest) request).getParameter("deposit");				
		
		class MyWrapper extends HttpServletRequestWrapper{
			
			public MyWrapper(HttpServletRequest request) {
				super(request);
			}
			
			private String format(String value) {
				return value.replace(",", ".");
			}
			
			@Override
			public String getParameter(String name) {
				if(name.equals("withdraw") || name.equals("deposit")){    					
					return format(super.getParameter(name));    					    					
				}else{
					return super.getParameter(name);
				}    				
			}
		}
		
		chain.doFilter(new MyWrapper((HttpServletRequest)request), response);	
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
}
