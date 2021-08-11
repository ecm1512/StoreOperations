package com.educode.examentottus.presentation.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import com.educode.examentottus.R
import com.educode.examentottus.databinding.ActivityLoginBinding
import com.educode.examentottus.presentation.ui.home.HomeActivity
import com.educode.examentottus.presentation.ui.register.RegisterActivity
import org.koin.androidx.scope.ScopeActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : ScopeActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnCreateAccount.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.btnAutenticate.setOnClickListener {
            validateForm()
        }
    }

    private fun validateForm() {

        val icon = AppCompatResources.getDrawable(this, R.drawable.ic_error)
        icon?.setBounds(0,0,icon.intrinsicWidth,icon.intrinsicHeight)

        when{
            TextUtils.isEmpty(binding.etMail.text.toString().trim())->{
                binding.etMail.setError("Ingresa el correo",icon)
            }
            TextUtils.isEmpty(binding.etPassword.text.toString().trim())->{
                binding.etPassword.setError("Ingresa la contraseña",icon)
            }

            binding.etMail.text.isNotEmpty() && binding.etPassword.text.toString().isNotEmpty() -> {
                if(binding.etMail.text.toString().matches(Regex("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"))){
                    if(binding.etPassword.text.toString().length>=5){
                        viewModel.autenticate(binding.etMail.text.toString().trim(),binding.etPassword.text.toString().trim()).observe(this){
                            if(it){
                                Toast.makeText(this,"Te logueaste correctamente", Toast.LENGTH_SHORT).show()
                                val intent = Intent(this, HomeActivity::class.java)
                                startActivity(intent)
                            }else{
                                Toast.makeText(this,"Usuario o contraseña incorrectas", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }else{
                        binding.etPassword.setError("Ingresa una contraseña valida",icon)
                    }
                }else{
                    binding.etMail.setError("Ingresa un email valido",icon)
                }
            }
        }
    }
}