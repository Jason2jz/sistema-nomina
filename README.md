# Sistema de Nómina - Souk 4.0

Sistema de nómina desarrollado en Java con Programación Orientada a Objetos.

## Integrantes
- Jeison Andrés Posada Lacharme
- Sebastián Alvarado Beltrán
- Kevin Andrés Galindo Florez
- Didier Pérez Polo

## Tecnologías
- Java 8
- VS Code

## Metodología
Desarrollo iterativo basado en Scrum, con entregas por módulos.

## Principios aplicados
- **SOLID**: Single Responsibility, Open/Closed
- **Código limpio**: nombres descriptivos, constantes, comentarios
- **Refactorización**: sin código duplicado

## Tipos de Empleados
- Empleado Asalariado
- Empleado por Horas
- Empleado por Comisión
- Empleado Temporal

## Cómo ejecutar
```bash
javac -source 8 -target 8 src/models/*.java src/services/*.java src/Main.java -d out
java -cp out Main
```

## Estructura del proyecto
```
sistema-nomina/
├── src/
│   ├── models/       → Clases de empleados
│   ├── services/     → Lógica de nómina
│   └── utils/        → Validaciones
├── test/             → Pruebas unitarias
└── README.md
```