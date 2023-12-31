<h1 align="center">E-commerce App</h1></br>
## Tech stack & Open-source libraries

- Minimum SDK level 24
- 100% [Kotlin](https://kotlinlang.org/)
  based + [Coroutines](https://github.com/Kotlin/kotlinx.coroutines)
  and [Flow](https://developer.android.com/kotlin/flow) & [State](https://developer.android.com/jetpack/compose/state#state-in-composables) & [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) -
  Collection of libraries that help you design robust, testable, and maintainable apps.
    - A single-activity architecture, using
      the [Navigation Component](https://developer.android.com/guide/navigation) to manage composable navigation.
    - [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - perform an
      action when lifecycle state changes
    - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores
      UI-related data that isn't destroyed on UI changes.
    - [UseCases](https://developer.android.com/topic/architecture/domain-layer) - Located domain
      layer that sits between the UI layer and the data layer.
    - [Repository](https://developer.android.com/topic/architecture/data-layer) - Located in data
      layer that contains application data and business logic.
- [Android Hilt](https://developer.android.com/training/dependency-injection/hilt-android) -
  Dependency Injection Library
- [Retrofit](https://square.github.io/retrofit/) A type-safe HTTP client for Android and Java
- [OkHttp](https://square.github.io/okhttp/) An HTTP client that efficiently make network requests
- [Moshi](https://github.com/square/moshi) Moshi is a modern JSON library for Android, Java and
  Kotlin. It makes it easy to parse JSON into Java and Kotlin classes.
- [Room](https://developer.android.com/training/data-storage/room) The Room persistence library
  provides an abstraction layer over SQLite to allow for more robust database access while
  harnessing the full power of SQLite.
- [WorkManager](https://developer.android.com/topic/libraries/architecture/workmanager) WorkManager
  is an API that makes it easy to schedule deferrable, asynchronous tasks that are expected to run
  even if the app exits or device restarts.
- [Local Notifications](https://developer.android.com/training/notify-user/build-notification) A
  notification is a message that Android displays outside your app's UI to provide the user with
  reminders, communication from other people, or other timely information from your app.
- [kJWT](https://github.com/nefilim/kjwt) Functional Kotlin & Arrow based library for generating and
  verifying JWTs and JWSs.
- [Firebase](https://firebase.google.com/) - Used for authentication, crashlytics, analytics,
  firestore and messaging.
    - [Firebase Authentication](https://firebase.google.com/docs/auth) Firebase Authentication
      provides backend services, easy-to-use SDKs, and ready-made UI libraries to authenticate users
      to your app.
    - [Firebase Crashlytics](https://firebase.google.com/docs/crashlytics) Firebase Crashlytics is a
      lightweight, realtime crash reporter that helps you track, prioritize, and fix stability
      issues that erode your app quality.
    - [Firebase Analytics](https://firebase.google.com/docs/analytics) Firebase Analytics is a free
      app measurement solution that provides insight on app usage and user engagement.
    - [Firebase Firestore](https://firebase.google.com/docs/firestore) Cloud Firestore is a
      flexible, scalable database for mobile, web, and server development from Firebase and Google
      Cloud.
    - [Firebase Messaging(FCM)](https://firebase.google.com/docs/cloud-messaging) Firebase Cloud
      Messaging (FCM) is a cross-platform messaging solution that lets you reliably send messages at
      no cost.
- [SharedPreferences](https://developer.android.com/training/data-storage/shared-preferences) Store
  private primitive data in key-value pairs.
- Testing
    - [Mockito](https://site.mockito.org/) A mocking framework that tastes really good. It lets you
      write beautiful tests with a clean & simple API
    - [MockWebServer](https://github.com/square/okhttp/tree/master/mockwebserver) A scriptable web
      server for testing HTTP clients
    - [Truth](https://truth.dev/) A library for performing assertions in tests
    - [Turbine](https://github.com/cashapp/turbine) A small testing library for kotlinx.coroutines
      Flow

## API

E-commerce App uses the [DummyJson](https://dummyjson.com/) for constructing RESTful API.<br>
And also uses [Firebase](https://firebase.google.com/) for authentication, crashlytics, analytics,
firestore and messaging.
