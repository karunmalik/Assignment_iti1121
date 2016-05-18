

/**
 * Class StudentByGrade
 * 
 * This class is used to store information for the grades in a course,
 * recording the list of students that received each letter grade.
 * 
 * @author Lucia Moura
 *
 */
/**
 * @author lucia
 *
 */
public class StudentByGrade {
	
	// The letter grades and corresponding students are stored in a binary search tree
	// the values stored in the BinarySearchTree will be StudentListWithGrade, 
	// which implements Comparable<StudentListWithGrade>
	// The binary search tree "key" used to store the elements in order
	// is the letter grade, since the comparison between objects of
	// StudentListWithGrade is based solely on letter grades
	
	BinarySearchTree<StudentListWithGrade> tree;
	
	/**
	 * The constructor simply initializes an empty binary search tree
	 */
	public StudentByGrade() {
			tree= new BinarySearchTree<StudentListWithGrade>();
	}
	
	
	/**
	 * Method add inserts information as student name with its letter grade.
	 * 
	 * If there is already a list of students with the same grade inserted into
	 * the binary search tree, it simply adds this new student to the existing list
	 * If there is no current list of students with this grade, it creates 
	 * create an object of class StudentListWithGrade with the given grade
	 * containing the given student name and insert into the binary search tree
	 * 
	 * @param grade is the grade of the student
	 * @param name is the student name
	 * @return true if the insertion was successful
	 */
	public boolean add(String grade, String name) {
		//StudentListWithGrade gol= new StudentListWithGrade("")
	 if( tree.contains(new StudentListWithGrade(grade))){//if tree contains 
		 StudentListWithGrade n1 =tree.find(new StudentListWithGrade(grade));
		 
		 StudentListWithGrade n2 = new StudentListWithGrade(n1.getLetterGrade());
		 n2 = n1;
		 n2.add(name);
		 return tree.contains(n2);
		 
	 }
	 else{
		 StudentListWithGrade n= new StudentListWithGrade(grade);
		 n.add(name);
		return tree.add(n);
		 
		 
	 }
	}
	
	
	/**
	 * Method add inserts information for a list of student names having the same letter grade 
	 * 
	 * If there is already a list of students with the same grade inserted into
	 * the binary search tree, it simply merges this new student list into existing list
	 * If there is no current list of students with this grade, it inserts the given list.
	 * 
	 * @param myList is a member of class StudentListWithGrade, which is a list of student
	 * names as well as the letter grade for all these students
	 * @return true if the insertion was successful
	 * 
	 */
	public boolean add(StudentListWithGrade myList) {
		
	   if(tree.contains(myList)){
		   tree.find(myList).merge(myList);//merging my list with the list retrieved from tree.
		 if(tree.contains(tree.find(myList))){
			 return true;
		 }
		 else
			 return false;
			   
	   }
	   else{
		   tree.add(myList);
		  return tree.contains(myList) ;
	   }
		//boolean result=false;
		
		//return false;
		
	}
	
	/**
	 * @return a string showing the data in "tree format"
	 */
	public String treeToString() {
		// Do not modify this method or the testing will give incorrect output!!!
		return tree.toString();
	}
	

	
	/* 
	 * The format of toString() is a format that shows in different lines
	 * each grade and the corresponding list of students with that grade.
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String s = tree.toString();
		String ans="";
		for (int i=0; i< s.length(); i++) {
			if ( (s.charAt(i)!=')') && (s.charAt(i)!='(' ) ) {
				ans=ans+s.charAt(i);
				if (s.charAt(i)==']') ans=ans+"\n";
			}
		}
		return ans;
	}


}
