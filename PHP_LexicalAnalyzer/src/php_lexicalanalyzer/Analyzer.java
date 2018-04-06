/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package php_lexicalanalyzer;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;


/**
 *
 * @author usuario
 */
public class Analyzer
{
   public String contentToAnalyze="";
   LinkedList<String> fixedErrors=new LinkedList<String> ();
   public String contentFixed="";

   public Analyzer()
   {
      reviewLexerDotJava();
   }
  
   public String ReadFileContent(String path)throws  Exception{
      String content="";
       File entry = new File(path);
       BufferedReader reader = new BufferedReader(new FileReader(entry));
       
       String line;
         while ((line = reader.readLine()) != null){
           content+=line.trim()+"\n";
         }
       reader.close();
       //contentToAnalyze = content.replace("\n", " \n").toLowerCase();
       contentToAnalyze = content.toLowerCase().replace("\n", "\\n").replace("\r", "\\r").replace("\t", "\\t").replace("\f", "\\f").replace("\b", "\\b");
       return content;
    }
   
   public String ProcessingInput() throws  IOException{
      fixedErrors.clear();
        File temporalFile = new File("temporalFile.txt");
        PrintWriter writer;
        try{
           writer = new PrintWriter(temporalFile);
           writer.print(contentToAnalyze); //this fill the temp file with the current php instructions to analyze
           writer.close();
        }
        catch(Exception e){
        }
        Reader reader = new BufferedReader(new FileReader("temporalFile.txt"));
        Lexer lex = new Lexer(reader);
        String results="";
       
        //se comienza a evaluar cada caracter
        while (true)
        {
           try{
              Token token = lex.yylex();
               if(token==null){
                  results+="**** the analyze was finished ****";
                  reader.close();
                  deleteFile("temporalFile.txt");
                  contentFixed();
                   return results; //show the results
                } //termina la evaluacion 
           
                switch(token){
                  case Error: //print if had an error
                     if(!lex.lexeme.equals("")){
                        results+=" Error, el simbolo no coincide: "+lex.lexeme+"\n";
                        fixedErrors.add(token+"á"+lex.lexeme);
                     }
                   break;
                  case Scape_secuence:
                     fixedErrors.add(token+"á"+lex.lexeme);
                     break;
                   default:
                      results+=token+":: "+lex.lexeme+"\n";
                      fixedErrors.add(token+"á"+lex.lexeme);
                   break;
               }
           }catch(Exception e){ return results+="**** the analyze was finished ****";}
     }
   }
   
   private void contentFixed(){
      String result="";
      for (int i = 0; i < fixedErrors.size(); i++)
      {
         String lexeme = fixedErrors.get(i).split("á")[1];//.replace("{", "{\n").replace("}", "}\n").replace(";", ";\n");
         
       //  lexeme = lexeme.replace("\\n", "\n").replace("\\r", "\r").replace("\\t", "\t").replace("\\f", "\f").replace("\\b", "\b");
         switch(fixedErrors.get(i).split("á")[0]){
            case "switch": case "foreach": case "for": case "do": case "while": case "if":
               //result+=lexeme+"\n";
               result+=lexeme;
               break;
            case "Comments":
               //result+="\n"+lexeme+"\n";
               result+=lexeme;
               break;
            case "Function":
               if(lexeme.contains("function")){
                  String input = lexeme.split(" ")[1];
                 // result+= "\nfunction " + input.substring(0, 1).toUpperCase() + input.substring(1)+" ";
                  result+= "function " + input.substring(0, 1).toUpperCase() + input.substring(1);
               }else{
                  String input = lexeme.split(" ")[1];
                  //result+= "\n"+input.substring(0, 1).toUpperCase() + input.substring(1)+" ";
                  result+= input.substring(0, 1).toUpperCase() + input.substring(1);
               }
               break;
            case "Access_field":
               String name = lexeme.split("�")[1].toUpperCase();
               //result+= "\n"+lexeme.split("�")[0]+"'"+name+"'"+lexeme.split("�")[2];
               result+= lexeme.split("�")[0]+"'"+name+"'"+lexeme.split("�")[2];
               break;
            case "Default_variables":
               //result+= lexeme.toUpperCase()+" ";
               result+= lexeme.toUpperCase();
               break;
            case "String_value":
               result+=lexeme;
               break;
            case "Error":
               //result+= "\nESTE SÍMBOLO NO ESTA DEFINIDO: "+lexeme+"\n";
               result+= "ESTE SÍMBOLO NO ESTA DEFINIDO: "+lexeme;
               break;
            default:
               //result+=lexeme+" ";
               result+=lexeme;
             break; 
         }
      }
      contentFixed = result;//.replace("\n\n", "\n").replace("\n \n", "\n").replace("(\n", "(");
   }
   
   private  void deleteFile(String path){
      try {
         Files.delete(Paths.get(path));
      } catch (Exception e) {
      }
   }
   
   public void reviewLexerDotJava(){
      try{
         FileReader reader = new FileReader("src\\php_lexicalanalyzer\\lexer.java");
         BufferedReader br = new BufferedReader(reader);
         if(br.readLine() == null){
            //crear el archivo lexer
            br.close();
            reader.close();
            jflex.Main.generate(new File("src\\php_lexicalanalyzer\\Rules.flex"));
         }else{
            br.close();
            reader.close();
         }
      }catch(Exception e){}
   }
}
