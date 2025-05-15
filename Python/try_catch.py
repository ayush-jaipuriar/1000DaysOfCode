# exception_handling_examples.py

# Hey Bro! Let's dive into Python Exception Handling.
# This stuff is your safety net. When your code hits a snag,
# instead of crashing and burning, it can handle the problem gracefully.
# We'll cover try, except, else, and finally.

# ---------------------------------------------------------------------------
# Example 1: Basic try-except for NameError
# A NameError occurs when you try to use a variable that hasn't been defined yet.
# ---------------------------------------------------------------------------
print("--- Example 1: NameError ---")
try:
    # This line will cause a NameError because 'undefined_variable' doesn't exist.
    print("Trying to access an undefined variable...")
    result = undefined_variable
    print(f"Result: {result}") # This line won't be reached
except NameError as e:
    # This block executes if a NameError occurs in the try block.
    # 'e' is the exception object, containing details about the error.
    print(f"Oops! A NameError occurred: {e}")
    print("Looks like you tried to use a variable that wasn't defined, my dude.")
print("Example 1 finished.\n")

# ---------------------------------------------------------------------------
# Example 2: Basic try-except for ZeroDivisionError
# A ZeroDivisionError occurs when you try to divide a number by zero.
# ---------------------------------------------------------------------------
print("--- Example 2: ZeroDivisionError ---")
numerator = 10
denominator = 0
try:
    print(f"Trying to divide {numerator} by {denominator}...")
    result = numerator / denominator
    print(f"Result: {result}") # This line won't be reached
except ZeroDivisionError as e:
    # This block executes if a ZeroDivisionError occurs.
    print(f"Woah there! A ZeroDivisionError occurred: {e}")
    print("You can't divide by zero, man. That's like, math rule #1.")
print("Example 2 finished.\n")

# ---------------------------------------------------------------------------
# Example 3: Basic try-except for ValueError
# A ValueError occurs when a function receives an argument of the correct type
# but an inappropriate value. e.g., trying to convert 'abc' to an integer.
# ---------------------------------------------------------------------------
print("--- Example 3: ValueError ---")
invalid_number_string = "not_a_number"
try:
    print(f"Trying to convert '{invalid_number_string}' to an integer...")
    number = int(invalid_number_string)
    print(f"Converted number: {number}") # This line won't be reached
except ValueError as e:
    # This block executes if a ValueError occurs.
    print(f"Hold up! A ValueError occurred: {e}")
    print(f"The string '{invalid_number_string}' isn't a valid number, bro.")
print("Example 3 finished.\n")

# ---------------------------------------------------------------------------
# Example 4: Handling multiple specific exceptions with multiple except blocks
# Sometimes, a block of code can raise different types of exceptions.
# ---------------------------------------------------------------------------
print("--- Example 4: Multiple Specific Exceptions ---")
def process_input(value):
    try:
        print(f"Processing value: {value}")
        number = int(value) # Potential ValueError
        result = 100 / number # Potential ZeroDivisionError
        print(f"Result of 100 / {number} is {result}")
    except ValueError:
        # Handles only ValueError
        print("Invalid input! Please enter a whole number, my friend.")
    except ZeroDivisionError:
        # Handles only ZeroDivisionError
        print("Can't divide by zero! Pick a non-zero number.")
    except TypeError as e:
        # Handles TypeError if 'value' isn't suitable for int() e.g. if it was None
        print(f"Type error detected: {e}. Input must be a string representing a number.")

process_input("20")      # Successful case
process_input("abc")     # Triggers ValueError
process_input("0")       # Triggers ZeroDivisionError
process_input(None)      # Triggers TypeError (int(None) raises TypeError)
print("Example 4 finished.\n")

