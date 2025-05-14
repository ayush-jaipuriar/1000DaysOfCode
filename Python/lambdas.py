# Hey there, bro! Let's get into the nitty-gritty of Lambda functions in Python.
# Lambda functions are also known as anonymous functions. "Anonymous" because they don't have a proper name like functions defined using 'def'.
# They are small, restricted to a single expression, and super useful for short, simple operations.

# Syntax: lambda arguments: expression
# - 'lambda' is the keyword.
# - 'arguments' are the parameters the function takes (can be zero, one, or more).
# - 'expression' is a single expression that is evaluated and returned.

# Why use them?
# 1. For short, throwaway functions.
# 2. When you need a simple function for a short period, often as an argument to higher-order functions like map(), filter(), sorted(), etc.
# 3. They can make your code more concise in certain situations.

# Let's dive into a bunch of examples!

# --- Basic Arithmetic Operations ---

# Example 1: Adding two numbers
print("--- Example 1: Adding two numbers ---")
# Using a regular function
def add_regular(a, b):
    return a + b
print(f"Regular add function (5, 3): {add_regular(5, 3)}")

# Using a lambda function
add_lambda = lambda a, b: a + b
print(f"Lambda add function (5, 3): {add_lambda(5, 3)}")
# You can even call it directly (though less common for simple assignment)
print(f"Lambda add function directly (10, 7): {(lambda a, b: a + b)(10, 7)}")
print("-" * 30)

# Example 2: Multiplying two numbers
print("--- Example 2: Multiplying two numbers ---")
multiply_lambda = lambda x, y: x * y
print(f"Lambda multiply (4, 6): {multiply_lambda(4, 6)}")
print("-" * 30)

# Example 3: Squaring a number
print("--- Example 3: Squaring a number ---")
square_lambda = lambda x: x * x
print(f"Lambda square (7): {square_lambda(7)}")
print("-" * 30)

# Example 4: Division
print("--- Example 4: Division ---")
divide_lambda = lambda x, y: x / y if y != 0 else "Cannot divide by zero" # Adding a check
print(f"Lambda divide (10, 2): {divide_lambda(10, 2)}")
print(f"Lambda divide (10, 0): {divide_lambda(10, 0)}")
print("-" * 30)

# --- String Manipulations ---

# Example 5: Concatenating two strings
print("--- Example 5: Concatenating two strings ---")
concat_lambda = lambda s1, s2: s1 + " " + s2
print(f"Lambda concatenate ('Hello', 'World'): {concat_lambda('Hello', 'World')}")
print("-" * 30)

# Example 6: Convert string to uppercase
print("--- Example 6: Convert string to uppercase ---")
uppercase_lambda = lambda s: s.upper()
print(f"Lambda uppercase ('python'): {uppercase_lambda('python')}")
print("-" * 30)

# Example 7: Get the length of a string
print("--- Example 7: Get the length of a string ---")
len_lambda = lambda s: len(s)
print(f"Lambda string length ('lambda functions'): {len_lambda('lambda functions')}")
print("-" * 30)

# Example 8: Reversing a string
print("--- Example 8: Reversing a string ---")
reverse_string_lambda = lambda s: s[::-1] # Using slicing
print(f"Lambda reverse string ('madam'): {reverse_string_lambda('madam')}")
print("-" * 30)

# --- Lambdas with Conditional Expressions ---
# The structure is: result_if_true if condition else result_if_false

# Example 9: Check if a number is even
print("--- Example 9: Check if a number is even ---")
# Using a regular function
def is_even_regular(num):
    if num % 2 == 0:
        return True
    else:
        return False
print(f"Regular is_even (24): {is_even_regular(24)}")

# Using a lambda function
is_even_lambda = lambda num: True if num % 2 == 0 else False
# Or even more concisely for booleans:
is_even_lambda_concise = lambda num: num % 2 == 0
print(f"Lambda is_even (24): {is_even_lambda(24)}")
print(f"Lambda is_even_concise (24): {is_even_lambda_concise(24)}")
print(f"Lambda is_even (17): {is_even_lambda(17)}")
print("-" * 30)

# Example 10: Return "Positive", "Negative", or "Zero"
print("--- Example 10: Return 'Positive', 'Negative', or 'Zero' ---")
# This gets a bit more complex for a single lambda if you need multiple nested conditions,
# but a simple positive/negative check is doable.
check_sign_lambda = lambda x: "Positive" if x > 0 else ("Negative" if x < 0 else "Zero")
print(f"Lambda check_sign (10): {check_sign_lambda(10)}")
print(f"Lambda check_sign (-5): {check_sign_lambda(-5)}")
print(f"Lambda check_sign (0): {check_sign_lambda(0)}")
print("-" * 30)

