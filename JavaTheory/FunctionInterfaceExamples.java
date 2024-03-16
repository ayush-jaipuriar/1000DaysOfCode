package JavaTheory;

import java.util.function.Function;

public class FunctionInterfaceExamples {

    public static void main(String[] args) {
        // A function to format a name(apply() showcase)
        Function<String, String> formatName = inputString -> inputString.toUpperCase().trim();
        String fullName = " ayush jaipuriar   ";
        System.out.println("Formatted Name : " + formatName.apply(fullName));

        // A function to calculate the area of a squad
        Function<Integer, Integer> calculateArea = side -> side * side;
        int area = calculateArea.apply(5);
        System.out.println("Calculated area : " + area);

        // Chaining functions with andThen()
        Function<String, Integer> countWords = st -> st.split(" ").length;
        Function<String, Integer> formatAndCountWords = formatName.andThen(countWords);
        int wordCount = fullName.split(" ").length;
        System.out.println("Word Count before formatting : " + wordCount);
        wordCount = formatAndCountWords.apply(fullName);
        System.out.println("Word Count after formatting : " + wordCount);

        Function<Integer, Integer> doubleIt = num -> num * 2; 
        Function<Integer, String> addExclamation = num -> num + "!"; 
        
        Function<Integer, String> doubleThenAddExclamation =  addExclamation.compose(doubleIt); // Correct order with compose()

        int inputNumber = 4;
        String result = doubleThenAddExclamation.apply(inputNumber); // Output: 8! (doubles first, then adds exclamation)
        System.out.println("Result after applying compose : " + result);

        // Using identity()
        Function<String, String> keepOriginal = Function.identity();
        String originalText = "Original Text";
        System.out.println("Original text : " + originalText);
        String unchangedText = keepOriginal.apply(originalText);
        System.out.println("Unchanged text after applying identity() function : " + unchangedText);



    }

}
