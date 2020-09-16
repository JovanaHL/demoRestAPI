# demoRestAPI
Practice with creating RESTful web services with Java JAX-RS using Jersey 

# Overview
Create REST API with Java JAX-RS using Jersey. This API is for random Character data that can be fetched from a connected database over HTTP and returns XML or JSON response.

Character data included in database:
 
    Character ID
 
    Character Name
 
    Character Type
 
    Character Ability
 

The REST API uses CRUD methods below:

    GET - get data using query
 
    POST - add data using query
 
    PUT - update existing data using query
 
    DELETE - delete existing data using query
 
 All methods are used with MySQL database connection using the MySQL Java connector.
 
 # Example
 
 An example query to get all characters:
 
    http://localhost:8080/demoRestAPI/webresources/characters
    
 Following JSON response:
 
        {
        "character": [
            {
                "ability": "Battle",
                "id": "1",
                "name": "2B",
                "type": "Android"
            },
            {
                "ability": "Scanner",
                "id": "2",
                "name": "9S",
                "type": "Android"
            }
        ]
    }
    
    
  Following XML response:
  
          <characters>
        <character>
            <ability>Battle</ability>
            <id>1</id>
            <name>2B</name>
            <type>Android</type>
        </character>
        <character>
            <ability>Scanner</ability>
            <id>2</id>
            <name>9S</name>
            <type>Android</type>
        </character>
    </characters>
