package StringsWork;

public class reverseTextProgram {

	public static void main(String[] args) {
		
		String originalText = "Wishing you good health";
		String[] splitWords = originalText.split("\\s");
		String resultText = "";
		for (int i = splitWords.length-1; i >= 0; i--)
		{
			resultText = resultText + splitWords[i] + " ";
		}
		System.out.println("Output String : "+ resultText);
		

	}

}
