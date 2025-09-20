#!/usr/bin/env python3
\"\"\"Simple Interactive Calculator (calculator.py)

Usage: run `python calculator.py` in your terminal.

Features:
- Addition, subtraction, multiplication, division, power, modulo
- Input validation and division-by-zero handling
- Looping menu (choose operations until you quit)
- Accepts floats and ints
\"\"\"

def get_number(prompt):
    \"\"\"Read a number from input; keep asking until valid.\"\"\"
    while True:
        value = input(prompt).strip()
        if value.lower() in ('q', 'quit', 'exit'):
            return None
        try:
            # allow integers and floats
            if '.' in value:
                return float(value)
            return int(value)
        except ValueError:
            print(\"Invalid number. Type a number (or 'q' to cancel).\")


def calculator():
    print(\"Simple Calculator — type 'q' at any prompt to quit/cancel a step.\")
    operations = {
        '+': 'Addition',
        '-': 'Subtraction',
        '*': 'Multiplication',
        '/': 'Division',
        '^': 'Power (a ^ b -> a**b)',
        '%': 'Modulo'
    }

    while True:
        print(\"\\nAvailable operations:\")
        for op, desc in operations.items():
            print(f\"  {op} : {desc}\")
        print(\"  help : Show this menu\")
        print(\"  exit : Quit the calculator\")

        op = input(\"\\nChoose an operation: \").strip().lower()
        if op in ('exit', 'quit', 'q'):
            print(\"Goodbye!\")
            break
        if op == 'help' or op == 'h':
            continue
        if op not in operations:
            print(\"Unknown operation — type 'help' to see available operations.\")
            continue

        a = get_number(\"Enter the first number: \")
        if a is None:
            print(\"Cancelled. Back to menu.\")
            continue
        b = get_number(\"Enter the second number: \")
        if b is None:
            print(\"Cancelled. Back to menu.\")
            continue

        try:
            if op == '+':
                result = a + b
            elif op == '-':
                result = a - b
            elif op == '*':
                result = a * b
            elif op == '/':
                if b == 0:
                    print(\"Error: Division by zero is not allowed.\")
                    continue
                result = a / b
            elif op == '^':
                result = a ** b
            elif op == '%':
                result = a % b
            else:
                print(\"Operation not implemented.\")
                continue

            print(f\"Result: {a} {op} {b} = {result}\")
        except Exception as e:
            print(f\"An error occurred: {e}\")


if __name__ == '__main__':
    try:
        calculator()
    except KeyboardInterrupt:
        print(\"\\nInterrupted. Bye!\")
