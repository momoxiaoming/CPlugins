package com.dn.plugin

import com.android.build.gradle.AppExtension
import com.google.gson.Gson
import mp3agic.ID3v2
import mp3agic.Mp3File
import org.gradle.api.Action
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task
import pixy.meta.Metadata
import pixy.util.MetadataUtils

class FileHex implements Plugin<Project> {


    def genTaskReleaseResourcesReg = "^merge\\S*ReleaseResources\$"
    def genTaskReleaseAssetsReg = "^merge\\S*ReleaseAssets\$"
    def genTaskPackageReleaseReg = "processReleaseResources"
    def final NINEPATCH_SUFFIX = "9.png"
    def final EXT_NAME = "filehex"
    def final DEFAULT_CONFIG_FILE_NAME = "filehex_config.json"

    FileHexExtension ext
    FileHexConfig fileHexConfig

    def logEnable=false

    @Override
    void apply(Project project) {
        dealWithFile(project)

    }

    /**
     *
     * @param project
     */
    void dealWithFile(Project pj) {
        pj.extensions.create(EXT_NAME, FileHexExtension.class)

        AppExtension androidEx=  pj.extensions.getByName("android")
        androidEx.aaptOptions.cruncherEnabled = false
//                androidEx.buildTypes.getByName("release").setCrunchPngs(false)
        androidEx.buildTypes.forEach({
            it.setCrunchPngs(false)
        })

        pj.afterEvaluate(new Action<Project>() {
            @Override
            void execute(Project project) {
//                AppExtension androidEx=  project.extensions.getByName("android")
//                androidEx.aaptOptions.cruncherEnabled = false
////                androidEx.buildTypes.getByName("release").setCrunchPngs(false)
//                androidEx.buildTypes.forEach({
//                    it.setCrunchPngs(false)
//                })

                log("androidEx.aaptOptions.cruncherEnabled  ${androidEx.aaptOptions.cruncherEnabled}  " )
                log(" androidEx.buildTypes.getByName(isCrunchPngs)  ${  androidEx.buildTypes.getByName("release").isCrunchPngs()}  " )
                ext = (FileHexExtension) project.extensions.getByName(EXT_NAME)
                logEnable=ext.logEnable
                log(ext.toString())
                if (ext == null || !ext.enable)
                    return
                try {
                    loadFileHexConfig(project)
                } catch (Throwable e) {
                    log("loadFileHexConfig error" + e.toString())
                }

                Map<Project, Set<Task>> allTasks = project.getAllTasks(true)
                for (Map.Entry<Project, Set<Task>> projectSetEntry : allTasks.entrySet()) {
                    Set<Task> value = projectSetEntry.getValue()
                    for (Task task : value) {
                        log("task name>>>" + task.name)
                        if (task.name.matches(genTaskReleaseResourcesReg) || task.name.matches(genTaskReleaseAssetsReg)) {


                            task.doFirst { t ->

                                for (File file : t.getInputs().getFiles().getFiles()) {
                                    log("mergeReleaseResources filepath----: " + file.absolutePath)

                                    if (file.isDirectory()) {
                                        getHexFile(file, project) //更新文件 图片：png/jpg/webp，xml等
                                    }
                                }
                            }


                        } else if (task.name.matches(genTaskPackageReleaseReg)) {

                            task.doLast { t ->
                                for (File file : t.getOutputs().getFiles().getFiles()) {
                                    log("-------processReleaseResources---------: " + file.absolutePath)
                                    getApFile(file, project)
                                }
                            }
                        }
                    }
                }
            }
        })
    }


    /**
     *
     *  获取resources-release.ap_,该文件是一个zip文件，解压后包括
     *  AndroidManifest.xml, res, resources.arsc
     * @param file
     * @param project
     */
    void getApFile(File file, Project project) {


        for (File cfile : file.listFiles()) {
            log("-------processReleaseResources---name------: " + cfile.name)

            /**
             *  resources-release.ap_  //处理这个文件， output-metadata.json  R.txt
             */
            if (cfile.name.endsWith(".ap_")) {
                def filepath = cfile.absolutePath

                String apPath = filepath.substring(0, filepath.lastIndexOf(File.separator))
                String apName = filepath.substring(filepath.lastIndexOf(File.separator) + 1, filepath.length())

                //1. 解压
                def tempp = cfile.getParent() + File.separator + "temp"
                log("1.--------解压" + tempp)
                File tempPath = new File(tempp)

                if (!tempPath.exists()) {
                    tempPath.mkdirs()
                }
                Zip.unZip(cfile, tempPath)
                log("--------完成解压--tempPath------: " + tempPath.absolutePath)

                //2. 遍历解压缩文件夹temp 中的res,更改文件，注：这里只修改 9.png
                log("2.--------遍历修改")

                get9PathFile(tempPath, project)


                //3. 重新打包
                log("3.--------重新打包")
                File temp_apfile = new File(cfile.getParent() + File.separator + "temp.zip")
                temp_apfile.getParentFile().mkdirs();

                Zip.zip(tempPath, temp_apfile)

                assert cfile.delete()
                boolean package_rename_result = temp_apfile.renameTo(new File(filepath))
                log "重新打包result ${package_rename_result}"

            }
        }
    }

