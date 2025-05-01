#!/usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Python Loops Tutorial - A Bro's Guide

This file covers the basics of Python loops (`for`, `while`),
loop control statements (`break`, `continue`, `pass`), nested loops,
and the `else` clause with loops.

Run this file directly (e.g., `python python_loops_tutorial.py`)
to see the output for each example.
"""

print("Alright bro, let's break down Python loops!")
print("="*50 + "\n")

# ===========================================
# 1. The `for` Loop: Your Go-To Iterator
# ===========================================
# Think of the `for` loop for stepping through sequences like lists, strings, or ranges.
# The `range()` function is its best buddy for number sequences.

# --- Example 1: Basic `for` loop with `range(stop)` ---
print("--- Example 1: Basic range(stop) ---")
# `range(5)` gives numbers from 0 up to (but NOT including) 5. So, 0, 1, 2, 3, 4.
print("Looping from 0 up to 5 (exclusive):")
for i in range(5):
  print(f"Current number (i): {i}")
print("Loop finished!\n")

print("="*50 + "\n")

# --- Example 2: `for` loop with `range(start, stop)` ---
print("--- Example 2: range(start, stop) ---")
# Let's print numbers from 1 up to (but not including) 6.
print("Looping from 1 up to 6 (exclusive):")
for number in range(1, 6):
  print(f"Counting: {number}")
print("Done counting!\n")

print("="*50 + "\n")

# --- Example 3: `for` loop with `range(start, stop, step)` ---
print("--- Example 3: range(start, stop, step) ---")
# Let's print odd numbers between 1 and 10. Start=1, Stop<10, Step=2.
print("Looping from 1 to 10, step 2 (odd numbers):")
for odd_num in range(1, 10, 2):
  print(f"Odd number found: {odd_num}")
print("That's all the odd ones!\n")

print("="*50 + "\n")

# --- Example 4: `for` loop with negative step (Countdown!) ---
print("--- Example 4: range() with negative step ---")
# Count down from 10 to 1. Start=10, Stop>0 (so includes 1), Step=-1.
print("Countdown from 10 to 1:")
for countdown in range(10, 0, -1):
  print(f"T-minus {countdown}...")
print("Blast off! (Or maybe just loop finished)\n")

print("="*50 + "\n")

# --- Example 5: Iterating over a String ---
print("--- Example 5: Looping through a String ---")
# Strings are sequences of characters. `for` loops handle them easily.
my_name = "Brogrammer"
print(f"Spelling out '{my_name}':")
for char in my_name:
  print(f"Character: {char}")
print("Spelled out!\n")

print("="*50 + "\n")

# --- Example 6: Iterating over a List ---
print("--- Example 6: Looping through a List ---")
# Crucial for interviews! Looping through lists, tuples, etc.
skills_to_master = ["Striver SDE Sheet", "System Design", "Java Microservices", "Langchain", "GCP"]
print("Your Hit List:")
for skill in skills_to_master:
  print(f"- {skill}")
print("Gotta crush 'em all!\n")

print("="*50 + "\n")

# ===========================================
# 2. The `while` Loop: The Conditional Repeater
# ===========================================
# Keeps looping *as long as* a condition is True.
# WARNING: Make sure the condition eventually becomes False, or you get an INFINITE LOOP!

# --- Example 7: Basic `while` loop with a counter ---
print("--- Example 7: Basic while loop ---")
# Replicating the 0-4 count using `while`.
print("Counting 0 to 4 using 'while':")
count = 0  # 1. Initialize BEFORE the loop
while count < 5:  # 2. Check the condition
  print(f"While count is: {count}")
  count = count + 1  # 3. IMPORTANT: Update the variable inside the loop!
  # Shorter way: count += 1
print("While loop finished!\n")

print("="*50 + "\n")

# --- Example 8: `while` loop for input validation ---
# NOTE: This part requires you to type input in the terminal when you run the script.
print("--- Example 8: While loop for input ---")
print("Enter commands below. Type 'quit' to exit.")
# command = "" # Initialize command
# # Use a 'while True' loop with an internal 'break' for cleaner input loops sometimes
# while True:
#     command = input("Enter a command (or 'quit' to exit): ")
#     print(f"You entered: {command}")
#     if command.lower() == "quit":
#         break # Exit the loop if user types 'quit'
#     else:
#         # Add other command processing here if needed
#         print("Okay, waiting for the next command...")

# print("Exiting the command loop. Later, bro!\n")
# Commenting out the interactive part so the script runs fully without stopping.
# You can uncomment the block above (lines 101-110) to try it interactively.
print("(Example 8 involving user input is commented out for non-interactive run)")
print("Imagine asking for input until 'quit' is typed.\n")


print("="*50 + "\n")

# ===========================================
# 3. Loop Control Statements: Changing the Flow
# ===========================================
# `break`: Exit the loop immediately.
# `continue`: Skip the rest of the current iteration, go to the next.
# `pass`: Do nothing (placeholder).

# --- Example 9: Using `break` to find an item ---
print("--- Example 9: Using break ---")
target = 5
print(f"Searching for {target} in numbers 0 to 9...")
for i in range(10):
  print(f"Checking {i}...")
  if i == target:
    print(f"Found {target}! Breaking the loop.")
    break  # Wham! Exit the loop right now.
print("Loop has ended (either completed or broke early).\n")

print("="*50 + "\n")

# --- Example 10: Using `continue` to skip even numbers ---
print("--- Example 10: Using continue ---")
# Print only odd numbers from 0 to 9.
print("Printing odd numbers from 0 to 9:")
for i in range(10):
  # If the number is even...
  if i % 2 == 0:
    # ...skip the rest of this iteration and jump to the next value of i.
    continue
  # This line only runs if 'continue' wasn't hit (i.e., the number is odd).
  print(f"Odd number: {i}")
print("Finished checking numbers.\n")

print("="*50 + "\n")

# --- Example 11: Using `pass` as a placeholder ---
print("--- Example 11: Using pass ---")
# `pass` is useful when syntax needs a statement, but you want to do nothing (yet).
print("Processing numbers, using 'pass' for zero:")
numbers = [1, 2, -3, 0, 4, -5, 6]
for num in numbers:
  if num > 0:
    print(f"Processing positive number: {num}")
    # ... complex logic might go here ...
  elif num == 0:
    # We need a statement here, but don't want to do anything for zero yet.
    pass # So we use pass. It does nothing.
  else:
    print(f"Handling negative number: {num} (maybe log it)")
    # ... other logic ...
print("Processing complete.\n")

print("="*50 + "\n")

# ===========================================
# 4. Nested Loops: Loops Inside Loops
# ===========================================
# For each iteration of the outer loop, the inner loop runs completely.

# --- Example 12: Basic Nested Loop (Coordinates) ---
print("--- Example 12: Nested Loops ---")
print("Generating coordinate pairs (i, j):")
# Outer loop (e.g., rows)
for i in range(3):  # i will be 0, 1, 2
  # Inner loop (e.g., columns)
  for j in range(2):  # j will be 0, 1 for EACH value of i
    print(f"Coordinates: (i={i}, j={j})")
  print(f"--- End of inner loop for i={i} ---") # Helps visualize flow
print("Nested loops complete.\n")

print("="*50 + "\n")

# --- Example 13: Printing a Simple Pattern ---
print("--- Example 13: Nested Loop Pattern ---")
# Nested loops are classic for creating patterns.
rows = 5
print(f"Printing a triangle with {rows} rows:")
for i in range(1, rows + 1):  # Outer loop: controls rows (1 to 5)
    # Inner loop: prints '*' 'i' times for the current row
    for j in range(i):
        # `end=""` tells print NOT to add a newline, so stars stay on the same line
        print("*", end="")
    # After the inner loop finishes for a row, print a newline to move to the next row
    print()
print("Triangle pattern done.\n")

print("="*50 + "\n")

# ===========================================
# 5. Bonus: `else` Clause on Loops
# ===========================================
# The `else` block after a loop runs ONLY if the loop finished normally
# (i.e., wasn't terminated by a `break`).

# --- Example 14: `for...else` ---
print("--- Example 14: for...else ---")
numbers_to_search = [1, 3, 7, 9]
target_to_find = 5
print(f"Searching for {target_to_find} in {numbers_to_search}")

for num in numbers_to_search:
    print(f"Checking {num}...")
    if num == target_to_find:
        print(f"Found {target_to_find}! Breaking.")
        break # Loop terminates early
else:
    # This runs ONLY because the loop finished WITHOUT hitting 'break'.
    print(f"{target_to_find} was not found in the list.")
print("Search concluded.\n")

# --- Second run, where target is found ---
target_to_find = 7
print(f"Searching for {target_to_find} in {numbers_to_search}")
for num in numbers_to_search:
    print(f"Checking {num}...")
    if num == target_to_find:
        print(f"Found {target_to_find}! Breaking.")
        break # Loop terminates early due to 'break'
else:
    # This block will NOT run this time because 'break' was executed.
    print(f"{target_to_find} was not found in the list.")
print("Search concluded.\n")


print("="*50)
print("Loop tutorial finished! Keep practicing this stuff, bro.")
print("Understanding loops inside-out is key for coding challenges and real-world dev work.")
print("You got this!")
print("="*50)