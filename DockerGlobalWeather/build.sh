#!/bin/bash
docker build --tag="mule-container" .

docker run --network container:mockService -it --name weatherService mule-container