    /**
     * 处理9.png
     * @param file
     * @param project
     */
    void get9PathFile(File file, Project project) {
        for (File cfile : file.listFiles()) {
            def isInWhite = ifFileInWhiteList(cfile.absolutePath)
            log("-------ifFileInWhiteList---------" + isInWhite)
            if (isInWhite) {
                continue
            }
            if (cfile.isDirectory()) {
                get9PathFile(cfile, project)
            } else if (cfile.name.endsWith(NINEPATCH_SUFFIX)) {
                updatePngJpg(cfile, project)
            }
        }
    }

    /**
     * update file hex
     * @param file
     * @param project
     */
    void getHexFile(File file, Project project) {
        for (File cfile : file.listFiles()) {
            def isInWhite = ifFileInWhiteList(cfile.absolutePath)
            log("-------ifFileInWhiteList---------" + isInWhite)
            if (isInWhite) {
                continue
            }
            if (cfile.isDirectory()) {
                getHexFile(cfile, project)
            } else if (cfile.name.endsWith(".png") ||
                    cfile.name.endsWith(".jpg") ||
                    cfile.name.endsWith(".jpeg") ||
                    cfile.name.endsWith(".gif")) {

                log("png/jpg/gif file->" + cfile.absolutePath)
                //更新pngjpg 文件
                updatePngJpg(cfile, project)

            } else if (cfile.name.endsWith(".webp")) {

                updateWebp(cfile, project)
            } else if (!cfile.name.contains("values") &&
                    !cfile.absolutePath.contains("material") &&
                    cfile.name.endsWith(".xml")) {

                //更新xml 文件
                updateXml(cfile, project)

            } else if (cfile.name.endsWith(".mp3")) {
                //更新mp3
                updateMp3(cfile, project)
            }
        }
    }

    /**
     * update mp3
     * @param file
     * @param project
     */
    void updateMp3(File file, Project project) {
        def isInWhite = ifFileInWhiteList(file.absolutePath)
        log("updateMp3")
        if (!file.exists()||isInWhite) {
            log("file.exists()")
            return
        }
        def abPath = file.absolutePath
        log("mp3file before")
        // 创建 Mp3File 对象
        Mp3File mp3file = new Mp3File(file)
        log("mp3file")
        // 获取文件名
        String fileName = file.getName()
        // 获取ID3v2对象，通过该对象可以获取文件信息如标题、艺术家等内容
        ID3v2 id3v2Tag = mp3file.getId3v2Tag()
        //获取后缀
        String suffix = fileName.substring(fileName.lastIndexOf("."))

        // 修改标题
        log("setTitle")
        id3v2Tag.setTitle(genRandomStr())
        // 简单打印一下
        System.out.println(id3v2Tag.getTitle() + "->")

        // 将修改后的文件保存到新的目录
        String tempFilePath = file.getParent() + File.separator + "tmp_${System.nanoTime()}${suffix}"
        File newFile = new File(tempFilePath)
        if (!newFile.exists())
            newFile.createNewFile()
        log(" mp3file.save")
        mp3file.save(tempFilePath)

        assert file.delete()
        boolean isRename = newFile.renameTo(new File(abPath))
        newFile.delete()
        log "mp3---------rename---result ${isRename}"
    }

    /**
     * update png/jpg file
     * @param file
     * @param project
     */
    void updatePngJpg(File file, Project project) {
        if (!file.exists()) {
            return
        }

        def abs_filePath = file.absolutePath
        boolean ifMp3 = ifFileInMp3list(abs_filePath)
        if (ifMp3) {
            log("you are a fake png!!")
            updateMp3(file, project)
            return
        }
        String filePath = abs_filePath.substring(0, abs_filePath.lastIndexOf(File.separator))
        String fileName = abs_filePath.substring(abs_filePath.lastIndexOf(File.separator) + 1, abs_filePath.length())
        log("filePath-->" + filePath + " filename = " + fileName)


        def split = fileName.split("\\.") as String[]
        if (split.length == 0) return

        //源文件输入流
        FileInputStream fin = new FileInputStream(abs_filePath)

        //创建临时文件
        //临时文件输出流
        def temp_path = filePath + File.separator + "temp_${System.nanoTime()}.${split[1]}"

        log "temppath: $temp_path"
        FileOutputStream fout = new FileOutputStream(temp_path)

//        //向图片文件插入
        Metadata.insertComments(fin, fout, Arrays.asList("" + genRandomStr()))
        fin.close()
        fout.close()
        assert new File(abs_filePath).delete()

        boolean result = new File(temp_path).renameTo(new File(abs_filePath))

        log "--------rename result:$result"
    }


