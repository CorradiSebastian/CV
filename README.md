# CV
### resume app, created in kotlin

This app was created to show some basic implementations of android concepts, libraries and architectures described below

**##LIBRARIES**

- Retrofit: The data is retrived with retrofit once and the loaded from an internal DB (there is no backend for this app, so the MockWebServer is used to allow a JSON file to be used as a server response.

- MockWebServer: Originally developed to use in test cases, I used it to allow a JSON file to be used as a server response, is implemented through a interceptor.

- ROOM: The data retrived by retrofit, are stored here at the beggining of the app flow, and then are retrived. Also I used data converters and foreign keys.

- Coroutines: Kotlin's coroutines are used to handle several threads, it is well known that you cannot do a network call on the main thread.

**##ARCHITECTURE**

- MVVM is used in this app, just a standar implementation interacting with coroutines and fragments, fragments are sharing viewmodels with Activities, also SingleLiveEvent (pattern?) is used.

**##TO BE ADDED**

- App flow: A basic reference of how this app works, how the data is retived, stored and shown.
 
 - Animations: Just a few to make the UI nicer, it is not the main objective on this app to work on design issues.
 
 - Playstore Link: This app is intented to be uploaded and its code freed.
 
 - Developer contact: My email just to lisent suggestions.
 
 **##NOT PLANNED YET**
 - Crashlitics:
 
 - Notifications:
