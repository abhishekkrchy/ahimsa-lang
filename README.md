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
➜  ~ ahimsa count ~/Desktop/someData
4
➜  ~ ahimsa splitBy o ~/Desktop/someData
Wh  are y u t  wave y ur finger?
Y u must have been  ut y ur head
Eye h le deep in muddy waters
Y u practically raised the dead
➜  ~ ahimsa replace a olo ~/Desktop/someData
Who olore you to wolove your finger?
You must holove been out your heolod
Eye hole deep in muddy woloters
You prolocticololly roloised the deolod
➜  ~ ahimsa splitBy o replace a olo ~/Desktop/someData
Wh   l re y u t  w l ve y ur finger?
Y u must h l ve been  ut y ur he l d
Eye h le deep in muddy w l ters
Y u pr l ctic l lly r l ised the de l d
➜  ~ ahimsa takeColumns 1 2 splitBy o replace a olo ~/Desktop/someData
Wh
Y u must h
Eye h le deep in muddy w
Y u pr
</code>
</pre>