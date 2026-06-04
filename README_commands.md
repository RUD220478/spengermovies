# Commands used

Run docker and pull the image
```
docker run --name postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres
```
Enter the docker container
```
docker exec -it postgres psql -U postgres
```
Inside the container execute
```
CREATE DATABASE spengermovies;
CREATE USER spengermovies WITH PASSWORD 'spengermovies';
GRANT ALL PRIVILEGES ON DATABASE spengermovies TO spengermovies;
\q
```
Run these commands and build
```
./mvnw clean package -U
./mvnw spring-boot:run 
```
Use clean if the project isn't running properly.
```
./mvnw clean package
./mvnw test
```