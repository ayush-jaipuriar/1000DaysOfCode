class Animal:
    def __init__(self, name):
        self.name = name

    def speak(self): # Generic speak
        # This could raise NotImplementedError if we want to force subclasses to implement it
        return f"{self.name} makes a generic animal sound."

    def introduce(self):
        return f"I am {self.name}, an animal."

class Dog(Animal):
    def speak(self): # Override
        return f"{self.name} says: Woof!"

    def introduce(self): # Override
        return f"I am {self.name}, a Dog. Loyalty is my game!"

class Cat(Animal):
    def speak(self): # Override
        return f"{self.name} says: Meow!"

    def introduce(self): # Override
        return f"I am {self.name}, a Cat. I judge you silently."

class Bird(Animal):
    def __init__(self, name, can_fly=True):
        super().__init__(name)
        self.can_fly = can_fly

    def speak(self): # Override
        return f"{self.name} says: Chirp chirp!"

    def introduce(self): # Override
        status = "I fly high!" if self.can_fly else "I prefer walking."
        return f"I am {self.name}, a Bird. {status}"

# A function that demonstrates polymorphism
def make_animal_speak_and_introduce(animal_object):
    print(f"--- {animal_object.name}'s Turn ---")
    print(animal_object.introduce()) # Calls the specific introduce() of the object's class
    print(animal_object.speak())     # Calls the specific speak() of the object's class

# Create a list of different animal objects
animals = [
    Dog("Buddy"),
    Cat("Whiskers"),
    Bird("Tweety", can_fly=True),
    Animal("Generic Creature"), # Uses the base class methods
    Dog("Rocky"),
    Bird("Pengu", can_fly=False) # A non-flying bird
]

# Iterate and call the function
# The SAME function `make_animal_speak_and_introduce` works with DIFFERENT types of animals
for animal in animals:
    make_animal_speak_and_introduce(animal)
    print("-" * 20)