%{
#include "java.tab.h"
#include "helpers.h"
#include <cstdio>
#include <cstdlib>
#include <stdlib.h>
#include <string.h>
#include <vector>
#include <iostream>
using namespace std;

void yyerror(char*); // we need to forward declare these functions ,
int yyparse(void); // don't worry about them
extern void highlight();
%}

string		"[^\\]*"
name		[a-zA-Z_][a-zA-Z_0-9]*
packageName	[a-zA-Z]+(\.[a-zA-Z]+)*
integer		(0x)?[0-9]+
real		(0x)?([0-9]+\.[0-9]*|[0-9]*\.[0-9]+)
primitive	(short|char|int|long|float|double|boolean)
modifier	(public|protected|private|static|abstract|final|synchronized)
%%
package				{ yylval.strToken = new string(yytext); return PACKAGE; }
import				{ yylval.strToken = new string(yytext); return IMPORT; }
class				{ yylval.strToken = new string(yytext); return CLASS; } 
{modifier}			{ yylval.strToken = new string(yytext); return MODIFIER; } 
void 				{ yylval.strToken = new string(yytext); return VOID; }
{primitive}			{ yylval.strToken = new string(yytext); return PRIMITIVE_TYPE; }
[a-zA-Z]+			{ yylval.strToken = new string(yytext); return NAME; }
[0-9]+				{ yylval.strToken = new string(yytext); return NUMBER; }
[-+*/;'":?\.,()\[\]{}<>=]	{ return yytext[0]; }
[ \t\r]				;
[\n]				;
<<EOF>>				{ return EOF_SYMBOL; }
.				{ printf("Identifier not found: %s\n", yytext); }

%%

//<<EOF>>				{ return EOF_SYMBOL; }
void yyerror(const char* str ) { printf ("ERROR: Problem on line %d!\n", yylineno);}
int yywrap (void) {
	highlight();
	exit(0);
	return 0;
}
int main (int num_args, char** args) {
	if( num_args == 2) {
		cout << "Started parser with file input..." << endl;
		FILE * file = fopen ( args [1] ,"r");
		if( file == NULL ) { printf ("couldn't open %s\n", args [1]); exit (0);}
		yyin = file ; // now flex reads from file
		yyparse ();
		fclose ( file );
	} else {
		cout << "Started parser with console input..." << endl;
		yyparse (); // yyparse is defined for us by flex
	}
	cout << "End of program!" << endl;
	cout << endl;
	highlight();
}
