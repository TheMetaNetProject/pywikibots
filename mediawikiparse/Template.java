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
public class Template {
    String templateName = "";
    ArrayList<Object> page = new ArrayList<Object>();

    Template (String tName) {
	this.templateName = tName;
    }

    void add(Object obj) {
	page.add(obj);
    }
    
    /*
    void printTemplate(int indent) {
        System.out.print("--");
        System.out.print(this.templateName);
        System.out.println("--");
        
        for (int i = 0; i < page.size(); i++) {
            
            for (int k = 0; k < indent; k++) {
            System.out.print("  ");
        }
            page.get(i).print(indent);
        }
    } */
    

}
