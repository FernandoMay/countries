# Countries

App Android nativa (Java) que consume la REST Countries API v3.1 para mostrar información de países del mundo con ViewPager, TabLayout y Retrofit.

## Stack

| Capa | Tecnología |
|------|-----------|
| Lenguaje | Java 8 |
| UI | ViewPager + TabLayout + Material Design |
| Networking | Retrofit 2.9 + Gson |
| JSON | Jackson (annotations en modelos) |
| Arquitectura | ViewModel + LiveData |
| Build | Gradle 7.4, minSdk 24, targetSdk 33 |
| CI/CD | GitHub Actions (assembleDebug + test) |

## Funcionalidades

- Consume `https://restcountries.com/v3.1/all` vía Retrofit
- Visualización tipo tabs: "Countries" e "Info"
- Modelo de datos completo (~50 campos por país): nombre, capital, región, población, área, idiomas, monedas, banderas, coordenadas, husos, dominio, etc.
- ViewModel + LiveData para retener datos en cambios de configuración
- FloatingActionButton presente (sin funcionalidad asignada aún)
- Modelos auto-generados con Jackson annotations (~977 líneas para monedas)

## Estructura

```
app/src/main/java/com/example/countries/
├── MainActivity.java            # ViewPager + TabLayout setup
├── FragmentCountries.java       # Fragment lista de países (sin lógica)
├── FragmentInfo.java            # Fragment info simple
├── CountriesViewModel.java      # Fetch API + LiveData
├── CountriesAPI.java            # Wrapper Retrofit
├── CountriesService.java        # Interface Retrofit (@GET "all")
├── models/
│   ├── Countries.java           # POJO principal (~50 campos)
│   ├── Name.java, Flags.java, Currencies.java, ...
│   └── Converter.java           # Helper Jackson
└── ui/main/
    ├── SectionsPagerAdapter.java  # Adaptador alternativo
    └── PlaceholderFragment.java   # Fragment template
```

## Inicio rápido

```bash
./gradlew assembleDebug
```

## Pruebas

```bash
./gradlew test
```

## Notas

- Proyecto en desarrollo — FragmentCountries no observa el ViewModel
- activity_detail.xml existe pero no está conectado a ninguna Activity
- Usa tanto Jackson (modelos) como Gson (Retrofit) — inconsistencia menor
- Modelos generados con quicktype.io
