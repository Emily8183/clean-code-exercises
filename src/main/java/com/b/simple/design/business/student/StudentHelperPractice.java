package com.b.simple.design.business.student;

public class StudentHelperPractice {

	private static final int GRADE_B_UPPER_LIMIT = 80; // static final一般都用大写
	private static final int GRADE_B_LOWER_LIMIT = 51;
	private static final int EXTRA_UPPER_FOR_MATHS= 10;

	/* PROBLEM 1 */	
	/*
	* You get a grade B if marks are between 51 and 80 (both inclusive). Except for Maths where the upper limit is increased by 10.

	boolean function: isGradeB
	all other courses: 51 <= score <= 80
	Maths: 51 <= score <= 90

	Problem & Solution: 
	1/ If there's a typo or change about the numbers, easy to get wrong => change all the numbers to constants
	2/ Almost the same range, except for the upper limit of Maths. So in this code, there's duplicates. => if-function for the upper limit of maths first

	*/
	public boolean isGradeB(int marks, boolean isMaths) {

		int extraLimits = isMaths ? EXTRA_UPPER_FOR_MATHS : 0;

		int upperLimits = GRADE_B_UPPER_LIMIT + extraLimits;
		
		return marks >= GRADE_B_LOWER_LIMIT && marks <= upperLimits; 
	}

	/* PROBLEM 2 */
	/*
	You are awarded a grade based on your marks.
	Grade A = 91 to 100, Grade B = 51 to 90, Otherwise Grade C
	Except for Maths where marks to get a Grade are 5 higher than required for other subjects.
	*/

	public String getGrade(int mark, boolean isMaths) {

		//Method A:

		int extraLimitsForMaths = isMaths? 5 : 0;

		if (mark >= 91 + extraLimitsForMaths) return "A";

		if (mark >= 51 + extraLimitsForMaths) return "B";

		return "C";

		//Method B:
		// int lowerLimitForAGrade = isMaths ? 96 : 91;
		
		// if (mark > lowerLimitForAGrade) return "A";

		// int lowerLimitForBGrade = isMaths? 56 : 51;

		// if (mark > lowerLimitForBGrade) return "B";
		
		// return "C";
	}

    /*  PROBLEM 3
     * You and your Friend are planning to enter a Subject Quiz.
     * However, there is a marks requirement that you should attain to qualify.
     * 
     * Return value can be YES, NO or MAYBE.
     * 
     * YES If either of you are very good at the subject(has 80 or more marks)
     * However, there is an exception that if either of you is not good in the subject(20 or less marks), it is NO.
     * In all other conditions, return MAYBE.
     * 
     * However, the definition for good and not good are 5 marks higher if the subject is Mathematics.
     * 
     * marks1 - your marks
     * marks2 - your friends marks
    */
        
    public String willQualifyForQuiz(int marks1, int marks2, boolean isMaths) {

        if (isNotGood(marks1, isMaths) || isNotGood(marks2, isMaths)) return "NO";
        if (isGood(marks1, isMaths) || isGood(marks2, isMaths)) return "YES";

        return "MAYBE";
	}

		
	private boolean isGood(int marks, boolean isMaths) {
		int extraLimits = isMaths? 5 : 0;
		return marks >= extraLimits + 80;
	}

	private boolean isNotGood(int marks, boolean isMaths) {
		int extraLimits = isMaths? 5 : 0;
		return marks <= extraLimits + 20;
	}	


}