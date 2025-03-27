# Práctica 4: API REST + Página Web Estática de Apple Inc.

Este repositorio fusiona la **página web de Apple Inc.** (Práctica 2) con un **API REST** en Spring Boot (Práctica 4), cumpliendo los requerimientos de ambas prácticas.

## 1. Objetivo de la Práctica

- **Práctica 2**: Crear una **web estática** sobre Apple Inc., con HTML, CSS, JavaScript, Bootstrap, gráficos interactivos y una calculadora de inversión.
- **Práctica 4**: Implementar un **API REST** en Spring Boot (Java 21), con las operaciones CRUD (Creación, Lectura, Actualización y Borrado) sobre datos relacionados con la temática de la web (en este caso, la entidad `Accion` de Apple).

---

## 2. Descripción de la Web (Práctica 2)

La web consta de cuatro páginas principales:
1. **Página Principal (`index.html`)**: Valores de Apple, análisis DAFO.
2. **Productos Más Vendidos (`productosmasvendidos.html`)**: iPhone, iPad, MacBook, AirPods, con gráficas de ventas.
3. **Regiones con Mayores Ventas (`regiones.html`)**: Análisis de ventas por región, gráficos interactivos.
4. **Valor de las Acciones (`valoracciones.html`)**: Evolución histórica del precio de las acciones de Apple (1985-2025) y calculadora de inversión.

La web usa:
- **Bootstrap** para diseño responsive.
- **Chart.js** para gráficos interactivos.
- **Formularios** para la calculadora de inversión.

---

## 3. API REST (Práctica 4)

Se ha creado una **API REST** con Spring Boot para manejar la entidad `Accion`.  
La clase `Accion` (modelo) representa los datos de una acción de Apple (fecha, precio de cierre, volumen).

### 3.1. Requisitos y configuración

- **Java 21**  
- **Maven** 3.x  
- **Spring Boot 3.4.4**  
- **H2 Database** en memoria para pruebas (configurada en `application.properties`).

### 3.2. Endpoints CRUD

La API expone rutas en `http://localhost:8080/api/acciones`.  
| Método | Endpoint           | Cuerpo (JSON)                                                   | Descripción                                             | Respuesta                             |
|--------|--------------------|-----------------------------------------------------------------|---------------------------------------------------------|---------------------------------------|
| **POST**   | `/api/acciones`     | `{"fecha":"2025-05-10","precioCierre":145.3,"volumen":300000}`  | Crea una nueva acción de Apple                          | **200 OK** + objeto creado            |
| **GET**    | `/api/acciones`     | -                                                               | Obtiene todas las acciones guardadas                    | **200 OK** + array JSON               |
| **GET**    | `/api/acciones/{id}`| -                                                               | Obtiene la acción con el ID especificado               | **200 OK** si existe,<br>**404** si no |
| **PUT**    | `/api/acciones/{id}`| `{"fecha":"2025-06-20","precioCierre":150.0,"volumen":400000}`  | Actualiza la acción con el ID indicado                  | **200 OK** si existe,<br>**404** si no |
| **DELETE** | `/api/acciones/{id}`| -                                                               | Elimina la acción con el ID indicado                    | **204 No Content** si existe,<br>**404** si no |

### 3.3. Ejemplos de prueba con Postman o cURL

- **Crear (POST)**:
  ```bash
  curl -X POST \
       -H "Content-Type: application/json" \
       -d '{"fecha":"2025-05-10","precioCierre":145.3,"volumen":300000}' \
       http://localhost:8080/api/acciones
