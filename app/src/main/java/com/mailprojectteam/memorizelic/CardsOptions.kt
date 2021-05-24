package com.mailprojectteam.memorizelic

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.mailprojectteam.memorizelic.ui.home.Deck
import okhttp3.*
import java.io.Serializable

const val BASE_URL =  "https://google-translate1.p.rapidapi.com/"

class CardsOptions : AppCompatActivity(), Comunicator, ComunicatorFinishTest, ComunicatorReturnToDeck{

    var jsonResults: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContentView(R.layout.cards_options)
        val deck = intent.getSerializableExtra("deck") as Deck

        val fragmentDeck = FragmentDeck()
        val bundle = Bundle()
        bundle.putSerializable("deck", deck)
        fragmentDeck.arguments = bundle

        val trasactionDeck = supportFragmentManager
                .beginTransaction().replace(R.id.fragment_container, fragmentDeck)
                .commit()


        var checkLang: Boolean = true

//        val languages = arrayOf("English","Russian")

        /*val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                languages
        )*/
        /*adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)

        val spinner: Spinner = findViewById(R.id.spinner)

        spinner.adapter = adapter*/

        /*val startSettingsButton: Button = findViewById(R.id.button_start_test);

        startSettingsButton.setOnClickListener {
            val intent = Intent(this@CardsOptions, CardPage::class.java)
            startActivity(intent)
        }

        val swipeButton: ImageView = findViewById(R.id.swipe_but)
        val leftText: TextView = findViewById(R.id.text_left)
        val rightText: TextView = findViewById(R.id.text_right)
        val wordsAmo: TextView = findViewById(R.id.text_statistic)

        wordsAmo.setText(wordAmount.toString())
        swipeButton.setOnClickListener {
            if (checkLang) {
                rightText.setText(getString(R.string.language_En))
                leftText.setText(getString(R.string.language_Ru))
                checkLang = false
            } else {
                rightText.setText(getString(R.string.language_Ru))
                leftText.setText(getString(R.string.language_En))
                checkLang = true
            }
        }

        val startDialog: Button = findViewById(R.id.start_dialog)
        startDialog.setOnClickListener {


            val mDialogView = LayoutInflater.from(this).inflate(R.layout.edit_text_layout, null)
            val swipeButtonDia: ImageView = mDialogView.findViewById(R.id.swipe_but)
            val leftTextDia: TextView = mDialogView.findViewById(R.id.text_left)
            val rightTextDia: TextView = mDialogView.findViewById(R.id.text_right)
            var checkDiaLanguage: Boolean = true

            swipeButtonDia.setOnClickListener {
                if (checkDiaLanguage) {
                    rightTextDia.setText(getString(R.string.language_En))
                    leftTextDia.setText(getString(R.string.language_Ru))
                    checkDiaLanguage = false
                } else {
                    rightTextDia.setText(getString(R.string.language_Ru))
                    leftTextDia.setText(getString(R.string.language_En))
                    checkDiaLanguage = true
                }
            }


            val mBuilder = AlertDialog.Builder(this)
                    .setView(mDialogView)
                    .setTitle("Add your word")
            mBuilder.setPositiveButton("Ok") { _, _ ->
                word = mDialogView.findViewById<EditText>(R.id.word_edittext).text.toString()
                // Логгер запросов. Его желательно подключать только во время разработки и не оставлять в релизных сборках
                val logging = HttpLoggingInterceptor().apply {
                    setLevel(HttpLoggingInterceptor.Level.BODY)
                }

                val client = OkHttpClient.Builder()
                        .addNetworkInterceptor(logging)
                        .build()

                val gson = GsonBuilder()
                        .create()

                val retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .client(client)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build()
                        .create(RetrofitServices::class.java)

                GlobalScope.launch(Dispatchers.IO) {
                    try {

                        val response = retrofit.getTranslate().awaitResponse()
                        if (response.isSuccessful) {

                            val data = response.body()!!

                            Toast.makeText(
                                this@CardsOptions,
                                data.toString(),
                                Toast.LENGTH_SHORT
                            ).show()

                        }

                    } catch (e: Exception) {
                            Toast.makeText(
                                this@CardsOptions,
                                    "Seems like something went wrong...",
                                    Toast.LENGTH_SHORT
                            ).show()
                    }
                }

                *//*val test = Get()
                    test.run(word, checkDiaLanguage, this,
                            object : Callback {

                                override fun onFailure(call: Call, e: IOException) {
                                    Toast.makeText(
                                            this@CardsOptions,
                                            "Something gone wrong",
                                            Toast.LENGTH_SHORT
                                    ).show()
                                }

                                override fun onResponse(call: Call, response: Response) {

                                    Handler(Looper.getMainLooper()).post {
                                        Log.d("Message", response.toString())
                                        Toast.makeText(
                                                this@CardsOptions,
                                                response.toString(),
                                                Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                }
                            })*//*
                }

                mBuilder.setNegativeButton("Cancel") { dialog, _ ->
                    dialog.dismiss()
                }
                val mAlertDialog = mBuilder.show()*/

