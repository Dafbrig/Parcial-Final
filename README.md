# Parcial Final
 
Las bibliotecas son entidades cada vez más complejas que requieren de la aplicación de sistemas de trabajo que permitan garantizar por un lado la calidad de todos sus servicios, y por otro la permanente innovación y generación de recursos adaptados. Es aquí donde el software para bibliotecas se convierte en una herramienta fundamental para la consecución de esos objetivos. Una institución de educación superior de la ciudad de Medellín, requiere de un software que permita gestionar todo su material bibliográfico El software debe permitir:

1. Gestionar categorías 
2. Gestionar libros 
3. Gestionar usuarios 
4. Gestionar préstamos de libros 
5. Gestionar devoluciones de libros 
6. Mostrar informes

Explicación de cada módulo: 
1. GESTIONAR CATEGORIAS: la biblioteca ordena los libros de acuerdo a la categoría que pertenece. Estas categorías son equivalentes a los temas de las diferentes asignaturas impartidas en la universidad. Ejemplo (calculo vectorial, base de datos, programación, algoritmia entre otras). Se debe permitir todo el manejo de las categorías (ingresar, modificar, consultar, eliminar) 

3. GESTIONAR LIBROS: debe permitir el manejo de todos los libros (ingresar, modificar, consultar y eliminar) Validaciones Para un libro nuevo se debe ingresar el código ISBN, titulo, autor, fecha de ingreso (obtenido del sistema), número de ejemplares y la categoría Para modificar: se puede modificar todos los datos excepto el código ISBN Para consultar: se puede consultar por código ISBN, titulo Para eliminar se debe validar que el libro no este prestado 3. GESTIONAR USUARIOS: son todas las personas que usan el sistema entre estudiantes y administrador (ingreso, modificación, consulta, eliminación) Para estudiantes se debe ingresar el carnet, nombre, apellido, correo electrónico, dirección y teléfono Se puede modificar todos los campos excepto el carnet Se puede consultar por carnet, nombre o apellido Se puede eliminar si el usuario no tiene prestamos pendiente, ni deudas 

4. PRESTAMO DE LIBROS: se puede realizar un préstamo a un usuario siempre y cuando exista ejemplares disponibles Para el préstamo se debe registrar el libro a prestar, el usuario, fecha del préstamo(sistema) y la fecha de devolución (la fecha de devolución es una fecha calculada y corresponde a los 5 días posteriores a la fecha del préstamo.). Al momento del préstamo de sistema debe restar a la disponibilidad de ejemplares disponibles 

5. DEVOLUCION DE LIBROS. El sistema debe verificar que el libro este prestado y que la devolución esta entre las fechas permitidas. De lo contrario se le cobrara al usuario 1000 pesos por cada día posterior a la fecha límite de devolución. Al momento de la devolución sistema debe sumar a la disponibilidad de ejemplares disponibles 

6. MOSTRAR INFORMES: Se debe mostrar los siguientes informes a) Listado de libros prestados (todos los campos) b) Listado de libros (todos los campos) c) Listado de libros prestados por un usuario en particular d) Listados de libros devueltos en un rango de fechas e) Listado de morosos
