# Kiwiland Repository

**How to use the program**:
 1. Clone/Fork this repository.
 2. Go to the releases folder.
 3. Open a command line on the folder.
 4. Execute either of those lines:
  ```
  java - jar Kiwiland_v1.jar
  ```
  or
  ```
  java jar Kiwiland_v1.jar -d "data_input" -p "paths_input"
  ```
 
 **Arguments**
 
 The format of the arguments must follow these rules:
  - The data argument must be a string of nodes. Each node must contain two characters representing the startinc city, and the ending city,
    and a positive integer number. The nodes must be separated by commas. This is an example of a valid data argument:
    ```
    -d "AE5, BC20, CG6, GB11, AG9"
    ```
  - The paths argument must be a string of sequenced characters, separated by dashes. Here is an example of a valid paths argument:
    ```
    -p "A-E-B, Z-J-X"
    ```
If *NO ARGUMENTS* are provided, the program will execute the code using the default test arguments provided on the exercice description.

**Program returns**
When a valid invocation of the jar is done, the program will return the numeric value representing the sum of all the ninimum paths for
each given route. In case no route exists that connect the given edges, the program will return "NO SUCH ROUTE".
