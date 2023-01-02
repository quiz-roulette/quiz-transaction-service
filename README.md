# Quiz Transaction Service

A service dedicated to log all user transactions for both players and admins.


### Helpful Commands

#### GCloud:

```
gcloud builds submit --tag gcr.io/endless-comfort-334004/quiz-log-rest-api
```

#### Docker:

```
eval $(minikube docker-env)
docker build -t quiz-log-rest-api .
docker build -t quiz-roulette/quiz-log-event-service .
```


### References:

- https://msayag.github.io/WebFlux/