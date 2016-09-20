# First time running
Do this in terminal:

    ./activator run
    
Should install all dependencies and startup at localhost:9000


# IntelliJ Setup
Open project. Do not import anything. 
Create new run configuration with SBT Task.
Under 'Tasks' simply add 'run'


# Heroku
Application can be found here:

## Pushing updates



# Develop using SBT features
The Play console is just a normal sbt console, so you can use sbt features such as triggered execution.
Start the console like so:

    ./activator

## Compile to get errors

    compile

## Run test scripts

    test

## Run the app
The compilation will also be triggered each time you change a source file.

    run
