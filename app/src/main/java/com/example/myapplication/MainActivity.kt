package com.example.myapplication
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class  MainActivity : AppCompatActivity() {

    //Here we see the two button and two textViews that we created as an interface.
    private lateinit var nextButton : Button
    private lateinit var previousButton : Button
    private lateinit var departmentTextView: TextView
    private lateinit var descriptionDepartmentTextView: TextView

    //The list includes the explanations we need
    private val allDepartments = listOf(
        Departments(R.string.computer_engineering,R.string.desc_CE_engineering),
        Departments(R.string.molecular_biology_genetics,R.string.desc_molecular_biology_genetics),
        Departments(R.string.mechatronics_engineering,R.string.desc_mechatronics_engineering),
        Departments(R.string.civil_engineering,R.string.desc_Civil_enginerring),
        Departments(R.string.energy_systems_engineering,R.string.desc_energy_systems_engineering),
        Departments(R.string.electrical_engineering,R.string.desc_electrical_engineering),
        Departments(R.string.industrial_engineering,R.string.desc_industrial_engineering))

    //CurrentIndex will help to change values when we press the next and previous buttons
    private var currentIndex = 0


    //Here, buttons are defined and different functional operations are specified for each button.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        departmentTextView = findViewById(R.id.department_text_view)
        descriptionDepartmentTextView = findViewById(R.id.department_description)
        nextButton = findViewById(R.id.next_button)
        previousButton = findViewById(R.id.previous_button)


        //Next button will show next department name and description when it will pressed
        nextButton.setOnClickListener{view: View ->
            currentIndex = (currentIndex + 1) % allDepartments.size //switch to next department
            val departmentsTextId = allDepartments[currentIndex].textResId // get the current department
            departmentTextView.setText(departmentsTextId)
            val descId = allDepartments[currentIndex].descId
            descriptionDepartmentTextView.setText(descId)

        }

        //Previous button will show Previous department name and description when it will pressed
        previousButton.setOnClickListener{view: View ->

            currentIndex = (currentIndex - 1) % allDepartments.size
            if(currentIndex<0){
                currentIndex=6
            }//switch to next department
            val departmentTextId = allDepartments[currentIndex].textResId // get the current department
            departmentTextView.setText(departmentTextId)
            val descId = allDepartments[currentIndex].descId
            descriptionDepartmentTextView.setText(descId)//display current department
        }

    }


}
