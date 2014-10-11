%code requires { 
	#include "helpers.h"
}
%{
#include <stdio.h>
#include <iostream>
#include <stdlib.h>
#include <string.h>
#include <string>
#include <sstream>
#include <vector>
#include "helpers.h" 
using namespace std;

void register_package(string* text);
void register_import(string* text);
string* append_extension(string* base, string* extension);
void register_method(Method&);
void register_constructor(Constructor& ctor, Class& c);
void register_member(Variable* v);
void register_class(Class c);
void highlight();

extern int yylex();
extern void yyerror(const char*);

string package;
vector<string> imports;
vector<Method> methods;
vector<Variable> members;
vector<Class> classes;
%}


%union {
	int ival;
	double dval;
	string* strToken;
	vector<Variable>* varVectorToken;
	Variable* varToken;
	Method* methodToken;
	Constructor* constructorToken;
	Modifier* modifierToken;
	vector<Modifier>* modifierVectorToken;
	Class* classToken;
}

%token PACKAGE IMPORT
%token <strToken> NAME CLASS PRIMITIVE_TYPE VOID MODIFIER
%token <ival> NUMBER
%token EOF_SYMBOL

%type <strToken> package_name import_name
%type <varToken> variable_declaration variable_simple_declaration variable_declaration_assignment member_declaration
%type <varVectorToken> arguments 
%type <methodToken> function_declaration
%type <constructorToken> class_constructor
%type <modifierToken> modifier 
%type <modifierVectorToken> modifier_list 
%type <strToken> data_type
%type <classToken> class_body
%%
file	: program EOF_SYMBOL	{ cout << "END OF FILE!!!" << endl;/*highlight();*/ }
program : statement		{ /*cout << "Prog production SIMPLE" << endl; /**/ }
	| program statement 	{ /*cout << "Prog production RECURSION" << endl; /**/ }
	;

statement : package_statement		{ }
	  | import_statements		{ }
	  | function_declaration	{ }
	  | member_declaration		{ }
	  | class_declaration		{ }
	  ;

package_statement : PACKAGE package_name ';'	{ register_package($2); }
		  ;
package_name : NAME			{ $$ = $1; }
	     | package_name '.' NAME	{ $$ = append_extension($1, $3); }
	     ;

import_statements : import_statements import_statement
		  | 
		  ;
import_statement : IMPORT import_name ';'	{ register_import($2); }
import_name : NAME			{ $$ = $1; }
	    | import_name '.' '*'	{ $$ = append_extension($1, new string("*")); }
	    | import_name '.' NAME	{ $$ = append_extension($1, $3); }
	    ;

function_declaration : modifier_list data_type NAME '(' arguments ')' '{' code_block '}'	{ Method* m = new Method(*$3, *$2, *$5, *$1); register_method(*m); $$ = m; }
		     | 		     data_type NAME '(' arguments ')' '{' code_block '}'	{ Method* m = new Method(*$2, *$1, *$4); register_method(*m); $$ = m; }
		     ;
class_constructor : modifier_list NAME '(' arguments ')' '{' code_block '}'	{ Constructor* c = new Constructor(*$2, *$4, *$1); $$ = c; }
		  | 		  NAME '(' arguments ')' '{' code_block '}'	{ Constructor* c = new Constructor(*$1, *$3); $$ = c; }
		  ;

code_block : /*nothing for now*/		{  }
arguments : arguments ',' data_type NAME	{ vector<Variable>* ar = $1; ar->push_back(Variable(*$4, *$3)); $$ = ar; }
	  | data_type NAME			{ $$ = new vector<Variable>{ Variable(*$2, *$1) }; }
	  | /* Nothing */			{ $$ = new vector<Variable>(); }
	  ;
modifier_list : /* NOTHING */		{ $$ = new vector<Modifier>(); }
	      | modifier_list modifier 	{ vector<Modifier>* v = $1; v->push_back(*$2); $$ = v;}
	      ;
modifier : MODIFIER	{ $$ = new Modifier(*$1); }
	 ;
variable_declaration : variable_simple_declaration	
		     | variable_declaration_assignment	{ $$ = $1; }
		     ;
variable_simple_declaration : data_type NAME	{ $$ = new Variable(*$2, *$1); }
			    ;
variable_declaration_assignment : variable_simple_declaration '=' NUMBER 	{ Variable* v = $1; v->value = to_string($3); $$ = v; }
		   		;
member_declaration : variable_declaration ';'	{ register_member($1); }

class_declaration : /*midifiers*/ CLASS NAME /*inheritance*/ '{' class_body '}'	{ Class c = *$4; c.name = *$2; register_class(c); }
		  ;
class_body : class_body function_declaration	{ Class* c = $1; c->methods.push_back(*$2); $$ = c; }
	   | class_body class_constructor	{ Class* c = $1; c->constructors.push_back(*$2); $$ = c; }
	   | class_body member_declaration	{ Class* c = $1; c->members.push_back(*$2); $$ = c; }
	   |					{ $$ = new Class(); } 
	   ;

data_type : PRIMITIVE_TYPE	{ $$ = $1; /* primitive type */ }
	  | NAME		{ $$ = $1; /* class type name */ }
%%

void highlight() {
	cout << endl << endl << "Registered data about the java file:" << endl
	     << "- package: '" << package.c_str() << '\'' << endl
	     << "- methods: " << Utils::join<Method>(methods, ">, <", [](Method& m) { return m.toString(); }, "<", ">") << endl
	     << "- members: " << Utils::join<Variable>(members, ">, <", [](Variable& v) { return v.toString(); }, "<", ">") << endl
	     << "- members: " << Utils::join<string>(imports, ">, <", [](string& s) { return s; }, "<", ">") << endl
//	     << "- classes: " << Utils::join<Class>(vector<Class>(), ">, <", [](Class& v) { return v.toString(); }, "<", ">") << endl
	     /*<< "- classes: " << Utils::join<Class>(classes, ">, <", [](Class& v) { return v.toString(); }, "<", ">") << endl/**/;
	
}
void register_package(string* text) {
	package = *text;
//	cout << "Registered import: " << package << endl;
}
void register_import(string* text) { 
	imports.push_back(*text);
}
string* append_extension(string* base, string* extension) {
	return &(*base += "." + *extension);
}
void register_method(Method& m) {
	methods.push_back(m);
//	cout << "Registered method: " << m.toString() << endl;
}
void register_member(Variable* v) {
	members.push_back(*v);
//	cout << "Registered member: " << v->toString() << endl;
}
void register_class(Class c) {
	cout << "Registerd class: " << c.toString() << endl;
	classes.push_back(c);
}
void register_constructor(Constructor& ctor, Class& c) {
	cout << "Registerd constructor: " << ctor.toString() << " for class: " << c.name << endl;
}
