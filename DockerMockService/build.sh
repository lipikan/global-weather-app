#!/bin/bash

docker build --tag="mule-container" .

docker run -it -p 8081:8081 --name mockService mule-container