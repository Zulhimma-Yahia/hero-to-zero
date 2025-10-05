\# Like Hero To Zero - CO2 Emissions Tracker



Eine Webanwendung zur Verwaltung und Darstellung weltweiter CO2-Emissionsdaten.



\## Projektbeschreibung



\*\*Like Hero To Zero\*\* ist eine Webanwendung, die im Rahmen eines Universitätsprojekts entwickelt wurde. Die Anwendung ermöglicht:



\- \*\*Öffentliche Ansicht\*\*: Anzeige aktueller CO2-Emissionsdaten aller Länder (ohne Login)

\- \*\*Wissenschaftler-Backend\*\*: Login-geschützter Bereich zum Hinzufügen und Verwalten von Daten

\- \*\*Datenfreigabe\*\*: Neu eingereichte Daten müssen vor Veröffentlichung freigegeben werden



\## User Stories (MoSCoW-Methode)



\### MUST (Pflicht)

1\. Als umweltpolitisch interessierte:r Bürger:in möchte ich den aktuellsten CO2-Ausstoß meines Landes einsehen können

2\. Als registrierte:r Wissenschaftler:in möchte ich neue Klimaforschungsdaten hinzufügen können



\### COULD (Optional)

3\. Als Herausgeber:in möchte ich sicherstellen, dass Daten vor Veröffentlichung freigegeben werden müssen



\## Technologie-Stack



\- \*\*Backend\*\*: Spring Boot 2.7.18

\- \*\*Frontend\*\*: Thymeleaf Templates

\- \*\*Sicherheit\*\*: Spring Security

\- \*\*Datenhaltung\*\*: Spring Data JPA + Hibernate

\- \*\*Datenbank\*\*: H2 (Entwicklung) / MySQL (Produktion)

\- \*\*Build-Tool\*\*: Maven

\- \*\*Java-Version\*\*: 17



\## Voraussetzungen



\- JDK 17 oder höher

\- Maven 3.9 oder höher

\- Git



\## Installation und Start



\### 1. Repository klonen

```bash

git clone https://github.com/Zulhimma-Yahia/hero-to-zero.git

cd hero-to-zero

