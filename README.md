# Instruction for using csv_generated
## Launching the program

To run the program, follow these steps:
1. To run the program, you need a jar file: *generation-of-students-1.0-jar-with-dependencies.jar*
2. After opening the console, you need to write the command: **java - jar generation-of-students-1.0-jar-with-dependencies.jar** ***[number]***

***[number]*** is a number symbolizing the number of generated lines in files.

For example, *java - jar generation-of-students-1.0-jar-with-dependencies.jar* ***100***

***Important:*** 
- If the path in the command line differs from the path to the jar file, then before starting the program, 
you should specify the path to the file or when entering the command, specify the path to the file;
- The files that contain the information for generating the final file should be located next to the jar file;
- The names of the files must contain a description of their contents. For example, **new_lastname.csv** or **groups_2022_newsessision.csv**.
## Working with the program

After the program has started, you can enter the number of lines that the program will generate.

The CSV file will be created next to the jar file if the path in the command line and the path to the jar file match. Otherwise, the file will be created on the path specified in the command line.

It will be best if the entered number is between *1* and *100.000*. 
If the number exceeds *150.000*, then there is a chance that the generation will take some time.

## Errors that occur when working with the program

Errors can occur if:
- Instead of numbers, letters were written at the beginning;
- An empty request was sent for generation;
- There are no files with information nearby.

In case of errors, a message will be displayed explaining why the generation was interrupted.

#### Note:
If you want to run the program through the IDE, then you need to uncomment the specified code fragment in the ReadCSV file. And put your test csv files in the resource folder.
