# Word Wrap Kata (Kotlin)

Kata clásica de **word wrap**: dado un texto y un ancho máximo de columnas, devolver el mismo texto partido en líneas que no excedan ese ancho, respetando los espacios cuando sea posible.

El objetivo del ejercicio no es solo implementar el algoritmo, sino **pensar los edge cases antes de teclear**: enumerar los casos y luego ir haciéndolos pasar uno a uno con ciclos TDD **red → green → refactor**.

## Contenido

- `src/main/kotlin/dev/kata/wordWrap/domain/WordWrap.kt` — algoritmo puro
- `src/main/kotlin/dev/kata/wordWrap/infrastructure/WordWrapCLI.kt` — pequeño REPL por `stdin` para probarlo a mano
- `src/test/kotlin/dev/kata/wordWrap/domain/WordWrapShould.kt` — 7 tests + checklist de casos al pie del fichero
- `build.gradle.kts` — Kotlin + JUnit 5 + AssertJ

## Requisitos

- JDK 17+
- Gradle wrapper incluido (`./gradlew`)

## Cómo ejecutar

```bash
# Tests
./gradlew test

# CLI interactivo (pide texto y número de columnas por stdin)
./gradlew run
```

## Checklist de casos

### Casos principales (cubiertos por tests)

- [x] `"hola", 4` → `"hola"` — cabe, no parte
- [x] `"hola mundo bonito", 20` → `"hola mundo bonito"` — cabe, no parte
- [x] `"hola", 2` → `"ho\nla"` — sin espacios, parte por columna
- [x] `"hola", 3` → `"hol\na"` — sin espacios, posición distinta
- [x] `"hola mundo", 8` → `"hola\nmundo"` — parte por espacio
- [x] `"hola caracola de goma", 4` → `"hola\ncara\ncola\nde\ngoma"` — multi-wrap mezclando espacios y corte por columna
- [x] `"", 2` → `""` — texto vacío

### Casos límite pensados pero aún no cubiertos

- [ ] `"hola", 0` → error (ancho inválido)
- [ ] `"hola     mundo", 5` → `"hola\nmundo"` (múltiples espacios)
- [ ] `"hola     mundo", 4` → `"hola\nmund\no"` (múltiples espacios + partición)

Este listado vive también como comentario al inicio de `WordWrapShould.kt` para que quien abra el fichero vea inmediatamente qué está y qué no está implementado.

## Cómo leer el historial

Los commits siguen el patrón:

```
:rotating_light:     <nombre_del_test>   ← test que falla (red)
:white_check_mark:   <nombre_del_test>   ← mínimo código para pasar (green)
:recycle:            <nombre_del_test>   ← refactor sin romper nada
```

Recorrer los 20 commits en orden equivale a reproducir la kata desde cero.

```bash
git log --oneline --reverse
```

## Reglas TDD aplicadas

- Un test rojo antes de cualquier código de producción
- Mínimo código para poner el test en verde, sin adelantarse al siguiente caso
- Refactor únicamente con la suite en verde
- Nombres de test expresivos con `fun \`backticks\`` describiendo **la intención**, no la implementación
