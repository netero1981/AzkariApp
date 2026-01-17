
package com.azkari;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

// Model class
class AzkarItem {
    String title;
    String text;
    boolean isHeader;

    AzkarItem(String title, String text, boolean isHeader) {
        this.title = title;
        this.text = text;
        this.isHeader = isHeader;
    }
}

public class AzkarActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<AzkarItem> azkarList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_azkar);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        azkarList = new ArrayList<>();
        loadAzkar(); // هنا نضيف الأذكار

        AzkarAdapter adapter = new AzkarAdapter(azkarList);
        recyclerView.setAdapter(adapter);
    }

    private void loadAzkar() {
        // -----------------------------
        // 30 أذكار الصباح
        // -----------------------------
        azkarList.add(new AzkarItem("أذكار الصباح", "", true));

        azkarList.add(new AzkarItem("1",
                "أصبحنا وأصبح الملك لله، والحمد لله، لا إله إلا الله وحده لا شريك له، له الملك وله الحمد وهو على كل شيء قدير...",
                false));

        azkarList.add(new AzkarItem("2",
                "اللهم بك أصبحنا وبك أمسينا، وبك نحيا وبك نموت وإليك المصير.",
                false));

        azkarList.add(new AzkarItem("3",
                "رضيت بالله رباً وبالإسلام ديناً وبمحمد ﷺ نبياً.",
                false));

        azkarList.add(new AzkarItem("4",
                "أستغفر الله الذي لا إله إلا هو الحي القيوم وأتوب إليه.",
                false));

        azkarList.add(new AzkarItem("5",
                "اللهم إني أصبحت أشهدك وأشهد حملة عرشك وملائكتك وجميع خلقك أنك أنت الله لا إله إلا أنت وحدك لا شريك لك وأن محمدًا عبدك ورسولك.",
                false));

        azkarList.add(new AzkarItem("6",
                "اللهم إني أسألك علماً نافعاً، ورزقاً طيباً، وعملاً متقبلاً.",
                false));

        azkarList.add(new AzkarItem("7",
                "اللهم إني أعوذ بك من الكسل والهرم، ومن عذاب القبر، ومن فتنة المحيا والممات، ومن شر فتنة المسيح الدجال.",
                false));

        azkarList.add(new AzkarItem("8",
                "اللهم إني أعوذ بك من شر ما عملت ومن شر ما لم أعمل.",
                false));

        azkarList.add(new AzkarItem("9",
                "بسم الله الذي لا يضر مع اسمه شيء في الأرض ولا في السماء وهو السميع العليم.",
                false));

        azkarList.add(new AzkarItem("10",
                "اللهم إني أعوذ بك من الجبن والبخل، وأعوذ بك من أن أُردّ إلى أرذل العمر، وأعوذ بك من فتنة الدنيا وعذاب القبر.",
                false));

        azkarList.add(new AzkarItem("11",
                "اللهم إني أعوذ بك من عذاب جهنم ومن عذاب القبر ومن فتنة المحيا والممات ومن شر فتنة المسيح الدجال.",
                false));

        azkarList.add(new AzkarItem("12",
                "أعوذ بكلمات الله التامات من شر ما خلق.",
                false));

        azkarList.add(new AzkarItem("13",
                "اللهم إني أصبحت في نعمة منك، ورضا من عندك، وعافية منك، وأسألك من فضلك العظيم.",
                false));

        azkarList.add(new AzkarItem("14",
                "اللهم إني أصبحت أشكو إليك ضعف قوتي، وقلة حيلتي، وهواني على الناس.",
                false));

        azkarList.add(new AzkarItem("15",
                "اللهم إني أعوذ بك من شر ما أجد وأحاذر، ومن شر كل دابة أنت آخذ بناصيتها.",
                false));

        azkarList.add(new AzkarItem("16",
                "اللهم إني أسألك خير هذا اليوم، فتحه ونصره ونوره وبركته وهدايته، وأعوذ بك من شر ما فيه وشر ما بعده.",
                false));

        azkarList.add(new AzkarItem("17",
                "اللهم إني أسألك الهدى والتقى والعفاف والغنى.",
                false));

        azkarList.add(new AzkarItem("18",
                "اللهم إني أسألك حبك وحب من يحبك وحب عمل يقربني إلى حبك.",
                false));

        azkarList.add(new AzkarItem("19",
                "اللهم اجعلني من التوابين واجعلني من المتطهرين.",
                false));

        azkarList.add(new AzkarItem("20",
                "اللهم إني أعوذ بك من شر نفسي ومن شر كل دابة أنت آخذ بناصيتها.",
                false));

        azkarList.add(new AzkarItem("21",
                "سبحان الله وبحمده عدد خلقه ورضا نفسه وزنة عرشه ومداد كلماته.",
                false));

        azkarList.add(new AzkarItem("22",
                "اللهم صل وسلم على نبينا محمد وعلى آله وصحبه وسلم.",
                false));

        azkarList.add(new AzkarItem("23",
                "أعوذ بكلمات الله التامة من غضبه وعقابه ومن شر عباده ومن همزات الشياطين وأن يحضرون.",
                false));

        azkarList.add(new AzkarItem("24",
                "اللهم إني أسألك عيشة طيبة، وميتة سوية، ومرداً غير مخزٍ ولا فاضح.",
                false));

        azkarList.add(new AzkarItem("25",
                "اللهم إني أسألك من خير ما تعلم، وأعوذ بك من شر ما تعلم.",
                false));

        azkarList.add(new AzkarItem("26",
                "اللهم إني أسألك خير هذا اليوم وخير ما بعده، وأعوذ بك من شر هذا اليوم وشر ما بعده.",
                false));

        azkarList.add(new AzkarItem("27",
                "اللهم إني أسألك العفو والعافية في الدنيا والآخرة.",
                false));

        azkarList.add(new AzkarItem("28",
                "اللهم إني أعوذ بك من الهم والحزن، والعجز والكسل، والجبن والبخل، وضلع الدين وغلبة الرجال.",
                false));

        azkarList.add(new AzkarItem("29",
                "أصبحنا وأصبح الملك لله، والحمد لله، لا إله إلا الله وحده لا شريك له، له الملك وله الحمد وهو على كل شيء قدير.",
                false));

        azkarList.add(new AzkarItem("30",
                "اللهم إني أسألك رحمة من عندك تهدي بها قلبي وتجمع بها شتاتي وتلم بها شعثي وترد بها ألفتي وتلهمني رشدي وتعينني على ذكرك وشكرك وحسن عبادتك.",
                false));

        // -----------------------------
        // 30 أذكار المساء
        // -----------------------------
        azkarList.add(new AzkarItem("أذكار المساء", "", true));

        azkarList.add(new AzkarItem("1",
                "أمسينا وأمس الملك لله، والحمد لله، لا إله إلا الله وحده لا شريك له، له الملك وله الحمد وهو على كل شيء قدير...",
                false));

        azkarList.add(new AzkarItem("2",
                "اللهم بك أمسينا وبك أصبحنا، وبك نحيا وبك نموت وإليك المصير.",
                false));

        azkarList.add(new AzkarItem("3",
                "رضيت بالله رباً وبالإسلام ديناً وبمحمد ﷺ نبياً.",
                false));

        azkarList.add(new AzkarItem("4",
                "أستغفر الله الذي لا إله إلا هو الحي القيوم وأتوب إليه.",
                false));

        azkarList.add(new AzkarItem("5",
                "اللهم إني أمسيت أشهدك وأشهد حملة عرشك وملائكتك وجميع خلقك أنك أنت الله لا إله إلا أنت وحدك لا شريك لك وأن محمدًا عبدك ورسولك.",
                false));

        azkarList.add(new AzkarItem("6",
                "اللهم إني أسألك علماً نافعاً، ورزقاً طيباً، وعملاً متقبلاً.",
                false));

        azkarList.add(new AzkarItem("7",
                "اللهم إني أعوذ بك من الكسل والهرم، ومن عذاب القبر، ومن فتنة المحيا والممات، ومن شر فتنة المسيح الدجال.",
                false));

        azkarList.add(new AzkarItem("8",
                "اللهم إني أعوذ بك من شر ما عملت ومن شر ما لم أعمل.",
                false));

        azkarList.add(new AzkarItem("9",
                "بسم الله الذي لا يضر مع اسمه شيء في الأرض ولا في السماء وهو السميع العليم.",
                false));

        azkarList.add(new AzkarItem("10",
                "اللهم إني أعوذ بك من الجبن والبخل، وأعوذ بك من أن أُردّ إلى أرذل العمر، وأعوذ بك من فتنة الدنيا وعذاب القبر.",
                false));

        azkarList.add(new AzkarItem("11",
                "اللهم إني أعوذ بك من عذاب جهنم ومن عذاب القبر ومن فتنة المحيا والممات ومن شر فتنة المسيح الدجال.",
                false));

        azkarList.add(new AzkarItem("12",
                "أعوذ بكلمات الله التامات من شر ما خلق.",
                false));

        azkarList.add(new AzkarItem("13",
                "اللهم إني أمسيت في نعمة منك، ورضا من عندك، وعافية منك، وأسألك من فضلك العظيم.",
                false));

        azkarList.add(new AzkarItem("14",
                "اللهم إني أمسيت أشكو إليك ضعف قوتي، وقلة حيلتي، وهواني على الناس.",
                false));

        azkarList.add(new AzkarItem("15",
                "اللهم إني أعوذ بك من شر ما أجد وأحاذر، ومن شر كل دابة أنت آخذ بناصيتها.",
                false));

        azkarList.add(new AzkarItem("16",
                "اللهم إني أسألك خير هذه الليلة، فتحها ونصرها ونورها وبركتها وهدايتها، وأعوذ بك من شر ما فيها وشر ما بعدها.",
                false));

        azkarList.add(new AzkarItem("17",
                "اللهم إني أسألك الهدى والتقى والعفاف والغنى.",
                false));

        azkarList.add(new AzkarItem("18",
                "اللهم إني أسألك حبك وحب من يحبك وحب عمل يقربني إلى حبك.",
                false));

        azkarList.add(new AzkarItem("19",
                "اللهم اجعلني من التوابين واجعلني من المتطهرين.",
                false));

        azkarList.add(new AzkarItem("20",
                "اللهم إني أعوذ بك من شر نفسي ومن شر كل دابة أنت آخذ بناصيتها.",
                false));

        azkarList.add(new AzkarItem("21",
                "سبحان الله وبحمده عدد خلقه ورضا نفسه وزنة عرشه ومداد كلماته.",
                false));

        azkarList.add(new AzkarItem("22",
                "اللهم صل وسلم على نبينا محمد وعلى آله وصحبه وسلم.",
                false));

        azkarList.add(new AzkarItem("23",
                "أعوذ بكلمات الله التامة من غضبه وعقابه ومن شر عباده ومن همزات الشياطين وأن يحضرون.",
                false));

        azkarList.add(new AzkarItem("24",
                "اللهم إني أسألك عيشة طيبة، وميتة سوية، ومرداً غير مخزٍ ولا فاضح.",
                false));

        azkarList.add(new AzkarItem("25",
                "اللهم إني أسألك من خير ما تعلم، وأعوذ بك من شر ما تعلم.",
                false));

        azkarList.add(new AzkarItem("26",
                "اللهم إني أسألك خير هذه الليلة وخير ما بعدها، وأعوذ بك من شر هذه الليلة وشر ما بعدها.",
                false));

        azkarList.add(new AzkarItem("27",
                "اللهم إني أسألك العفو والعافية في الدنيا والآخرة.",
                false));

        azkarList.add(new AzkarItem("28",
                "اللهم إني أعوذ بك من الهم والحزن، والعجز والكسل، والجبن والبخل، وضلع الدين وغلبة الرجال.",
                false));

        azkarList.add(new AzkarItem("29",
                "أمسينا وأمس الملك لله، والحمد لله، لا إله إلا الله وحده لا شريك له، له الملك وله الحمد وهو على كل شيء قدير.",
                false));

        azkarList.add(new AzkarItem("30",
                "اللهم إني أسألك رحمة من عندك تهدي بها قلبي وتجمع بها شتاتي وتلم بها شعثي وترد بها ألفتي وتلهمني رشدي وتعينني على ذكرك وشكرك وحسن عبادتك.",
                false));
    }
}
