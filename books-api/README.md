# BookAPI
BookAPI exposes operations on REST over HTTP. Service description can be found in file [BookAPI YAML description](src/main/resources/api.yaml).

### Resources
##### Get books
* Path `/book`
* Method `GET`
* Url example `http://localhost:8080/book`
* Response example
```
[
    {
        "author": "John Doe",
        "title": "Fabulous Journey",
        "published": "2019-11-30",
        "notes": "Interesting book"
    },
    {
        "author": "Jane Doe",
        "title": "Back Home",
        "published": "2019-11-30",
        "notes": "Home sweet home"
    }
]
```

##### Get book by id
* Path `/book/{id}`
* Method `GET`
* Url example `http://localhost:8080/book/{id}`
* Response example
```
{
	"author": "John Doe",
	"title": "Fabulous Journey",
	"published": "2019-11-30",
	"notes": "Interesting book"
}
```

##### Create book
* Path `/book`
* Method `POST`
* Url example `http://localhost:8080/book`
* Request example 
```
{
	"author": "John Doe",
	"title": "Fabulous Journey",
	"published": "2019-11-30",
	"notes": "Interesting book"
}
```

### Prerequisites
* Java8+
* Maven3

### Maven commands
* Clean `mvn clean`
* Compile `mvn clean compile`
* Build without tests `mvn clean install -DskipTests`
* Build and run tests `mvn clean install`
* Run SpringBoot application `mvn spring-boot:run`
