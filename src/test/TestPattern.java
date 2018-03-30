import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestPattern {
    public static void main(String[] args) throws ParseException {

        String a = "a";
        Pattern pattern = Pattern.compile("\\d+.\\d+.\\d+|\\d+.\\d+|\\d+..\\d+..\\d+|\\d+..\\d+");
        Matcher matcher = pattern.matcher("大家好！\n" +
                "学生于勤芬汇报2018年2月22日功课早5点起.早晚各背《心经》21遍，全天打坐念佛1小时.诵《无量寿经》一部.诵《地藏经》一部(共257遍).读《了凡四训谦德之效一遍(共63遍).读《佛说八人觉经》1遍(共1097遍)并学习《阿难问事佛吉凶经》讲记第七集的第3讲。朗读《让世界因为我而美丽》(263天)未大拜108拜.早晚课做..抄写并读诵《群书治要360》之一百四十四，愿以此功德，普及于一切！\n" +
                "我等与众生，皆共成佛道！\n" +
                "南无阿弥陀佛\uD83D\uDE4F\uD83D\uDE4F\uD83D\uDE4F" +
                "\uD83D\uDE4F\uD83D\uDE4F\uD83D\uDE4F\uD83D\uDE4F\uD83D\uDE4F\uD83D\uDE4F\uD83D\uDE4F\uD83D\uDE4F\uD83D\uDE4F\n");
        if (matcher.find()) {
            String test = matcher.group();
            System.out.println(test);
            Pattern pattern1 = Pattern.compile("\\d+");
            Matcher matcher1 = pattern1.matcher(test);
            ArrayList list = new ArrayList();
            while (matcher1.find()) {
                list.add(matcher1.group());
            }
            if (list.size() == 2) {
                String aa = "2018-" + list.get(0) + "-" + list.get(1);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                sdf.parse(aa);
                System.out.println(sdf.parse(aa));
            }
            if (list.size() == 3) {
                String bb = list.get(0) + "-" + list.get(1) + "-" + list.get(2);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                sdf.parse(bb);
                System.out.println(sdf.parse(bb));
            }
        }
//        while (matcher.find()) {
//            System.out.println(matcher.group());
//        }

    }
}
