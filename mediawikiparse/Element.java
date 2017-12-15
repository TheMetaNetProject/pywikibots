/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mediawikiparse;

import java.util.ArrayList;

/**
 *
 * @author jalalbuckley
 */
public class Element {
    String elementName = "";
    String elementValue = "";
    Template templateValue;
        
    Element (String eName, String eVal) {
        this.elementName = eName;
	this.elementValue = eVal;
    }
    
    Element (String eName, Template temp) {
        this.elementName = eName;
	this.templateValue = temp;
    }
    
    Element (String eName) {
        this.elementName = eName;
    }
    
    void add(Template temp) {
        
    }
    
    /*
    void print(int indent) {
        if (!elementValue.equals(""))
            System.out.println(elementName + ": " + elementValue);
        else if (templateValue != null) {
            System.out.println(elementName + ": ");
            templateValue.printTemplate(indent+1);
        }
    } */
}
