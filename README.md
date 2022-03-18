This project is to test whether when we inject two `ManagedExecutor`s, they point to the same object or if new ManagedExecutor objects are created.

To build:
```
mvn clean install
```

To run:
```
mvn quarkus:dev
```

Access:
```
http://localhost:8080/hello
```

If it says 'true', the 2 ManagedExecutors point to the same object. If 'false',
new objects are created for both of them.

The code to verify if they are the same is:
```
executorFirst.equals(executorSecond)
```
