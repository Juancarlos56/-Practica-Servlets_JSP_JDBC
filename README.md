### TÍTULO PRÁCTICA: 
Desarrollo de una aplicación JEE basado en Servlets, JSP y JDBC para el intercambio de datos en un modelo de tres capas aplicando los patrones diseño de software MVC y DAO.

### Desarrollar una aplicación con tecnología JEE para gestionar requerimientos de compra en la web. Gestionar requerimientos de compras de varias empresas

- Un usuario pertenece a una sola empresa. Y una empresa cuenta con muchos productos, los cuales están organizados en diferentes categorías. Sin embargo, un producto puede pertenecer a una sola categoría

- La finalidad de la aplicación es que el usuario pueda ingresar a través de un inicio de sesión y pueda registrar un requerimiento para la compra de varios productos. Además, que pueda ver el estado de la compra.

### Los requerimientos funcionales del sistema son:
- La aplicación deberá manejar dos roles “Usuario” y “Administrador”
- Un “usuario” y “administrador” puede iniciar sesión usando su correo y contraseña.
- Una vez iniciado sesión el “usuario” podrá: 
•	Registrar, modificar, eliminar, buscar y listar sus requerimientos de compra

- Una vez iniciado sesión el “administrador” podrá:
•	Registrar, modificar, eliminar, buscar y listar los productos de la empresa a la que pertenece 
•	Listar todos los requerimientos de compra de los “usuarios” de la empresa a la que pertenece 
•	Aprobar o Rechazar los requerimientos de compra de los “usuarios” de la empresa a la que pertenece

- Se pide manejar sesiones y filtros para que existe seguridad en el sistema
- Debe existir una parte pública y una privada
- La parte pública será una página index.html a través de la cual podrán acceder al sistema.
- Debe mostrar un catálogo de los productos filtrados por cada empresa.
- El sistema debe aplicar los patrones de diseño de software MVC y DAO, en donde, el modelo será clases POJOs de Java, la vista será JSP + JSTL y los controladores serán a través de DAOs y Servlets.

### Desarrollo de la aplicación con tecnología JEE.

