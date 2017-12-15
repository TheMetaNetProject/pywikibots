# encoding: utf-8
#!/usr/bin/python

import codecs
import sys
import re

def main():
    toFile = codecs.open(sys.argv[4], encoding='utf-8', mode='w+')
    data = codecs.open(sys.argv[3], encoding='utf-8');
    if (sys.argv[2] == 'en'):
        toAdd = 'IS'
    elif (sys.argv[2] == 'es'):
        toAdd = 'ES'
    elif (sys.argv[2] == 'ru'):
        toAdd = '- ЭТО'
    lines = list()
    for line in data:
        lines.append(line)

    for a in range(0, len(lines)):
        if ((lines[a])[:3] == '---'):
            continue
        prog = re.compile('\w+', re.U)
        words = prog.findall(lines[a])
        if ((lines[a])[-3:-1] == '-:'):
            temp = words[0]
            words[0] = words[1]
            words[1] = temp
        for b in range(0, 2):
            toFile.write(u'xxxx\n')
            toFile.write(u'\'\'\'AutoSchema:' + words[b].capitalize() + '\'\'\'\n')
            toFile.write(u'{{AutoSchema\n|Status=auto extracted\n|Entered by=SiteBot\n}}\n')
            toFile.write(u'yyyy\n')
        toFile.write('xxxx\n')
        toFile.write('\'\'\'AutoMetaphor:' + words[1].upper() + " ES " + words[0].upper() + '\'\'\'\n')
        toFile.write('{{AutoMetaphor\n|Source schema=AutoSchema:' + words[0].capitalize() + '\n|Target schema=AutoSchema:' + words[1].capitalize() + '\n|Status=auto extracted\n|Entered by=SiteBot\n}}\n')
        toFile.write('yyyy\n')
    sys.exit(0)

if __name__ == '__main__':
   main()