# ---------------------------------------------------------------------------
# Example 5: Catching multiple exceptions with a single except block (using a tuple)
# If you want to handle several exception types in the exact same way.
# ---------------------------------------------------------------------------
print("--- Example 5: Catching Multiple Exceptions in One Block ---")
def combined_handler(value):
    try:
        print(f"Processing value with combined handler: {value}")
        number = int(value)
        result = 100 / number
        print(f"Result is {result}")
    except (ValueError, ZeroDivisionError) as e:
        # Handles both ValueError and ZeroDivisionError the same way.
        print(f"An issue occurred: {e}. Make sure you enter a valid, non-zero number.")

combined_handler("50")
combined_handler("xyz")
combined_handler("0")
print("Example 5 finished.\n")

# ---------------------------------------------------------------------------
# Example 6: Using the generic `Exception` class
# This catches any exception that inherits from the base `Exception` class.
# It's a good idea to put this *after* more specific handlers.
# ---------------------------------------------------------------------------
print("--- Example 6: Generic Exception ---")
def generic_exception_example(data):
    try:
        print(f"Trying a risky operation with: {data}")
        # Let's simulate something that could go wrong in many ways
        length_of_data = len(data) # Could be TypeError if data has no len()
        item = data[5]             # Could be IndexError if data is too short
        number = int(item)         # Could be ValueError or TypeError
        result = 100 / number      # Could be ZeroDivisionError
        print(f"Result: {result}")
    except ValueError:
        print("Caught a ValueError specifically.")
    except IndexError as e:
        print(f"Caught an IndexError: {e}")
    except Exception as e: # This is the generic catch-all
        # This will catch any other exception not caught by the above.
        # For example, TypeError if data was an int, or ZeroDivisionError if item was '0'.
        print(f"An unexpected error occurred: {type(e).__name__} - {e}")
        print("This is the generic handler kicking in. Better to be specific if you can!")

generic_exception_example("123456") # Might work if data[5] is a non-zero digit string
generic_exception_example("123")    # Will cause IndexError
generic_exception_example([1, 2, 3, 4, 5, '0']) # Will cause ZeroDivisionError, caught by generic
generic_exception_example(12345)    # Will cause TypeError (len() on int), caught by generic
print("Example 6 finished.\n")

# ---------------------------------------------------------------------------
# Example 7: `else` block
# The `else` block executes ONLY IF the `try` block completes without any exceptions.
# ---------------------------------------------------------------------------
print("--- Example 7: else Block ---")
def divide_with_else(num, den):
    try:
        print(f"Attempting {num}/{den}...")
        result = num / den
    except ZeroDivisionError:
        print("Error: Cannot divide by zero.")
    else:
        # This runs if no exception occurred in the try block.
        print(f"Division successful! The result is {result}.")
        print("The 'else' block says: 'All clear!'")

divide_with_else(10, 2)  # Successful, else block runs
divide_with_else(10, 0)  # Fails, else block does not run
print("Example 7 finished.\n")

# ---------------------------------------------------------------------------
# Example 8: `finally` block
# The `finally` block ALWAYS executes, whether an exception occurred or not.
# Ideal for cleanup operations like closing files or network connections.
# ---------------------------------------------------------------------------
print("--- Example 8: finally Block ---")
def example_with_finally(val):
    try:
        print(f"Trying operation with {val}...")
        num = int(val)
        result = 10 / num
        print(f"Result: {result}")
        # return result # Even with a return, finally executes!
    except ValueError:
        print("ValueError: Could not convert to number.")
    except ZeroDivisionError:
        print("ZeroDivisionError: Cannot divide by zero.")
    finally:
        # This block always runs.
        print("The 'finally' block says: 'I always run, no matter what!' This is for cleanup.")

example_with_finally("5")   # Success
example_with_finally("0")   # ZeroDivisionError
example_with_finally("abc") # ValueError
# If there was an unhandled exception, finally would still run before the program crashes.
print("Example 8 finished.\n")

