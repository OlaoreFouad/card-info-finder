## Card Info Finder (Summary)

This app works as a retriever for credit/debit card details. The user is expected to type at least
the first eight numbers (to assist verification) into the input field and upon hitting the check
button, the card numbers are verified and the details are presented to the user.

### The App

1. Click on "Input Card Details" button

<img src="https://github.com/OlaoreFouad/card-info-finder/blob/main/shots/input_card_details.jpeg" width="250" />   

2. Enter Card details and click "Check"

<img src="https://github.com/OlaoreFouad/card-info-finder/blob/main/shots/enter_credit_card_number.jpeg" width="250" />   

3. Card details are displayed.

<img src="https://github.com/OlaoreFouad/card-info-finder/blob/main/shots/card_details_page.jpeg" width="250" />   


### The Structure

This project makes use of the following technologies:

1. MVVM (Model-View-ViewModel) Architecture
2. Kotlin Coroutines for background operations
3. Dagger for Dependency Injection
4. Retrofit for Network requests
5. Jetpack Navigation Components for Navigation

### The Package Structure

<img src="https://github.com/OlaoreFouad/card-info-finder/blob/main/shots/package_structure.jpeg" width="250" />   


The project files were grouped by feature as seen in the image below where:

1. data package contains the common models used across the app, the models per feature (info_finder) 
   and specs for the network layer.
2. di package contains the dependency injection components and modules.
3. ui package includes the UI-related classes e.g. viewmodels, fragments per feature (info_finder).
4. util package includes the constants and helper functions used across the application.