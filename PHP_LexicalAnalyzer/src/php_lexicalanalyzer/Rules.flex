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
comparisonOperator = "=="|"!="|">"|"<"|"<="|"=>"
logicalOperators ="&&"|"and"|"or"|"xor"|"||"|"!"
asignationOperator = "="
symbolsIdentifier = "_"|{letters}|{digits}{digits}*
stringElements = {letters} | {symbolsString} | {digits} | {scapeSecuence} | {arithmeticOperator} | {comparisonOperator}
integerNumbers = "-"{digits}{digits}* | {digits}{digits}*
realNumber = {integerNumbers} | {integerNumbers}"."{integerNumbers} | {integerNumbers}"/"{integerNumbers} | {integerNumbers}"E"[+-]{integerNumbers}
booleanValues = "TRUE" | "FALSE" | "true" | "false"
stringValues = "'"{stringElements}*"'"|"\""{stringElements}*"\""
continueSigns = ":"|","
reserveWords ="if"|"else"|"while"|"do"|"for"|"foreach"|"as"|"break"|"switch"|"case"|"include"|"return"|"function"|"echo"|"continue"|"<?php"|"?>"|"const"|"endwhile"|"__halt_compiler()"|"abstract"|"array()"|"as"|"callable"|"catch"|"class"|"clone"|"declare"|"default"|"die()"|"elseif"|"empty()"|"enddeclare"|"endfor"|"endforeach"|"endif"|"endswitch"|"eval()"|"exit()"|"extends"|"final"|"finally"|"global"|"goto"|"implements"|"include_once"|"instanceof"|"insteadof"|"interface"|"isset()"|"list()"|"namespace"|"new"|"print"|"private"|"protected"|"public"|"require"|"require_once"|"static"|"throw"|"trait"|"try"|"unset()"|"use"|"var"|"yield"
opening = "("|"{"|"["
closing =")"|"}"|";"|"]"
identifiers = "_"*{letters}{symbolsIdentifier}*
variables = "$"{identifiers}
values = {stringValues}|{booleanValues}|{realNumber}

constants = "private const"|"public const"|"const"|"define('"{white}*{identifiers}"',"{white}*{values}{white}*"')"
Comentaries = "//"{stringElements}*|"/*"{stringElements}*"*/"
accessFields = {variables}"[‘"{identifiers}"’]"|{variables}"[�"{identifiers}"�]"
function = "function "{identifiers}
defaultVariables = "$globals"|"$_server"|"$_get"|"$_post"|"$_files"|"$_request"|"$_session"|"$_env"|"$_cookie"|"$php_errormsg"|"$http_raw_post_data"|"$http_response_header"|"$argc"|"$argv"

%{
   public String lexeme ="";
%}

%%
{white}* {/*ignore*/}
{scapeSecuence}* {/*ignore*/}
{reserveWords} {lexeme=yytext(); return Reserve_word;}
{opening} {lexeme=yytext(); return Opening;}
{closing} {lexeme=yytext(); return Closing;}
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
{accessFields} {lexeme=yytext(); return Access_field;}
{identifiers} {lexeme=yytext(); return Identifier;}
{defaultVariables} {lexeme=yytext(); return Default_variables;}
{variables} {lexeme=yytext(); return Variable;}
{function} {lexeme=yytext(); return Function;}
{constants} {lexeme=yytext(); return Constants;}
. {lexeme=yytext(); return Error;}