CREATE DATABASE IF NOT EXISTS task_manager;

USE task_manager;

CREATE TABLE IF NOT EXISTS tasks(
	id INT NOT NULL auto_increment,
    description VARCHAR (30),
    status VARCHAR(15) NOT NULL,
    PRIMARY KEY (id)
);
/*;

INSERT INTO tasks (description, status) VALUES 
	("Tarea num. 1", "pendiente"),
	("Tarea num. 2", "en progreso"),
    ("Tarea num. 3", "pendiente"),
    ("Tarea num. 4", "completada");
*/
SELECT * from tasks