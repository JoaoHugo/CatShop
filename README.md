# CatShop

Catshop microservices

## Run with Docker

The [Dockerfile](./Dockerfile) specifies a [multi-stage build](https://docs.docker.com/build/building/multi-stage/) image

### Docker compose

The easiest way to run the app is through [ Docker compose ](https://docs.docker.com/compose/)

The [docker-compose.yml](./docker-compose.yml) specifies 2 services:

| Container     | Description                                      | Port |
| ------------- | ------------------------------------------------ | ---- |
| catshop-micro | The Spring app created from the Dockerfile image | 8090 |
| mysql         | The MySQL container for the app                  | 3306 |

A `.env` file is used to specific the environment variables for the app (use `.env.example` as referece)

```bash
cp .env.example .env
```

If any of the default ports are already in use on localhost, the run will fail, and the values should be changed in the `.env` file to use available ports

- **Run the app through docker-compose:**

```bash
docker compose up -d
```

- **Shutdown the app, and tear down the created containers:**

```bash
docker compose down
```

The docker-compose specifies a [volume](https://docs.docker.com/storage/volumes/) to persist data from the MySQL container

To erase the data from this volume (or if any issues arise from the created MySQL configuration):

```bash
docker volume rm catshop-micro-mysql:
```

### Run without Docker Compose

```bash
# run MySQL Container
docker run -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123456 -e MYSQL_DATABASE=catshop mysql:latest

# build app image named 'catshop-micro'
docker build -t catshop-micro .

# run the app
docker run -p 8090:8090 catshop-micro
```
