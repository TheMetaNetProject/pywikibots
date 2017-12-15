# encoding: utf-8
#!/usr/bin/python

import codecs
import sys
import re
import subprocess

def main():
    botname = 'Metabot'
    
    # maximum number of sentenes to import per ling metaphor
    maxsents = 20
#    resultsBase = '/u/metanet/Parsing/Results/'
    resultsBase = '/scratch/tmp/jhong/Parsing/'
    
    subjrel = {'en':'ncsubj','es':'subj'}
    objrel = {'en':'dobj', 'es':'dobj'}
    resultsdir = {'en':'bnc','es':'GW/es'}
    corpusname = {'en':'BNC','es':'GW'}
    language = {'en':'English','es':'Spanish'}

    # argv[1] = lang (en, es, ru)
    # argv[2] = inputfile (extractor output)
    # argv[3] = outputfile (to import to wiki)
    
    if (sys.argv[1] != 'en' and sys.argv[1] != 'es' and sys.argv[1] != 'ru'):
        sys.exit("Invalid language parameter.")

    lang = sys.argv[1]
    data = codecs.open(sys.argv[2], encoding='utf-8')
    toFile = codecs.open(sys.argv[3], encoding='utf-8', mode='w+')

    resultscwd = resultsBase + resultsdir[lang]
    
    lines = list()
    for line in data:
        lines.append(line)
        
    seed = ''
    gramrel = ''
    for a in range(0, len(lines)):
        # skip dashed lines
        if ((lines[a])[:3] == '---'):
            gramrel = objrel[lang]
            continue

        # pull out all word matches
        prog = re.compile('\w+', re.U)
        words = prog.findall(lines[a])
        if ((lines[a])[-3:-1] == '-:'):
            target = words[0]
            source = words[1]
            gramrel = subjrel[lang]
        else:
            target = words[1]
            source = words[0]
        # all our source are v / all our target are n
        verb = source
        noun = target
        target = noun + '.n'
        source = verb + '.v'

        #rudimentary annotation
        annotation = source+'=pred(Source),'+target+'='+gramrel+'(Target)'
        
        # construct name of linguistic metaphor
        name = words[0] + ' ' + words[1]
        fullname = 'Linguistic metaphor:' + name.capitalize()
        
        # if there is a trailing : it is a seed
        isSeed = 0
        type = 'extracted'
        if ((lines[a])[-2:-1] == ':'):
            isSeed = 1
            type = 'seed'
            seed = fullname
        else:
            if (fullname == seed):
                type = 'seed, extracted'
            else:
                type = 'extracted'

        # Write Template Data
        comments = ""
        
        toFile.write('xxxx\n')
        toFile.write('\'\'\''+fullname+'\'\'\'\n')
        toFile.write('{{Linguistic metaphor')
        toFile.write('\n|Type='+type)
        # refer to seed if it is purely extracted
        if (type == 'extracted'):
            toFile.write('\n|Seed='+seed)
        toFile.write('\n|Source='+source)
        toFile.write('\n|Target='+target)
        toFile.write('\n|Examples=')
        
        # look up examples using script
        # check if words array has a 3rd element that is a number
        if (len(words) > 2 and re.match('\d+',words[2])):
            # look up examples
            sents = "";
            try:
                sents = unicode(subprocess.check_output(['./findrel', gramrel, verb, noun],cwd=resultscwd),'utf-8');
            except subprocess.CalledProcessError:
                sys.stderr.write('Error looking up examples for '+fullname+'\n');
            if sents is not u"" or None:
                sentlist = sents.splitlines()
                numex = 0;
                for sent in sentlist:
                    if numex >= maxsents:
                        comments = 'Imported %d examples out of %d.' % (maxsents,len(sentlist))
                        break
                    toFile.write('{{Example');
                    toFile.write('\n|Example.Text='+sent);
                    toFile.write('\n|Example.Annotation='+annotation)
                    toFile.write('\n|Example.Provenance='+corpusname[lang])
                    toFile.write('\n|Example.Language='+language[lang])
                    toFile.write('\n}}')
                    numex = numex + 1
        toFile.write('\n|Comments='+comments)
        toFile.write('\n|Entered by='+botname)
        toFile.write('\n|Status=auto imported')
        toFile.write('\n}}\n')
        toFile.write('yyyy\n')
    sys.exit(0)

if __name__ == '__main__':
    main()