# Example 11: Find the maximum of two numbers
print("--- Example 11: Find the maximum of two numbers ---")
max_of_two_lambda = lambda a, b: a if a > b else b
print(f"Lambda max of (10, 20): {max_of_two_lambda(10, 20)}")
print(f"Lambda max of (30, 15): {max_of_two_lambda(30, 15)}")
print("-" * 30)

# --- Lambdas with Multiple Arguments ---

# Example 12: Sum of three numbers (shown in your video transcript)
print("--- Example 12: Sum of three numbers ---")
add_three_lambda = lambda x, y, z: x + y + z
print(f"Lambda add three (12, 13, 14): {add_three_lambda(12, 13, 14)}")
print("-" * 30)

# Example 13: Calculate average of three numbers
print("--- Example 13: Calculate average of three numbers ---")
avg_three_lambda = lambda x, y, z: (x + y + z) / 3
print(f"Lambda average of three (10, 20, 30): {avg_three_lambda(10, 20, 30)}")
print("-" * 30)

# --- Lambdas with No Arguments ---
# Sometimes you might need a function that always returns a constant or performs a fixed action.

# Example 14: Lambda returning a fixed string or number
print("--- Example 14: Lambda with no arguments ---")
get_pi_lambda = lambda: 3.14159
get_greeting_lambda = lambda: "Hello from Lambda!"
print(f"Lambda get_pi: {get_pi_lambda()}")
print(f"Lambda get_greeting: {get_greeting_lambda()}")
print("-" * 30)

# --- Lambdas with Higher-Order Functions: map() ---
# map(function, iterable) applies the function to every item in the iterable.
# map() returns a map object (an iterator), so you often convert it to a list to see the results.

# Example 15: Square all numbers in a list (from your video transcript)
print("--- Example 15: Square all numbers in a list using map() ---")
numbers = [1, 2, 3, 4, 5, 6]
# Using a regular function with map
def regular_square_func(n):
    return n * n
squared_numbers_regular_map = list(map(regular_square_func, numbers))
print(f"Squared with regular function and map: {squared_numbers_regular_map}")

# Using lambda with map
squared_numbers_lambda_map = list(map(lambda x: x * x, numbers))
print(f"Squared with lambda and map: {squared_numbers_lambda_map}")
print("-" * 30)

# Example 16: Convert a list of strings to uppercase using map()
print("--- Example 16: Convert list of strings to uppercase using map() ---")
words = ["apple", "banana", "cherry"]
uppercase_words = list(map(lambda s: s.upper(), words))
print(f"Uppercase words: {uppercase_words}")
print("-" * 30)

# Example 17: Add a constant value to each element in a list using map()
print("--- Example 17: Add constant to list elements using map() ---")
values = [10, 20, 30, 40]
incremented_values = list(map(lambda x: x + 5, values))
print(f"Incremented values: {incremented_values}")
print("-" * 30)

# Example 18: Get lengths of strings in a list using map()
print("--- Example 18: Get lengths of strings in a list using map() ---")
phrases = ["lambda", "is", "cool"]
lengths = list(map(lambda phrase: len(phrase), phrases))
print(f"Lengths of phrases: {lengths}")
print("-" * 30)

# --- Lambdas with Higher-Order Functions: filter() ---
# filter(function, iterable) constructs an iterator from elements of iterable for which function returns true.
# Like map(), filter() returns an iterator.

# Example 19: Filter even numbers from a list
print("--- Example 19: Filter even numbers from a list using filter() ---")
numbers_for_filter = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
# Using a regular function with filter
def is_even_for_filter(n):
    return n % 2 == 0
even_numbers_regular_filter = list(filter(is_even_for_filter, numbers_for_filter))
print(f"Even numbers with regular function and filter: {even_numbers_regular_filter}")

# Using lambda with filter
even_numbers_lambda_filter = list(filter(lambda x: x % 2 == 0, numbers_for_filter))
print(f"Even numbers with lambda and filter: {even_numbers_lambda_filter}")
print("-" * 30)

# Example 20: Filter strings longer than a certain length
print("--- Example 20: Filter strings longer than 5 chars using filter() ---")
words_for_filter = ["python", "java", "c++", "javascript", "go", "swift"]
long_words = list(filter(lambda s: len(s) > 5, words_for_filter))
print(f"Long words (len > 5): {long_words}")
print("-" * 30)

