# Getting Started Elasticsearch

This guide walks you through the process of creating a "hello world" Elasticsearch web service with Spring.

## Install and launch [Elasticsearch](https://www.elastic.co/guide/en/elasticsearch/reference/current/_installation.html)

Before you install the Elasticsearch, please check your Java version first by running (and then install/upgrade accordingly if needed):

> java -version
> 
> echo $JAVA_HOME

Elasticsearch requires at least Java 8. You can download Java 8 from the [Oracle's website](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html).

This guide is work on Linux or Mac OS X system. You download the Elasticsearch with tar as follows:

> curl -L -O https://artifacts.elastic.co/downloads/elasticsearch/elasticsearch-6.4.0.tar.gz

Then extract it as follows:

> tar -xvf elasticsearch-6.4.0.tar.gz

It will then create a bunch of files and folders in your current directory. You then go into the bin directory as follows:

> cd elasticsearch-6.4.0/bin

And now you are ready to start node and single cluster:

> ./elasticsearch

The elasticsearch http server is started on port `9200`. You can run the command below with `curl` into a terminal.

> curl -X GET "localhost:9200/_cat/health?v"

And the response:

| epoch      | timestamp | cluster       | status | node.total | node.data | shards | pri | relo | init | unassign | pending_tasks | max_task\_wait_time | active_shards\_percent |
| ---------- | --------- | ------------- | ------ | ---------- | --------- | ------ | --- | ---- | ---- | -------- | ------------- | ------------------- | ---------------------- |
| 1475247709 | 17:01\:49 | elasticsearch | green  | 1          | 1         | 0      | 0   | 0    | 0    | 0        | 0             | -                   | 100%                   |

Looking for more detail, you can find on [Elasticsearch website](https://www.elastic.co/guide/en/elasticsearch/reference/current/getting-started.html).

## Run the project

This project is based on Gradle. So you can run the application from the command line with Gradle. Or you can build a single executable JAR file that contains all the necessary dependencise, classes, and resources, and run that.

Using Gradle, you can run the application using `./gradlew bootRun`. Or you can build the JAR file using `./gradlew build`. Then you can run the jar file:

> java -jar build/libs/gs-spring-elasticsearch-0.1.0.jar

## Test the application

> Note: Assume you already install mongo, and hava news data in it.

visit `http://localhost:8081/api/v1.0/news/list`, where you can see a news list.

visit `http://localhost:8081/api/v1.0/news/detail?id=***`, where you can see a news detail. when you visit the url, it meanwhile inserts a news record in Elasticsearch storage.

So, visit `http://localhost:8081/api/v1.0/es/news/all`, where you can see a news list in Elasticsearch.

You can find more REATful API in this project.
