# POO_TV

## src\ Structure
* src/
    * checker/ (from POO team)
    * filein/ (classes used to read data from the input)
    * fileout/ (classes used to print data to output)
    * program/ (classes with method of implementing the actions from input)
    * resources/ (contains classes of different objects)
        * data/ (contains data classes(database, user info, movies, etc.))
        * pages/ (contains classes of the platform pages)

The game begins in main where we form our database and then use the InputProcessing class to implement the actions

## The program
#### InputProcessing
This class is used to implement the following:
* adds users to the database from the input
* adds movies to the database from the input
* reads from the input the actions and calls the Processing class

#### Processing
This class is used to implement the following:
* the *Change Page* action that changes the current page of the user and print an error message if it is not possible
* the *On Page* action that calls the feature of each page, according to the input

## The user

The current user is implemented with the ActiveUser class that contains the user(with his credentials and other data), 
the current page he is on, the current movie list that can be accessed from the current page and a selected movie for when
he selects one from the current movie list.

## Pages
Each page has a class in the resources folder with the implementation of the actions that can used from that page.

## Database
The database is implemented with a *singleton design pattern*. It contains a list of the users that are registered,
a list of the movies that are on the platform and an instance of each page.
