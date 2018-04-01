package php_lexicalanalyzer;
import static php_lexicalanalyzer.Token.*;

%%
%class Lexer
%type Token

white=[ ]
scapeSecuence = \n|\r|\t|\f|\b
digits= "0"|"1"|"2"|"3"|"4"|"5"|"6"|"7"|"8"|"9"
letters= "q"|"w"|"e"|"r"|"t"|"y"|"u"|"i"|"o"|"p"|"a"|"s"|"d"|"f"|"g"|"h"|"j"|"k"|"l"|"ñ"|"z"|"x"|"c"|"v"|"b"|"n"|"m"
symbolsString = "!"|"#"|"%"|"&"|"("|")"|"="|"¿"|"?"|"¡"|"¨"|"*"|"["|"]"|"_"|":"|";"|">"|"<"|"°"|"|"|"¬"|"~"|"-"|"+"|" "|"."|","|"\\"|"�"|"$"
arithmeticOperator = "+"|"-"|"*"|"/"|"**"|"%"
comparisonOperator = "=="|"!="|">"|"<"
logicalOperators ="&&"|"and"|"or"|"xor"|"||"|"!"
asignationOperator = "="
symbolsIdentifier = "_"|{letters}|{digits}{digits}*
stringElements = {letters} | {symbolsString} | {digits} | {scapeSecuence} | {arithmeticOperator} | {comparisonOperator}
integerNumbers = "-"{digits}{digits}* | {digits}{digits}*
realNumber = {integerNumbers} | {integerNumbers}"."{integerNumbers} | {integerNumbers}"/"{integerNumbers} | {integerNumbers}"E"[+-]{integerNumbers}
booleanValues = "TRUE" | "FALSE" | "true" | "false"
stringValues = "'"{stringElements}*"'"|"\""{stringElements}*"\""
continueSigns = ":"|","
reserveWords ="if"|"else"|"while"|"do"|"for"|"foreach"|"as"|"break"|"switch"|"case"|"include"|"return"|"function"|"echo"|"continue"|"<?php"|"?>"
opening = "("|"{"|"["
closing =")"|"}"|";"|"]"
identifiers = "_"*{letters}{symbolsIdentifier}*
variables = "$"{identifiers}
Comentaries = "//"{stringElements}*|"/*"{stringElements}*"*/"

%{
   public String lexeme ="";
%}

%%
{white}* {/*ignore*/}
{scapeSecuence}* {/*ignore*/}
{reserveWords} {lexeme=yytext(); return Reserve_word;}
{opening} {lexeme=yytext(); return Opening;}
{closing} {lexeme=yytext(); return Closing;}
{identifiers} {lexeme=yytext(); return Identifier;}
{variables} {lexeme=yytext(); return Variable;}
{comparisonOperator} {lexeme=yytext(); return Comparison_operator;}
{arithmeticOperator} {lexeme=yytext(); return Arithmetic_operator;}
{logicalOperators} {lexeme=yytext(); return Logical_operator;}
{booleanValues} {lexeme=yytext(); return Boolean_value;}
{integerNumbers} {lexeme=yytext(); return Int_value;}
{realNumber} {lexeme=yytext(); return Real_value;}
{stringValues} {lexeme=yytext(); return String_value;}
{continueSigns} {lexeme=yytext(); return Continue_sign;}
{Comentaries} {lexeme=yytext(); return Comments;}
{asignationOperator} {lexeme=yytext(); return Asignation_operator;}
. {lexeme=yytext(); return Error;}