# ---------------------------------------------------------------------------
# Example 9: Combining `try`, `except`, `else`, and `finally`
# This shows the full flow.
# ---------------------------------------------------------------------------
print("--- Example 9: try-except-else-finally Combo ---")
def full_flow_example(num_str, den_str):
    print(f"\nProcessing inputs: numerator='{num_str}', denominator='{den_str}'")
    try:
        print("Inside TRY block...")
        numerator = int(num_str)     # Potential ValueError
        denominator = int(den_str)   # Potential ValueError
        result = numerator / denominator # Potential ZeroDivisionError
    except ValueError:
        print("Inside EXCEPT (ValueError) block: Invalid input, please provide numbers.")
    except ZeroDivisionError:
        print("Inside EXCEPT (ZeroDivisionError) block: Denominator cannot be zero.")
    except Exception as e: # A more general catch, just in case
        print(f"Inside EXCEPT (Generic) block: An unexpected error occurred: {e}")
    else:
        # Executes if TRY block is successful (no exceptions)
        print("Inside ELSE block: Operation successful!")
        print(f"The result of {numerator} / {denominator} is {result}")
    finally:
        # ALWAYS executes
        print("Inside FINALLY block: This concludes the operation attempt.")

full_flow_example("100", "20") # Success: try -> else -> finally
full_flow_example("100", "0")  # ZeroDivisionError: try -> except (ZeroDivisionError) -> finally
full_flow_example("hundred", "20") # ValueError: try -> except (ValueError) -> finally
full_flow_example("20", None) # TypeError from int(None), caught by generic Exception: try -> except (Generic) -> finally
print("Example 9 finished.\n")

# ---------------------------------------------------------------------------
# Example 10: File handling with try-except-finally
# This is a classic use case for `finally` - ensuring a file is closed.
# ---------------------------------------------------------------------------
print("--- Example 10: File Handling ---")
file_path_exists = "temp_example_file.txt"
file_path_non_existent = "non_existent_file.txt"

# Create a dummy file for the successful case
with open(file_path_exists, "w") as f:
    f.write("Hello from your bro, Gemini!\nThis is a test file.")

def read_file_safely(filepath):
    file = None # Initialize file variable outside try, so it's accessible in finally
    try:
        print(f"\nAttempting to open and read file: {filepath}")
        file = open(filepath, "r") # Potential FileNotFoundError, or other IOErrors
        content = file.read()
        print("File content:")
        print(content)
    except FileNotFoundError:
        print(f"Error: The file '{filepath}' was not found. Can't read it, chief.")
    except IOError as e: # Catches other I/O related errors like permission issues
        print(f"An IOError occurred: {e}")
    except Exception as e:
        print(f"An unexpected error occurred while handling the file: {e}")
    else:
        # Runs if the file was successfully opened and read
        print("File read successfully, no issues!")
    finally:
        # This block ensures the file is closed if it was opened.
        if file and not file.closed: # Check if 'file' was assigned and is not already closed
            print(f"Closing the file '{filepath}' in the 'finally' block.")
            file.close()
        elif file and file.closed:
            print(f"File '{filepath}' was already closed or handled by 'with open()'.")
        else:
            print(f"No file object to close for '{filepath}' (it likely wasn't opened).")
        print("File handling attempt finished.")

read_file_safely(file_path_exists)       # Should succeed
read_file_safely(file_path_non_existent) # Should trigger FileNotFoundError

# It's often better to use the 'with' statement for files, as it handles closing automatically.
# But this example shows how 'finally' can be used for such cleanup.
print("\n--- Using 'with' statement for safer file handling (recommended way) ---")
try:
    with open(file_path_exists, "r") as f: # 'with' handles opening and closing
        print(f"\nReading '{file_path_exists}' using 'with' statement...")
        content = f.read()
        print("File content:")
        print(content)
        # Simulate another error after successful read but before 'with' closes the file
        # 10/0 # This would cause ZeroDivisionError, but 'with' still ensures file is closed
    print("'with' statement automatically closed the file.")
except FileNotFoundError:
    print(f"Error: The file '{file_path_exists}' was not found with 'with'.")
