**Database Translator**
----
The Database Translator service submits SQL queries to user databases and translates the result set into the user's
 preferred language, either XML or JSON. 
 
 **URL**

  /`[Class]`/`[Query parameter]`/`[Language]`/
  
  /`[Class]`/`[Language]`/

 **Method:**

  `GET` 
  
  **URL Params**
   
  `Class`
  
  `Query parameter`

  `Language`
   

   **Required:**
 
   `Class: Object`
   
   `Language: JSON, XML`

   **Optional:**
 
   `Query Parameter`

<!--* **Data Params**

  <_If making a post request, what should the body payload look like? URL Params rules apply here too._>
-->
 **Success Response:**
  
   **Code:** 200 <br />
  **Sample Content:** 
        
         {
         
         0:
         id:	1
         firstName:	"John"
         lastName:	"Smith"
         birthYear:	1965
         deathYear:	1999
         nationality:	
           id:	1
           nationality:	"American"
         compositions:
           0:
             id:	1
             title:	"Gravity"
             arranger:	""
             duration:	10
             yearComposed:	2008
             numberOfPlayers:	4
             notes:	"Commissioned"
  
         
         }
     
 **Error Response:**



   **Code:** 401 UNAUTHORIZED <br />
   
  **Content:** `{ error : "Log in" }`
<!--
  OR

  * **Code:** 422 UNPROCESSABLE ENTRY <br />
  **Content:** `{ error : "Email Invalid" }`
-->
 **Sample Use:**

  `/services/Instruments/String/json`
  
  or
  
  `/services/Composers/American/xml`
  
   or 
   
   `/services/Instruments/json`
   
 **Notes:**

   Parameters are not required; if the query parameter does not return any results,
    the service will return an empty result set (JSON or XML). When parameters are
    omitted, the service will return  a result set
    equal to querying for all results of a certain class. 
    
   At this time, only XML and JSON are supported anguages for the result set translation. 
   A future iteration may include HTML. 
