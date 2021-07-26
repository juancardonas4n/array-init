grammar ArrayInit;

@header{
package co.s4n.arrayinit.parser;
}

init : '{' value (',' value)* '}';

value : init # array
      | INT  # integer
      ;

INT : [0-9]
    ;

WS : [ \t\r\n]+ -> skip;