CREATE DATABASE orgdb;
CREATE USER orgdb WITH PASSWORD 'orgdb';
GRANT ALL PRIVILEGES ON DATABASE orgdb TO orgdb;
\connect orgdb

CREATE EXTENSION IF NOT EXISTS LTREE WITH SCHEMA public;

-- Create table
CREATE TABLE IF NOT EXISTS organization_nodes(
  node_id serial PRIMARY KEY,
  node_name VARCHAR NOT NULL UNIQUE,
  height integer NOT NULL,
  root_node BOOLEAN NOT NULL,
  path ltree
);

-- Create index
CREATE INDEX IF NOT EXISTS node_path_idx ON organization_nodes USING gist (path);
