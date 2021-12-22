# Movie Store

## Before Used
### Step-1: SQL Dummies
- Gunakan dummy sql yang sudah disediakan di direktory docs.

### Step-2: Postman file 
- Import files postman

### Step-3: 
- Lakukan Sign Up.
- Kemudian Sign In agar mendapatkan TOKEN JWT.
- Gunakan token JWT di HTTP Header untuk mengakses API.


## Docker
Jika menggunakan docker untuk menjalankan MySQL
```
// MySQL
docker pull mysql 
docker run --name mysqlku -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=rahasia mysql:latest
docker start mysqlku
docker exec -it mysqlku bash
mysql -uroot -prahasia
CREATE DATABASE movie_store_task;

// Phpmyadmin
docker pull phpmyadmin/phpmyadmin:latest
docker run --name phpmyadmin-mysqlku -d --link mysqlku:db -p 8081:80 phpmyadmin/phpmyadmin
docker start phpmyadmin-mysqlku

// buka browser untuk membuka phpmyadmin
- http://localhost:8081/
- password: rahasia
```