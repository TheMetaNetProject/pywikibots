# encoding: utf-8
#!/usr/bin/python

import sys
from ucb import main, trace, interact

def main():
    fromFile = open(sys.argv[1], 'r')
    toFile = open(sys.argv[2], 'w')
    data = fromFile.read()

    lines = data.split('\n')
    source = (lines[0].split(' '))[1]

    toFile.write('xxxx\n')
    toFile.write('\'\'\'AutoSchema:' + source.capitalize() + '\'\'\'\n')
    toAdd = '{{AutoSchema\n|Status=auto extracted\n|Entered by=SiteBot\n}}\n'
    toFile.write(toAdd)
    toFile.write('yyyy\n')
    for a in range(1, len(lines)):
        words = lines[a].split(' ')
        for b in range(1, len(words)):
            toFile.write('xxxx\n')
            toFile.write('\'\'\'AutoSchema:' + words[b].capitalize() + '\'\'\'\n')
            toFile.write(toAdd)
            toFile.write('yyyy\n')

    for a in range(1, len(lines)):
        words = lines[a].split(' ')
        for b in range(1, len(words)):
            toAdd = '{{AutoMetaphor\n|Source schema=AutoSchema:' + source.capitalize() + '\n|Target schema=AutoSchema:' + words[b].capitalize() + '\n|Status=auto extracted\n|Entered by=SiteBot\n}}\n'
            toFile.write('xxxx\n')
            toFile.write('\'\'\'AutoMetaphor:' + words[b].upper() + " IS " + source.upper() + '\'\'\'\n')
            toFile.write(toAdd)
            toFile.write('yyyy\n')
    sys.exit(0)

if __name__ == '__main__':
   main()
