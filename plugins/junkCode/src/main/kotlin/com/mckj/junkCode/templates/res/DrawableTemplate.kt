package com.mckj.junkCode.templates.res

import com.mckj.junkCode.util.Helper.randomColor
import kotlin.random.Random

/**
 * DrawableTemplate
 *
 * @author mmxm
 * @date 2023/7/14 17:33
 */
object DrawableTemplate {


    fun randomTemplate(): String {
        val list = arrayListOf<String>()
        list.add(
            String.format(
                "<shape xmlns:android=\"http://schemas.android.com/apk/res/android\">\n" +
                        "<solid android:color=\"%s\"/>\n" +
                        "<corners android:radius=\"%sdp\"/>\n" +
                        "</shape>", randomColor(), "${Random.nextInt(10, 100)}"
            )
        )

        list.add(
            String.format(
                "<shape xmlns:android=\"http://schemas.android.com/apk/res/android\">\n" +
                        "<solid android:color=\"%s\"/>\n" +
                        "<corners android:radius=\"%sdp\"/>\n" +
                        "<gradient android:angle=\"%s\" android:endColor=\"%s\" android:startColor=\"%s\"/>\n" +
                        "<stroke android:color=\"%s\" android:width=\"%s\"/>" +
                        "</shape>",
                randomColor(),
                "${Random.nextInt(10, 100)}",
                "${Random.nextInt(10, 100)}",
                randomColor(),
                randomColor(),
                randomColor(),
                "${Random.nextInt(10, 100)}dp"
            )
        )

//        list.add(
//            String.format(
//                "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
//                        "<selector xmlns:android=\"http://schemas.android.com/apk/res/android\">\n" +
//                        "<item android:drawable=\"%s\" android:state_selected=\"false\"/>\n" +
//                        "<item android:drawable=\"%s\" android:state_selected=\"true\"/>\n" +
//                        "</selector>",
//                randomColor(), randomColor()
//            )
//        )

        list.add(
            String.format(
                "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                        "<layer-list xmlns:android=\"http://schemas.android.com/apk/res/android\">\n" +
                        "\t<item>\n" +
                        "\t\t<color android:color=\"%s\"/>\n" +
                        "\t</item>\n" +
                        "</layer-list>",
                randomColor()
            )
        )

        list.add(
            String.format(
                "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                        "<ripple xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                        "\tandroid:color=\"%s\"\n" +
                        "\tandroid:radius=\"%s\">\n" +
                        "\t<item android:width=\"%s\" />\n" +
                        "</ripple>",
                randomColor(),
                "${Random.nextInt(10, 100)}dp",
                "${Random.nextInt(10, 100)}dp",

            )
        )

        return list.random()
    }


}