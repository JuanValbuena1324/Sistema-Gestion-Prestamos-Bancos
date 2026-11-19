# 🏦 Sistema de Gestión de Préstamos Bancarios

![Java](https://img.shields.io/badge/Java-ED8B00?style=flat&logo=openjdk&logoColor=white)
![NetBeans](https://img.shields.io/badge/IDE-Apache_NetBeans-1B6AC6?style=flat&logo=apachenetbeanside&logoColor=white)
![Swing](https://img.shields.io/badge/GUI-Java_Swing-007396?style=flat)
![Architecture](https://img.shields.io/badge/Arquitectura-Monolítica_%7C_SOLID-10B981?style=flat)
![Patterns](https://img.shields.io/badge/Patrones-Singleton_%26_Observer-6366F1?style=flat)

## Descripción

**Sistema de Gestión de Préstamos Bancarios** es una aplicación monolítica de escritorio desarrollada en **Java (Apache NetBeans)** con interfaz gráfica construida en **Java Swing**. El sistema permite realizar operaciones **CRUD** completas sobre préstamos hipotecarios y vehiculares, gestionar la asociación con tarjetas de propiedad y calcular cuotas financieras aplicando **principios SOLID** y los patrones de diseño **Singleton** y **Observer**.

## Integrantes

| Integrante | Rol / Desarrollo |
| :--- | :--- |
| Juan Pablo Valbuena | `Arquitectura SOLID, Patrones Singleton & Observer, Servicios y GUI Swing` |

## Arquitectura y Patrones Implementados

* **Principios SOLID:** Separación de responsabilidades mediante capas (`model`, `services`, `gui`) e inversión de dependencias a través de interfaces (`IServicioPrestamo`, `IAsegurableHipoteca`, `ICambiable`).
* **Patrón Singleton:** Gestión centralizada y única de las instancias de servicio (`ServicioPrestamo` y `ServicioTarjetaPropiedad`) para mantener la consistencia de los datos en memoria durante toda la ejecución.
* **Patrón Observer:** Sincronización automática entre las ventanas de interfaz gráfica (`GUIAdd...`, `GUIActualizar...` y vistas principales) cada vez que se registra, actualiza o elimina un préstamo o tarjeta de propiedad.
* **Relaciones y Lógica de Negocio:**
  * **Clase Base (`Prestamo`):** Abstracción con atributos comunes y cálculo de cuotas.
  * **Préstamos Hipotecarios (`PrestamoHipotecario` - Clase B):** Gestión especializada con validación de asegurabilidad (`IAsegurableHipoteca`).
  * **Préstamos Vehiculares (`PrestamoVehicular` - Clase C):** Asociado directamente con la entidad **`TarjetaPropiedad` (Clase D)**.

## Estructura del proyecto

```text
Sistema-Gestion-Prestamos-Bancos/
├── pom.xml                                      # Configuración de dependencias Maven (JCalendar, etc.)
├── README.md                                    # Documentación del repositorio
└── src/main/java/com/mycompany/
    ├── model/
    │   ├── Prestamo.java                        # Clase base abstracta de préstamos
    │   ├── PrestamoHipotecario.java             # Modelo de préstamo hipotecario (Clase B)
    │   ├── PrestamoVehicular.java               # Modelo de préstamo vehicular (Clase C)
    │   ├── TarjetaPropiedad.java                # Modelo asociado al vehículo (Clase D)
    │   ├── IAsegurableHipoteca.java             # Interfaz de comportamiento hipotecario
    │   ├── ICambiable.java                      # Interfaz para actualización de estado
    │   ├── IServicioPrestamo.java               # Contrato de operaciones del servicio
    │   ├── services/
    │   │   ├── ServicioPrestamo.java            # Lógica CRUD y cálculo de cuotas (Singleton)
    │   │   └── ServicioTarjetaPropiedad.java    # Gestión CRUD de tarjetas de propiedad (Singleton)
    │   └── gui/
    │       ├── GUIAddHipotecario.java           # Formulario de registro hipotecario
    │       ├── GUIActualizarHipotecario.java    # Formulario de edición hipotecario
    │       ├── GUIAddVehicular.java             # Formulario de registro vehicular
    │       ├── GUIActualizarVehicular.java      # Formulario de edición vehicular
    │       ├── GUIAddTarjeta.java               # Formulario de registro de tarjeta de propiedad
    │       └── GUIActualizarTarjeta.java        # Formulario de edición de tarjeta de propiedad
    └── pocprestamos/                            # Clase principal de arranque (Main)
