# Smaller Gold Medal - SpringBoot Project


## Overview

This is a smaller scaled project of Gold Medal Project to personally test and explore on SpringBoot. 

This is an Olympic metrics reporting web application called Gold Medal Metrics. Gold Medal Metrics allows users to:
- View countries in a list with their population, GDP, and number of Olympic gold medals.
- Sort the list of countries by any of these attributes, as well as alphabetically by name.
- View a detailed description of a country, with statistics on their Olympic wins.
- View a list of every Olympic win a country has with the year, season, winner name, city, and event.
- Sort the list of Olympic wins by any of these attributes.


## Requirements

- Maven 3
- Java 11


## How to Use Application

### To start application

For Mac,
`./mvnw spring-boot:run`

For Window,
`mvnw spring-boot:run`


### With web application


**Home Page**

`localhost:8080/`
![Home]<img src= "https://github.com/sungbin-kang/SpringBoot-Smaller_Gold_Medal_Metrics/blob/master/resource/img/Home.png" width="250" />


**List of Countries**

`localhost:8080/countries`
![countries](https://github.com/sungbin-kang/SpringBoot-Smaller_Gold_Medal_Metrics/blob/master/resource/img/countries.png)

Additionally, user can specify ascending order by with values "y" or "n", and sorting values with "year", "city", "season", "name", "country", "gender", "sport", "discipline" or "event". For example: 
`localhost:8080/countries?ascending=n&sortby=population`
![countries?ascending=n&sortby=population](https://github.com/sungbin-kang/SpringBoot-Smaller_Gold_Medal_Metrics/blob/master/resource/img/countries%3Fascending%3Dn%26sortby%3Dpopulation.png)


**Specific Country Details**

User can type specific country to see the details.
`localhost:8080/{countryName}`

For example:
`localhost:8080/Australia`
![Australia](https://github.com/sungbin-kang/SpringBoot-Smaller_Gold_Medal_Metrics/blob/master/resource/img/Australia.png)


**Specific Country Gold Medal Lists**

`localhost:8080/{countryName}/medals`
For example:
`localhost:8080/Australia/medals`
![Australia/medals](https://github.com/sungbin-kang/SpringBoot-Smaller_Gold_Medal_Metrics/blob/master/resource/img/Australia:medals.png)

Additionally, user can specify 
`localhost:8080/Australia/medals?ascending=n&sortby=event`
![Australia/medals?ascending=n&sortby=event](https://github.com/sungbin-kang/SpringBoot-Smaller_Gold_Medal_Metrics/blob/master/resource/img/Australia:medals%3Fascending%3Dn%26sortby%3Devent.png)


### With curl




## Implementation Details

Models and Attributes:

- `Country`
    - id
    - name
    - code
    - gdp
    - population

- `GoldMedal`
    - year
    - city
    - season
    - name
    - country
    - gender
    - sport
    - discipline
    - event
