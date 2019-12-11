# ahimsa-lang

A simple to use language for command line file data processing.

## Requirements
Java 1.8 or later

## Installation 
Run ./install.sh - requires sudo permission
Make sure /usr/local/bin/ is included in your PATH.

## Usage
<pre>
<code>
➜  ~ cat ~/Desktop/someData
Who are you to wave your finger?
You must have been out your head
Eye hole deep in muddy waters
You practically raised the dead
➜  ~ ahimsa rows ~/Desktop/someData
4
➜  ~ ahimsa columns ~/Desktop/someData
1
➜  ~ ahimsa splitBy are ~/Desktop/someData
Who   you to wave your finger?
You must have been out your head
Eye hole deep in muddy waters
You practically raised the dead
➜  ~ ahimsa splitBy o ~/Desktop/someData
Wh  are y u t  wave y ur finger?
Y u must have been  ut y ur head
Eye h le deep in muddy waters
Y u practically raised the dead
➜  ~ ahimsa replace o ooo ~/Desktop/someData
Whooo are yooou tooo wave yooour finger?
Yooou must have been ooout yooour head
Eye hooole deep in muddy waters
Yooou practically raised the dead
➜  ~ ahimsa splitBy ooo replace o ooo ~/Desktop/someData
Wh  are y u t  wave y ur finger?
Y u must have been  ut y ur head
Eye h le deep in muddy waters
Y u practically raised the dead
➜  ~ ahimsa takeColumns 1 2 splitBy ooo replace o ooo ~/Desktop/someData
Wh  are y
Y u must have been
Eye h le deep in muddy waters
Y u practically raised the dead
➜  ~ ahimsa find dead takeColumns 1 2 splitBy ooo replace o ooo ~/Desktop/someData
Y u practically raised the dead
➜  ~ ahimsa find practically raised  ~/Desktop/someData
You practically raised the dead
➜  ~ ahimsa find hole dead  ~/Desktop/someData
Eye hole deep in muddy waters
You practically raised the dead
➜  ~ ahimsa match {Who WORD you to WORD your} ~/Desktop/someData
are wave
➜  ~ ahimsa match {Eye WORD deep in WORD waters} find hole dead  ~/Desktop/someData
hole muddy
</code>
</pre>