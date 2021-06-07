package com.mailprojectteam.memorizelic

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.mlkit.common.model.DownloadConditions
import com.google.mlkit.common.model.RemoteModelManager
import com.google.mlkit.nl.translate.TranslateLanguage
import com.google.mlkit.nl.translate.TranslateRemoteModel
import com.google.mlkit.nl.translate.Translation
import com.google.mlkit.nl.translate.TranslatorOptions
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val modelManager = RemoteModelManager.getInstance()

// Get translation models stored on the device.
        /*modelManager.getDownloadedModels(TranslateRemoteModel::class.java)
                .addOnSuccessListener { models ->
                    // ...
                }
                .addOnFailureListener {
                    // Error.
                }*/

        val conditions = DownloadConditions.Builder()
//                .requireWifi()
                .build()

        val englishModel = TranslateRemoteModel.Builder(TranslateLanguage.ENGLISH).build()
//        modelManager.deleteDownloadedModel(englishModel)
        modelManager.download(englishModel, conditions)
                .addOnSuccessListener {
                    Log.i("Info", "All Downloaded")
                }
                .addOnFailureListener {
                    Log.e("Info", it.toString())
                }

        val russianModel = TranslateRemoteModel.Builder(TranslateLanguage.RUSSIAN).build()
//        modelManager.deleteDownloadedModel(russianModel)
        modelManager.download(russianModel, conditions)
                .addOnSuccessListener {
                    Log.i("Info", "All Downloaded")
                }
                .addOnFailureListener {
                    Log.e("Info", it.toString())
                }
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
                setOf(
                R.id.navigation_home, R.id.navigation_dashboard
                )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        /*val optionsBuilderEnToRu = TranslatorOptions.Builder()
        val optionsBuilderRutoEn = TranslatorOptions.Builder()
        optionsBuilderEnToRu
                .setSourceLanguage(TranslateLanguage.ENGLISH)
                .setTargetLanguage(TranslateLanguage.RUSSIAN)
        optionsBuilderRutoEn
                .setSourceLanguage(TranslateLanguage.RUSSIAN)
                .setTargetLanguage(TranslateLanguage.ENGLISH)
        val optionsEnToRu = optionsBuilderEnToRu.build()
        val englishToRussianTranslator = Translation.getClient(optionsEnToRu)
        var conditions = DownloadConditions.Builder()
                .requireWifi()
                .build()
        englishToRussianTranslator.downloadModelIfNeeded(conditions)
                .addOnSuccessListener {
                    Toast.makeText(this, "Downloading file of translator", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { exception: Exception ->
                    Toast.makeText(this, "Some problem happend\ntry again", Toast.LENGTH_SHORT).show()
                }

        val optionsRuToEn = optionsBuilderEnToRu.build()
        val russianToEnglishTranslator = Translation.getClient(optionsEnToRu)
        englishToRussianTranslator.downloadModelIfNeeded(conditions)
                .addOnSuccessListener {
                    Toast.makeText(this, "Downloading file of translator", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { exception: Exception ->
                    Toast.makeText(this, "Some problem happend\ntry again", Toast.LENGTH_SHORT).show()
                }*/

    }


}