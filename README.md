# testPM
1) Cover "Search Breweries" method of https://www.openbrewerydb.org/documentation with autotests using Java + REST Assured 
(pick up to 5 scenarios covering main method features and implement corresponding autotest in code, the rest scenarios you think should be included in complete test suite can be listed in readme file).

In my autotest you can see the most important scenarios covering main method "Search Breweries" (in my opinion). 
Also i researched that this lib use elastic search core so there is a lot of difficult logic of search:
Here the core of this lib : https://github.com/ankane/searchkick#getting-started
It is use the Levenshtein distance algorithm (https://en.wikipedia.org/wiki/Levenshtein_distance). The work of this algorithm i did not cover (maybe partly but it is hardcoded).

2) Examine "List Breweries" method and share your thoughts (in readme file) on how you would apply test automation to it (what approach, test design techniques you'd choose etc).
Also please provide estimated effort for completing this task.




