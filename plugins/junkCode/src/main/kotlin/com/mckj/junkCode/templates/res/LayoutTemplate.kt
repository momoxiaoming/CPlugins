package com.mckj.junkCode.templates.res

import com.mckj.junkCode.util.Helper
import kotlin.random.Random

/**
 * DrawableTemplate
 *
 * @author mmxm
 * @date 2023/7/14 17:33
 */
object LayoutTemplate {



    init {

    }


    fun randomTemplate(): String {
        val list = arrayListOf<String>()
        list.add(
            String.format(
                "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                        "<androidx.constraintlayout.widget.ConstraintLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                        "    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n" +
                        "    xmlns:tools=\"http://schemas.android.com/tools\"\n" +
                        "    android:layout_width=\"match_parent\"\n" +
                        "    android:layout_height=\"match_parent\"\n" +
                        "    tools:context=\".MainActivity\">\n" +
                        "    <TextView\n" +
                        "        android:layout_width=\"wrap_content\"\n" +
                        "        android:layout_height=\"wrap_content\"\n" +
                        "        android:text=\"%s\"\n" +
                        "        app:layout_constraintBottom_toBottomOf=\"parent\"\n" +
                        "        app:layout_constraintLeft_toLeftOf=\"parent\"\n" +
                        "        app:layout_constraintRight_toRightOf=\"parent\"\n" +
                        "        app:layout_constraintTop_toTopOf=\"parent\" />\n" +
                        "</androidx.constraintlayout.widget.ConstraintLayout>",
                Helper.randomLengthName()
            )
        )

        list.add(
            String.format(
                "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                        "<LinearLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                        "\tandroid:orientation=\"vertical\"\n" +
                        "\tandroid:layout_width=\"match_parent\"\n" +
                        "\tandroid:layout_height=\"match_parent\">\n" +
                        "\t<Button\n" +
                        "\t\tandroid:id=\"@+id/btn\"\n" +
                        "\t\tandroid:layout_width=\"match_parent\"\n" +
                        "\t\tandroid:text=\"%s\"\n" +
                        "\t\tandroid:layout_height=\"wrap_content\"/>\n" +
                        "\t<Button\n" +
                        "\t\tandroid:id=\"@+id/btn2\"\n" +
                        "\t\tandroid:layout_width=\"match_parent\"\n" +
                        "\t\tandroid:text=\"%s\"\n" +
                        "\t\tandroid:layout_height=\"wrap_content\"/>\n" +
                        "</LinearLayout>",
                Helper.randomLengthName(), Helper.randomLengthName()
            )
        )

        list.add(
            String.format(
                "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                        "\n" +
                        "<layout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                        "\txmlns:app=\"http://schemas.android.com/apk/res-auto\"\n" +
                        "\txmlns:tools=\"http://schemas.android.com/tools\">\n" +
                        "\t<androidx.constraintlayout.widget.ConstraintLayout\n" +
                        "\t\tandroid:layout_width=\"match_parent\"\n" +
                        "\t\tandroid:layout_height=\"match_parent\">\n" +
                        "\n" +
                        "\t\t<androidx.appcompat.widget.Toolbar\n" +
                        "\t\t\tandroid:id=\"@+id/titleBar\"\n" +
                        "\t\t\tandroid:layout_width=\"match_parent\"\n" +
                        "\t\t\tandroid:layout_height=\"wrap_content\"\n" +
                        "\t\t\tandroid:fitsSystemWindows=\"true\"\n" +
                        "\t\t\tapp:contentInsetStart=\"%s\"\n" +
                        "\t\t\tapp:layout_constraintEnd_toEndOf=\"parent\"\n" +
                        "\t\t\tapp:layout_constraintStart_toStartOf=\"parent\"\n" +
                        "\t\t\tapp:layout_constraintTop_toTopOf=\"parent\"\n" +
                        "\t\t\tapp:titleTextColor=\"%s\" />\n" +
                        "\n" +
                        "\t\t<WebView\n" +
                        "\t\t\tandroid:id=\"@+id/webView\"\n" +
                        "\t\t\tandroid:layout_width=\"match_parent\"\n" +
                        "\t\t\tandroid:layout_height=\"%s\"\n" +
                        "\t\t\tapp:layout_constraintBottom_toBottomOf=\"parent\"\n" +
                        "\t\t\tapp:layout_constraintTop_toBottomOf=\"@id/titleBar\" />\n" +
                        "\t</androidx.constraintlayout.widget.ConstraintLayout>\n" +
                        "\n" +
                        "\n" +
                        "</layout>",
                "${Random.nextInt(10, 100)}dp", Helper.randomColor(), "${Random.nextInt(10, 100)}dp"
            )
        )

        list.add(
            String.format(
                "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                        "<layout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                        "    xmlns:app=\"http://schemas.android.com/apk/res-auto\">\n" +
                        "    <androidx.constraintlayout.widget.ConstraintLayout\n" +
                        "        android:id=\"@+id/root_layout\"\n" +
                        "        android:layout_width=\"match_parent\"\n" +
                        "        android:layout_height=\"match_parent\">\n" +
                        "        <FrameLayout\n" +
                        "            android:id=\"@+id/ad_layout\"\n" +
                        "            android:layout_width=\"%s\"\n" +
                        "            android:layout_height=\"%s\"\n" +
                        "            app:layout_constraintBottom_toBottomOf=\"parent\"\n" +
                        "            app:layout_constraintEnd_toEndOf=\"parent\"\n" +
                        "            app:layout_constraintStart_toStartOf=\"parent\"\n" +
                        "            app:layout_constraintTop_toTopOf=\"parent\" />\n" +
                        "    </androidx.constraintlayout.widget.ConstraintLayout>\n" +
                        "</layout>",
                "${Random.nextInt(10, 100)}dp", "${Random.nextInt(10, 100)}dp"
            )
        )
        list.add(
            String.format(
                "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                        "<LinearLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                        "\tandroid:orientation=\"vertical\"\n" +
                        "\tandroid:layout_width=\"match_parent\"\n" +
                        "\tandroid:layout_height=\"match_parent\">\n" +
                        "\t<TextView\n" +
                        "\t\tandroid:layout_width=\"wrap_content\" \n" +
                        "\t\tandroid:text=\"%s\"\n" +
                        "\t\tandroid:layout_height=\"wrap_content\"/>\n" +
                        "\t<TextView\n" +
                        "\t\tandroid:layout_width=\"wrap_content\"\n" +
                        "\t\tandroid:text=\"%s\"\n" +
                        "\t\tandroid:layout_height=\"wrap_content\"/>\n" +
                        "\n" +
                        "\t<TextView\n" +
                        "\t\tandroid:layout_width=\"wrap_content\"\n" +
                        "\t\tandroid:text=\"%s\"\n" +
                        "\t\tandroid:layout_height=\"wrap_content\"/>\n" +
                        "</LinearLayout>",
                Helper.randomLengthName(), Helper.randomLengthName(), Helper.randomLengthName()
            )
        )
        list.add(
            String.format(
                "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                        "<ImageView xmlns:android=\"http://schemas.android.com/apk/res/android\" android:layout_gravity=\"center_vertical\" android:id=\"@+id/%s\" android:duplicateParentState=\"true\" android:layout_width=\"wrap_content\" android:layout_height=\"wrap_content\" android:layout_marginLeft=\"8dp\" android:layout_marginTop=\"8dp\" android:layout_marginRight=\"-8dp\" android:layout_marginBottom=\"8dp\" android:scaleType=\"centerInside\" android:layout_marginStart=\"%s\" android:layout_marginEnd=\"%s\"/>",
                Helper.randomLengthName(),"${Random.nextInt(10, 100)}dp", "${Random.nextInt(10, 100)}dp"
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