# Java Flat File

## Installation
```
echo "get all the stuff"
apt-add-repository ppa:webupd8team/java
sudo add-apt-repository ppa:andrei-pozolotin/maven3
apt-get update
apt-get install oracle-java8-installer
apt-get install ant
apt-get install maven3
apt-get install mysql-server
apt-get install mysql-client
apt-get install libmysql-java
git clone https://github.com/fangyidong/json-simple
git clone https://github.com/wnameless/json-flattener

echo "create all the userz"
mysql -u root -p -e "CREATE DATABASE optimum" 
mysql -u root -p -e "CREATE USER 'default'@'localhost' IDENTIFIED BY 'vanilla'" mysql -u root -p -e "GRANT ALL PRIVILEGES ON optimum.* TO default@localhost IDENTIFIED BY 'vanilla'"
mysql -u root -p -e "FLUSH PRIVILEGES"

echo "install all the thingz"
cd json-simple
ant
cd ..
cd json-flattener
mvn install
cd ..
#javac -cp ".:/home/alex/Code/flatfile/json-simple/target/json-simple-1.1.1.jar:/home/alex/Code/flatfile/json-flattener/json-flattener-0.2.3-SNAPSHOT.jar" DBFlatfile.java

export CLASSPATH=$CLASSPATH.:/home/alex/Code/flatfile/json-simple/target/json-simple-1.1.1.jar:/home/alex/Code/flatfile/json-flattener/json-flattener-0.2.3-SNAPSHOT.ja:/usr/share/java/mysql-connector-java-5.1.28.jar


## Use

