# SportsApp
An Application client to this [API](https://618d3aa7fe09aa001744060a.mockapi.io/api/sports), that shows Sports and Events 
## Main features
- Acoordion list, where you can hide events of an specific sport
- Shows a countdown to the start of the event
- You can favorite you events and filter that for each sport, which is locally saved

## Patterns and Frameworks
- MVVM + Clean Architecture
- Hilt
- Room
- Retrofit + Gson
- Mockk + Junit
- Coroutines + FLow

## Gson TypeAdapter
The API has a problem that the field that must show the name in some of the objects show a list of objects, wich made nescessary a custom type adapter for gson to ignore that list, so the app can actually run without erros

## Tests
The Unit tests are made mainly on the view model, but they cover all the basic features of the app which is expand/collapse the list, save the favorites and filter the events
