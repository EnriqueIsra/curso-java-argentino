INSERT INTO clientes (id, nombre, apellido, forma_pago, creado_en, editado_en) VALUES (1,'enrique','torres','credito',NULL,NULL),(2,'santiago','sanchez','debito',NULL,NULL),(4,'ale','sanchez','debito',NULL,NULL),(5,'sebas','torres','credito',NULL,NULL),(6,'santi','hernandez','credito',NULL,NULL),(9,'santiago','torres','paypal',NULL,NULL),(10,'enrique','mendoza','mercado pago',NULL,NULL),(11,'Lalo','Torres','webpay','2024-09-07 15:00:51','2024-09-07 15:01:57'),(12,'mia','perez','paypal plus','2024-09-07 15:33:45','2024-09-07 15:34:27');
insert into alumnos (id, nombre, apellido) values (1, 'Johana', 'Doe');
insert into alumnos (id, nombre, apellido) values (2, 'Pepe', 'Gon');

insert into cursos(id, titulo, profesor) values (1, 'Curso Spring', 'Andres');
insert into cursos(id, titulo, profesor) values (2, 'Curso EE9', 'Andres');

insert into direcciones(calle, numero) values ('vaticano', 123);
insert into direcciones(calle, numero) values ('color', 456);

insert into tbl_clientes_direcciones (id_cliente, id_direccion) values (1, 1);
insert into tbl_clientes_direcciones (id_cliente, id_direccion) values (1, 2);

insert into clientes_detalles (prime, puntos_acumulados, cliente_detalle_id) values (1, 8000, 1);

insert into tbl_alumnos_cursos (alumno_id, curso_id) values (1, 1);
insert into tbl_alumnos_cursos (alumno_id, curso_id) values (1, 2);

insert into facturas (descripcion, total, id_cliente) values ('oficina', 4000, 1)
insert into facturas (descripcion, total, id_cliente) values ('casa', 2000, 1)
insert into facturas (descripcion, total, id_cliente) values ('deporte', 3000, 1)
insert into facturas (descripcion, total, id_cliente) values ('tecnologia', 7000, 2)