# pensjon-regler-api

## Versjonering

Vi følger [Semantic Versioning](https://semver.org/):

- **Major** – Inkompatible API-endringer
- **Minor** – Ny funksjonalitet som er bakoverkompatibel
- **Patch** – Bakoverkompatible feilrettinger

## Release-prosess

### 1. Lage release-branch fra master

Opprett en ny branch fra master, f.eks. `release/v1.3.0`, og oppdater versjonsnummeret i `pom.xml`.

### 2. Merge feature branch inn til release-branch

Merge den aktuelle feature-branchen inn til release-branchen.

### 3. Release til master

Merge release-branchen inn til master.

### 4. Lage manuell release

Gå til GitHub og lag en ny release manuelt fra master.

Merk: Teksten som vises i pensjon-regler ved ny release støtter ikke formattering (punktlister osv. fungerer ikke). Bruk derfor `-` som skilletegn istedenfor punktlister i release notes-teksten;
hold det enkelt.