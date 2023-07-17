package com.mckj.junkCode.templates.res

import com.mckj.junkCode.util.Helper
import kotlin.random.Random

/**
 * DrawableTemplate
 *
 * @author mmxm
 * @date 2023/7/14 17:33
 */
object StyleTemplate {


    fun randomTemplate(): String {
        val list = arrayListOf<String>()

        list.add(
            String.format(
                "<style name=\"%s\" parent=\"Theme.AppCompat.Light.NoActionBar\">\n" +
                        "\t\t<item name=\"android:textColor\">%s</item>\n" +
                        "\t</style>",
                Helper.randomLengthName(), Helper.randomColor(),
            )
        )

        list.add(
            String.format(
                "<style name=\"%s\" parent=\"Theme.AppCompat.NoActionBar\">\n" +
                        "\t\t<item name=\"android:background\">%s</item>\n" +
                        "\t</style>",
                Helper.randomLengthName(), Helper.randomColor()
            )
        )

        list.add(
            String.format(
                "<style name=\"%s\" parent=\"Theme.AppCompat.DayNight.Dialog.Alert\">\n" +
                        "\t\t<item name=\"colorPrimary\">%s</item>\n" +
                        "\t</style>",
                Helper.randomLengthName(), Helper.randomColor()
            )
        )

        list.add(
            String.format(
                "<style name=\"%s\" parent=\"Theme.AppCompat.Dialog\">\n" +
                        "        <!-- Primary brand color. -->\n" +
                        "        <item name=\"colorPrimary\">%s</item>\n" +
                        "        <item name=\"colorPrimaryDark\">%s</item>\n" +
                        "        <item name=\"colorOnPrimary\">%s</item>\n" +
                        "\n" +
                        "    </style>",
                Helper.randomLengthName(),
                Helper.randomColor(),
                Helper.randomColor(),
                Helper.randomColor()
            )
        )
        return list.random()
    }


    /**
     * 随机生成颜色值
     * @return String
     */
    private fun randomColor(): String {
        // 生成三个随机的RGB值
        val red = Random.nextInt(256)
        val green = Random.nextInt(256)
        val blue = Random.nextInt(256)
        // 将RGB值转换为十六进制表示
        return String.format("#%02x%02x%02x", red, green, blue)
    }
}