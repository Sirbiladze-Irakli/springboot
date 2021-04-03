#!/usr/bin/env/ bash

mvn clean package

echo 'Copy files...'

scp -i ~/.ssh/id_rsa \
	target/springboot-0.0.1-SNAPSHOT.jar \
	root@194.58.90.165:/root/

echo 'Restart server...'

ssh -i ~/.ssh/id_rsa root@194.58.90.165 << EOF

pgerp java | xargs kill -9
nohup java -jar springboot-0.0.1-SNAPSHOT.jar > log.txt &

EOF

echo 'Done'
