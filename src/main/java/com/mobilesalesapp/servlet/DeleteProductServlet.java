package com.mobilesalesapp.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import com.mobilesalesapp.dao.ProductDao;
import com.mobilesalesapp.impl.ProductImpl;
import com.mobilesalesapp.model.ProductPojo;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteProduct")
public class DeleteProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)  {
		int i = 0;
		try {
			int productId = Integer.parseInt(req.getParameter("deleteId"));

			ProductPojo obj1 = new ProductPojo(productId);
			ProductDao obj2 = new ProductImpl();
			i = obj2.delete(obj1);
		} catch (NumberFormatException e) {
			e.getMessage();
		}
		
			try(PrintWriter out=res.getWriter()) {
				if (i > 0) {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Successfully Deleted');");
					out.println("location='adminMain.jsp';");
					out.println("</script>");

				} else {
					
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Not Deleted');");
					out.println("location='adminMain.jsp';");
					out.println("</script>");

				}

			}catch (IOException e) {
				e.getMessage();
			}
	
			
			
		
	}
}