                /*val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
            val height = (resources.displayMetrics.heightPixels * 0.40).toInt()
            mAlertDialog!!.window?.setLayout(width, height)*/
//            MyCustomDialog().show(supportFragmentManager, "Write down your word")
                /*val edittext: EditText = findViewById(R.id.word_edittext)
            Toast.makeText(
                    this,
                    edittext.hint,
                    Toast.LENGTH_SHORT
            ).show()
            }*/

            /*spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent:AdapterView<*>, view: View, position: Int, id: Long){
                textForSpinner.text = "Spinner selected : ${parent.getItemAtPosition(position).toString()}"
            }*/
        }


        /*class Get {
            @Throws(IOException::class)
            fun run(word: String?, checkLang: Boolean, context: Context, callback: Callback) {
                Thread {
                    var client = OkHttpClient()
                    val mediaType = "application/x-www-form-urlencoded".toMediaTypeOrNull()
                    var contents: String
//                val mediaType = "application/x-www-form-urlencoded".toMediaTypeOrNull()
                    if (checkLang) {
                        contents = "q=Hello%2C%20world&target=ru&source=en"
                    } else {
                        contents = "q=Hello%2C%20world&target=en&source=ru"
                    }
                    val body = RequestBody.create(mediaType, "q=Hello%2C%20world&target=ru&source=en")
                    val request = Request.Builder()
                            .url("https://google-translate1.p.rapidapi.com/language/translate/v2")
                            .post(body)
                            .addHeader("content-type", "application/x-www-form-urlencoded")
                            .addHeader("accept-encoding", "application/gzip")
                            .addHeader("x-rapidapi-key", "09b7bf987emshf956815a19e422fp184e3djsn3d317e876483")
                            .addHeader("x-rapidapi-host", "google-translate1.p.rapidapi.com")
                            .build()

                    client.newCall(request).enqueue(callback)
                }.start()
            }

            }*/
            //context.getString(R.string.key_rapidAPI
//                println(response)
//                val response =
//                Toast.makeText(context, response.toString(), Toast.LENGTH_SHORT).show()
//                val sResponse: String = response.body!!.toString()



    override fun passDataToNewFragment(deck: Deck, numberInList: Int, arrayList: ArrayList<String>, langEnToRu: Boolean, arrayBoolean: BooleanArray) {
        val bundle = Bundle()
        bundle.putSerializable("deck", deck)
        bundle.putInt("numberInList", numberInList)
        bundle.putStringArrayList("list", arrayList)
        bundle.putBoolean("langEnToRu", langEnToRu)
        bundle.putBooleanArray("arrayBoolean", arrayBoolean)

        val transaction = this.supportFragmentManager.beginTransaction()
        val fragmentCard = FragmentCard()
        fragmentCard.arguments = bundle

        transaction.replace(R.id.fragment_container, fragmentCard).commit()
    }

    override fun sendDataToFinishTestFragment(deck: Deck, arrayBoolean: BooleanArray) {
        val bundle = Bundle()
        bundle.putSerializable("deck", deck)
        bundle.putBooleanArray("arrayBoolean", arrayBoolean)

        val transaction = this.supportFragmentManager.beginTransaction()
        val fragmentFinishTest = FragmentFinishTest()
        fragmentFinishTest.arguments = bundle

        transaction.replace(R.id.fragment_container, fragmentFinishTest).commit()
    }

    override fun sendDataToDeckFragment(deck: Deck) {
        val fragmentDeck = FragmentDeck()
        val bundle = Bundle()
        bundle.putSerializable("deck", deck)
        fragmentDeck.arguments = bundle

        val trasactionDeck = supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, fragmentDeck)
                .commit()
    }
}

