package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Sample125 extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Sample125() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void readData(RandomAccessFile raf,PrintWriter out){
	   int temp=0;
	   try{
		  raf.seek(0);  
	   }catch(Exception e){}
	   out.println("<table border='1'> ");
	   for(int i=0;i<=100;i++){
		  out.println("<tr>");
		  for(int j=0;j<=100;j++){
			try{
			  temp=raf.readInt();
			  out.println("<td>"+temp+"</td>");
			}catch(Exception e){
			   e.printStackTrace(out);	
			}
		  }
		  out.println("</tr>");
	   }
	   
	   out.println("</table>");
	   
	}
	
	
	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		response.setContentType("text/html;charset=UTF-8");

		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		
		try{
	      String path=getServletContext().getRealPath("/WEB-INF/randomAccess.dat");
		  RandomAccessFile raf=new RandomAccessFile(path,"rw");
		  out.println("修改前的資料<p>");
		  readData(raf,out);
		  raf.close();
		  
		}catch(Exception e){
		  e.printStackTrace(out);	
		}
		
		
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
