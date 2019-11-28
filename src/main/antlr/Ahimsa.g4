grammar Ahimsa;

command : (keyword)+ FILENAME;

keyword : 'count'                 #count
        | 'ripApartBy' ARGS       #ripApartBy
        ;

ARGS : ALPHANUMERIC;
FILENAME : (((PATH_SEP*)WORD('.')*(PATH_SEP*))+)('.')*(WORD)*;
WORD : [a-zA-Z]+;
ALPHANUMERIC : [a-zA-Z0-9]+;
PATH_SEP : [/];
WS  : [ \r\t\u000C\n]+ -> skip ;