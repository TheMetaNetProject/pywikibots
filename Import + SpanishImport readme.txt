Run Import.py or SpanishImport.py
1) First, run Import.py in order to create an "output" file that will be used.
2) The first command line argument is the "import file." The second command line argument is the "export file."
For example: python Import.py input.txt output.txt or python SpanishImport.py spanishInput.txt spanishOutput.txt

Run pagefromfile.py
1) Use the following format:
python pagefromfile.py -force -nottitle -putthrottle:2 -start:xxxx -end:yyyy -file:output.txt

-force makes the script overwrite a page if it finds a page already with the same title
-nottitle keeps the script from adding the title into the text of the wiki page being created
-putthrottle:2 makes the script wait 2 seconds in between uploading pages. You can replace 2 with a different number of seconds.
-start:xxxx tells the script that each page begins at the text "xxxx"
-end::yyyy tells the script that each page ends at the text "yyyy"
-file:output.txt tells the script to get the information for the pages to be uploaded from the file called "output.txt."