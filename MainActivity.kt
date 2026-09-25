package com.example.studentprofilecard

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.studentprofilecard.databinding.ActivityMainBinding
import com.example.studentprofilecard.Student
import com.example.studentprofilecard.toAcademicRanking

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var currentStudent = Student(
        id = "24151121120",
        name = "Le Thi Minh Thao",
        className = "126LTTD02",
        email = "viet@example.com",
        gpa = 3.8
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bindStudentData(currentStudent)

        binding.btnUpdateGpa.setOnClickListener {

            val inputStr = binding.edtNewGpa.text.toString().trim()

            val newGpa = inputStr.toDoubleOrNull()

            if (newGpa == null || newGpa !in 0.0..4.0) {

                binding.edtNewGpa.error =
                    "Vui lòng nhập GPA từ 0.0 đến 4.0"

                Toast.makeText(
                    this,
                    "GPA không hợp lệ!",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            currentStudent = currentStudent.copy(
                gpa = newGpa
            )

            bindStudentData(currentStudent)

            Toast.makeText(
                this,
                "Cập nhật thành công!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun bindStudentData(student: Student) {

        with(binding) {

            tvName.text = student.name

            tvStudentId.text =
                "MSSV: ${student.id} • Lớp: ${student.className}"

            tvEmail.text =
                "Email: ${student.email}"

            tvGpaBadge.text =
                "GPA: ${student.gpa} (${student.gpa.toAcademicRanking()})"

            edtNewGpa.setText(
                student.gpa.toString()
            )
        }
    }
}