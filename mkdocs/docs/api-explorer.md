# Exude API 

!!! info ""
    Version: 1.0.0

    <a href="https://exude-api.herokuapp.com/swagger-ui/index.html?url=/v3/api-docs" target="_blank">Open API Swagger Spec</a>

    Terms of service <a href="http://uttesh.com/apis/terms/ " target="_blank">Terms</a>


### /exude/stopping/data

#### POST
##### Summary

Filter the stopping words from the provided input data or links

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| type | path | provide the type of filtering required stopping | Yes | string |

##### Request Body

!!! Exude Request Bean ""
      Pass the ExudeRequestBean Object, pass either text data or data links

      ```
      {
        "data": "string",
        "links": [
          "string"
        ]
      }
      ```

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | Exude response |

##### Samples
!!! sample 
    RequestBody:
    ```
    {
    "links":[
      "https://en.wikipedia.org/wiki/Rama"
      ]
    }
    ```
    
    ResponseBody:
    ```
    {
      "data": {
          "https://en.wikipedia.org/wiki/Rama": "ramakien 516832 half tdr upload latina idol sivananda  kathakali ....
      }
    } 
    ```

### /exude/swear/data

#### POST
##### Summary

Filter the swear words from the provided input data or links

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| type | path | provide the type of filtering required swear | Yes | string |

##### Request Body

Pass the ExudeRequestBean Object, pass either text data or data links

```
{
  "data": "string",
  "links": [
    "string"
  ]
}
```

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | Exude response |


### /exude/stopping/file

#### POST
##### Summary

Filter the stopping words from the provided input file

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| type | path | provide the type of filtering required stopping | Yes | string |

##### Request Body

Pass the file binary string.

```
{
 "file":string($binary)
}
```

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | Exude response |

### /exude/swear/file

#### POST
##### Summary

Filter the swear words from the provided input file

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| type | path | provide the type of filtering required swear | Yes | string |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | Exude response |