except ZeroDivisionError:
    print("A ZeroDivisionError occurred inside the 'with' block for 'file_path_exists'. File still closed.")
except Exception as e:
    print(f"An unexpected error with 'with' statement: {e}")

try:
    with open(file_path_non_existent, "r") as f:
        print(f"\nReading '{file_path_non_existent}' using 'with' statement...")
        content = f.read() # This line won't be reached
except FileNotFoundError:
    print(f"\nError: The file '{file_path_non_existent}' was not found (handled by 'with' example).")
    print("'with' statement ensures no dangling file handles even on error.")

print("Example 10 finished.\n")


# ---------------------------------------------------------------------------
# Example 11: Raising your own exceptions (or re-raising)
# Sometimes you want to signal an error condition yourself.
# The video doesn't explicitly cover this, but it's related.
# ---------------------------------------------------------------------------
print("--- Example 11: Raising Exceptions ---")
def check_age_for_club(age):
    try:
        print(f"Checking age: {age}")
        if not isinstance(age, int):
            # Raise a TypeError if age is not an integer.
            raise TypeError("Age must be an integer, dawg.")
        if age < 18:
            # Raise a ValueError for a business rule violation.
            raise ValueError("Sorry, too young for the club, little bro.")
        elif age > 99:
            raise ValueError("Whoa, respect to the elders, but this might be a typo?")
        else:
            print("Welcome to the club! Have a good time.")
    except TypeError as e:
        print(f"Error processing age: {e}")
    except ValueError as e:
        print(f"Age restriction issue: {e}")
    finally:
        print("Age check complete.")

check_age_for_club(25)
check_age_for_club(16)
check_age_for_club("old enough") # Triggers TypeError
check_age_for_club(101)
print("Example 11 finished.\n")

# ---------------------------------------------------------------------------
# Example 12: Nested Try-Except Blocks
# You can have try-except blocks inside other try or except blocks.
# Useful for handling errors at different levels of an operation.
# ---------------------------------------------------------------------------
print("--- Example 12: Nested Try-Except ---")
def nested_example(outer_data, inner_data_idx):
    print(f"\nOuter processing for data: {outer_data}")
    try:
        # Outer try block
        selected_inner_dict = outer_data[inner_data_idx] # Potential IndexError or TypeError if outer_data isn't list/dict like
        print(f"Selected inner dictionary: {selected_inner_dict}")

        try:
            # Inner try block
            value = selected_inner_dict['key_that_might_not_exist'] # Potential KeyError
            number = int(value) # Potential ValueError
            print(f"Processed inner value: {number}")
        except KeyError:
            print("Inner Error: 'key_that_might_not_exist' not found in the inner dictionary.")
        except ValueError:
            print(f"Inner Error: Could not convert value '{selected_inner_dict.get('key_that_might_not_exist')}' to an integer.")
        else:
            print("Inner processing successful.")
        finally:
            print("Inner 'finally' block executed.")

    except IndexError:
        print(f"Outer Error: Index {inner_data_idx} is out of bounds for the provided data.")
    except TypeError:
        print("Outer Error: The provided data structure is not indexable or not what was expected.")
    except Exception as e:
        print(f"Outer Error: An unexpected error occurred: {e}")
    else:
        print("Outer processing (including inner attempts) completed without outer exceptions.")
    finally:
        print("Outer 'finally' block executed.")

data_list = [
    {'key_that_might_not_exist': "123"},
    {'key_that_might_not_exist': "abc"},
    {'another_key': "789"}
]

nested_example(data_list, 0)  # Inner success
nested_example(data_list, 1)  # Inner ValueError
nested_example(data_list, 2)  # Inner KeyError
nested_example(data_list, 5)  # Outer IndexError
nested_example("not_a_list", 0) # Outer TypeError

print("Example 12 finished.\n")

print("All examples covered! Hope this helps you master exception handling, bro!")
print("Remember, handling errors gracefully makes your programs way more robust and user-friendly.")