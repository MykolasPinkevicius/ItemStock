# ItemStock

Spring Boot Item stock management system

CRUD methods for Create Read Update Delete

# To Access Services
Our server, or Localhost:8080 for this instance, following by "/items/" and service with parameters or request body

| Service | Parameters | return type |
| ------- | ---------- | ----------- |
| getItemById | Long id | Optional < Item > |
| getAll | ----- | List<Item> |
| getItemsWithValidDate | LocalDate date | List<Item> |
| save | Item item | void |
| update | Item item | void
| delete | Long id | void |
| getItemsWithProvidedAvailableQuantityAndType | String type, Long, quantity | List<Item> |


Additional methods for getting Items by Valid Date and getting items by type and lower quantity than

# Open API methods 
with parameters and information could be accessed here after running application
ItemStockApplication main method: 

http://localhost:8080/swagger-ui.html

# Database in memory H2 
Deletes each time you run the application. JPA Dialect H2. Access after starting ItemStockApplication main method with console being enabled at:

http://localhost:8080/h2-console
