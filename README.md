# Calculator

- Crear entorno de trabajo utilizando Maven `4.0.0`, Sprint Boot `3.0.3` y Java `17` más otras dependencias utiles encontradas dentro del pom.xml.

- Importar librerías externas __tracer.jar__ de la carpeta _.libs_ a través del __pom.xml__.

- Preparar una arquitectura hexagonal del proyecto con lo que desarollar posteriormente.

- Crar una clase principal ejecutadora del programa en si, un modelo de la estructura de calculadora, una interfaz e implementación sobre la que interactuará con el tracer y el repositorio JPA para la posterior gestión de operaciones registradas, y un controlador que estará escuchando las consultas de suma y resta por sus respectivos end-point.

- Agregar en el application.properties persistencia de datos utilizando H2 como gestor de pruebas, "lo dejé en (create-drop)".

- Implementar nuevas consultas básicas de CRUD para sacar mayor provecho al proyecto. También un paquete para errores personalizados.