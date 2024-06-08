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