grammar Ahimsa;

command : (keyword)+ FILENAME;

keyword : 'rows'                            #count
        | 'columns'                         #countColumns
        | 'splitBy' WORD                    #splitBy
        | 'replace' WORD WORD               #replace
        | 'takeColumns' WORD+               #takeColumns
        | 'find' WORD+                      #findWords
        ;

WORD : [a-zA-Z0-9]+;

PATH_SEP : [/];
FILENAME : (((PATH_SEP*)WORD('.')*(PATH_SEP*))+)('.')*(WORD)*;

WS  : [ \r\t\u000C\n]+ -> skip ;