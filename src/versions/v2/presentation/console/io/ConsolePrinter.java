package versions.v2.presentation.console.io;

public class ConsolePrinter {

    public void print(String message) {
        System.out.print(message);
    }

    public void println(String message) {
        System.out.println(message);
    }

    public void blankLine() {
        System.out.println();
    }

    public void separator() {
        System.out.println("--------------------------------------------------");
    }

    public void separator(char symbol) {
        System.out.println(String.valueOf(symbol).repeat(50));
    }

    public void header(String title) {

        separator('=');

        println(title.toUpperCase());

        separator('=');

    }

    public void success(String message) {
        println("[SUCCESS] " + message);
    }

    public void error(String message) {
        println("[ERROR] " + message);
    }

    public void warning(String message) {
        println("[WARNING] " + message);
    }

    public void info(String message) {
        println("[INFO] " + message);
    }

}
/*
Code
public void separator(char symbol) {
    System.out.println(String.valueOf(symbol).repeat(50));
}

Chalo isko engineer ki tarah todte hain.

Step 1

Method

public void separator(char symbol)

Question.

Ye method kya expect karta hai?

Ek

char

Not

String

Example

'-'

Ya

'='

Ya

'*'

Single character.

Step 2

Inside

String.valueOf(symbol)

Question.

symbol kya hai?

Example

'-'

Type?

char

Lekin

repeat()

kispe available hai?

String

Not

char

To pehle

'-'

ko

"-"

me convert karte hain.

Example

char symbol = '-';

After

String.valueOf(symbol)

Result

"-"
Step 3

Now

.repeat(50)

Question.

Ye kya karega?

"-".repeat(50)

Result

--------------------------------------------------

50 times.

Same.

"*".repeat(50)

Result

**************************************************
Step 4

Finally

System.out.println(...)

Print karega.

Output

==================================================

Ya

--------------------------------------------------

Depends.

Why didn't we write this?
System.out.println("--------------------------------");

Good question.

Kyunki

phir

sirf

------

hi print hoga.

Reusable nahi.

Humne reusable banaya.

Example.

printer.separator('-');

Output

--------------------------------------------------

Example

printer.separator('=');

Output

==================================================

Example

printer.separator('*');

Output

**************************************************

Same method.

Different output.
 */