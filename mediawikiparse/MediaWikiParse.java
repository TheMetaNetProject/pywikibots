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
public class MediaWikiParse {
    
    private static int tokenIndex = 0;
    private static int endTokenIndex = 0;
    private static String endToken = "";
    private static String startToken = "";
    
    public static boolean isBracket(String str, int index) {
        return str.substring(index, index+2).equals("{{") || str.substring(index, index+2).equals("}}");
}

    public static int nextTokenIndex(String str) {
        int openBracket = str.indexOf("{{");
        int pipe = str.indexOf("|");
        int equals = str.indexOf("=");
        int closingBracket = str.indexOf("}}");
        return Math.min(Math.min(Math.min(openBracket, pipe),equals),closingBracket);
    }
    
    public static int nextTokenIndex(String str, int index) {
        if (index == -1)
            index++;
        else if (isBracket(str, index))
            index += 2;
        else
            index++;
        
        int openBracket = str.indexOf("{{", index);
        int pipe = str.indexOf("|", index);
        int equals = str.indexOf("=", index);
        int closingBracket = str.indexOf("}}", index);
        //return Math.min(Math.min(Math.min(openBracket, pipe),equals),closingBracket);
        
        if (openBracket != -1 && pipe != -1 && equals != -1 && closingBracket != -1)
            return Math.min(Math.min(Math.min(openBracket, pipe),equals),closingBracket);
        
        else if (openBracket != -1 && pipe != -1 && equals != -1)
            return Math.min(Math.min(openBracket, pipe),equals);
        else if (openBracket != -1 && pipe != -1 && closingBracket != -1)
            return Math.min(Math.min(openBracket, pipe),closingBracket);
        else if (openBracket != -1 && closingBracket != -1 && equals != -1)
            return Math.min(Math.min(openBracket,equals),closingBracket);
        else if (closingBracket != -1 && pipe != -1 && equals != -1)
            return Math.min(Math.min(pipe,equals),closingBracket);
        
        else if (openBracket != -1 && pipe != -1)
            return Math.min(openBracket, pipe);
        else if (openBracket != -1 && equals != -1)
            return Math.min(openBracket, equals);
        else if (openBracket != -1 && closingBracket != -1)
            return Math.min(openBracket, closingBracket);
        else if (pipe != -1 && equals != -1)
            return Math.min(pipe, equals);
        else if (pipe != -1 && closingBracket != -1)
            return Math.min(pipe, closingBracket);
        else if (equals != -1 && closingBracket != -1)
            return Math.min(equals, closingBracket);
        
        else if (openBracket != -1)
            return openBracket;
        else if (pipe != -1)
            return pipe;
        else if (equals != -1)
            return equals;
        else if (closingBracket != -1)
            return closingBracket;
        else
            return -9999999;
    }
    
    public static int lastTokenIndex(String str, int index) {
        index--;
        int openBracket = str.lastIndexOf("{{", index);
        int pipe = str.lastIndexOf("|", index);
        int equals = str.lastIndexOf("=", index);
        int closingBracket = str.lastIndexOf("}}", index);
        
        if (openBracket != -1 && pipe != -1 && equals != -1 && closingBracket != -1)
            return Math.min(Math.min(Math.min(openBracket, pipe),equals),closingBracket);
        
        else if (openBracket != -1 && pipe != -1 && equals != -1)
            return Math.min(Math.min(openBracket, pipe),equals);
        else if (openBracket != -1 && pipe != -1 && closingBracket != -1)
            return Math.min(Math.min(openBracket, pipe),closingBracket);
        else if (openBracket != -1 && closingBracket != -1 && equals != -1)
            return Math.min(Math.min(openBracket,equals),closingBracket);
        else if (closingBracket != -1 && pipe != -1 && equals != -1)
            return Math.min(Math.min(pipe,equals),closingBracket);
        
        else if (openBracket != -1 && pipe != -1)
            return Math.min(openBracket, pipe);
        else if (openBracket != -1 && equals != -1)
            return Math.min(openBracket, equals);
        else if (openBracket != -1 && closingBracket != -1)
            return Math.min(openBracket, closingBracket);
        else if (pipe != -1 && equals != -1)
            return Math.min(pipe, equals);
        else if (pipe != -1 && closingBracket != -1)
            return Math.min(pipe, closingBracket);
        else if (equals != -1 && closingBracket != -1)
            return Math.min(equals, closingBracket);
        
        else if (openBracket != -1)
            return openBracket;
        else if (pipe != -1)
            return pipe;
        else if (equals != -1)
            return equals;
        else if (closingBracket != -1)
            return closingBracket;
        else
            return -9999999;
    }
    
