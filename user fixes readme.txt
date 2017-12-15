User fixes README

NOTE: In order for this to work, first you must replace the existing metaphor_family.py family file in pywikipedia/families with the one provided here.

Fixing Role names
-------------------------------------------------------------------------------------
This will uncapitalize role names.
(1) Enter "python replace.py -catr:Schema -fix:fixRole

-cat:Schema indicates that we want to look through all of the pages in the category "Schema"
-fix:fixRole indicates that we want to run fixRole which will uncapitalize role names

Fixing Schema Names
-------------------------------------------------------------------------------------
This will make sure words in a schema are separated by spaces, not underscores
(1) python replace.py -catr:Metaphor -fix:fixSchema

-cat:Metaphor indicates that we want to look through all of the pages in the category "Metaphor"
-fix:fixSchema indicates that we want to run fixSchema which will get rid of underscores in Schema and replace them with spaces