package php_lexicalanalyzer;
import static php_lexicalanalyzer.Token.*;

%%
%class Lexer
%type Token

white=[ ]
digits= "0"|"1"|"2"|"3"|"4"|"5"|"6"|"7"|"8"|"9"
letters= "q"|"w"|"e"|"r"|"t"|"y"|"u"|"i"|"o"|"p"|"a"|"s"|"d"|"f"|"g"|"h"|"j"|"k"|"l"|"ñ"|"z"|"x"|"c"|"v"|"b"|"n"|"m"|"Q"|"W"|"E"|"R"|"T"|"Y"|"U"|"I"|"O"|"P"|"A"|"S"|"D"|"F"|"G"|"H"|"J"|"K"|"L"|"Ñ"|"Z"|"X"|"C"|"V"|"B"|"N"|"M"
symbolsString = "!"|"#"|"%"|"&"|"("|")"|"="|"?"|"¡"|"¨"|"*"|"["|"]"|"_"|":"|";"|">"|"<"|"°"|"|"|"¬"|"~"|"-"|"+"|" "
symbolsIdentifier = "_"|{letters}|{naturalNumbers}
stringElements = {letters} | {symbolsString} | {digits}
naturalNumbers= {digits}{digits}*
integerNumbers = "-"{naturalNumbers} | {naturalNumbers}
variables = "a"|"b"
integerValues ={variables}|{integerNumbers}
booleanValues = {variables}| {booleanData}

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

booleanData = "TRUE" | "FALSE" | "true" | "false";
integerNumbers = "-"{naturalNumbers} | {naturalNumbers}
realNumber = {integerNumbers} | {integerNumbers}"."{integerNumbers} | {integerNumbers}"/"{integerNumbers} | {integerNumbers}"E"[+-]{integerNumbers}
stringData = "'"{stringElements}+"'"
 
identifiers = {letters}{symbolsIdentifier}*

%{
   public String lexeme ="";
%}

%%
{white} {/*ignore*/}
{scapeSecuence} {/*ignore*/}
{reserveWords} {lexeme=yytext(); return RESERVE_WORD;}
{aritmeticExpression} {lexeme=yytext(); return ARITMETIC_OPERATOR;}
{logicalExpression} {lexeme=yytext(); return LOGICAL_OPERATOR;}
{booleanData} {lexeme=yytext(); return TYPE_BOOL;}
{integerNumbers} {lexeme=yytext(); return TYPE_INT;}
{realNumber} {lexeme=yytext(); return TYPE_REAL;}
{stringData} {lexeme=yytext(); return TYPE_STRING;}
{identifiers} {lexeme=yytext(); return IDENTIFIERS;}
. {lexeme=yytext(); return ERROR;}