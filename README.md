example

    instruction: L M L M Ln M L M M
    Start: 1, 2 N
    L => 1 2 W
    M => 0 2 W
    L => 0 2 S
    M => 0 1 S
    L => 0 1 E
    M => 1 1 E
    L => 1 1 N
    M => 1 2 N
    M => 1 3 N



Instruction

    5 5 => size x y env
    1 2 N => Position rover x , y
    LMLMLMLMLM => Instruction for previous rover


Representation

                            N
                          W-|-E
                            S

        Y
        |
        |
        |
        |
        |
        |
        |
     0,0----------------------- X


Edge Cases / Errors

    When their is no file 
    When the rover reach plateau limit
    When the instruction is invalid when parsed

Launching
    
    pathToJava17\bin\java.exe -jar .\rover-1.0-SNAPSHOT.jar ..\input.txt
