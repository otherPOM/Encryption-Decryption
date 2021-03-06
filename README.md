# Encryption-Decryption https://hyperskill.org/projects/46
## Stage 1
For the first stage, you need to manually encrypt the message "**we found a treasure!**" and print only the ciphertext (in lower case)

## Stage 2
Write a program that reads an English message and an integer number (key) from the standard input and shifts each letter by the specified number according to its order in the alphabet. If you reach the end of the alphabet, start back at the beginning (a follows z).

## Stage 3
In this stage, you need to support decryption in your program. The decryption is simply the inverse of encryption, following the same steps but reversing the order in which the keys are applied.

## Stage 4
Modify the previous program to work with command-line arguments instead of the standard input. The program must parse three arguments: **-mode**, **-key** and **-data**. The first argument should determine the program’s mode (**enc** for encryption, **dec** for decryption). The second argument is an integer key to modify the message, and the third argument is a text or ciphertext to encrypt or decrypt.

## Stage 5
At this stage, you need to add the ability to read and write original and cipher data to files. The program must parse two additional arguments -in and -out to specify the full name of a file to read data and to write the result. Arguments -mode, -key, and -data should still work as before.

## Stage 6
Extend your program by adding different algorithms to encode/decode data. The first one would be shifting algorithm (it shifts each letter by the specified number according to its order in the alphabet in circle). The second one would be based on Unicode table, like in the previous stage.