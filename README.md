# Denys Zvieriev Portfolio (Kotlin Multiplatform)

This repository is a Kotlin Multiplatform portfolio app targeting:
- Android
- iOS
- Desktop (JVM)
- Web (JS)
- WebAssembly (Wasm)

The shared UI includes:
- Name: **Denys Zvieriev**
- About: **Backend Software Engineer with 8+ years of experience building scalable cloud-based microservices. Specialized in Java, Kotlin, and Spring Boot.**
- Contact information:
  - `dzdenya@gmail.com`
  - `+34661455825`
  - `t.me/denys_zz`
  - `wa.me/+34661455825`
  - `https://www.linkedin.com/in/denys-zvieriev`

## Run Locally

### Android
```bash
./gradlew :composeApp:assembleDebug
```

### Desktop (JVM)
```bash
./gradlew :composeApp:run
```

### Web (Wasm)
```bash
./gradlew :composeApp:wasmJsBrowserDevelopmentRun
```

### Web (JS)
```bash
./gradlew :composeApp:jsBrowserDevelopmentRun
```

### iOS
Open `/iosApp` in Xcode and run the iOS target.

## Build Production Wasm Bundle

```bash
./gradlew :composeApp:wasmJsBrowserDistribution
```

Output folder:
- `composeApp/build/dist/wasmJs/productionExecutable`

## Deploy Wasm to GitHub Pages

A workflow is included at:
- `.github/workflows/deploy-wasm-pages.yml`

It will:
1. Build `:composeApp:wasmJsBrowserDistribution`
2. Upload `composeApp/build/dist/wasmJs/productionExecutable`
3. Deploy to GitHub Pages

Deployment triggers:
- Push to `main` or `master`
- Manual run via **workflow_dispatch**

Before first deploy, ensure repository settings use:
- **Settings → Pages → Build and deployment → Source = GitHub Actions**

Expected URL format after deployment:
- `https://<your-github-username>.github.io/<repository-name>/`
