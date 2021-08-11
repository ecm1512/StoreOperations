package com.educode.examentottus.presentation.ui.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import com.educode.examentottus.R
import com.educode.examentottus.databinding.ActivityLoginBinding
import com.educode.examentottus.databinding.ActivityRegisterBinding
import com.educode.examentottus.presentation.ui.login.LoginViewModel
import org.koin.androidx.scope.ScopeActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterActivity : ScopeActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private val viewModel: RegisterViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            validateForm()

        }
    }

    private fun validateForm() {

        val icon = AppCompatResources.getDrawable(this, R.drawable.ic_error)
        icon?.setBounds(0,0,icon.intrinsicWidth,icon.intrinsicHeight)

        when{
            TextUtils.isEmpty(binding.etMailRegister.text.toString().trim())->{
                binding.etMailRegister.setError("Ingresa el correo",icon)
            }
            TextUtils.isEmpty(binding.etPasswordRegister.text.toString().trim())->{
                binding.etPasswordRegister.setError("Ingresa la contraseña",icon)
            }

            binding.etMailRegister.text.isNotEmpty() && binding.etPasswordRegister.text.toString().isNotEmpty() -> {
                if(binding.etMailRegister.text.toString().matches(Regex("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"))){
                    if(binding.etPasswordRegister.text.toString().length>=5){
                        viewModel.insertUser(binding.etMailRegister.text.toString(),binding.etPasswordRegister.text.toString(),binding.etName.text.toString(),binding.etLastName.text.toString()).observe(this){
                            if(it){
                                Toast.makeText(this,"Usuario Creado", Toast.LENGTH_SHORT).show()
                                finish()
                            }else{
                                Toast.makeText(this,"Usuario no se pudo crear", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }else{
                        binding.etPasswordRegister.setError("Ingresa una contraseña valida",icon)
                    }
                }else{
                    binding.etMailRegister.setError("Ingresa un email valido",icon)
                }
            }
        }
    }
}