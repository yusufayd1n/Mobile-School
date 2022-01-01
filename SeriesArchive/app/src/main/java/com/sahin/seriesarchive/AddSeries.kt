package com.sahin.seriesarchive

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.database.sqlite.SQLiteDatabase
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.sahin.seriesarchive.databinding.ActivityAddSeriesBinding
import java.io.ByteArrayOutputStream
import java.lang.Exception

class AddSeries : AppCompatActivity() {

    private lateinit var binding : ActivityAddSeriesBinding
    private lateinit var activityResultLauncher: ActivityResultLauncher<Intent>
    private lateinit var permissionResultLauncher: ActivityResultLauncher<String>
    var selectedBitmap : Bitmap? = null
    private lateinit var dataBase:SQLiteDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAddSeriesBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        dataBase=this.openOrCreateDatabase("Series", MODE_PRIVATE,null)
        registerLaunchers()

        val intent =intent
        val control=intent.getIntExtra("control",3)
        if(control==0){
            binding.saveButton.visibility=View.INVISIBLE
            val selectedId=intent.getIntExtra("id",1)

            val cursor=dataBase.rawQuery("SELECT * FROM series WHERE id=?", arrayOf(selectedId.toString()))

            val seriesNameIX=cursor.getColumnIndex("seriesname")
            val leadRoleIx=cursor.getColumnIndex("leadrole")
            val imdbIx=cursor.getColumnIndex("imdb")
            val imageIx=cursor.getColumnIndex("image")

            while (cursor.moveToNext()){
                binding.seriesNameEditText.setText(cursor.getString(seriesNameIX))
                binding.seriesLeadRoleEditText.setText(cursor.getString(leadRoleIx))
                binding.seriesImdbPointEditText.setText(cursor.getString(imdbIx))

                val byteArray=cursor.getBlob(imageIx)
                val bitmap=BitmapFactory.decodeByteArray(byteArray,0,byteArray.size)
                binding.selectImageView.setImageBitmap(bitmap)
            }
            cursor.close()
        }else{
            binding.seriesNameEditText.setText("")
            binding.seriesLeadRoleEditText.setText("")
            binding.seriesImdbPointEditText.setText("")
            binding.saveButton.visibility=View.VISIBLE
            binding.selectImageView.setImageResource(R.drawable.selectimage)
        }
    }

    fun saveSeries(view:View){
        val seriesName=binding.seriesNameEditText.text.toString()
        val leadRoleName=binding.seriesLeadRoleEditText.text.toString()
        val imdbPoint=binding.seriesImdbPointEditText.text.toString()


        if(selectedBitmap!=null){
            val smallBitmap = reduceSize(selectedBitmap!!,300)

            //image to bytes
            val outputStream=ByteArrayOutputStream()
            smallBitmap.compress(Bitmap.CompressFormat.PNG,50,outputStream)
            val byteArray=outputStream.toByteArray()

            try {
                dataBase.execSQL("CREATE TABLE IF NOT EXISTS series(id INTEGER PRIMARY KEY,seriesname VARCHAR,leadrole VARCHAR,imdb VARCHAR,image BLOB)")
                val sqlString="INSERT INTO series(seriesname,leadrole,imdb,image) VALUES(?,?,?,?)"
                val statement=dataBase.compileStatement(sqlString)
                statement.bindString(1,seriesName)
                statement.bindString(2,leadRoleName)
                statement.bindString(3,imdbPoint)
                statement.bindBlob(4,byteArray)
                statement.execute()
            }catch (e:Exception){
                e.printStackTrace()
            }
            val intent=Intent(this@AddSeries,MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)

        }
    }

    private fun reduceSize(image:Bitmap,maximumSize:Int):Bitmap{
        var width=image.width
        var height=image.height

        val bitmapRatio : Double = width.toDouble()/height.toDouble()

         if(bitmapRatio>1){
             //yatay
             width=maximumSize
             val scaledHeight=width/bitmapRatio
             height = scaledHeight.toInt()
         }else{
             //dikey
             height=maximumSize
             val scaledWidth=height*bitmapRatio
             width= scaledWidth.toInt()
         }

        return Bitmap.createScaledBitmap(image,width,height,true)
    }

    fun selectImage(view:View){
        if(ContextCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED){
             if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.READ_EXTERNAL_STORAGE)){
                 Snackbar.make(view,"Galeri için izin gerekiyor",Snackbar.LENGTH_INDEFINITE).setAction("İzin Ver!",View.OnClickListener {
                     permissionResultLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
                 }).show()
             }else{
                 permissionResultLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
             }

        }else{
            val intentToStorage=Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            activityResultLauncher.launch(intentToStorage)

        }
    }

    private fun registerLaunchers(){
        activityResultLauncher=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){success->

            if(success.resultCode== RESULT_OK){
                val intentResult=success.data
                if(intentResult!=null){
                    val seriesImageData=intentResult.data
                    if(seriesImageData!=null){
                        try {
                            if(Build.VERSION.SDK_INT>=28){
                                val source=ImageDecoder.createSource(this@AddSeries.contentResolver,seriesImageData)
                                selectedBitmap=ImageDecoder.decodeBitmap(source)
                                binding.selectImageView.setImageBitmap(selectedBitmap)
                            }else{
                                selectedBitmap = MediaStore.Images.Media.getBitmap(contentResolver,seriesImageData)
                                binding.selectImageView.setImageBitmap(selectedBitmap)
                            }

                        }catch (e:Exception){
                            e.printStackTrace()
                        }
                    }

                }
            }
        }

        permissionResultLauncher=registerForActivityResult(ActivityResultContracts.RequestPermission()){success->
            if(success){
                val intentToStorage=Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                activityResultLauncher.launch(intentToStorage)
            }else{
                Toast.makeText(this@AddSeries, "İzin Gerekiyor!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}