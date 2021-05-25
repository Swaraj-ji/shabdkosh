# shabdkosh
Its an Android application vocabulary, the main content of the vocabulary is on the online mysql database (plesk) and meanings are added manually. 
Since the words are added manually so it consist of 3 activities :
  1. MainActivity - it consist of interface for searching the meanings of the words. This page have two text views one have the heading "Online Dictionary" and other is used to show the meanings, between both the text views there is a autocomplete text view to enter the word. At the bottom there is a button "Add Word" which is used to Add new words.
  2. LoginActivity - When we press the "Add Word" buttom it brings us to the login page which needs a userid and password. Userid and password is hardly coded in this activity. 
  3. AddWord Activity - After the successful login we comes on this activity it have a text view with the heading "Add Word" and two edit text views one to enter word and other for the meaning below these edit text views we have two buttons "Add" and "Back". Add button is used to finally add a word and back button takes us to the main activity again.

This project also have a java class name "DbManager.java" this class is responsible for the connection to the database basically it does two steps of the JDBC connection :
  1. Load driver of the JDBC.
  2. Connection between front end and back end.

There is one image among the files name logo.jpg which is the logo of this app. Paste this image in the mipmap folder (app > res > mipmap) or directly paste in the path- Shabdkosh\app\src\main\res\mipmap-hdpi
