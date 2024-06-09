// Demonstrating the use of template literals for string interpolation
let personName = "Bob";
console.log(`Hello, ${personName} Welcome to our application.`);

// Exploring string repetition
let repeatMessage = "Welcome".repeat(3);
console.log(repeatMessage); // Outputs: WelcomeWelcomeWelcome

// Using the startsWith() method to check if a string begins with specified characters
let website = "https://example.com";
console.log(website.startsWith("http")); // false
console.log(website.startsWith("https")); // true

// The endsWith() method to check if a string ends with specified characters
console.log(website.endsWith(".com")); // true

// The includes() method to determine whether one string may be found within another string
console.log(website.includes("example")); // true

// The trimStart() and trimEnd() methods to remove whitespace from both ends of a string
let leadingWhitespace = "    Hello World    ";
console.log(leadingWhitespace.trimStart()); // "Hello World    "
console.log(leadingWhitespace.trimEnd()); // "    Hello World"

// The trim() method to remove whitespace from both ends of a string
console.log(leadingWhitespace.trim()); // "Hello World"