    /**
     * update webp file
     * @param file
     * @param project
     */
    void updateWebp(File file, Project project) {
        def is = new FileInputStream(file)

        if (!file.exists() || MetadataUtils.getImageType(is) != "webp") {
            return
        }

        String randomStr = genRandomStr()
        addTxtToFileBuffered(file, randomStr)

    }
    /**
     * 生成一个随机的字符串
     * @return
     */
    String genRandomStr() {
        Random randomC = new Random();
        int count = randomC.nextInt(7) + 3;
        Random random = new Random()
        String str = "abcdefghijklmnopqrstuvwxyz0123456789"
        StringBuilder sb = new StringBuilder()
        for (int j = 0; j < count; j++) {
            int number = random.nextInt(36)
            sb.append(str.charAt(number))
        }

        return sb.toString()
    }

    void addTxtToFileBuffered(File file, String content) {
        //在文本文本中追加内容
        BufferedWriter out = null;
        try {
            log "--------addTxtToFileBuffered webp"
            //FileOutputStream(file, true),第二个参数为true是追加内容，false是覆盖
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)))
            out.newLine()//换行
            out.write(content)
        } catch (Exception e) {
            e.printStackTrace()
        } finally {
            try {
                if (out != null) {
                    out.close()
                }
            } catch (IOException e) {
                e.printStackTrace()
            }
        }

    }


    /**
     * 更新xml 文件，添加CDATA
     * @param xmlFile
     * @param project
     */
    void updateXml(File xmlFile, Project project) {
        def xmlparser = new XmlParser(false,false)

        def rootNode = xmlparser.parse(xmlFile.path)
        if (rootNode == null)
            return

        def cdata = "<![CDATA[<!--${genRandomStr()}-->]]>"
        if (rootNode.children().isEmpty()) {
            rootNode.children().add(cdata)
        } else {
            def rootName = rootNode.name()
            if (rootName == "layout") {
                //处理最外层是layout的情况
                def nodeIndex = 0;
                def child = rootNode.children().get(0)
                if (child == null || !(child instanceof Node) || child.children().isEmpty())
                    return

                if (child.name() == "data") {
                    if (child.children().size() > 1) {

                        nodeIndex = 1
                    } else {
                        return
                    }
                }
                def clast = rootNode.children().get(nodeIndex).children().last()
                if (!(clast instanceof Node)) {
                    //如果最后一个节点不是node,则先移除（避免CDATA不断新增）
                    rootNode.children().get(nodeIndex).children().removeLast()
                }
                // 添加CDATA
                rootNode.children().get(nodeIndex).children().add(cdata)
            } else {

                def last = rootNode.children().last()
                if (!(last instanceof groovy.util.Node)) {
                    //如果最后一个节点不是node,则先移除（避免CDATA不断新增）
                    rootNode.children().removeLast()
                }
                // 添加CDATA
                rootNode.children().add(cdata)
            }

        }

        def xmlText = groovy.xml.XmlUtil.serialize(rootNode)
        //替换转义符号
        def map = new Hashtable()
        map.put("&lt;", "<")
        map.put("&gt;", ">")
        def replace = xmlText.replace(map)

        xmlFile.withWriter { writer ->
            writer.write(replace)
        }
    }


    void loadFileHexConfig(Project project) {
        try {
            def configFile = findConfigFile(project)
            if (configFile == null)
                throw new FileNotFoundException("filehex config file not found,please place a file named 'filehex_config.json' to rootProject's rootdir or your custom dir")

            def content = configFile.getText()

            fileHexConfig = new Gson().fromJson(content, FileHexConfig.class)
        } catch (Throwable e) {
            throw new RuntimeException("read filehex config file error", e)
        }
    }

    private File findConfigFile(Project project) {

        File file = null
        if (!ext.configFile.isEmpty()) {
            file = new File(ext.configFile)
            if (file.exists()) {
                log("filehex config file found,path=${file.path}")
                return file
            }
        }
        file = new File(project.rootProject.projectDir, DEFAULT_CONFIG_FILE_NAME)
        if (file.exists()) {
            log("filehex config file found in root dir,path=${file.path}")
            return file
        }
        return null
    }


    void log(String name) {
        if(logEnable){
            println("filehex >>>: " + name)
        }
    }

    /**
     * judge if the file is in white list,
     * @param path
     * @return
     */
    boolean ifFileInWhiteList(String path) {
        if (fileHexConfig?.enable_whitelist)
            for (filtername in fileHexConfig?.whitelist) {
                log("ifFileInWhiteList path ${path} item ${filtername}")
                if (path.contains(filtername)) {
                    log("ifFileInWhiteList contains ${filtername}")
                    return true
                }
            }
        return false
    }

    /**
     * judge if the file is in mp3 list
     * @param path
     * @return
     */
    boolean ifFileInMp3list(String path) {

        for (filterName in fileHexConfig?.mp3list) {
            filterName = filterName.replace("/", File.separator)
            log("ifFileInMp3list path ${path} item ${filterName}")
            if (path.contains(filterName)) {
                log("ifFileInMp3list contains ${filterName}")
                return true
            }
        }
        return false
    }


}