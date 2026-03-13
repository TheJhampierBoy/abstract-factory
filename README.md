# Sistema de Gestión de Cafetería Inteligente

## Descripción del Proyecto

Aplicación de consola en Java para administrar pedidos, notificaciones y generación de productos en una cadena de cafeterías. El sistema implementa el patrón **Abstract Factory** como solución principal, complementado con otros 5 patrones de diseño.

## Patrones de Diseño Implementados

| Patrón | Paquete | Descripción |
|--------|---------|-------------|
| **Abstract Factory** | `com.cafeteria.factory` | Crear familias de productos según tipo de cafetería (Tradicional/Fitness) |
| **Strategy** | `com.cafeteria.strategy` | Variar comportamiento de pago o cálculo en tiempo de ejecución |
| **Command** | `com.cafeteria.command` | Encapsular operaciones del menú como comandos |
| **Iterator** | `com.cafeteria.iterator` | Recorrer pedidos y productos sin exponer estructura interna |
| **Singleton** | `com.cafeteria.singleton` | Garantizar instancia única de configuración global |
| **Observer** | `com.cafeteria.observer` | Notificar automáticamente a módulos interesados ante cambios de estado |

## Tipos de Cafetería

- **Cafetería Tradicional**: Café con leche, Cheesecake, Combo clásico
- **Cafetería Fitness**: Té sin azúcar, Barra proteica, Combo fit

## Estructura del Proyecto

```
com/cafeteria/
├── command/    - Patrón Command (operaciones CRUD de pedidos)
├── factory/     - Patrón Abstract Factory (fábricas de menús)
├── iterator/    - Patrón Iterator (recorrer colecciones)
├── main/        - Clase principal Main.java
├── model/       - Modelos del dominio (Pedido, Producto, etc.)
├── observer/    - Patrón Observer (notificaciones)
├── singleton/   - Patrón Singleton (SystemConfig)
└── strategy/    - Patrón Strategy (estrategias de pago)
```

## Requerimientos

- Java 8 o superior

## Ejecución

```bash
cd com/cafeteria/main
javac *.java
java Main
```

## Integrantes

- Justin Daniela Bahamon Baloco
- Nicole Dayana Ramirez Vargas
- Maria de los angeles Olaya Garcia
- Cristofer David Lozano Contreras
- Jhampier Santos Ortiz
- Keneth Santiago Rubiano Silva
- Johan Smith SantaMaria Fernandez

