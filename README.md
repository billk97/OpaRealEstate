# OpaRealEstate
## This is a small project on an android app that will connect to a Database via the MVC architecture 
The project is divided in three packages **Controller** ,**DBHelper**, **Presenter**
* ### Presenter
> The **presenter** is responsible for all the User Interface and the connection with the Xml code.
> It contains four java file **ListView** , **MainActivity**, **Sale**, **Search** each responsible 
> for a corresponding XML activity.
* ### Controller
> The **Controller** is responsible for the program's logic filters the input and output of the current program.
* ### DBHelper
> The **DBHelper** is responsible for the communication of the program with the data Base. 
> The **DBHelper** also creates the database if it's the first time the program has been created
> The database use was an SqLite database that creates a file inside the device
 and runs locally
> Note that when the application closes the data do not get deleted
