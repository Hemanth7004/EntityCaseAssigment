Project uses H2DB for processing the data.

1. 1st API from the sheet is 
POST: http://localhost:8080/entities
Body: 
[
    {
    "name" : "Entity1",
    "address" : "bangalore",
    "email" : "entity1@gmail.com",
    "companyName" : "Company2",
    "is_company": false,
    "entityToCases": [
        {
            "caseNumber": "casse2"
        },
        {
            "caseNumber": "casse1"
        }
    ]
}
]
This above api add data to the entity table along with the relation table i.e, entity_to_case table.


2. 2nd API 
Post: http://localhost:8080/cases/{caseNumber}/entities
Body: 
{
    "caseNumber": "case1"
}
This API allows user to edit caseNumber from entity_to_case table.

3. 3rd API
GET: http://localhost:8080/cases/{caseNumber}/entities

This API find number of entity assigned for the perticular case.


Optional API:
4. 4th API
POST: http://localhost:8080/cases
Body:
{
    "caseNumber": "case1"
}

This Api allows user to add cases for case table
