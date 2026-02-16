# CLAUDE.md – pensjon-regler-api

This file provides guidance to Claude Code when working with the pensjon-regler-api project.

## Overview

pensjon-regler-api is the **shared domain model and API contract library** for NAV's pension calculation system. It defines Kotlin domain classes, request/response DTOs, and enums consumed by pensjon-regler (the calculation engine) and other pension services.

This is a **pure library** – no Spring Boot, no REST framework, no deployable service.

## Build Commands

```bash
mvn clean install                         # Build with tests
mvn test                                  # Run all tests
mvn test -Dtest=ClassName                 # Single test class
mvn test -Dtest=ClassName#methodName      # Single test method
./releaseGithub.sh                        # Release to GitHub Packages
```

## Project Structure

```
pensjon-regler-api/
├── pom.xml
├── src/
│   ├── main/kotlin/no/nav/pensjon/regler/
│   │   ├── domain/              # ~341 domain model classes
│   │   │   ├── beregning/       # Calculation results (Beregning, Grunnpensjon, Tilleggspensjon, ...)
│   │   │   ├── beregning2011/   # 2011+ pension reform models
│   │   │   ├── enum/            # 85+ enums (BeregningsmetodeEnum, SakTypeEnum, ...)
│   │   │   ├── gomregning/      # G-adjustment/recalculation models
│   │   │   ├── grunnlag/        # Input basis models (Persongrunnlag, ...)
│   │   │   ├── krav/            # Claim models (Kravhode, Kravlinje)
│   │   │   ├── sats/            # Rate tables
│   │   │   ├── simulering/      # Simulation models
│   │   │   ├── trygdetid/       # Insurance period models
│   │   │   ├── vedtak/          # Decision models
│   │   │   └── util/formula/    # Formula representation (Formel, IFormelProvider)
│   │   └── to/                  # ~100 request/response DTOs
│   │       ├── ServiceRequest   # Abstract base for all requests
│   │       ├── ServiceResponse  # Abstract base for all responses (includes Pakkseddel)
│   │       ├── BeregnYtelseRequest/Response
│   │       ├── SimuleringRequest/Response
│   │       └── TrygdetidRequest/Response
│   └── test/kotlin/
└── .github/workflows/           # CI/CD (build, release, publish)
```

## Key Technical Details

- **Kotlin 2.x**, JDK 17, Maven
- **Dependencies (minimal):** kotlin-stdlib, commons-lang3, Jackson annotations, JUnit 4
- **Serializable models:** All domain classes implement `Serializable`
- **Mutable properties:** Models use `var` (not data classes) for flexibility
- **Jackson annotations:** `@JsonGetter` for computed properties
- **ServiceRequest/ServiceResponse:** Abstract base classes for all API contracts
- **Pakkseddel:** Metadata object on responses indicating calculation validity (`kontrollTjenesteOk`, `merknadListe`)
- **Formel:** Recursive formula tree (`subFormelList`) for calculation transparency

## Key Domain Concepts

| Concept | Description |
|---------|-------------|
| **Beregning** | Calculation result with components (Grunnpensjon, Tilleggspensjon, barnetillegg, etc.) |
| **Trygdetid** | Insurance period (Norwegian, EOS, bilateral agreements) |
| **Kravhode** | Application header with person basis and claim lines |
| **Persongrunnlag** | Person's basis data for calculations |
| **Pakkseddel** | Response metadata – validation status and remarks list |
| **Formel** | Formula representation for transparency into calculation steps |

## Distribution

- Published to **GitHub Packages**: `https://maven.pkg.github.com/navikt/pensjon-regler-api`
- Version format for releases: `1.YYYY.MM.DD-HH.MM-{git-hash}`
- Consumed as Maven dependency by pensjon-regler and other services:
  ```xml
  <dependency>
    <groupId>no.nav.pensjon</groupId>
    <artifactId>pensjon-regler-api</artifactId>
  </dependency>
  ```

## Relationship to Other Projects

```
pensjon-regler-api (this project)
    ↑ consumed by
pensjon-regler (calculation engine) – uses domain models for REST API + internal logic
```

Changes here affect all consumers – coordinate releases with pensjon-regler.
