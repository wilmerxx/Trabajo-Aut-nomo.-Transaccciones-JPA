# Trabajo Autónomo. Transaccciones JPA
## Como parte del aprendizaje autónomo es necesario realizar la siguiente actividad:

Con Spring Boot, realizar un proyecto que contenga dos tablas:

- CABECERA_FACTURA.- con los campos: nombres, fecha, dirección, número de factura, total factura.
- DETALLE_FACTURA.- con los campos: nombreProducto, cantidad, precioUnitario, PrecioTotal.
Este diseño de BDD Maestro-Detalle trabaja en conjunto, eso quiere decir que no puede existir inconsistencias entre las dos estructuras, es así que se requiere implementar Transaccionalidad al realizar CRUD.

Realizar dos escenarios, (puede ser una inserción de factura) que sea registrado con éxito y otro con error en detalle para verificar el reverso de todos los datos.
Adicional, realizar dos escenarios de propagación de transacción. 

![image](https://github.com/wilmerxx/Trabajo-Aut-nomo.-Transaccciones-JPA/assets/66105231/d894a2ee-3cdd-4b91-a9e7-f45a240206ed)
