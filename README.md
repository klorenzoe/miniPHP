# miniPHP
This is only a lexical analyzer of some PHP statements using JFlex with Netbeans 

At the beginnig I had to add a JFlex library to netbeans. The source, I found it on http://jflex.de/download.html, It is the .zip file, after of decompress I the .jar is found on lib directory. The project is very simple, It has a frame that is all the graphic part, on that class I do the transacctions with the user. The project has a "Analyzer.java" that is the logical part, on that I call the functions, analyze the tokens, build the answers. The JFlex part is the file "Rules.flex" that file contains rules that allow analyze the php code. With the JFlex library added is possible run the .flex file, the result is a external file named "lexer.java" contains the code about the rules. Its important said that is necessary have a enum class with the tokens returned for the lexer.java. I read the tokens and processing the information. 

The project has three buttons, "import" its function is upload the code to analyze, "export" its function is download the results on a specific directory, and "clear", the symbol is a broom, when you press this buttom the areas are cleaned and the lexer.java is erasered, when you import or you open the project again, the lexer.java is overwriting.

I think my program is functional because validate the rules about the php tokens, also, puts priorities, so It is few probably its fail. 

About the errors, when the program does not found all the expression, it analyze each character for find some token recognized... but if one character is not recognize, show on screen that it is not recognized that token.
