grammar Java;

@header {
import structure.*;
}

start returns [JavaProgram value]
    : program
    ;

program :
    package_statement?
    import_statement*
    class_statement*        // this should be '+' (at least one class definition
    ;

package_statement :
    (
        PACKAGE x=PACKAGE_NAME ';'      {System.out.println("package: " + $x.text);}
    )+
    ;

import_statement :
    IMPORT x=PACKAGE_NAME ';'           {System.out.println("import: " + $x.text);}
    ;

class_statement :
//      visibility_list
        CLASS name=WORD '{'     {System.out.println("class: " + $name.text);}

        '}'
    ;

PACKAGE         : 'package' ;
IMPORT          : 'import' ;
CLASS           : 'class' ;
PACKAGE_NAME    : WORD ('.' WORD)* ('.' '*')?;
IDENTIFIER      : [a-zA-Z_] [a-zA-Z0-9_]* ;
WORD            : LETTER+;
LETTER          : [a-zA-Z] ;
DIGIT           : [0-9] ;


LINE_COMMENT : '//' ~'\n'* '\n' -> channel(HIDDEN) ;
WS : [ \t\n\r]+ -> channel(HIDDEN) ;