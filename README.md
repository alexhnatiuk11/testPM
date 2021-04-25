# testPM
1) Cover "Search Breweries" method of https://www.openbrewerydb.org/documentation with autotests using Java + REST Assured 
(pick up to 5 scenarios covering main method features and implement corresponding autotest in code, the rest scenarios you think should be included in complete test suite can be listed in readme file).

In my autotest you can see the most important scenarios covering main method "Search Breweries" (in my opinion). 
Also i researched that this lib use elastic search core so there is a lot of difficult logic of search:
Here the core of this lib : https://github.com/ankane/searchkick#getting-started.
It is use the Levenshtein distance algorithm (https://en.wikipedia.org/wiki/Levenshtein_distance).
For this algorithm we can check some case like this:
- Missing letter: Actual param - "Lews", Expected - "Lewis".
- The letters are rearranged: Actual param - "Lewsi", Expected - "Lewis".
The work of this algorithm i did not cover (maybe partly but it is hardcoded).\n
**ATTENTION The autotest contains hardcoded data, for example, the expected number of searched objects, ideally this data should be taken from the database **

2) Examine "List Breweries" method and share your thoughts (in readme file) on how you would apply test automation to it (what approach, test design techniques you'd choose etc).
Also please provide estimated effort for completing this task.

The search for breweries is based on some parameters. Test cases will be formed depending on the parameters:

**by_city** (main scenarios)
 - simle text: "alameda"
 - uppercase text: "ALAMED"
 - partly text: "alamed"
 - missing letter: "alamd"
 - letters are rearranged: actual param - "lewsi", Expected - "lewis".
 - text with spaces (using underscore): "san_diego"
 - text with spaces (url encoding): "san%20diego"
 - text start with spaces and end with spaces to test trim
 - empty param - nothing should break
 - digits
 - special symbols (unicode symbols) 
 - null - nothing should break

 **by_name** (main scenarios)
 Same as by param by_city
 
 **by_state** (main scenarios)
 Same as by param by_city and by_name BUT important full state name.
 - simle text: "alameda"
 - uppercase text: "ALAMED"
 - text with spaces (using underscore): "san_diego"
 - text with spaces (url encoding): "san%20diego"
 - text start with spaces and end with spaces to test trim
 - empty param
 - digits
 - special symbols (unicode symbols)
 - null

 **by_postal** (main scenarios)
 Cases when the code is less than 5 digits:
 - 0 (sometimes 0 is poorly processed)
 - code with 1 digit (partly code)
 - code with 5 digit (full code)
 - empty param - nothing should break
 
 Сases when the code is more than 5 digits (according to the requirements, we must use hyphen or an underscore). May be filtered by basic (5 digit) postal code or more precisely     filtered by postal+4 (9 digit) code.

 - without digits after hyphen or an underscore (12305_ or 12305-)
 - partly code with hyphen or an underscore (12305_1 or 12305-1)
 - full code with hyphen or an underscore (12305_1234 or 12305-1234)
 - code with more than 9 digits (12305_12345 or 12305-12345) - nothing should break
 - wrong place of hyphen or an underscore (123_123 or 123-123) -  nothing should break
 - code start with hyphen or an underscore (-123 or _231) -  nothing should break
 - use letters - nothing should break

**by_type** (main scenarios)
In this param we should use some key like: "micro, nano, regional, brewpub, large, planning, bar, contract, proprietor, closed"
Try to test like **by_name** but using this key. Also try to use some invalid key to check that everything fine

**page** (main scenarios)
- 0 - must return first page
- less than 0 - must return first page
- simple number of page, example 3 
- check that every page has 20 objects
- check the max page
- chech more than max page

**per_page** (main scenarios)
Note: Default per page is 20. Max per page is 50.
- check that without param it return 20 object
- param 0 - return nothing
- less than 0 - return default 20 object
- 5 - return 5 object
- 25 - return 25 object
- 50 - return 50 object
- more than 50 - return 50 object
- use letters - nothing should break

**by_dist** (main scenarios)
I didn't really understand the logic of searching for this parameter. But since numbers are used here, I would use the techniques of equivalent partitioning, boundary values and try a few invalid values.

**sort**
By requirements, you can sort both by one and by several fields, so there can be quite a lot of test scenarios here. So in this case I would use a pairwise technique to reduce the number of scenarios.



 










