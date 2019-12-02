# Books example

Solution contains a Books API component exposing a REST service and a Books UI component connecting to the REST service.

# Books API
REST contract is declared in api.yaml file, then generated using Swagger2 into a REST service running within a Spring Boot server.

# Books UI
Generated using Angluar CLI, UI component is implemented in Angular6. It uses @ngrx/store and @ngrx/effects for state management. API calls to the REST service are performed using HttpClient.
