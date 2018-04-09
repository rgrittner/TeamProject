# Team Project - Renee, Nicole, Xinan

### Problem Statement
Today’s developers need the ability to build dynamic, responsive web pages using data stored as Java objects.  Common 
approaches to output Java objects include JSTL and Scriptlets. However, using JSPs to display JSTL and/or Scriptlets 
limits the dynamic display capabilities of the developer. Front end development benefits from the use of JavaScript, 
which allows elements to be individually displayed as needed – but cannot work with Java objects. Enter Database 
Translator, which allows Java objects stored in databases to be seamlessly translated into a JavaScript-friendly 
language, either JSON or XML. 

Happy Coding!


### [Project Plan](projectPlan.md)

### User Guide
| Table | url | verb |Description | 
| -----  |  ---- | ---   | -----|
| Nationality | /services/Nationalities/xml<br>/services/Nationality/json | GET |Lists all Nationalities |
| Composer | /services/Composers/xml<br>/services/Composers/json | GET |List all Composers |
| Composer | /services/Composers/{Nationality}/xml<br>/services/Composers/{Nationality}/json| GET |Lists all composers of given nationality |
| Composer | /services/Composers/lastName/{lastName}/xml<br>/services/Composers/lastName/{lastName}/json| GET |Lists all composers of given last name |
| InstrumentCategory | /services/InstrumentCategories/xml<br>/services/InstrumentCategories/json| GET |Lists all instrument categories |
| Instruments | /services/Instruments/xml<br>/services/Instruments/json| GET |Lists all instruments  |
| Instruments | /services/Instruments/{instrument}/xml<br>/services/Instruments/{instrument}/json| GET |Lists all instruments of provided name |
| Compositions | /services/Compositions/xml<br>/services/Compositions/json| GET |Lists all compositions  |
| Compositions | /services/Compositions/title/{title}/xml<br>/services/Compositions/title/{title}/json| GET |Lists all compositions of provided title  |