# Kafka

Configure a Kafka cluster using Docker with the following parameters: 
* Number of brokers - 3 
* Number of partitions - 3 
* Replication factor - 2 
* observe the Kafka broker logs to see how leaders/replicas for every partition are assigned
Based on https://hub.docker.com/r/wurstmeister/kafka/

Run with:

`docker-compose -f docker-compose.yml up
docker-compose -f docker-compose.yml down -v`
