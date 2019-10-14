package com.scdevs.ideasimplecalcstarter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {

	/*
	THIS IS A COMMENT - IF IT IS GRAYED OUT, THE CODE IS "IGNORED" BY THE COMPUTER AND GETS SKIPPED OVER
	This is the .java part of the backend code
	Each activity is basically just a page in the app
		-Each activity has a frontend, the .xml file, and a backend, the .java file
	This is the backend code, where all of your app's behind-the-scenes calculations takes place
	 */


	Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonplus, buttonminus, buttontimes, buttondivide, buttonequals;

	// TODO: Declare two TextViews named "equation" and "answer"
	TextView equation, answer;


	//This is the onCreate() method. Each time an activity is created, the following code is run.
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		/*
		TODO: Define the two TextViews at the top of the calculator and clear their text
		Use findViewById() to declare the TextViews
		We need to use the .setText() method of a TextView to set the initial text to nothing ("")
		 */
		equation = findViewById(R.id.equation);
		answer = findViewById(R.id.answer);
		equation.setText(" ");
		answer.setText("");
		//The following 2 lines calls the methods that are declared below
		setButtons();
		setOnClicks();


	}

	//To save time, this method is pre-filled. It defines all of the number/symbol buttons
	void setButtons() {
		button0 = findViewById(R.id.button0);
		button1 = findViewById(R.id.button1);
		button2 = findViewById(R.id.button2);
		button3 = findViewById(R.id.button3);
		button4 = findViewById(R.id.button4);
		button5 = findViewById(R.id.button5);
		button6 = findViewById(R.id.button6);
		button7 = findViewById(R.id.button7);
		button8 = findViewById(R.id.button8);
		button9 = findViewById(R.id.button9);
		buttonplus = findViewById(R.id.buttonplus);
		buttonminus = findViewById(R.id.buttonminus);
		buttontimes = findViewById(R.id.buttontimes);
		buttondivide = findViewById(R.id.buttondivide);
		buttonequals = findViewById(R.id.buttonequals);

	}

	/*
	 Some of the following code is already filled in
	 This method will create onClickListeners for each of the buttons
	 	- This means that the buttons will start "listening" for clicks
	 	- When the button is clicked, it will run the code inside the onClick() method inside each onClickListener
	 Right, now the code inside the onClick will run the .append() method of a TextView
	 	- append means to add on to the end of a String
	*/
	void setOnClicks() {
		button0.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				equation.append("0");
			}
		});
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				equation.append("1");
			}
		});
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				equation.append("2");
			}
		});
		button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				equation.append("3");
			}
		});
		button4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				equation.append("4");
			}
		});
		button5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				equation.append("5");
			}
		});
		button6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				equation.append("6");
			}
		});
		button7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				equation.append("7");
			}
		});
		button8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				equation.append("8");
			}
		});
		button9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				equation.append("9");
			}
		});

		// TODO: Add onClickListeners for all of the number buttons you just added (4-9)


		buttonplus.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {

				equation.append("+");

				/*
				This will make it so that the user can't enter in multiple operators
				Once a symbol button is pressed, all operator buttons are disabled
				 */
				buttonplus.setEnabled(false);
				buttonminus.setEnabled(false);
				buttontimes.setEnabled(false);
				buttondivide.setEnabled(false);
			}
		});
		buttonminus.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				equation.append("-");
				buttonplus.setEnabled(false);
				buttonminus.setEnabled(false);
				buttontimes.setEnabled(false);
				buttondivide.setEnabled(false);
			}
		});

		//TODO: Add onClickListeneers for all of the symbol buttons you just added (* and /)
		buttontimes.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {

				equation.append("*");

				/*
				This will make it so that the user can't enter in multiple operators
				Once a symbol button is pressed, all operator buttons are disabled
				 */
				buttonplus.setEnabled(false);
				buttonminus.setEnabled(false);
				buttontimes.setEnabled(false);
				buttondivide.setEnabled(false);
			}
		});
		buttondivide.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {

				equation.append("/");

				/*
				This will make it so that the user can't enter in multiple operators
				Once a symbol button is pressed, all operator buttons are disabled
				 */
				buttonplus.setEnabled(false);
				buttonminus.setEnabled(false);
				buttontimes.setEnabled(false);
				buttondivide.setEnabled(false);
			}
		});
		buttonequals.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {

				//Pass in the equation to our findAnswer() method
				String compute = findAnswer(equation.getText().toString());

				//TODO: Set the answer TextView to the compute variable defined above and clear the equation TextView
				answer.setText(compute);
				//TODO: Re-enable all of the operator buttons
				buttonplus.setEnabled(true);
				buttonminus.setEnabled(true);
				buttontimes.setEnabled(true);
				buttondivide.setEnabled(true);
				equation.setText("");
			}
		});
	}




	/*
	The code below will calculate each answer
	All you need to know is that this code will take text from the equation and calculate it
	 */
	String findAnswer(String equation) {
		try {

			if (equation.contains("+"))
			{
				String[] eqArr = equation.split("\\+");
				return BigDecimal.valueOf(Double.parseDouble(eqArr[0]) + Double.parseDouble(eqArr[1])).stripTrailingZeros().toPlainString() + "";
			}
			else if (equation.contains("-"))
			{
				String[] eqArr = equation.split("-");
				return BigDecimal.valueOf(Double.parseDouble(eqArr[0]) - Double.parseDouble(eqArr[1])).stripTrailingZeros().toPlainString() + "";
			}
			else if (equation.contains("*"))
			{
				String[] eqArr = equation.split("\\*");
				return BigDecimal.valueOf(Double.parseDouble(eqArr[0]) * Double.parseDouble(eqArr[1])).stripTrailingZeros().toPlainString() + "";
			}
			else
			{
				String[] eqArr = equation.split("/");
				return BigDecimal.valueOf(Double.parseDouble(eqArr[0]) / Double.parseDouble(eqArr[1])).stripTrailingZeros().toPlainString() + "";
			}

		}
		catch (Exception e) {
			return "Error";
		}
	}
}