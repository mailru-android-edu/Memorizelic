package com.mailprojectteam.memorizelic.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mailprojectteam.memorizelic.R
import com.mailprojectteam.memorizelic.ui.home.HomeViewModel

class DashboardFragment : Fragment() {
        private val text = generateTextList().toMutableList()

        var adapter: TextAdapter? = null

override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
): View? {
    val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
    val rvDeckList: RecyclerView = root.findViewById(R.id.hello_activity__rv_deck_list)
    adapter = TextAdapter(text)
    rvDeckList.adapter = adapter
    rvDeckList.layoutManager = LinearLayoutManager(context)
    val button: FloatingActionButton = root.findViewById(R.id.hello_activity__fab_add_movie)
    button.setOnClickListener { onClick() }
    return root
}

    private fun onClick() {
        text.add(
                Text(
                        requireActivity().getString(R.string.new_text) ,
                        "Новый текст"
                )
        )
        adapter?.notifyDataSetChanged()
    }
}

    private fun generateTextList(): List<Text> {
        return listOf(
                Text(
                        "Doctor",
                        "Doctor Klein: Good morning, Cecilia, how are you feeling today?\n" +
                                "Cecilia: I do not feel very well, Doctor Klein. I hope that you can treat my illness.\n" +
                                "Doctor Klein: I’m sorry that you feel very sick. Tell me some of your symptoms so that I can give you a proper diagnosis.\n" +
                                "Cecilia: I have not felt well since yesterday afternoon. The symptoms began with a headache and a gradual sore throat. I drank tea with lemon and honey, and I went to bed early. However, I am extremely exhausted, and I don’t feel any better today.\n" +
                                "Doctor Klein: I have seen these symptoms recently in some of my other patients. I’ll check your temperature and examine your throat in order to give you a proper diagnosis.\n" +
                                "Cecilia: Thank you, Doctor.\n" +
                                "Doctor Klein: Open up and say “Ahhhhhh...”\n" +
                                "Cecilia: “Ahhhhhh...”\n" +
                                "Doctor Klein: Oh, my! I can already see that your throat is very red. Your temperature of 100 degrees indicates that you are running a mild fever. I am afraid that you might have the flu.\n" +
                                "Cecilia: What is the best way to cure my symptoms?\n" +
                                "Doctor Klein: You will need plenty of rest, and you should drink fluids frequently in order to stay hydrated. You’ve also just started to show symptoms, so I can prescribe you a medication that can reduce fever and shorten the duration of your illness.\n" +
                                "Cecilia: Should I stay home from work as well?\n" +
                                "Doctor Klein: Yes, you should remain in bed until the fever breaks. You should also wait until 24 hours after the fever has broken before you return to work. You do not want to risk getting your coworkers sick as well.\n" +
                                "Cecilia: I suppose I will just take it easy and relax for a couple of days. Thank you, doctor, for all of your help!\n" +
                                "Doctor Klein: No problem! Try your best to rest for a couple of days. I hope you feel better soon!"
                ), Text(
                "The city where I live",
                "My name is Clark, and I will tell you about my city.\n" +
                        "\n" +
                        "I live in an apartment. In my city, there is a post office where people mail letters. On Monday, I go to work. I work at the post office. Everyone shops for food at the grocery store. They also eat at the restaurant. The restaurant serves pizza and ice cream.\n" +
                        "\n" +
                        "My friends and I go to the park. We like to play soccer at the park. On Fridays, we go to the cinema to see a movie. Children don't go to school on the weekend. Each day, people go to the hospital when they are sick. The doctors and nurses take care of them. The police keep everyone safe. I am happy to live in my city."
        ), Text(
                "Human body parts and organs",
                "It goes without saying that humans (mammals identifiable as those that stand upright and are comparatively advanced and capable of detailed thought) have pretty remarkable bodies, given all that they've accomplished. (Furthermore, an especially intelligent human brain produced this text!) To be sure, humans have overcome predators, disease, and all sorts of other obstacles over thousands of years.\n" +
                        "\n" +
                        "To fully understand and appreciate these accomplishments, let's take at some of the most well-known parts of the human body!\n" +
                        "\n" +
                        "The head, or the spherical body part that contains the brain and rests at the top of the human body, has quite a few individual organs and body parts on it. (It should quickly be mentioned that hair occupies the space on top of the head, and the ears, the organs responsible for hearing, are located on either side of the head.) From top to bottom, the eyebrows, or horizontal strips of hair that can be found above the eye, are the first components of the head. The eyes are below them, and are round, orb-like organs that allow humans to see.\n" +
                        "\n" +
                        "The eyes make way for the nose, or an external (sticking-out) organ that plays an important part in the breathing and bacteria-elimination processes. Below that is the mouth, or a wide, cavernous organ that chews food, removes bacteria, helps with breathing, and more. The mouth contains teeth, or small, white-colored, pointed body parts used to chew food, and the tongue, or a red-colored, boneless organ used to chew food and speak.\n" +
                        "\n" +
                        "The neck is the long body part that connects the head to the chest (the muscular body part that protects the heart and lungs), and the stomach, or the part of the body that contains food and liquid-processing organs, comes below that.\n" +
                        "\n" +
                        "The legs are the long, muscular body parts that allow humans to move from one spot to another and perform a variety of actions. Each leg contains a thigh (a thick, especially muscular body part used to perform strenuous motions; the upper part of the leg) and a calf (thinner, more flexible body part that absorbs the shock associated with movement; the lower part of the leg). Feet can be found at the bottom of legs, and each foot is comprised of five toes, or small appendages that help balance.\n" +
                        "\n" +
                        "Arms are long, powerful body parts that are located on either side of chest, below the shoulders;arms are comprised of biceps (the thicker, more powerful upper portion), and forearms (the thinner, more flexible lower portion). Hands, or small, gripping body parts used for a tremendous number of actions, are at the end of arms. Each hand contains five fingers, or small appendages used to grip objects.\n" +
                        "\n" +
                        "The aforementioned shoulders are rounded body parts that aid arms' flexibility. One's back is found on the opposite side of the stomach, and is a flat section of the body that contains important muscles that're intended to protect the lungs and other internal organs, in addition to helping humans perform certain motions and actions."
        ), Text(
                "Las Vegas",
                "Last April, John took a trip to Las Vegas, Nevada. Las Vegas is a popular destination in the western portion of the United States. The town is most popular for its casinos, hotels, and exciting nightlife.\n" +
                        "\n" +
                        "In downtown Las Vegas, John spent a lot of time on The Strip, which is a 2.5 mile stretch of shopping, entertainment venues, luxury hotels, and fine dining experiences. This is probably the most commonly visited tourist area in the city. The Strip at night looks especially beautiful. All of the buildings light up with bright, neon, eye-catching signs to attract visitor attention.\n" +
                        "\n" +
                        "A stay in Las Vegas can feel similar to a visit to many popular cities worldwide. Many of the hotels have miniature versions of important international sites and monuments. These famous landmarks include the Eiffel Tower, Venice, and even ancient Rome.\n" +
                        "\n" +
                        "One day, John took a side trip outside of the city to visit the Grand Canyon, one of the Seven Wonders of the Natural World. The canyon offers a breathtaking view of Nevada’s ridges and natural landscape. John especially liked the canyon because it was removed from all of the noise and movement in downtown Las Vegas.\n" +
                        "\n" +
                        "John had a great time during his trip to Las Vegas. He did not win a lot of money in the casinos. However, he managed to see a lot of amazing sites during his visit to this city that never sleeps."
        ), Text(
                "Washington, D.C.",
                "Yesterday, Stephen returned from a trip to Washington, D.C., the capital of the United States. His visit took place during the week prior to the Fourth of July. Logically, there were many activities and celebrations in town in preparation for Independence Day. During his stay in the city, Stephen visited a lot of important historical sites and monuments, and he left with a deeper understanding of the political history of the United States.\n" +
                        "\n" +
                        "Stephen spent a lot of time outdoors exploring the important monuments surrounding Capitol Hill. Of course, he saw the White House from its outside gate at 1600 Pennsylvania Avenue. Stephen also visited the Washington Monument, the Jefferson Memorial, and the Lincoln Memorial. These statues and pavilions are dedicated to former U.S. presidents. They commemorate the contributions that these leaders made throughout American history. Washington, D.C. also has several war memorials dedicated to fallen soldiers during the major wars of the 20th century.\n" +
                        "\n" +
                        "Away from the Capitol Hill area, Washington, D.C. has many museums and art galleries worth visiting. Stephen enjoyed his visit to Washington, D.C. because he learned a lot more about American history after touring each important landmark."
        ), Text(
                "The four seasons",
                "The four seasons are spring, summer, fall, and winter, and although various areas of the United States experience drastically different weather during these times, all portions of the country recognize the seasons; winter in California may bring heat, and winter in New York may bring blizzards, but both periods are nevertheless winter.\n" +
                        "\n" +
                        "Following winter, spring begins on 20 March and ends on either 20 June or 21 June, in the United States (this date may vary slightly from year to year and hemisphere to hemisphere). For most, spring is a time of \"thawing,\" when the cold and snow of the winter are replaced by sunshine, reasonable temperatures, green grass, and more. It is also the season wherein previously dormant bees and butterflies reemerge, and when birds become more active.\n" +
                        "\n" +
                        "Summer follows spring and spans from about 21 June to 22 September, in America. Summer is the warmest, the longest, and (arguably) the liveliest of the four seasons; students from kindergarten to college are given two or so summer months off from class, and to be sure, there are more young individuals out and about during this season than any other. It's not uncommon to see shorts, t-shirts, and sunglasses worn by those who're soaking up the summer's hot sun, and to stay cool, many individuals crank the air conditioning, take a dip in a swimming pool, and/or explore the ever-comforting ocean waves.\n" +
                        "\n" +
                        "Autumn (or fall), more than being a simple precursor to winter, is one of the most beautiful and exciting seasons. Spanning from 22 September to 21 December (technically, that is; snow will begin to fall long before this latter date, in most parts of the country, leading many to classify the period as winter) in the US, autumn is characterized by falling leaves, Halloween (on 31 October), and Thanksgiving. During fall, traditional farmers harvest their produce, and the aforementioned falling leaves change to gorgeous orange, red, and yellow colors; these colors are generally associated with autumn itself, in turn.\n" +
                        "\n" +
                        "In the US, winter spans from 21 December to 20 March, and is, as one would expect, the coldest of the four seasons. In the eastern, northern, and central portions of the country, winter snowfall can be considerable; in the western and southern portions of the country, winter snowfall is highly unlikely, but temperatures nevertheless drop from their usual. Winter is most widely known for its snow and the Christmas holiday, but it also boasts New Year's Eve (on December 31, in recognition of the start of a new year) and other special days. Ice skating, sledding, ice hockey, and snowball fights are commonly enjoyed winter activities."
        ), Text(
                "Halloween",
                "Halloween (also referred to as All Hollows' Eve) is a holiday that's celebrated in America on 31 October of each year, regardless of what day of the week this date falls on. Although it is rooted in religion, Halloween today is enjoyed mainly because of its decorations, costumes, candy, treats, and general excitement, and furthermore, it is enjoyed by most everyone.\n" +
                        "\n" +
                        "Before Halloween, many individuals carve a design into an orange-colored pumpkin, or a solid, durable vegetable. Once a personally satisfying design is carved, a lit candle is typically put inside a pumpkin, thereby making it a Jack-O-Lantern. At night, this design lights up against the darkness.\n" +
                        "\n" +
                        "Besides carving pumpkins, some celebrate Halloween by putting decorations up. Supernatural (referring in this case to non-natural creatures that're typically based in fiction) figures, including vampires, ghosts, werewolves, zombies, and more, generally account for most of these decorations. Bugs, spiders, cobwebs, gravestones, and anything else that can be considered creepy (or unusual and possibly scary) can also be found on Halloween, in decoration form.\n" +
                        "\n" +
                        "Only some adults celebrate Halloween, and they generally do so by attending parties. Inversely, the vast majority of children dress in costume (Halloween costumes can be based upon anything, from the mentioned supernatural creatures to the stars of today's films) and walk from door to door in search of candy—a practice known as trick or treat—on Halloween. After knocking on a door (houses that participate in Halloween usually leave a light on), one says, \"Trick or Treat\" and a piece (or pieces!) of candy is given to him or her."
        )
        )
}