    public static String nextToken(String str, int tokenIndex) {
        if ( str.substring(tokenIndex,tokenIndex+2).equals("{{") || str.substring(tokenIndex,tokenIndex+2).equals("}}") )
            return str.substring(tokenIndex,tokenIndex+2);
        else
            return str.substring(tokenIndex, tokenIndex+1);
    }

    public static void main(String[] args) {
        String input = "{{Metaphor|Aliases={{Metaphor.Alias|Metaphor.Alias.Name=EXPERIENCING A STATE IS BEING IN A LOCATION|Metaphor.Alias.Provenance=Ellen}}|Comments=proposed variation of States Are Locations|Metaphor Type=Primary|Experiential basis=experiencing different states at different locations|Source schema=Trajector landmark|Target schema=Experiencing a state|Mappings={{Mapping|Target=exteriencer|Source=trajector}}{{Mapping|Target=state|Source=profiled_region|Comment=current state is current location}}|Related metaphors={{Related metaphor|Related metaphor.Relation type=makes use of|Related metaphor.Name=STATES ARE LOCATIONS}}{{Related metaphor|Related metaphor.Relation type=is related to|Related metaphor.Name=CIRCUMSTANCES ARE SURROUNDINGS}}|Entailments={{Entailment|Entailment.Target entailment=currently experiencing a state|Entailment.Source inference=being in a bounded region (at interior)|Entailment.Type=image schematic}}{{Entailment|Entailment.Target entailment=not currently experiencing a state|Entailment.Source inference=being outside a bounded region (at exterior)|Entailment.Type=image schematic}}{{Entailment|Entailment.Target entailment=imminence of experience|Entailment.Source inference=distance to boundary (from exterior)}}|Examples={{Example|Example.Language=English|Example.Text=I'm in love.|Example.Provenance=PITF, p. 180|Example.Comments=in a region/state}}{{Example|Example.Language=English|Example.Text=She's out of her depression.|Example.Provenance=PITF, p. 180|Example.Comments=out of region/state}}{{Example|Example.Language=English|Example.Text=She's close to insanity.|Example.Provenance=PITF, p. 180|Example.Comments=near a region/state}}{{Example|Example.Language=English|Example.Text=When at rest, the computer goes into hibernation.}}{{Example|Example.Language=English|Example.Text=He's at an advanced stage in his studies.|Example.Provenance=1991 Metaphor list}}{{Example|Example.Language=English|Example.Text=What state is the project in?|Example.Provenance=1991 Metaphor list}}|Relevant LUs=|Entered by=Ellen|Last reviewed by=Ellen, Oana|Status=in development, proposed}}";
        ArrayList<Template> templates = new ArrayList<Template>();
        templates.add(makeTemplate(input,0));
        /*
        for (int i = 0; i < templates.size(); i ++) {
            templates.get(i).printTemplate(0);
        } */
        System.out.println("Done!");
    }
    
    public static String getElement(String str, int start, int end) {
        if (str.substring(start,start+2).equals("{{"))
            return str.substring(start+2,end);
        else
            return str.substring(start+1,end);
    }
    
    public static void advanceTokens(String str) {
        tokenIndex = endTokenIndex;
        endTokenIndex = nextTokenIndex(str, tokenIndex);
        endToken = nextToken(str, endTokenIndex);
        startToken = nextToken(str, tokenIndex);
    }
    
