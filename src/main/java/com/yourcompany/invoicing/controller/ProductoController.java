package com.yourcompany.invoicing.controller;

import java.util.*;

import org.openxava.actions.*;
import org.openxava.jpa.*;
import org.openxava.model.*;
import org.openxava.util.*;
import org.openxava.validators.*;

import com.yourcompany.invoicing.model.*;

import net.sf.jasperreports.engine.*;

public class ProductoController extends JasperReportBaseAction {
	private Product product;
	
	public Map getParameters() throws Exception {
		Messages errores = 
				MapFacade.validate("FiltroPorProducto", getView().getValues());
        if (errores.contains()) throw new ValidationException(errores);     
        Map parametros = new HashMap();
        parametros.put("number", getProduct().getNumber());
        parametros.put("producto", getProduct().getDescription());
        parametros.put("price", getProduct().getPrice());
        parametros.put("remarks", getProduct().getRemarks());
        parametros.put("category", getProduct().getCategory().getDescription());
        return parametros;
	}
	
	protected JRDataSource getDataSource() throws Exception {
		 //  return new JRBeanCollectionDataSource();
		return null;                  
    }
 
    protected String getJRXML() {                                            
        return "reporte.jrxml"; 
    }
	
	private Product getProducts() throws Exception {
		if (product == null) {
            int codigoProduct = getView().getValueInt("number");
            product = XPersistence.getManager().find(
                Product.class, codigoProduct);
        }
        return product;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}