# Example 21: Filter out None values from a list
print("--- Example 21: Filter out None values from a list ---")
mixed_list = [1, None, "hello", 42, None, "world"]
# The `None` object itself evaluates to False in a boolean context.
# So, you can use `lambda x: x is not None` or simply `lambda x: x` if other falsy values are okay to filter.
# For explicit None check:
filtered_list_explicit = list(filter(lambda x: x is not None, mixed_list))
print(f"List with None filtered out (explicit): {filtered_list_explicit}")
# If you want to filter out all "falsy" values (None, 0, "", [], {}), you can use `bool` or `lambda x: x`
filtered_list_falsy = list(filter(lambda x: x, mixed_list)) # or list(filter(bool, mixed_list))
print(f"List with falsy values filtered out: {filtered_list_falsy}")
print("-" * 30)

# --- Lambdas with `sorted()` / `list.sort()` for Custom Sorting ---
# The `key` argument of `sorted()` or `list.sort()` can take a lambda function.
# This lambda is applied to each item to get a "key" for comparison.

# Example 22: Sort a list of strings by their length
print("--- Example 22: Sort list of strings by length ---")
fruits = ["mango", "apple", "banana", "kiwi", "pineapple"]
sorted_fruits_by_length = sorted(fruits, key=lambda s: len(s))
print(f"Fruits sorted by length: {sorted_fruits_by_length}")
# For reverse sort:
sorted_fruits_by_length_desc = sorted(fruits, key=lambda s: len(s), reverse=True)
print(f"Fruits sorted by length (descending): {sorted_fruits_by_length_desc}")
print("-" * 30)

# Example 23: Sort a list of tuples based on the second element
print("--- Example 23: Sort list of tuples by second element ---")
points = [(1, 5), (3, 2), (8, 9), (4, 6)] # (x, y) coordinates
# Sort by y-coordinate
sorted_points_by_y = sorted(points, key=lambda point: point[1])
print(f"Points sorted by y-coordinate: {sorted_points_by_y}")
print("-" * 30)

# Example 24: Sort a list of dictionaries by a specific key's value
print("--- Example 24: Sort list of dictionaries by 'age' ---")
people = [
    {'name': 'Alice', 'age': 30},
    {'name': 'Bob', 'age': 25},
    {'name': 'Charlie', 'age': 35}
]
sorted_people_by_age = sorted(people, key=lambda person: person['age'])
print(f"People sorted by age: {sorted_people_by_age}")
# Sort by name
sorted_people_by_name = sorted(people, key=lambda person: person['name'])
print(f"People sorted by name: {sorted_people_by_name}")
print("-" * 30)

# Example 25: Case-insensitive sorting of strings
print("--- Example 25: Case-insensitive sorting of strings ---")
mixed_case_words = ["Banana", "apple", "Cherry", "date"]
sorted_case_insensitive = sorted(mixed_case_words, key=lambda word: word.lower())
print(f"Words sorted case-insensitively: {sorted_case_insensitive}")
print("-" * 30)

# --- Lambdas with `functools.reduce()` ---
# `reduce(function, iterable)` applies the function cumulatively to the items of iterable,
# from left to right, so as to reduce the iterable to a single value.
# You need to import `reduce` from `functools`.
from functools import reduce

# Example 26: Calculate the sum of all numbers in a list using reduce
print("--- Example 26: Sum of list elements using reduce() ---")
num_list_for_reduce = [1, 2, 3, 4, 5]
# Using a regular function with reduce
def regular_add_for_reduce(x, y):
    print(f"reduce add: x={x}, y={y}") # To see how it works
    return x + y
# sum_reduce_regular = reduce(regular_add_for_reduce, num_list_for_reduce)
# print(f"Sum with regular function and reduce: {sum_reduce_regular}")

# Using lambda with reduce
sum_reduce_lambda = reduce(lambda x, y: x + y, num_list_for_reduce)
print(f"Sum with lambda and reduce: {sum_reduce_lambda}")
# You can also provide an initializer: reduce(lambda x, y: x + y, num_list_for_reduce, 100) -> 100+1+2+3+4+5
sum_reduce_lambda_init = reduce(lambda x, y: x + y, num_list_for_reduce, 100)
print(f"Sum with lambda and reduce (initializer 100): {sum_reduce_lambda_init}")
print("-" * 30)

# Example 27: Calculate the product of all numbers in a list using reduce
print("--- Example 27: Product of list elements using reduce() ---")
product_reduce_lambda = reduce(lambda x, y: x * y, num_list_for_reduce)
print(f"Product with lambda and reduce: {product_reduce_lambda}")
print("-" * 30)

