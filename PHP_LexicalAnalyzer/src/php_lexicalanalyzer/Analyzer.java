/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package php_lexicalanalyzer;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author usuario
 */
public class Analyzer
{
   public String contentToAnalyze="";

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
       contentToAnalyze = content.replace("\n", " \n").toLowerCase();
       return content;
    }
   
   public String ProcessingInput() throws  IOException{
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
                   return results; //show the results
                } //termina la evaluacion 
           
                switch(token){
                  case Error: //print if had an error
                     results+=" Error, el simbolo no coincide: "+lex.lexeme+"\n";
                   break;
                   default:
                      results+=token+": "+lex.lexeme+"\n";
                   break;
               }
           }catch(Exception e){ return results+="**** the analyze was finished ****";}
     }
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
