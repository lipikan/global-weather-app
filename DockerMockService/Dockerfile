# Dockerizing Mule EE

FROM                    java:8u91-jdk
ARG MULE_ESB_VERSION
ARG MULE_AGENT_VERSION
MAINTAINER              Lipika <linaik@deloitte.co.za>

LABEL version="ESB 3.8.0"
LABEL description="Mule ESB Standalone 3.8.0."
ENV MULE_ESB_VERSION="3.8.0"

# Install Mule EE
COPY                    ./mule-ee-distribution-standalone-${MULE_ESB_VERSION}.tar.gz /opt/
WORKDIR                 /opt
RUN                     tar -zxf mule-ee-distribution-standalone-${MULE_ESB_VERSION}.tar.gz
RUN                     ln -s mule-enterprise-standalone-${MULE_ESB_VERSION}/ mule


# Run AMC Setup
# WORKDIR                 /opt/mule-enterprise-standalone-3.7.2/bin/
# RUN                     ./amc_setup -A http://52.74.225.250:8080/hybrid/api/v1 -W "wss://52.74.225.250:8443/mule" -F https://52.74.225.250/apiplatform -C https://52.74.225.250/accounts -H 61aa89ba-611a-449a-af83-f13921cee831---2 MULE-$HOSTNAME

# Configure external access:
# HTTP Service Port
# Expose the necessary port ranges as required by the Mule Apps
EXPOSE 8081-8082

# Expose the mock service port
EXPOSE 63081

# Mule remote debugger
EXPOSE  5000

# Mule JMX port (must match Mule config file)
EXPOSE  1098

# Mule MMC agent port
EXPOSE  7777


# install Mule app
COPY mock-weather-app.zip /opt/mule/apps/


# Environment and execution:

ENV             MULE_BASE /opt/mule
WORKDIR         /opt/mule
CMD             /opt/mule/bin/mule
