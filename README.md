# pdf-decrypter
A very simple test utility that remove any protection to pdf that can be opened.

# How to run
Clone this repository, put your encrypted pdf in the input folder and run `java -jar pdf-decrypter-1.0-SNAPSHOT.jar`

# Build
This code leverage on iText 2.0.2 (newer versions have more constraints related to password and encryption of pdf files...this code works *only* with 2.0.2).

Specific version of iText and dependencies are in `lib/` folders; you may or not install them in your local repository.  