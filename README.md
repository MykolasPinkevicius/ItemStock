# ItemStock

Spring Boot Item stock management system

CRUD methods for Create Read Update Delete

# To Access Services
Our server, or Localhost:8080 for this instance, following by "/items/" and service with parameters or request body
http://localhost:8080/items/service?parameters

| Service | Parameters | return type |
| ------- | ---------- | ----------- |
| getItemById | Long id | Optional < Item > |
| getAllItems | ----- | List<Item> |
| getItemsWithValidDate | LocalDate date ( pattern="yyyy-MM-dd" ) | List<Item> |
| addItem | Item item | void |
| updateItem | Item item | void |
| deleteItem | Long id | void |
| getItemsWithProvidedAvailableQuantityAndType | String type, Long, quantity | List<Item> |

# Item object
| Item Variable | Variable Type | Additional Info |
| ------------- | ------------- | --------------- |
| id | Long | Primary Key |
| type | String | Product type or name |
| quantity | Long | --- |
| created | LocalDate | Date when products crated |
| validUntil | LocalDate | Products valid until |

Additional methods for getting Items by Valid Date and getting items by type and lower quantity than

# Open API methods 
with parameters and information could be accessed here after running application
ItemStockApplication main method: 

http://localhost:8080/swagger-ui.html

# Database in memory H2 
Deletes each time you run the application. JPA Dialect H2. Access after starting ItemStockApplication main method with console being enabled at:

http://localhost:8080/h2-console
