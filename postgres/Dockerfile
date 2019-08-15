FROM postgres:11.1
COPY 00_schema.sql /docker-entrypoint-initdb.d/
COPY 01_data.sql /docker-entrypoint-initdb.d/