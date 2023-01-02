# Quiz Transaction Service

A service dedicated to log all user transactions for both players and admins.


### Helpful Commands

#### GCloud:

```
gcloud builds submit --tag gcr.io/endless-comfort-334004/quiz-log-rest-api
```

#### Docker:

```
docker build -t quizroulette/quiz-transaction-service:v1.0.0 .
docker push quizroulette/quiz-transaction-service:v1.0.0
```

#### K8:

```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: quiz-transaction-deployment
  labels:
    app: quiz-transaction
spec:
  replicas: 3
  selector:
    matchLabels:
      app: quiz-transaction
  template:
    metadata:
      labels:
        app: quiz-transaction
    spec:
      containers:
      - name: quiz-transaction
        image: quizroulette/quiz-transaction-service:v1.0.0
        ports:
        - containerPort: 8080
```

Expose:

```sh
kubectl expose deployment quiz-transaction-deployment --type=LoadBalancer --name=quiz-roulette-quiz-transaction-service
```


### References:

- https://msayag.github.io/WebFlux/