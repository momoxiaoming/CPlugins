package res.gradle.plugin.task

import org.gradle.api.DefaultTask
import org.gradle.api.Project
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
/**
 * app打包后,执行此任务
 * 1.找出最终的mapping 相关文件
 * 2.根据现有mapping,合并出插件需要的mapping文件
 * 3.执行插件编译任务
 * 4.将app生成的apk,通过重编译,将插件apk置于assets下
 * 5.输出最终的宿主apk
 */
public class AppAssembleTask extends DefaultTask {
    @Input
    Project rootProj
    @Input
    String buildType

    def mappingLines = new ArrayList<String>()
    def seedLines = new ArrayList<String>()

    def readSeeds = new HashMap<String, ArrayList<String>>()
    def readMappings = new HashMap<String, ArrayList<String>>()


    @TaskAction
    void confuse() {
        if (buildType.toLowerCase() == "debug") {
            //跳过合并阶段

        } else {
            //开始合并mapping


            mergeMapping()
        }

    }


    /**
     * 合并mapping
     * @return
     */
    private void mergeMapping() {

        println("开始合并mapping和seeds")
        def mappingFile = new File(rootProj.buildDir , "/outputs/mapping/${buildType.toLowerCase()}/mapping.txt")
        println("mapping是否存在-->${mappingFile.exists()}")

        mappingLines.addAll(mappingFile.readLines())
        println("开始合并2")

        def seedFile = new File(rootProj.buildDir , "/outputs/mapping/${buildType.toLowerCase()}/seeds.txt")
        println("seedFile是否存在-->${seedFile.exists()}")

        seedLines.addAll(seedFile.readLines())

        println("读取mapping和seeds完成")
        readSeeds = readSeeds()
        readMappings = readMapping()

        def newMappFileDir=new File(rootProj.buildDir, "/hdl/mapping")
        if(!newMappFileDir.exists()){
            newMappFileDir.mkdirs()
        }
        def newMappFile=new File(newMappFileDir,"mapping.txt")

        if(newMappFile.exists()){
            newMappFile.delete()
        }
        newMappFile.createNewFile()
        def mapping=mappingToSeeds()

        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(newMappFile,true), "UTF-8");//指定以UTF-8格式写入文件
        for(String key:mapping.keySet()){
            def list=mapping.get(key)
            if(!key.endsWith("\n")){
                osw.write(key+"\n")
            }else{
                osw.write(key)
            }
            for(String line:list){
                if(!line.endsWith("\n")){
                    osw.write(line+"\n")
                }else{
                    osw.write(line)
                }

            }
        }
        osw.close()
        print("mapping合并完成")
    }


    private HashMap<String, ArrayList<String>> mappingToSeeds() {
        def mapping = seedToMapping()
        def seed = readSeeds
        println("开始合并mapping到seed")
        for (String key : seed.keySet()) {
            def seedList = seed.get(key)
            def rlt = false
            for (String item : mapping.keySet()) {
                if (item.contains("$key -> ")) {
                    rlt = true
                }
            }
            if (!rlt) {
                def mappList = new ArrayList<String>()
                for (String sd : seedList) {
                    if (sd.contains("(") && sd.contains(")")) {
                        def arr = sd.split(" ")
                        if (arr.length > 1) {
                            def rlt2 = arr[0]
                            def nm = arr[1]
                            def m = nm.split("\\(")[0]
                            def temp = "    " + rlt2 + " " + nm + " -> " + m + "\n"
                            mappList.add(temp)
                        }
                    }
                }

                def clsNum=key+" -> "+key+":\n"
                mapping[clsNum]=mappList
            }
        }
        println("开始合并mapping到seed---end")

        return mapping
    }


    /**
     * 将seeds合并到mapping
     * @return
     */
    private HashMap<String, ArrayList<String>> seedToMapping() {
        println("开始合并seed到mapping")
        def mapping = readMappings
        def seed = readSeeds
        for (String key : mapping.keySet()) {
            def clsNm = key.split("->")[0].trim()
            def seedList = seed.get(clsNm)
            if (seedList == null || seedList.size() == 0) {
                continue
            }
            for (String sd : seedList) {
                if (sd.contains("(") && sd.contains(")")) {
                    def arr = sd.split(" ")
                    if (arr.length > 1) {
                        def rlt = arr[0]
                        def nm = arr[1]
                        def m = nm.split("\\(")[0]
                        def temp = "    " + rlt + " " +nm + " -> " + m + "\n"
                        def mappList = mapping.get(key)
                        if (!listContains(mappList, nm)) {
                            mappList.add(temp)
                        }
                    }
                }
            }
        }
        println("开始合并seed到mapping---end")
        return mapping
    }

    private boolean listContains(List list, String item) {
        for (String i : list) {
            if (i.contains(item)) {
                return true
            }
        }
        return false
    }
    /**
     * 读取所有mapping文件规则
     * @return
     */
    private HashMap<String, ArrayList<String>> readMapping() {
        println("读取mapping规则")
        def lines = mappingLines
        def status_invalid = false
        def newMap = new HashMap<String, ArrayList<String>>()
        def key = "key"
        for (int i = 0; i < lines.size(); i++) {
            def line = lines[i]
            if (filter(line)) {
                status_invalid = true
                continue
            }
            if (line.startsWith(" ")) {
                if (status_invalid) {
                    continue
                } else {
                    def value = newMap[key]
                    value.add(line)
                    newMap[key] = value
                }
            } else {
                status_invalid = false
                key = line
                newMap[key] = new ArrayList<String>()
            }
        }
        println("读取mapping规则---结束")

        return newMap
    }


    private HashMap<String, ArrayList<String>> readSeeds() {
        println("读取seeds规则")
        def lines = seedLines
        def seedMap = new HashMap<String, ArrayList<String>>()
        for (int i = 0; i < lines.size(); i++) {
            def line = lines[i]
            def sp = line.split(":")
            if (sp.length > 1) {
                def clsNm = sp[0].trim()
                def method = sp[1].trim()
                def value = seedMap.get(clsNm)
                if (value == null) {
                    value = new ArrayList<String>()
                }
                value.add(method)
                seedMap[clsNm] = value
            }
        }
        println("读取seeds规则---结束")
        return seedMap
    }

    private static boolean filter(String line) {
        def list = new ArrayList<String>()
        list.add("com.android.tools.r8.GeneratedOutlineSupport")
        list.add('#')
        list.add('$')
        for(int i=0;i<list.size();i++){
            def item=list.get(i)
            if (line.startsWith(item)) {
                println("无效行--->$line")
                return true
            }
        }
        return false
    }
}