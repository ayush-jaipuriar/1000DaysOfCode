// Function Constructors

// Define a function constructor called Person
function Person(firstname, lastname) {
  // Inside the constructor, set the firstname and lastname properties of the object being created
  this.firstname = firstname;
  this.lastname = lastname;
}

// Add a greet method to the prototype of the Person constructor
Person.prototype.greet = function () {
  // Inside the greet method, log a greeting message using the firstname and lastname properties
  console.log(`Hello, ${this.firstname} ${this.lastname}`);
};

// Create a new instance of the Person object using the 'new' keyword and pass in the firstname and lastname values
let ayush = new Person("Ayush", "Jaipuriar");

// Call the greet method on the ayush object
ayush.greet();

// Symbols in Javascript
let symbol1 = Symbol("symbol1");
let symbol2 = Symbol("symbol1");
console.log(symbol1 === symbol2); // false

let mySymbol = Symbol();
let obj = {
  [mySymbol]: "Ayush",
};
console.log(obj[mySymbol]);

// How to check if a key exists in an object
let object = { name: "Ayush" };
console.log("name" in object); // true
console.log(object.hasOwnProperty("name")); // true

// How to check if a value exists in an object
obj = { name: "John", age: 30 };

function hasValue(obj, value) {
  return Object.values(obj).includes(value);
}

console.log(hasValue(obj, "John")); // true
console.log(hasValue(obj, 40)); // false