![1](https://user-images.githubusercontent.com/51839660/101501115-55c9aa00-393d-11eb-9d28-41c9f4d5f752.JPG) 
![2](https://user-images.githubusercontent.com/51839660/101501138-5cf0b800-393d-11eb-9996-466ee80077d8.JPG)


A fin de obtener una organización adecuada para la aplicación en el paquete src se crearon 4 paquetes. En el paquete DAO y mysql.jdbc en la cual se controla la persistencia de datos. En el paquete modelo se encuentran los POJOs, que son: administrador, categoría, empresa, pedido, persona, producto y usuario. Finalmente, en el paquete Servlets se encuentras los servlets para las funciones CRUD de la aplicación web, que se especificaron en los requerimientos.  

Mientras en la carpeta Web Content se crearon carpetas público y privado a finalidad de una mejor organización de grupo. En la carpeta publica tenemos la página de index, login de usuario y mostrar productos sin necesidad de que el usuario haya ingresado. La carpeta privada tiene dos carpetas la de administrador que tiene las funcionalidades de CRUD a productos y además aprobar los requerimientos de compra del usuario normal. El usuario administrador tiene las paginas para realizar el CRUD hacia los pedidos que realice. 
Las imágenes, estilos y archivos js también fueron creados en diferentes carpetas. 


### 1. Gestionar requerimientos de compras de varias empresas
En nuestra aplicación web con el nombre de “Tu pídelo”, trabaja con tres empresas, Pizza Hut, Tía, y Floristería katy Flor. 
- Esta en la pagina de index que presenta la aplicación web Tu pídelo. 

![3](https://user-images.githubusercontent.com/51839660/101501173-6a0da700-393d-11eb-9099-d3fbf35c6025.JPG)

- Al seleccionar una de las empresas que se presentan en el index, se desplega una lista de los productos disponibles de esa empresa. Como ejemplo se selecciona los productos de la empresa Pizza Hut. 

![4](https://user-images.githubusercontent.com/51839660/101501194-73970f00-393d-11eb-8c49-6d5ca77e002a.JPG)


-La finalidad de la aplicación es que el usuario pueda ingresar a través de un inicio de sesión 
-Registrar un requerimiento para la compra de varios productos. Además, que pueda ver el estado de la compra.

### 2. Un “usuario” y “administrador” puede iniciar sesión usando su correo y contraseña.
- En la aplicación Tu pídelo, se manejan dos tipos de usuarios, un usuario normal que realiza los pedidos hacia la empresa dependiendo de los productos disponibles que tenga la empresa. Y el administrador que puede crear nuevos productos y aceptar los requisitos de compra de los usuarios normales. 
La pagina para login de Tu pídelo es la siguiente. 
- El usuario normal de prueba será usu@com con la contraseña de 123, que pertenece a la empresa de Pizza Hut
![5](https://user-images.githubusercontent.com/51839660/101501230-801b6780-393d-11eb-93af-ed0ddd7a02ea.JPG)


### 3. Una vez iniciado sesión el “usuario” podrá: 
•	Registrar, modificar, eliminar, buscar y listar sus requerimientos de compra

- Una vez que el usuario puede iniciar sesión con su correo y contraseña en caso de no ser correctos, el usuario es redirigido a la página de index. 
Esta es la pagina que se presenta, cuando el usuario esta en su pagina principal. 

![6](https://user-images.githubusercontent.com/51839660/101501285-8f021a00-393d-11eb-8500-00c7e66dce13.JPG)


- Para el usuario normal se presenta un menu, que tiene las opciones de registrar pedido, modificar pedido y listar pedido. 
- En la pagina de registrar pedido el usuario, primero busca el producto que desea pedir luego de seleccionarlo se rellenan los espacios vacíos y el usuario puede añadir la cantidad que desea del producto y calcular el total del pedido.  Finalmente se presenta un aviso si el pedido a sido creado o no. 
![7](https://user-images.githubusercontent.com/51839660/101501315-96c1be80-393d-11eb-8ae3-b7d5bf0e2e88.JPG)


-En la pagina modificar pedido, el usuario primero visualiza su lista de pedidos. Selecciona y se rellenan los espacios vacíos con la información de pedido seleccionado, el usuario puede modificar la cantidad y volver a calcular la cantidad los demás atributos no pueden ser modificados por un usuario normal. También existe la opción de eliminar el pedido seleccionado. 
![8](https://user-images.githubusercontent.com/51839660/101501335-9c1f0900-393d-11eb-84d6-0b0197039547.JPG)
-Finalmente presentara un mensaje dependiendo si el pedido fue modificado o eliminado. 

- Finalmente la pagina de listar pedidos, muestra la lista de requerimientos de compra que tiene el usuario. En este caso se volvieron a crear dos pedidos diferentes con pizza de Peperonni y pizza mixta

![9](https://user-images.githubusercontent.com/51839660/101501359-a3461700-393d-11eb-983b-1eb4a10aed26.JPG)

### 4. Una vez iniciado sesión el “administrador” podrá:
- Para realizar el login del administrador usamos el usuario con rol de administrador juan.com con la contraseña de 1234. Y presenta su pagina de inicio con las opciones que puede realizar. 

![10](https://user-images.githubusercontent.com/51839660/101501478-c96bb700-393d-11eb-8292-bc167ecec142.JPG)


- En la pagina principal se muestran las opciones que puede tener este administrador de la misma forma, en el encabezado se presenta el nombre el usuario administrador y la empresa para que trabaja. 
En este caso, usaremos como ejemplo un usuario que pertenece de igual forma a la empresa de Pizza Hut con el fin de verificar los pedidos que se realizaron por el usuario normal usu@com

•	Registrar, modificar, eliminar, buscar y listar los productos de la empresa a la que pertenece 

Para registrar un producto, se presenta un listado de atributos que tiene el producto, primero se pide seleccionar una categoría para registrar el producto en este caso en la categoría pizzas agregamos una nueva pizza doble. 
![11](https://user-images.githubusercontent.com/51839660/101501523-d9839680-393d-11eb-8e4c-7e76d069e64b.JPG)


Para modificar el producto, primero buscamos en este caso vamos a modificar la pizza doble que ingresamos en el primer paso. Se modifico el nombre y el precio. El IVA es un atributo que no se puede modificar. Finalmente presentamos un mensaje de que se modificó el producto.  

![12](https://user-images.githubusercontent.com/51839660/101502350-d9d06180-393e-11eb-82f4-2592a89a9aa8.JPG)

Finalmente puede listar todos los productos que tiene la empresa o aquellos que fueron eliminados con anterioridad, pero se presentan ya con el estado de inactivo. 

•	Listar todos los requerimientos de compra de los “usuarios” de la empresa a la que pertenece 
- Se presenta una lista con todos los pedidos que fueron realizados a esa empresa, siendo aprobados, rechazados o pendientes. 
![15](https://user-images.githubusercontent.com/51839660/101502450-f4a2d600-393e-11eb-9503-7276b9ddb174.JPG)


•	Aprobar o Rechazar los requerimientos de compra de los “usuarios” de la empresa a la que pertenece.
- En esta parte se listan los pedidos que hicieron los usuarios de esa empresa. Anteriormente nuestro usuario usu@com creo dos pedios. Por lo que al listar se presenta opciones de apobar o rechazar. Aprobamos el pedido con cantidad de 10 pizzas
![16](https://user-images.githubusercontent.com/51839660/101502481-ff5d6b00-393e-11eb-82e1-6efc1c9bc456.JPG)
Al volver a listar se presenta un solo pedido debido a que listamos solo pedidos con el estado de pendiente para ser aprobados o rechazados. 

![17](https://user-images.githubusercontent.com/51839660/101502496-06847900-393f-11eb-8d94-8074d86c5b3f.JPG)

### El sistema debe aplicar los patrones de diseño de software MVC y DAO, en donde, el modelo será clases POJOs de Java, la vista será JSP + JSTL y los controladores serán a través de DAOs y Servlets
Se presenta un ejemplo para exponer como se realizó el procedimiento. En este caso lo haremos con la opción del administrador de crear el producto. 
1.	La petición llega a la pagina RegistrarPro.jsp, en el cual se presenta un formulario y ahí se encuentran los datos de categoría, y las propiedas que tiene el producto. Tiene la siguiente estructura. 

![19](https://user-images.githubusercontent.com/51839660/101502575-1dc36680-393f-11eb-9fc9-16da278e9cd1.JPG)


El botón Registrar Producto nos llena al método crearProducto() en nuestro funAdmin.js

2.	En la carpeta js y en el archivo funAdmin.js se encuentra el método crearProducto(), que es un método con AJAX que recibe todos las características de producto  y envía estas características al Servlets NuevoPro.java en su método GET. 
![20](https://user-images.githubusercontent.com/51839660/101502605-2451de00-393f-11eb-987d-8e7c2835e76c.JPG)


3.	En el Servlet en el método Get, se crea un nuevo producto de la clase producto y además llamamos a la factoria del paquete DAO. En este caso enviamos en el método getProducto_DAO().createConCategoria(p,categoría) ya el producto nuevo creado y la categoría que se había seleccionado. 
![21](https://user-images.githubusercontent.com/51839660/101502633-2d42af80-393f-11eb-86a3-947ced4459b8.JPG)


4.	Esta es la clase DAO para los productos, llamada Producto_DAO.java y se llama al método createConCategoria() a la que se envia el producto y la categoría. 
![22](https://user-images.githubusercontent.com/51839660/101502654-32076380-393f-11eb-9af0-01e326738a5e.JPG)

5.	Esto llama al JDBC_Producto_DAO.java que esta ubicado en la carpeta de ec.ups.edu.mysql.jdbc donde se encuentra nuestro método createConCategoria y se inserta el producto con categoría en la base de datos
![23](https://user-images.githubusercontent.com/51839660/101502676-3895db00-393f-11eb-81c1-6a3c125fcf97.JPG)


### RESULTADO(S) OBTENIDO(S):
1.	Se obtuvieron dos aplicaciones, la primera con   y la segunda con       .
2.	La interfaz de usuario es adecuada para el manejo y fácil comprensión del sistema.

### CONCLUSIONES:
1.	Se adquirió un conocimiento más cercano y claro de como funciona y su interacción entre las diferentes clases, al igual de como se interconectan y que métodos se deben usar y en que orden para que el sistema a desarrollar se lleve a cabo. El aprendizaje se profundizo y algunas dudas que se generaron durante el proceso de explicación fueron solventadas con estas prácticas. 

