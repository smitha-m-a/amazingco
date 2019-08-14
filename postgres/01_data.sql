-- Insert values
\connect orgdb

INSERT INTO organization_nodes (node_name, height, root_node, path) values ('Top', 0, TRUE, 'Top');
INSERT INTO organization_nodes (node_name, height, root_node, path) values ('Science', 1, FALSE, 'Top.Science');
INSERT INTO organization_nodes (node_name, height, root_node, path) values ('Astronomy', 2, FALSE, 'Top.Science.Astronomy');
INSERT INTO organization_nodes (node_name, height, root_node, path) values ('Astrophysics', 3, FALSE, 'Top.Science.Astronomy.Astrophysics');
INSERT INTO organization_nodes (node_name, height, root_node, path) values ('Cosmology', 3, FALSE, 'Top.Science.Astronomy.Cosmology');
INSERT INTO organization_nodes (node_name, height, root_node, path) values ('Hobbies', 1, FALSE , 'Top.Hobbies');
INSERT INTO organization_nodes (node_name, height, root_node, path) values ('Amateurs_hockey', 2, FALSE , 'Top.Hobbies.Amateurs_hockey');