    public static void pastTokens(String str) {
        endTokenIndex = tokenIndex;
        tokenIndex = lastTokenIndex(str, tokenIndex);
        startToken = nextToken(str, tokenIndex);
        endToken = nextToken(str, endTokenIndex);
    }

    public static Template makeTemplate(String str, int beginIndex) {
        tokenIndex = nextTokenIndex(str, beginIndex-1);
        endTokenIndex = nextTokenIndex(str, tokenIndex);
        Template temp = new Template(getElement(str, tokenIndex,endTokenIndex));
        advanceTokens(str);
        //tokenIndex = endTokenIndex;
        
        while (true) {
            //advanceTokens(str);
            
            if (startToken.equals("{{") || endToken.equals("|")) 
                advanceTokens(str);
            
            
            if (startToken.equals("}}"))
                break;
            
            if (endToken.equals("=")) {
                String name = getElement(str,tokenIndex,endTokenIndex);
                advanceTokens(str);
                if (endToken.equals("|"))
                    temp.add(new Element(name, getElement(str,tokenIndex,endTokenIndex)));
                else if (endToken.equals("}}")) {
                    temp.add(new Element(name, getElement(str,tokenIndex,endTokenIndex)));
                    return temp;
                }
                else {
                    Template nestedTemp = new Template(name);
                    while (endToken.equals("{{")) {
                        Template newTemp = makeTemplate(str, endTokenIndex);
                        //temp.add(new Element(name, newTemp));
                        nestedTemp.add(newTemp);
                        advanceTokens(str);
                    }
                    temp.add(nestedTemp);
                advanceTokens(str);
                }   
            }
            //advanceTokens(str);
        }
        return temp;
    }
    
    /*
    public static Template makeTemplateOld(String str) {
	//Need to implement functionality for no = sign
	int firstBlock = str.indexOf("|");
	String name = str.substring(0,firstBlock);
	Template temp = new Template(name);

        int ending = -1;
	int first=0;
	int second = firstBlock;
        int equalsPos = 0;
	while (true) {
            if (str.substring(first,first+4).equals("}}{{")) {
                String tempStr = str.substring(first+4);
		Template newTemp = makeTemplate(tempStr);
                
                first = newTemp.lastCharIndex + first + 4;
                equalsPos = first + 4 + newTemp.lastEqualPos;
                ending = first + 4 + newTemp.lastEnding;
		temp.add(newTemp);
            }
            first = str.indexOf("|", first+1);
	    if (first == -1 && endTemplate(str.substring(second+1,second+3)) ) {
		break;
	    }

	    equalsPos = str.indexOf("=", equalsPos+1);
            
            if ( isTemplate(str.substring(equalsPos+1,equalsPos+3)) ) {
		String tempStr = str.substring(equalsPos+3);
		Template newTemp = makeTemplate(tempStr);
                
                first = newTemp.lastCharIndex + equalsPos + 3;
                equalsPos = equalsPos + 3 + newTemp.lastEqualPos;
                ending = equalsPos + 3 + newTemp.lastEnding;
		temp.add(newTemp);
	    } else {
		name = str.substring(first+1, equalsPos);
		second = str.indexOf("|", first+1);
		String value = str.substring(equalsPos+1,second);
                //ending = str.indexOf("}}",ending+1);
                if ( str.indexOf("}}",ending+1) < second ) {
                    ending = str.indexOf("}}",ending+1);
                    value = value.substring(0,value.indexOf("}}"));
                    Element newEl = new Element(name,value);
                    temp.add(newEl);
                    temp.setLastChar(str.indexOf("}}"));
                    temp.setLastEqualPos(equalsPos);
                    temp.setEnding(ending);
                    return temp;
                } else {
                    Element newEl = new Element(name,value);
                    temp.add(newEl);
                }
	    }
	}
        return temp;
    }
*/
}
