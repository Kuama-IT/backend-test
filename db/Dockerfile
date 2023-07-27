FROM postgres:13.11-bullseye

LABEL author="Mattia Gallinaro"
LABEL description="Kuama's technical test - Drinks DB"
LABEL version="1.0.0"

COPY db/*.sql /docker-entrypoint-initdb.d/
