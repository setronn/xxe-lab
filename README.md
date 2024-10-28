```
docker build -t xxe_lab .
docker run -p 8090:8090 xxe_lab

curl localhost:8090/test -X POST -H "Content-Type: application/json" -d '{"message":"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><!DOCTYPE foo [<!ENTITY x \"3\"> ]><employee><name>John</name><role>Manager</role><id>&x;</id></employee>"}'
```
![Result](/result.png)
