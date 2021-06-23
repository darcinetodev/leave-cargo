#!/bin/bash
docker-compose up -d postgres

while true; do
  docker ps | grep 5432 > /dev/null
  if [ $? -eq 0 ]
  then
    echo "postgres is up and running!"
    break
  fi
  echo "waiting for postgres..."
  sleep 1
done

#after postgres is up wait 3 seconds to ensure connection
sleep 3
docker-compose run liquibase