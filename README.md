# simple-kafka-demo

# create topic

$ bin/kafka-topics.sh --create --topic people-events --bootstrap-server localhost:9092

# insert people into topic

$ bin/kafka-console-producer.sh --topic people-events --bootstrap-server localhost:9092
{ "uniqueIdentificationNumber":"62daa433-0039-4929-8508-c63ec056aea7", "firstName": "Hristo", "lastName": "Penchev", "age": "35" }
{ "uniqueIdentificationNumber":"6b8e5fa6-b92d-42c8-ba94-2358b93ee269", "firstName": "John", "lastName": "Smith", "age": "47" }
{ "uniqueIdentificationNumber":"72b1c285-2e3b-4715-8562-6c7051ab6417", "firstName": "Ivan", "lastName": "Petrov", "age": "22" }

# Swagger:
http://localhost:8080/swagger-ui/