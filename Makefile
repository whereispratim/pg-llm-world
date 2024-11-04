
up: dev-env dev-run             ## Startup / Spinup Docker Compose
down: docker-stop               ## Stop Docker
destroy: docker-teardown clean  ## Teardown (removes volumes, tmp files, etc...)

dev-env: ## Bootstrap Environment (with a Docker-Compose help).
	#docker-compose up -d --build mongodb		#Use Mongodb Atlas URL in application config
	#docker-compose up -d --build zookeeper
	#docker-compose up -d --build kafka
	#docker-compose up -d --build redis

dev-run: dev-env
	./gradlew bootRun

docker-stop:
	docker-compose down

docker-teardown:
	docker-compose down --remove-orphans -v

