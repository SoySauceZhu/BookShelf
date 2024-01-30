#!/bin/bash

# Loop to run the command 50 times
for i in {1..50}
do
    curl -X POST http://localhost:8080/books/add -d id=$i -d title="book"
    echo "Request $i completed"
done
