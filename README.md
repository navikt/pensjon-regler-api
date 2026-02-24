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

Hver gang noe merges til master opprettes eller oppdateres automatisk en release-draft på GitHub. Denne draften samler opp alle endringer fortløpende og fungerer som en mal/guide for release notes. Ved flere merges til master oppdateres den samme draften kontinuerlig inntil en release publiseres.

Gå til GitHub → Releases → finn draften, juster teksten ved behov, og publiser.

Merk: Teksten som vises i pensjon-regler ved ny release støtter ikke formattering (punktlister, hyperlenker osv. fungerer ikke). Bruk derfor `-` som skilletegn istedenfor punktlister i release notes-teksten.