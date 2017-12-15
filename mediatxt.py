# encoding: utf-8
#!/usr/bin/python

import sys
from ucb import main, trace, interact
import xml.etree.ElementTree as ET

def main():
    metaphor = ET.Element("metaphor")
    aliases = ET.SubElement(metaphor, "alises")

    fromFile = open(sys.argv[1], 'r')
    toFile = open(sys.argv[2], 'w')
    data = fromFile.read()

    first = str.index('{{Metaphor')
    if (first > 0)
        #record info
        str = str[first+10:]
    if (str.index('|Aliases=') == 0):
        str = str[9:]
        while (str[:46] == '{{Metaphor.Alias|Metaphor.Alias.Name='):
            second = str.index('}}')
            aliasName = str[46:second]
            anAliasName = ET.SubElement(aliases, "anAliasName")
            anAliasName = aliasName
            #record info
            if (str[second:second+2] == '}}'):
                str = str[second+2]
    if (str.index('|Comments=') == 0):
        first = str.index('|',1)
        comments = [10:first]
        #record info
        str = str[first]
    #tagS????
    if (str.index('|Tags=') == 0):
        first = str.index('|',1)
        list = str[6:first].split(',')
        for i in range(len(list)):
            tag = list[i]
            #record info
        str = str[first:]
    if (str.index('|Family=') == 0):
        first = str.index('|',1)
        list = str[8:first].split(',')
        for i in range(len(list)):
            family = list[i]
            #record info
        str = str[first:]
    if (str.index('|Metaphor Level=') == 0):
        first = str.index('|',1)
        level = str[16:first]
        #record info
        str = str[first:]
    if (str.index('|Metaphor Type=') == 0):
        first = str.index('|',1)
        level = str[15:first]
        #record info
        str = str[first:]
    if (str.index('|Experiential Basis=') == 0):
        first = str.index('|',1)
        level = str[20:first]
        #record info
        str = str[first:]
    if (str.index('|Source schema=') == 0):
        first = str.index('|',1)
        level = str[15:first]
        #record info
        str = str[first:]
    if (str.index('|Target schema=') == 0):
        first = str.index('|',1)
        level = str[16:first]
        #record info
        str = str[first:]
    if (str.index('|Mappings=') == 0):
        str = str[10:] #get rid of '|Mappings='
        while (str[:17] == '{{Mapping|Target='):
            first = str.index('|',10)
            target = str[17:first]
            second = str.index('}}')
            source = str[first+8:-2]
            #record info
            str = str[second+2:]
    if (str.index('|Related metaphors=') == 0):
        str = str[20:] #get rid of '|Mappings='
        while (str[:42] == '{{Related metaphor|Related metaphor.Name='):
            second = str.index('}}')
            metaphorName = str[42:second]
            #record info
            str = str[second+2:]
    if (str.index('|Entailments=') == 0):
        str = str[13:] #get rid of '|Entailments='
        while (str[:12] == '{{Entailment'):
            str = str[12:]
            if (str[:30] == '|Entailment.Target entailment='):
                first = str.index('|', 1)
                targetEntailment = str[:first]
                #record info
                str = str[64:]
            if (str[:29] == '|Entailment.Source interference='):
                first = str.index('|', 1)
                sourceInterference = str[29:first]
                #record info
                str = str[first:]
            if (str[:31] == '|Entailment.Entailed metaphors='):
                first = str.index('|', 1)
                sourceInterference = str[31:first]
                #record info
                str = str[first:]
    if (str.index('|Examples=') == 0):
        first = str.index('|',1)
        level = str[10:first]
        #record info
        str = str[first:]
        
   
    sys.exit(0)

if __name__ == '__main__':
   main()
