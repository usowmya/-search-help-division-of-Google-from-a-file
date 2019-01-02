# -search-help-division-of-Google-from-a-file

You work in the “search help” division of Google. Specifically, you’re writing a feature for the
search engine (from the mid 1990’s). When a user starts to type a search word, the system will
want to provide a list of word completions to the user, provided that the list is small enough.
Write a class that will store the set of words that you can complete and that allows a user to
find the matches to a word or to find matches to word prefixes. Your class should implement
the following interface class:
public interface word_match {
boolean Load ( String filename );
boolean Add ( String word );
boolean Remove ( String word );
boolean Find ( String word );
int Count_prefix ( String prefix );
String[ ] Report_prefix ( String prefix );
}
The functions have the following semantics:
Load Creates the data structure using all of the words in the given filename. If the
data structure already had words in it before calling Load then those words
are lost. This method allows you to build the bulk of the data structure at
one time, in case your choice of data structure can benefit from the onetime
load. Otherwise, it becomes a loop that calls the Add method on each
word in the file.
The method returns true if the loading was successful and false if some error
occurred during the load.
Add Adds one string to the existing data structure. The method returns true if
the word was added and returns false otherwise.
Remove Removes one string from the existing data structure. The method returns
true if the word was removed and false otherwise.
Find Search the data structure for the word. Return true if the word was found
and false otherwise.
Count_prefix Given a string that represents the start of a word, return the number of
words in your data structure that begin with the same prefix. For example, if
the prefix is “ant” then words like “ant”, “anterior”, “antenna”, and
“antithesis” all start with “ant” and could be counted in the return value.
Report_prefix Given a string that represents the start of a word, return all of the strings in
your data structure that begin with the same prefix…provided that there are
20 or fewer words. If there are more than 20 matching words then return
null.
