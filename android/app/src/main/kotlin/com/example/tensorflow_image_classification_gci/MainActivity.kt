package com.example.tensorflow_image_classification_gci

import android.os.Bundle
import io.flutter.app.FlutterActivity
import io.flutter.plugins.GeneratedPluginRegistrant

class MainActivity: FlutterActivity() {
private val CHANNEL = "com.startActivity/testChannel"
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    provideFlutterEngine(this)?.let { GeneratedPluginRegistrant.registerWith(it) }
    MethodChannel(flutterEngine?.dartExecutor,CHANNEL).setMethodCallHandler{ call, result ->
        if(call.method.equals("StartSecondActivity")){
            val intent= Intent(this,KotlinActivity::class.java)
            startActivity(intent)
            result.success("ActivityStarted")
        }
        else{
            result.notImplemented()
        }
    }
}}
