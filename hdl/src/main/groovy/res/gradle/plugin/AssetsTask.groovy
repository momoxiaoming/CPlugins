package res.gradle.plugin

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * 执行mapping映射替换任务
 */
public class AssetsTask extends DefaultTask {


    @TaskAction
    void confuse() {
        //修改assets下文件名
        println("------------模拟复制生成的debug包======----------")

    }

    /**
     * 随机生成num位小写字母
     * @return
     */
    String randomPrefix(int num) {
        StringBuffer stringBuffer = new StringBuffer()
        for (int i = 0; i < num; i++) {
            char rn = (char) new Random().nextInt(26) + 97
            stringBuffer.append(rn)
        }
        return stringBuffer.toString()
    }
}