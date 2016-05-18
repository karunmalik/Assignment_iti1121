

/**
 * 
 * PartialPermutations is a class to generate collections of partial permutations
 * of different types depending on settings specified by the user
 *
 * @author Lucia Moura
 *
 */
public class PartialPermutations {
	
	// the three types of generation
	public enum Mode {UPTOSIZE,FIXEDSIZE,MAXSIZE}
	
	// mode stores the selected type of generation
	// initialized to default value UPTOSIZE
	Mode mode=Mode.UPTOSIZE;
	
	// parameter size indicates the maximum size of permutations printed 
	// in modes UPTOSIZE and FIXEDSIZE
	// initialize to default value 3
	int size=3;
	
	// alphabet specifies the alphabet; initalized to default value {a,b,c,d}
	char alphabet[]={'a','b','c','d'};
	
	
	/**
	 * Sets the mode of generation
	 * @param mode is one of the 3 possible modes of generation
	 */
	public void setMode(Mode mode) {
		this.mode=mode;	
	}
	
	
	/**
	 * Gets the mode of generation
	 * @return the current mode of generation (one of 3 possible modes)
	 */
	public Mode getMode() {
		return mode;	
	}

	/**
	 * 
	 * Sets the size parameter used in modes UPTOSIZE and FIXEDSIZE
	 * @param size must be smaller than equal the length of the alphabet
	 */
	public void setSize(int size) {
		this.size=size;	
	}
	
	/**
	 * Gets the size paramter used in modes UPTOSIZE and FIXEDSIZE
	 * @return
	 */
	public int getSize() {
		return size;	
	}
	
	/**
	 * 
	 * Sets the alphabet to be use in the generation
	 * @param a is an array of characters given the letters of the alphabet 
	 * in the desired order
	 */
	public void setAlphabet( char[] a) {
		
		alphabet=new char[a.length];	
		System.arraycopy(a,0, alphabet, 0, a.length);
				
	}
	
	/**
	 * printMode prints the current mode of generation
	 */
	private void printMode() {
		switch (mode) {
		case UPTOSIZE: 
			System.out.println("Output Mode UPTOSIZE size="+size
							   +" alphabet size="+ alphabet.length);
			break;
		case FIXEDSIZE:
			System.out.println("Output Mode FIXEDSIZE size="+size
							   +" alphabet size="+ alphabet.length);
			break;
		case MAXSIZE:
			System.out.println("Output Mode MAXSIZE alphabet size="
							   + alphabet.length);
			break;
		}
	}
	
	
	/**
	 * visit will be called from generateWords() to "process" a word
	 * @param word
	 * @return a String which will be the word if this is a word to be in the output of 
	 * the current type of generation (note that the empty string is retrned as 
	 * the String "<empty>")
	 * if the word is not supposed to be in the output of the current type of 
	 * generation returns ""
	 * 
	 */
	private String visit(String word) {// method visit checks if the word has two same alphabets.
		char[] temp = new char[word.length()];
		if(word.equals(""))
			return ("<empty>");
		else{
		for(int i=0;i<word.length();i++)
		{
			temp[i]=word.charAt(i);
		}
		for(int k=0;k<word.length();k++)
		{
			
		for(int j=0;j<word.length();j++)
		{
			if(j!=k){
			if(word.charAt(k)==temp[j]){
				return "";
				
			}}
				
		}
		
		}}
		return word;
		
		
	}
	
	/**
	 * generateWords will generate all partial permutations according to the desired 
	 * mode and parameters
	 * @return a String where all the desired partial permutations of the current type are 
	 * separated by ; without extra spaces.
	 *
	 */
	public String generateWords() {// method to generate words
		Queue<String> wordQueue = new LinkedQueue<String>(); //creating queue
		String finalstring="";// temporary final string
		String finalstring2="";// FINAL STRING
		if(this.mode==Mode.UPTOSIZE){// MODE=UPTOZIE
		String s4="";
		wordQueue.enqueue(finalstring);
				while(s4.length()<=this.getSize()){// while loop to dequeue the queue
					
				finalstring=wordQueue.dequeue();
				
				for(int i=0;i<alphabet.length;i++)// for loop to add string with alphabets(creates all possible permutation)
				{
				 s4=finalstring+alphabet[i];
				String s5=this.visit(finalstring2);
				String s3=this.visit(s4);
				if(s5.equals("<empty>"))
				{
					finalstring2="<empty>;";
					
				}
				
				 if(!s3.equals("")){// adding to FINAL STRING
					 if(s4.length()<=this.getSize())
					finalstring2=finalstring2+s4+";";
					wordQueue.enqueue(s4);
					
				}
				}	
				}
				}
		
		
		if(this.mode==Mode.FIXEDSIZE){// method to generate words for fixed size.
			String s4="";
			int count=0;
			wordQueue.enqueue(finalstring);
					while(s4.length()<=this.getSize()){
						
					finalstring=wordQueue.dequeue();
					
					for(int i=0;i<alphabet.length;i++)
					{
						
						
					 s4=finalstring+alphabet[i];
					String s5=this.visit(finalstring2);
					String s3=this.visit(s4);
					if(this.getSize()==0)
					if(s5.equals("<empty>"))
					{
						finalstring2="<empty>";
					}
					
					 if(!s3.equals("")){
						 if(s4.length()<=this.getSize())
							 if(s4.length()==this.getSize())
						finalstring2=finalstring2+s4+";";
						wordQueue.enqueue(s4);
					}
					}	
					count++;
					}
					}
		
		if(this.mode==Mode.MAXSIZE){// method to generate words for max size
			String s4="";
			int count=0;
			wordQueue.enqueue(finalstring);
					while(s4.length()<=this.alphabet.length){
						
					finalstring=wordQueue.dequeue();
					
					for(int i=0;i<alphabet.length;i++)
					{
						
						
					 s4=finalstring+alphabet[i];
					
					String s5=this.visit(finalstring2);
					String s3=this.visit(s4);
					if(this.getSize()==0)
					if(s5.equals("<empty>"))
					{
						finalstring2="<empty>";
						
					}
					
					 if(!s3.equals("")){
						 if(s4.length()<=this.alphabet.length)
							 if(s4.length()==this.alphabet.length)
						finalstring2=finalstring2+s4+";";
						wordQueue.enqueue(s4);
						
					}
					}	
					count++;
					}
					}
		return finalstring2;
		}
}
		
		
	


