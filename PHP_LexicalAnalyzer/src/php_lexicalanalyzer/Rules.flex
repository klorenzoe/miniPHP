package php_lexicalanalyzer;
import static php_lexicalanalyzer.Token.*;

%%
%class Lexer
%type Token

white=[ ]
digits= "0"|"1"|"2"|"3"|"4"|"5"|"6"|"7"|"8"|"9"
naturalNumbers= {digits}{digits}*
integerNumbers = "-"{naturalNumbers} | {naturalNumbers}
variables = "a"|"b"

integerValues ={variables}|{integerNumbers}
booleanValues = {variables}| "TRUE" | "FALSE" | "true" | "false"

operators = "+"|" + "|"-"|" - "|"*"|" * "|"/"|" / "|"**"|" ** "|"%"|" % "
operatorPlusNumber = {operators}{integerValues}
operatorPlusOperation = {operators}{arithmeticOperators}
logicalOperators ="&&"|" and "|" or "|" xor "|" && "|" || "|"||"
logicalPlusValue = {logicalOperators}{booleanValues}
logicalPlusOperation = {logicalOperators}{logicalOperations}

scapeSecuence = \n|\r|\t|\f|\b
reserveWords = "die()"|"do"|"echo"|"else"|"elseif"|"empty()"|"enddeclare"|"endfor"|"endforeach"|"endif"|"endswitch"|"endwhile"|"eval()"|"exit()"|"extends"|"xor"|"yield"|"__halt_compiler()"|"abstract"|"and"|"array()"|"as"|"break"|"callable"|"case"|"catch"|"class"|"clone"|"const"|"continue"|"declare"|"default"|"use"|"var"|"while"|"final"|"finally"|"for"|"foreach"|"function"|"global"|"goto"|"if"|"implements"|"include"|"include_once"|"instanceof"|"insteadof"|"interface"|"isset()"|"list()"|"namespace"|"new"|"or"|"print"|"private"|"protected"|"public"|"require"|"require_once"|"return"|"static"|"switch"|"throw"|"trait"|"try"|"unset()"
arithmeticOperators = "+"{integerValues} | "-"{integerValues} | {integerValues}{operators}{integerValues}
aritmeticExpression = {arithmeticOperators}{operatorPlusNumber}* | {arithmeticOperators}{operatorPlusOperation}*
logicalOperations = {booleanValues}{logicalOperators}{booleanValues} | "!"{booleanValues}
logicalExpression = {logicalOperations}{logicalPlusValue}* | {logicalOperations}{logicalPlusOperation}*

%{
   public String lexeme ="";
%}

%%
{white} {/*ignore*/}
{scapeSecuence} {/*ignore*/}
{reserveWords} {lexeme=yytext(); return RESERVE_WORD;}
{aritmeticExpression} {lexeme=yytext(); return ARITMETIC_OPERATOR;}
{logicalExpression} {lexeme=yytext(); return LOGICAL_OPERATOR;}
. {lexeme=yytext(); return ERROR;}