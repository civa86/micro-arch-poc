#!/usr/bin/env bash

MAVEN_WRAPPER_BIN="mvnw"

function get_service_list () {
    echo -e "----------------------"
    echo -e "     Service List     "
    echo -e "----------------------"
    find . -name "$MAVEN_WRAPPER_BIN"|while read service; do
        service_folder=`dirname "$service"`
        service_fullname=`basename $service_folder`
        echo "> ${service_fullname/-service/}"
    done
    echo -e "\n"
}

if [ -z "$1" ]
    then
        echo -e "\nUsage: ./run-dev-env.sh <service_name>"
        get_service_list
        exit 1
fi


service_to_run=`find . -name "mvnw" | grep $1`

if [ -z "$service_to_run" ]
    then
        echo -e "\nService $1 not found!"
        get_service_list
        exit 1
fi

service_to_run_folder=`dirname "$service_to_run"`
cd $service_to_run_folder
./$MAVEN_WRAPPER_BIN spring-boot:run

