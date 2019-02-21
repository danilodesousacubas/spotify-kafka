#### build
mvn clean package

#### install and run 
mvn clean install spring-boot:run

#### build docker images
mvn dockerfile:build

#### swagger api docs
http://localhost:9000/v2/api-docs

#### compose up
${project}:dev-stack/docker-compose up -d

