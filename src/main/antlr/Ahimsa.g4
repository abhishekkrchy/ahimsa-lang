grammar Ahimsa;

command : (keyword)+ FILENAME;

keyword : 'count'                           #count
        | 'splitBy' WORD                    #splitBy
        | 'replace' WORD WORD               #replace
        | 'takeColumns' WORD+                #takeColumns
        ;

WORD : [a-zA-Z0-9]+;

PATH_SEP : [/];
FILENAME : (((PATH_SEP*)WORD('.')*(PATH_SEP*))+)('.')*(WORD)*;

WS  : [ \r\t\u000C\n]+ -> skip ;