grammar Ahimsa;

command : (keyword)+ WORD;

keyword : 'rows'                            #count
        | 'columns'                         #countColumns
        | 'splitBy' WORD                    #splitBy
        | 'replace' WORD WORD               #replace
        | 'takeColumns' WORD+               #takeColumns
        | 'find' WORD+                      #findWords
        | 'match' WORD+                     #match
        ;

WORD : ((SYMBOLS*)ALPHANUMERIC(SYMBOLS*))+;

ALPHANUMERIC : [a-zA-Z0-9]+;
SYMBOLS : ('~' | '`' |'@' | '#' |'$' | '%' |'^' | '&' |'*' | '(' |')' | '_' |'-' | '=' |'+' | '[' |']' | '|' | '{' | '}' | '\\' | '/' | ',' | '"' | '?' | '.' | '<' | '>');

WS  : [ \r\t\u000C\n]+ -> skip
    ;