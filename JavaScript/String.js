let name = "Alice";
console.log(name);

// Now using Backticks
console.log(`Hello, ${name}`);

// Support multi line Strings without the need for escape characters
let multiLineString = `Vande 
Mataram`;
console.log(multiLineString);

// Determining the length of a string
console.log(name.length);

// Accessing the individual characters in a string
console.log(name[0]);
// FU: Trying to access an index beyond the limit
console.log(name[69]);

// slice() method
let originalString = "Hello World";
let slicedString = originalString.slice(1,4);
console.log(slicedString);
// FU : Trying to slice() using a negative index
slicedString = originalString.slice(-3);
console.log(slicedString);
// FU : Behaviour of slice() when the start is greater than the end of the string
slicedString = originalString.slice(69, 3);
console.log(slicedString);

// Difference between behaviour of slice() and substring() functions
let text = "Example";
// 1. Negative Indices : slice() interprets negative indices as counting from the end, while substring() treats them as 0.
console.log(text.slice(-5,-1)); // ampl
console.log(text.substring(-5, -1));
// 2. Index Order : If the start index is greater than the end index in slice(), it returns an empty string. In substring(), it swaps the indices.
console.log(text.slice(4, 2)); // empty string ""
console.log(text.substring(4,2)); // am

// Converting a String to a number
let str1 = "42";
let num1 = parseInt(str1);
console.log(typeof str1);
console.log(typeof num1);
console.log(num1);

let str2 = "3.14";
let num2 = parseFloat(str2);
console.log(typeof str2);
console.log(typeof num2);
console.log(num2);

let str3 = "123";
let num3 = +str3;
console.log(typeof str3);
console.log(typeof num3);
console.log(num3);

// FU : Trying to parse a String that is not a number will return NaN
let str4 = "Ayush";
let num4 = parseInt(str4);
console.log(num4); // NaN
str4 = "Ayush123";
console.log(parseInt(str4)); // NaN

