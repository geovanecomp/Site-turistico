package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadFileController
 */
public class UploadFileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		List<String> listaItens = (List<String>)sessao.getAttribute("listaItens");
		if(listaItens==null){
			listaItens =  listaItens = new ArrayList<String>();
		}
		
		   boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		    if (!isMultipart) {
		      System.out.println("File Not Uploaded");
		      request.setAttribute("status", "Nenhuma imagem informada");
		      RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarEmpresa.jsp");
			  dispatcher.forward(request,response);
		    } else {
			      FileItemFactory factory = new DiskFileItemFactory();
			      ServletFileUpload upload = new ServletFileUpload(factory);
			      List items = null;
	
			      try {
			        items = upload.parseRequest(request);
			        System.out.println("items: "+items);
			      } catch (FileUploadException e) {
			        e.printStackTrace();
			      }
			      Iterator itr = items.iterator();
			      while (itr.hasNext()) {
					FileItem item = (FileItem) itr.next();
					if (!item.isFormField()){
					//	String name = item.getFieldName();
						//System.out.println("nome: "+name);
						//String value = item.getString();
						//System.out.println("value: "+value);
						try {
							String itemName = item.getName();
							long sizeInBytes = item.getSize();
							        //long tamanhoPermitido = 200000;
							//if ((sizeInBytes<=tamanhoPermitido)){
							
							File savedFile = new File("C:/Users/Geovane/workspace/Estag/ProjetoTurismo/WebContent/img/"+itemName);
				            item.write(savedFile);
				            System.out.println("Esta em:"+savedFile.isDirectory());
				           
				            listaItens.add(itemName);
				            
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					      
					    
			      }
		    	  sessao.setAttribute("listaItens", listaItens);
			      RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarEmpresa.jsp");
				  dispatcher.forward(request,response);
			      
			      
		    }
	}
}	
/*
 if (!fitem.isFormField()) {  
        InputStream fin = null;  
        FileOutputStream fout = null;  
        try {  
            fin = fitem.getInputStream();  
            fout = new FileOutputStream("c:/incoming/" + fitem.getName());  
            byte b = fin.read();  
            while (b != -1) {  
                fout.write(b);  
                b = fin.read();  
            }  
            in.flush();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            if (fin != null) fin.close();  
            if (fout != null) fout.close();  
        }  
    }   
 */
			  