# Example 28: Find the maximum element in a list using reduce
print("--- Example 28: Find max element in list using reduce() ---")
max_val_reduce = reduce(lambda x, y: x if x > y else y, num_list_for_reduce)
print(f"Max value with lambda and reduce: {max_val_reduce}")
print("-" * 30)

# --- More Specific/Advanced Use Cases ---

# Example 29: Lambda with default argument value
print("--- Example 29: Lambda with default argument value ---")
# Regular function with default arg
def power_regular(base, exp=2):
    return base ** exp
print(f"Regular power (5): {power_regular(5)}")      # 5^2
print(f"Regular power (5, 3): {power_regular(5, 3)}") # 5^3

# Lambda with default arg
power_lambda = lambda base, exp=2: base ** exp
print(f"Lambda power (5): {power_lambda(5)}")       # 5^2
print(f"Lambda power (5, 3): {power_lambda(5, 3)}")  # 5^3
print("-" * 30)

# Example 30: Lambda with *args (variable number of positional arguments)
print("--- Example 30: Lambda with *args ---")
# Regular function with *args
def sum_all_regular(*args):
    total = 0
    for num in args:
        total += num
    return total
print(f"Regular sum_all (1,2,3): {sum_all_regular(1,2,3)}")

# Lambda with *args
# The expression part needs to handle the tuple 'args'. `sum()` is perfect here.
sum_all_lambda = lambda *args: sum(args)
print(f"Lambda sum_all (1, 2, 3, 4, 5): {sum_all_lambda(1, 2, 3, 4, 5)}")
print(f"Lambda sum_all (10, 20): {sum_all_lambda(10, 20)}")
print("-" * 30)

# Example 31: Lambda with **kwargs (variable number of keyword arguments)
print("--- Example 31: Lambda with **kwargs ---")
# This is a bit trickier due to the single expression limit.
# You'd typically use it to extract a specific value or perform a simple operation on kwargs.
# Regular function with **kwargs
def greet_regular(**kwargs):
    if 'name' in kwargs and 'greeting' in kwargs:
        return f"{kwargs['greeting']}, {kwargs['name']}!"
    return "Hello!"
print(f"Regular greet: {greet_regular(name='Bro', greeting='Wassup')}")

# Lambda with **kwargs - e.g., extracting a value if it exists
get_name_lambda = lambda **kwargs: kwargs.get('name', 'Guest') # .get() is safer than direct access
print(f"Lambda get_name (name='Dude', age=25): {get_name_lambda(name='Dude', age=25)}")
print(f"Lambda get_name (city='Hyderabad'): {get_name_lambda(city='Hyderabad')}")

# Another example: checking if a specific key exists
has_key_lambda = lambda key, **kwargs: key in kwargs
print(f"Lambda has_key 'job' (name='AI', job='Helper'): {has_key_lambda('job', name='AI', job='Helper')}")
print(f"Lambda has_key 'salary' (name='AI', job='Helper'): {has_key_lambda('salary', name='AI', job='Helper')}")
print("-" * 30)

# Example 32: Lambdas for creating simple "function factories" (closures)
print("--- Example 32: Lambdas as function factories (closures) ---")
# A function that returns another function (often a lambda)
def multiplier_factory_regular(n):
    def multiply_by_n(x):
        return x * n
    return multiply_by_n

doubler_regular = multiplier_factory_regular(2)
tripler_regular = multiplier_factory_regular(3)
print(f"Regular doubler (10): {doubler_regular(10)}")
print(f"Regular tripler (10): {tripler_regular(10)}")

# Using lambda for the inner function
def multiplier_factory_lambda_inner(n):
    return lambda x: x * n

doubler_lambda_inner = multiplier_factory_lambda_inner(2)
tripler_lambda_inner = multiplier_factory_lambda_inner(3)
print(f"Lambda inner doubler (10): {doubler_lambda_inner(10)}")
print(f"Lambda inner tripler (10): {tripler_lambda_inner(10)}")

# You could even (though less readable for complex cases) make the factory itself a lambda,
# but this is often pushing it for readability.
# multiplier_factory_outer_lambda = lambda n: (lambda x: x * n)
# doubler_outer_lambda = multiplier_factory_outer_lambda(2)
# print(f"Outer lambda doubler (10): {doubler_outer_lambda(10)}")
print("-" * 30)

