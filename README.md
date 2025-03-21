# SPASM
A simple pseudo ASM emulator based on specific specifications.

High-Level programming languages like Java must be translated into a low level assembly language (ASM) in order to be executed by the underlying computational hardware.

ASM syntax consists of only three types: opcodes, registers, and literal values.

The opcode refers to the instruction that the processor must perform.

Registers represent the available storage.

Literal values are the integer numbers.

This is a simple ASM emulator with the following specifications: 

Four static integer fields:
1. eax: General purpose 32-bit storage for integer value. (Extended accumulator register)
2. ebx: General purpose 32-bit storage for integer value. (Extended base register)
3. ecx: General purpose 32-bit storage for integer value. (Extended counter register)
4. edx: General purpose 32-bit storage for integer value. (Extended data register)

Opcodes are represented in this emulator with static methods.

The call opcode in assembly invokes procedures (i.e methods). This emulator has a "PRINT" method that uses System.out to display the contents of a register. 

As an example: 

MOV ecx 3
MOV ebx 5
CALL PRINT eax

This as input would output [eax]: 8

After if we used IMUL, it would multiply it by whatever literal value we use.

CMP would compare to see if two values are equal. 1 representing true, 0 representing false.