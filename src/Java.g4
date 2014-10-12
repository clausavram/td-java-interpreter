grammar Java;

@header {
import structure.*;
import java.util.stream.*;
}

start returns [JavaProgram value]
    : program
    ;

program :
    package_statement?
    importStatement*
    classDeclaration*        // this should be '+' (at least one class definition
    ;

package_statement :
    (
        PACKAGE x=PACKAGE_NAME ';'      {System.out.println("package: " + $x.text);}
    )+
    ;

importStatement :
    IMPORT x=PACKAGE_NAME ';'           {System.out.println("import: " + $x.text);}
    ;

classDeclaration :
       modifierList CLASS n=IDENTIFIER classBody      {System.out.println("class: " + $n.text);}
    ;

classBody :
    '{'
        memberDeclarationList
        ctorDeclarationList
        methodDeclarationList
        // TODO: inner classes
    '}'
    ;

memberDeclarationList :
    (
        modifierList n=variableDefinition ';'       {System.out.println("member: " + $n.text);}
    )* ;

ctorDeclarationList : ctorDeclaration* ;
ctorDeclaration :
    modifierList n=IDENTIFIER '(' args=argumentList ')' '{' codeBlock '}'      {System.out.println("ctor: " + $n.text + "(" + $args.text + ")");}
    ;

methodDeclarationList : methodDeclaration* ;
methodDeclaration :
    modifierList dataType n=IDENTIFIER '(' args=argumentList ')' '{' codeBlock '}'      {System.out.println("method: " + $n.text + "(" + $args.text + ")");}
    ;

argumentList
    : variableDefinition (',' variableDefinition)*
    |
    ;

codeBlock :
// TODO: implement
    ;

interfaceDeclaration :
// TODO: implement this
    ;

dataType
    : PRIMITIVE_TYPE
    | IDENTIFIER            // class type definitions (ex: 'String s;')
    ;

variableDefinition : dataType IDENTIFIER ;

modifierList
@init { ArrayList<Modifier> mods = new ArrayList<>(); }
    : (m=modifier {mods.add(Modifier.fromString($m.text));} )* ;
finally { if(!mods.isEmpty()) System.out.println("modifier list: " + mods); }
modifier :
    ('public' | 'protected' | 'private' | 'static' | 'abstract' | 'final')
    ;

PACKAGE         : 'package' ;
IMPORT          : 'import' ;
CLASS           : 'class' ;
IDENTIFIER      : [a-zA-Z_] [a-zA-Z0-9_]* ;
PACKAGE_NAME    : IDENTIFIER ('.' IDENTIFIER)* ('.' '*')?;
WORD            : LETTER+;
LETTER          : [a-zA-Z] ;
DIGIT           : [0-9] ;
PRIMITIVE_TYPE  : ('char' | 'int' | 'long' | 'float' | 'double' | 'boolean') ;


LINE_COMMENT : '//' ~'\n'* '\n' -> channel(HIDDEN) ;
WS : [ \t\n\r]+ -> channel(HIDDEN) ;