# Example 33: Lambdas in a list (e.g., list of operations)
print("--- Example 33: Lambdas in a list ---")
operations = [
    lambda x: x + x,  # double
    lambda x: x * x,  # square
    lambda x: x - 1   # decrement
]
num_to_operate = 5
for i, op in enumerate(operations):
    print(f"Operation {i+1} on {num_to_operate}: {op(num_to_operate)}")
print("-" * 30)

# Example 34: Lambdas in dictionary values (e.g., command dispatcher)
print("--- Example 34: Lambdas in dictionary values (command dispatcher) ---")
command_dispatcher = {
    'add': lambda x, y: x + y,
    'subtract': lambda x, y: x - y,
    'multiply': lambda x, y: x * y
}
op_name = 'add'
val1, val2 = 7, 8
if op_name in command_dispatcher:
    result = command_dispatcher[op_name](val1, val2)
    print(f"Dispatching '{op_name}' on ({val1}, {val2}): {result}")
else:
    print(f"Unknown command: {op_name}")

op_name = 'divide' # This command is not in our dispatcher
if op_name in command_dispatcher:
    result = command_dispatcher[op_name](val1, val2)
    print(f"Dispatching '{op_name}' on ({val1}, {val2}): {result}")
else:
    print(f"Unknown command: {op_name}")
print("-" * 30)

# Example 35: Using lambda with `if` condition directly in list comprehensions (less common for lambdas themselves)
# While you can, often a direct conditional expression in the list comprehension is cleaner than defining a lambda just for it.
print("--- Example 35: Lambda with if in list comprehension (for illustration) ---")
numbers_lc = [1, 2, 3, 4, 5, 6]
# Get squares of even numbers
# Using direct conditional in list comprehension (more Pythonic for this case)
squares_of_evens_lc = [x*x for x in numbers_lc if x % 2 == 0]
print(f"Squares of evens (direct list comprehension): {squares_of_evens_lc}")

# You *could* use map and filter with lambdas to achieve the same:
squares_of_evens_map_filter = list(map(lambda x: x*x, filter(lambda x: x % 2 == 0, numbers_lc)))
print(f"Squares of evens (map, filter, lambdas): {squares_of_evens_map_filter}")

# Defining a lambda just to use in a list comprehension's `if` is usually overkill,
# as the `if` part of a list comprehension is already very expressive.
# For example, this is redundant:
# is_even = lambda x: x % 2 == 0
# squares_of_evens_lambda_in_lc = [x*x for x in numbers_lc if is_even(x)]
# print(f"Squares of evens (lambda in list comprehension if): {squares_of_evens_lambda_in_lc}")
print("-" * 30)


# --- When NOT to use Lambdas (Readability is Key!) ---
# 1. Complex Logic: If your function requires multiple lines of code, multiple expressions, or complex conditional branching,
#    a regular `def` function is much more readable and maintainable. Lambdas are for single expressions.
# 2. When you need a docstring: Lambdas can't have docstrings. If documentation is important, use `def`.
# 3. When the lambda becomes too long or unreadable: The goal of a lambda is conciseness for simple tasks.
#    If it's hard to understand at a glance, it defeats the purpose.
#    Example of a potentially unreadable lambda (though it works):
#    complex_lambda = lambda x, y, z: (x + y) * z if z > 0 else (x - y) / z if z < 0 else x * y
#    print(f"Complex lambda (2,3,4): {complex_lambda(2,3,4)}") # (2+3)*4 = 20
#    print(f"Complex lambda (5,2,-1): {complex_lambda(5,2,-1)}") # (5-2)/-1 = -3
#    A `def` function would be clearer here.

print("--- When NOT to use Lambdas ---")
def complex_logic_regular(x, y, z):
    """
    This function demonstrates logic that is too complex for a readable lambda.
    - If z is positive, returns (x+y)*z
    - If z is negative, returns (x-y)/z
    - If z is zero, returns x*y
    """
    if z > 0:
        return (x + y) * z
    elif z < 0:
        # Ensure z is not zero for division, though covered by the first if.
        # This is just for illustration of more logic.
        if y == x: # some other arbitrary condition
             return 0
        return (x - y) / z
    else: # z is 0
        return x * y

print(f"Complex regular function (2,3,4): {complex_logic_regular(2,3,4)}")
print(f"Complex regular function (5,2,-1): {complex_logic_regular(5,2,-1)}")
print("-" * 30)

print("Phew! That was a ton of lambda examples, my friend!")
print("Key takeaway: Lambdas are awesome for short, simple, one-expression functions, especially with map, filter, and sorted.")
print("Don't overuse them if it hurts readability. A good old 'def' function is your bro too!")

