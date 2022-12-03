# criteriabuilder-demo
sample application to describe criteriabuilder JPA in spring application - Injecting Entity Manager in the Repository class

Run the below url in postman
Method: Post 
URL: http://localhost:8082/api/student/listAll
Body: (pass Std or name as values)
{    
 "std":10
}

Response: Students of 10th std
[
    {
        "id": 1,
        "name": "Arun",
        "std": 10
    },
    {
        "id": 5,
        "name": "Rose",
        "std": 10
    }
]


