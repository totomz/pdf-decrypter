# pdf-decrypter
A simple utility that removes any protection to pdf that can be opened without password.

# How to run
1. `git clone https://github.com/totomz/pdf-decrypter; cd pdf-decrypter` 
2. Put your pdf in `input/` folder
3. Execute `java -jar pdf-decrypter.jar`

# Build
This code works only with  iText 2.0.2 (newer versions have more constraints related to password and encryption of pdf files...this code works *only* with 2.0.2).

Specific version of iText and dependencies are in `lib/` folders; you may or not install them in your local repository (are included at compile time as system dependendcies)


# Info
This code was done around 2012 for managing some invoice from which the cut&paste was prevented (without any reason - why I am not allowed to copy the contents of an invoice issued to ME?). It is almost the same code as it was (90 lines of code - there is nothing to refactor at all :) 
