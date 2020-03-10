# <img src="img/logo.png" alt="drawing" width="80"/> Exude API <sup style="color:red">beta</sup>

!!! Version ""
    The latest version is: 1.0.0

    Open Source The Apache License.

Exude API is an Open Source project, It is used for the primary ways for filtering the stopping, stemming words from the text data. This API is in beta level of development need to work and test more.


## Features

* Filter stopping words from given text/file/link.
* Filter stemming words from given text/file/link.
* Get swear words from given text/file/link

## Stopping and Porter stemming algorithm

Stop words are words that are filtered out before or after processing of natural language data, Though "stop words" usually refers to the most common words in a language i.e this, that, what, where...etc 

The Porter stemming algorithm (or 'Porter stemmer') is a process for removing the commoner morphological and inflexional endings from words in English. 
Its main use is as part of a term normalization process that is usually done when setting up Information Retrieval systems.

Terms with a common stem will usually have similar meanings, for example:

```
REPORT
REPROTING
REPORTS
REPORTED

....
CONNECT
CONNECTION
CONNECTED
CONNECTING
CONNECTIONs

```

By removing the various suffixs -ED,-ING,-ION,IONS to leave the single word.


## How Exude API library works

1. Filter the duplicate words from the input data/file.
2. Filter the stopping words from step1 filtered data.
3. Filter the stemmer/swear words from step2 filtered data using the Porter algorithm which is used for suffix stripping.

exude process sequence flow:
![Exude API Process Flow](img/exude_filtering_flow.png "Title")

## Demo

1. POSTMAN collection json file
   
    Use postman collection to test the API, its currently using the heroku endpoints.
    <a href="https://raw.githubusercontent.com/uttesh/exude-api/gh-pages/exude-api.postman_collection.json" target="_blank">Download Exude API Postman collection!</a>

!!! Heroku 
    Heroku exude API link is not recommended for the production use, Use docker for the production or continues testing on development environment.
    
1.  Using the Docker. <a href="https://hub.docker.com/r/uttesh/exude-api" target="_blank">Docker image link</a>
   
    ```
    docker pull uttesh/exude-api
    ```

2. Sample video  ![](exude_api.webm)
<iframe width="560" height="315" src="https://www.youtube.com/embed/KDZ4BEfoGo4" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>

4. Simple web demo link to sample test Exude API ONLY!!! (This web link is not recommended for prod, Its demo version). <a href="https://exude.herokuapp.com/" target="_blank">Exude API Demo!</a>
   
   

